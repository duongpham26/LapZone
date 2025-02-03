package com.duongpham26.LaptopShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duongpham26.LaptopShop.domain.Cart;
import com.duongpham26.LaptopShop.domain.CartDetail;
import com.duongpham26.LaptopShop.domain.Product;
import com.duongpham26.LaptopShop.domain.User;
import com.duongpham26.LaptopShop.repository.CartDetailRepository;
import com.duongpham26.LaptopShop.repository.CartRepository;
import com.duongpham26.LaptopShop.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class ProductService {

   private final ProductRepository productRepository;

   private final CartDetailRepository cartDetailRepository;

   private final CartRepository cartRepository;

   private final UserService userService;

   public ProductService(
         ProductRepository productRepository,
         CartRepository cartRepository,
         UserService userService,
         CartDetailRepository cartDetailRepository) {
      this.productRepository = productRepository;
      this.cartRepository = cartRepository;
      this.userService = userService;
      this.cartDetailRepository = cartDetailRepository;
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
}
