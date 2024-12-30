package com.duongpham26.LaptopShop.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.duongpham26.LaptopShop.domain.User;
import com.duongpham26.LaptopShop.service.UploadService;
import com.duongpham26.LaptopShop.service.UserService;

import jakarta.validation.Valid;

// // Spring MVC
@Controller
public class UserController {
   
   private final UserService userService;

   private final UploadService uploadService;

   private final PasswordEncoder passwordEncoder;

   public UserController(
         UserService userService, 
         UploadService uploadService,
         PasswordEncoder passwordEncoder
      ) {
      this.userService = userService;
      this.uploadService = uploadService;
      this.passwordEncoder = passwordEncoder;
   }

   @GetMapping("/user")
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

      if(currentUser != null) {
         currentUser.setFullName(user.getFullName());
         currentUser.setAddress(user.getAddress());
         currentUser.setPhone(user.getPhone());
         currentUser.setRole(this.userService.getRoleByName(user.getRole().getName()));
         this.userService.handleSavaUser(currentUser);
      }
      model.addAttribute("updateUser", currentUser);
      String redirectUrl = "/admin/user";
      return "redirect:" + redirectUrl;
   }

   @PostMapping(value = "admin/user/create")
   public String doAddUser(
      Model model,
      @ModelAttribute("newUser") @Valid User user,
      BindingResult newUserBindingResult, 
      @RequestParam("imageFile") MultipartFile file
   ) {
      List<FieldError> errors= newUserBindingResult.getFieldErrors();

      for(FieldError error : errors) {
         System.out.println(">>> " + error.getField() + " - " + error.getDefaultMessage() + "\n");
      }

      if(newUserBindingResult.hasErrors()) {

         return "admin/user/create";
      }

      // String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
      // String password = this.passwordEncoder.encode(user.getPassword());

      // user.setAvatar(avatar);
      // user.setPassword(password);
      // user.setRole(this.userService.getRoleByName(user.getRole().getName()));

      // this.userService.handleSavaUser(user);

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
   public String postDeleteUser(@ModelAttribute("newUser")User user) throws IOException {
      String pathAvatar = this.userService.getUserById(user.getId()).getAvatar();
      this.uploadService.handleDeleteFile(pathAvatar);
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
