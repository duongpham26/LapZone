package com.duongpham26.LaptopShop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.duongpham26.LaptopShop.domain.Product;
import com.duongpham26.LaptopShop.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ItemController {

   private final ProductService productService;

   public ItemController(ProductService productService) {
      this.productService = productService;
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
      this.productService.handleAddProductToCart(email, id, session);
      return "redirect:/";
   }

   @GetMapping("/cart")
   public String getCartPage(Model model) {
      return "client/cart/show";
   }
}
