package com.duongpham26.LaptopShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duongpham26.LaptopShop.domain.Cart;
import com.duongpham26.LaptopShop.domain.CartDetail;
import com.duongpham26.LaptopShop.domain.Order;
import com.duongpham26.LaptopShop.domain.OrderDetail;
import com.duongpham26.LaptopShop.domain.Product;
import com.duongpham26.LaptopShop.domain.User;
import com.duongpham26.LaptopShop.repository.CartDetailRepository;
import com.duongpham26.LaptopShop.repository.CartRepository;
import com.duongpham26.LaptopShop.repository.OrderDetailRepository;
import com.duongpham26.LaptopShop.repository.OrderRepository;
import com.duongpham26.LaptopShop.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class ProductService {

   private final ProductRepository productRepository;

   private final CartDetailRepository cartDetailRepository;

   private final CartRepository cartRepository;

   private final UserService userService;

   private final OrderRepository orderRepository;

   private final OrderDetailRepository orderDetailRepository;

   public ProductService(
         ProductRepository productRepository,
         CartRepository cartRepository,
         UserService userService,
         CartDetailRepository cartDetailRepository,
         OrderRepository orderRepository,
         OrderDetailRepository orderDetailRepository) {
      this.productRepository = productRepository;
      this.cartRepository = cartRepository;
      this.userService = userService;
      this.cartDetailRepository = cartDetailRepository;
      this.orderDetailRepository = orderDetailRepository;
      this.orderRepository = orderRepository;
   }

   public List<Product> getAllProducts() {
      return this.productRepository.findAll();
   }

   public Product getProductById(long id) {
      return this.productRepository.findById(id);
   }

   public Product handleSavaProduct(Product product) {
      return this.productRepository.save(product);
   }

   public void deleteAProduct(long id) {
      this.productRepository.deleteById(id);
   }

   public void handleAddProductToCart(String email, long productId, HttpSession session) {
      User user = this.userService.getUserByEmail(email);
      if (user != null) {
         // check user co cart hay chua
         Cart cart = this.cartRepository.findByUser(user);
         if (cart == null) {

            Cart newCart = new Cart();
            newCart.setUser(user);
            newCart.setSum(0);
            cart = this.cartRepository.save(newCart);
         }

         // save cart detail
         // tim product by id
         Product product = this.productRepository.findById(productId);
         if (product != null) {
            CartDetail oldCartDetail = this.cartDetailRepository.findByCartAndProduct(cart, product);
            if (oldCartDetail == null) {
               CartDetail newCartDetail = new CartDetail();
               newCartDetail.setCart(cart);
               newCartDetail.setPrice(product.getPrice());
               newCartDetail.setQuantity(1);
               newCartDetail.setProduct(product);
               this.cartDetailRepository.save(newCartDetail);

               // update cart sum
               int s = cart.getSum() + 1;
               cart.setSum(s);
               this.cartRepository.save(cart);
               session.setAttribute("sum", s);
            } else {
               oldCartDetail.setQuantity(oldCartDetail.getQuantity() + 1);
               this.cartDetailRepository.save(oldCartDetail);
            }
         }
      }
   }

   public void handleRemoveCartDetail(long cartDetailId, HttpSession session) {
      Optional<CartDetail> cartDetailOptional = this.cartDetailRepository.findById(cartDetailId);
      if (cartDetailOptional.isPresent()) {
         CartDetail cartDetail = cartDetailOptional.get();

         Cart currentCart = cartDetail.getCart();

         // delete cart detail
         this.cartDetailRepository.deleteById(cartDetailId);

         // update cart
         if (currentCart.getSum() > 1) {
            int s = currentCart.getSum() - 1;
            currentCart.setSum(s);
            session.setAttribute("sum", s);
            this.cartRepository.save(currentCart);
         } else {
            this.cartRepository.deleteById(currentCart.getId());
            session.setAttribute("sum", 0);
         }
      }
   }

   public void handleUpdateCartBeforeCheckout(List<CartDetail> cartDetails) {
      for (CartDetail cartDetail : cartDetails) {
         Optional<CartDetail> cdOptional = this.cartDetailRepository.findById(cartDetail.getId());
         if (cdOptional.isPresent()) {
            CartDetail currentDetail = cdOptional.get();
            currentDetail.setQuantity(cartDetail.getQuantity());
            this.cartDetailRepository.save(currentDetail);
         }
      }
   }

   public void handlePlaceOrder(User user, HttpSession session, String receiverName, String receiverAddress,
         String receiverPhone) {

      // create order
      Order order = new Order();
      order.setReceiverName(receiverName);
      order.setReceiverAddress(receiverAddress);
      order.setReceiverPhone(receiverPhone);
      order.setUser(user);

      order = this.orderRepository.save(order);

      // create order detail
      // 1. get cart by user
      Cart cart = this.cartRepository.findByUser(user);
      double totalPrice = 0;
      if (cart != null) {
         List<CartDetail> cartDetails = cart.getCartDetails();
         if (cartDetails != null) {
            for (CartDetail cartDetail : cartDetails) {
               totalPrice += cartDetail.getPrice() * cartDetail.getQuantity();

               OrderDetail orderDetail = new OrderDetail();
               orderDetail.setOrder(order);
               orderDetail.setProduct(cartDetail.getProduct());
               orderDetail.setPrice(cartDetail.getPrice());
               orderDetail.setQuantity(cartDetail.getQuantity());
               this.orderDetailRepository.save(orderDetail);

               // delete cart detail
               this.cartDetailRepository.deleteById(cartDetail.getId());
            }

            // delete cart
            this.cartRepository.deleteById(cart.getId());

            // update session
            session.setAttribute("sum", 0);
         }
      }
   }
}
