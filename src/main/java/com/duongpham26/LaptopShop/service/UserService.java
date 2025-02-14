package com.duongpham26.LaptopShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duongpham26.LaptopShop.domain.Role;
import com.duongpham26.LaptopShop.domain.User;
import com.duongpham26.LaptopShop.domain.dto.RegisterDTO;
import com.duongpham26.LaptopShop.repository.OrderRepository;
import com.duongpham26.LaptopShop.repository.ProductRepository;
import com.duongpham26.LaptopShop.repository.RoleRepository;
import com.duongpham26.LaptopShop.repository.UserRepository;

@Service
public class UserService {

   private final UserRepository userRepository;

   private final RoleRepository roleRepository;

   private final ProductRepository productRepository;

   private final OrderRepository orderRepository;

   public UserService(
         UserRepository userRepository,
         RoleRepository roleRepository,
         OrderRepository orderRepository,
         ProductRepository productRepository) {
      this.userRepository = userRepository;
      this.roleRepository = roleRepository;
      this.orderRepository = orderRepository;
      this.productRepository = productRepository;
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

   public Role getRoleByName(String name) {
      return this.roleRepository.findByName(name);
   }

   public User registerDTOToUser(RegisterDTO registerDTO) {

      User user = new User();

      user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
      user.setEmail(registerDTO.getEmail());
      user.setPassword(registerDTO.getPassword());

      return user;
   }

   public boolean checkEmailExist(String email) {
      return this.userRepository.existsByEmail(email);
   }

   public User getUserByEmail(String email) {
      return this.userRepository.findOneByEmail(email);
   }

   public long countUser() {
      return this.userRepository.count();
   }

   public long countProduct() {
      return this.productRepository.count();
   }

   public long countOrder() {
      return this.orderRepository.count();
   }
}
