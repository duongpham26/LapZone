package com.duongpham26.LaptopShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duongpham26.LaptopShop.domain.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
