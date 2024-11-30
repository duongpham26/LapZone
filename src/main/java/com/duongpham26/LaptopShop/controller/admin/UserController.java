package com.duongpham26.LaptopShop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duongpham26.LaptopShop.domain.User;
import com.duongpham26.LaptopShop.service.UserService;

// // Spring MVC
@Controller
public class UserController {
   
   private final UserService userService;

   public UserController(UserService userService) {
      this.userService = userService;
   }

   @RequestMapping("/")
   public String getHomePage(Model model) {
      List<User> arrUser = this.userService.getAllUsersByEmail("duong.pham2617@gmail.com");
      System.out.println("Array user : " + arrUser);
      String text = this.userService.handleHello();
      model.addAttribute("text", text);
      return "hello";
   }

   @RequestMapping("/admin/user")
   public String getUserPage(Model model) {
      List<User> users = this.userService.getAllUsers();
      model.addAttribute("users", users);
      return "admin/user/show";
   }

   @RequestMapping("/admin/user/{id}")
   public String getDetailUserPage(@PathVariable long id, Model model) {

      User user = this.userService.getUserById(id);
      model.addAttribute("user", user);
      return "admin/user/detail";
   }

   @RequestMapping("/admin/user/create")
   public String getUser(Model model) {
      model.addAttribute("newUser", new User());
      return "admin/user/create";
   }

   @RequestMapping("/admin/user/update/{id}")
   public String getUpdateUserPage(@PathVariable long id, Model model) {
      model.addAttribute("id", id);
      User currentUser = this.userService.getUserById(id);
      model.addAttribute("updateUser", currentUser);
      return "admin/user/update";
   }

   @PostMapping("/admin/user/update")
   public String postUpdateUser(Model model, @ModelAttribute("newUser")User user) {
      long id = user.getId();
      User currentUser = this.userService.getUserById(id);
      System.out.println(currentUser);
      if(currentUser != null) {
         currentUser.setFullName(user.getFullName());
         currentUser.setAddress(user.getAddress());
         currentUser.setPhone(user.getPhone());
         this.userService.handleSavaUser(currentUser);
      }
      model.addAttribute("updateUser", currentUser);
      String redirectUrl = "/admin/user";
      return "redirect:" + redirectUrl;
   }

   @RequestMapping(value = "admin/user/create", method = RequestMethod.POST)
   public String doAddUser(@ModelAttribute("newUser")User user, ModelMap model) {

      this.userService.handleSavaUser(user);
      String redirectUrl = "/admin/user";
      return "redirect:" + redirectUrl;
   }

   @GetMapping("admin/user/delete/{id}")
   public String getDeleteUser(Model model, @PathVariable long id) {
      model.addAttribute("id", id);
      model.addAttribute("newUser", new User());
      return "/admin/user/delete";
   }

   
   @PostMapping("admin/user/delete")
   public String postDeleteUser(@ModelAttribute("newUser")User user) {
      this.userService.deleteAUser(user.getId());
      String redirectUrl = "/admin/user";
      return "redirect:" + redirectUrl;
   }
}

// Rest API
// @RestController
// public class UserController {
   
//    private UserService userService;

//    public UserController(UserService userService) {
//       this.userService = userService;
//    }

//    @GetMapping("/")
//    public String getHomePage() {
//       return this.userService.handleHello();
//    }
// }
