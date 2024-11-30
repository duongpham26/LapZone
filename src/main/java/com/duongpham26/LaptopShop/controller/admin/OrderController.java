package com.duongpham26.LaptopShop.controller.admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// // Spring MVC
@Controller
public class OrderController {
   @GetMapping("/admin/order")
   public String getOrder() {
       return "admin/order/show";
   }
   
}


