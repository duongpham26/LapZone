package com.duongpham26.LaptopShop.controller.client;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.duongpham26.LaptopShop.domain.Order;
import com.duongpham26.LaptopShop.domain.Product;
import com.duongpham26.LaptopShop.domain.User;
import com.duongpham26.LaptopShop.domain.dto.RegisterDTO;
import com.duongpham26.LaptopShop.service.OrderService;
import com.duongpham26.LaptopShop.service.ProductService;
import com.duongpham26.LaptopShop.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomePageController {

    private final ProductService productService;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final OrderService orderService;

    public HomePageController(
            ProductService productService,
            UserService userService,
            PasswordEncoder passwordEncoder,
            OrderService orderService) {
        this.productService = productService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String getHomePage(Model model, HttpServletRequest request) {

        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);

        Page<Product> productsPage = this.productService.getAllProducts(pageable);

        List<Product> products = productsPage.getContent();
        model.addAttribute("products", products);

        HttpSession session = request.getSession(false);

        return "client/homePage/show";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(
            Model model,
            @ModelAttribute("registerUser") @Valid RegisterDTO registerDTO,
            BindingResult newBindingResult) {

        // List<FieldError> errors = newBindingResult.getFieldErrors();
        // for (FieldError error : errors) {
        // System.out.println(">>> " + error.getField() + " - " +
        // error.getDefaultMessage() + "\n");
        // }

        if (newBindingResult.hasErrors()) {
            return "client/auth/register";
        }

        User user = this.userService.registerDTOToUser(registerDTO);
        String password = this.passwordEncoder.encode(user.getPassword());

        user.setPassword(password);
        user.setRole(this.userService.getRoleByName("USER"));

        this.userService.handleSavaUser(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "client/auth/login";
    }

    @GetMapping("/access-deny")
    public String getPageAccessDeny(Model model) {
        return "client/auth/deny";
    }

    @GetMapping("/order-history")
    public String getOrderHistoryPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User user = new User();

        long id = (long) session.getAttribute("id");
        user.setId(id);
        List<Order> orders = this.orderService.fetchOrdersByUser(user);

        model.addAttribute("orders", orders);

        return "client/cart/order-history";
    }
}
