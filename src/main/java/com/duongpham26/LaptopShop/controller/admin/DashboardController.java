package com.duongpham26.LaptopShop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.duongpham26.LaptopShop.service.UserService;

@Controller
public class DashboardController {

    private final UserService userService;

    public DashboardController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getDashboard(Model model) {
        model.addAttribute("countUsers", userService.countUser());
        model.addAttribute("countProducts", userService.countProduct());
        model.addAttribute("countOrders", userService.countOrder());
        return "admin/dashboard/show";
    }

}
