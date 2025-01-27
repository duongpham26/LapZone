package com.duongpham26.LaptopShop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.duongpham26.LaptopShop.service.CustomUserDetailsService;
import com.duongpham26.LaptopShop.service.UserService;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Bean
   public UserDetailsService userDetailsService(UserService userService) {
      return new CustomUserDetailsService(userService);
   }

   @Bean
   public DaoAuthenticationProvider authProvider(
         PasswordEncoder passwordEncoder,
         UserDetailsService userDetailsService) {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(passwordEncoder);
      // authProvider.setHideUserNotFoundExceptions(false); // Kem an toan, vi hien
      // thi kh co user
      return authProvider;
   }
}
