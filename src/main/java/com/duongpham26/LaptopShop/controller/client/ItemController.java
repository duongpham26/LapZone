package com.duongpham26.LaptopShop.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.duongpham26.LaptopShop.domain.Cart;
import com.duongpham26.LaptopShop.domain.CartDetail;
import com.duongpham26.LaptopShop.domain.Order;
import com.duongpham26.LaptopShop.domain.Product;
import com.duongpham26.LaptopShop.domain.User;
import com.duongpham26.LaptopShop.service.CartService;
import com.duongpham26.LaptopShop.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

   private final ProductService productService;

   private final CartService cartService;

   public ItemController(ProductService productService,
         CartService cartService) {
      this.productService = productService;
      this.cartService = cartService;
   }

   @GetMapping("/product/{id}")
   public String getDetailProductPage(@PathVariable long id, Model model) {
      Product product = this.productService.getProductById(id);

      model.addAttribute("product", product);
      model.addAttribute("id", id);

      return "client/product/detail";
   }

   @PostMapping("/add-product-to-cart/{id}")
   public String addProductToCart(@PathVariable long id, HttpServletRequest request) {
      HttpSession session = request.getSession(false);
      String email = (String) session.getAttribute("email");
      this.productService.handleAddProductToCart(email, id, session, 1);
      return "redirect:/";
   }

   @GetMapping("/cart")
   public String getCartPage(Model model, HttpServletRequest request) {
      HttpSession session = request.getSession(false);
      Object id = session.getAttribute("id");
      Cart cart = this.cartService.findCartByUserId((Long) id);
      List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();

      double totalPrice = 0;

      for (CartDetail cartDetail : cartDetails) {
         totalPrice += cartDetail.getPrice() * cartDetail.getQuantity();
      }
      model.addAttribute("products", cartDetails);
      model.addAttribute("totalPrice", totalPrice);
      model.addAttribute("cart", cart);
      return "client/cart/show";
   }

   @PostMapping("/delete-cart-product/{cartDetailId}")
   public String deleteCartDetail(@PathVariable long cartDetailId, HttpServletRequest request) {
      HttpSession session = request.getSession(false);
      this.productService.handleRemoveCartDetail(cartDetailId, session);
      return "redirect:/cart";
   }

   @PostMapping("/confirm-checkout")
   public String getChecKOutPage(@ModelAttribute("cart") Cart cart) {
      List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();
      this.productService.handleUpdateCartBeforeCheckout(cartDetails);
      return "redirect:/checkout";
   }

   @GetMapping("/checkout")
   public String getcout(Model model, HttpServletRequest request) {
      HttpSession session = request.getSession(false);
      Object id = session.getAttribute("id");
      Cart cart = this.cartService.findCartByUserId((Long) id);
      List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();

      double totalPrice = 0;

      for (CartDetail cartDetail : cartDetails) {
         totalPrice += cartDetail.getPrice() * cartDetail.getQuantity();
      }
      model.addAttribute("products", cartDetails);
      model.addAttribute("totalPrice", totalPrice);

      return "client/cart/checkout";
   }

   @PostMapping("/place-order")
   public String handlePlaceOrder(
         @RequestParam("receiverName") String receiverName,
         @RequestParam("receiverAddress") String receiverAddress,
         @RequestParam("receiverPhone") String receiverPhone,
         HttpServletRequest request) {
      HttpSession session = request.getSession(false);
      User user = new User();

      long id = (long) session.getAttribute("id");
      user.setId(id);

      this.productService.handlePlaceOrder(user, session, receiverName, receiverAddress, receiverPhone);
      return "redirect:/thanks";
   }

   @GetMapping("/thanks")
   public String getPageThanks() {
      return "client/cart/thanks";
   }

   @PostMapping("/add-product-from-view-detail")
   public String addProductFromViewDetail(@RequestParam("id") long id,
         @RequestParam("quantity") long quantity,
         HttpServletRequest request) {
      HttpSession session = request.getSession();

      String email = (String) session.getAttribute("email");
      this.productService.handleAddProductToCart(email, id, session, quantity);
      return "redirect:/product/" + id;
   }
}
