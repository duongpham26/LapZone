package com.duongpham26.LaptopShop.service;

import org.springframework.stereotype.Service;

import com.duongpham26.LaptopShop.domain.Cart;
import com.duongpham26.LaptopShop.repository.CartRepository;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart findCartByUserId(long id) {
        return this.cartRepository.findByUserId(id);
    }
}
