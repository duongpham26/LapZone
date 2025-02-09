package com.duongpham26.LaptopShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duongpham26.LaptopShop.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
