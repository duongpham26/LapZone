package com.duongpham26.LaptopShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duongpham26.LaptopShop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   User save(User user);

   List<User> findByEmail(String email);

   List<User> findAll();

   User findById(long id);

   void deleteById(Long id);

}
