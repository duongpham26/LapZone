package com.duongpham26.LaptopShop.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.duongpham26.LaptopShop.domain.Order;
import com.duongpham26.LaptopShop.service.OrderService;
import com.duongpham26.LaptopShop.service.UploadService;

// // Spring MVC
@Controller
public class OrderController {

    private final OrderService orderService;

    private final UploadService uploadService;

    public OrderController(
            OrderService orderService,
            UploadService uploadService) {
        this.orderService = orderService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/order")
    public String getOrder(Model model) {
        List<Order> orders = this.orderService.fetchAllOrders();
        model.addAttribute("orders", orders);
        return "admin/order/show";
    }

    @GetMapping("admin/order/delete/{id}")
    public String getDeleteOrder(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("deleteOrder", new Order());
        return "admin/order/delete";
    }

    @PostMapping("admin/order/delete")
    public String postDeleteOrder(@ModelAttribute("deleteOrder") Order order) throws IOException {
        this.orderService.deleteOrderById(order.getId());
        String redirectUrl = "/admin/order";
        return "redirect:" + redirectUrl;
    }

    @RequestMapping("/admin/order/update/{id}")
    public String getUpdateOrderPage(@PathVariable long id, Model model) {
        Optional<Order> currentOrder = this.orderService.fetchOrderById(id);
        model.addAttribute("updateOrder", currentOrder.get());
        model.addAttribute("id", id);
        return "admin/order/update";
    }

    @PostMapping("/admin/order/update")
    public String postUpdateOrder(@ModelAttribute("updateOrder") Order order) {
        this.orderService.updateOrder(order);
        String redirectUrl = "/admin/order";
        return "redirect:" + redirectUrl;
    }

    // @RequestMapping("/admin/order/update/{id}")
    // public String getDetailOrderPage(@PathVariable long id, Model model) {
    // Order Order = this.orderService.getOrderById(id);

    // model.addAttribute("Order", Order);

    // return "admin/Order/detail";
    // }

}
