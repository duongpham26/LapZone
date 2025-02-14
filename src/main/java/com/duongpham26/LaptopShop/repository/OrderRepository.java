package com.duongpham26.LaptopShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duongpham26.LaptopShop.domain.Order;
import com.duongpham26.LaptopShop.domain.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();

    List<Order> findByUser(User user);
}
