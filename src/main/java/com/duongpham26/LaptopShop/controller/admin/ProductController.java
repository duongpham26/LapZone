package com.duongpham26.LaptopShop.controller.admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// // Spring MVC
@Controller
public class ProductController {
   @GetMapping("/admin/product")
   public String getProduct() {
       return "admin/product/show";
   }
   
}

