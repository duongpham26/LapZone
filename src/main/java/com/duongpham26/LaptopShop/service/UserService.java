package com.duongpham26.LaptopShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duongpham26.LaptopShop.domain.User;
import com.duongpham26.LaptopShop.repository.UserRepository;

@Service
public class UserService {
   
   private UserRepository  userRepository;

   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public String handleHello() {
      return "Hello from service";
   }

   public List<User> getAllUsers() {
      return this.userRepository.findAll();
   }

   public List<User> getAllUsersByEmail(String email) {
      return this.userRepository.findByEmail(email);
   }

   public User getUserById(long id) {
      return this.userRepository.findById(id);
   }

   public User handleSavaUser(User user) {
      return this.userRepository.save(user);
   }

   public void deleteAUser(long id) {
      this.userRepository.deleteById(id);
   }
}
