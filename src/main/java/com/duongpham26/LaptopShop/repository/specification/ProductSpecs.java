package com.duongpham26.LaptopShop.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import com.duongpham26.LaptopShop.domain.Product;
import com.duongpham26.LaptopShop.domain.Product_;

public class ProductSpecs {
    public static Specification<Product> nameLike(String name) {
        return (root, query, CriteriaBuilder) -> CriteriaBuilder.like(root.get(Product_.NAME), "%" + name + "%");
    }
}
