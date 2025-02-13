package com.duongpham26.LaptopShop.repository.specification;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.duongpham26.LaptopShop.domain.Product;
import com.duongpham26.LaptopShop.domain.Product_;

public class ProductSpecs {
    public static Specification<Product> nameLike(String name) {
        return (root, query, CriteriaBuilder) -> CriteriaBuilder.like(root.get(Product_.NAME), "%" + name + "%");
    }

    // min price
    public static Specification<Product> minPrice(double price) {
        return (root, query, CriteriaBuilder) -> CriteriaBuilder.ge(root.get(Product_.PRICE), price);
    }

    // max price
    public static Specification<Product> maxPrice(double price) {
        return (root, query, CriteriaBuilder) -> CriteriaBuilder.le(root.get(Product_.PRICE), price);
    }

    // factory
    public static Specification<Product> matchFactory(String factory) {
        return (root, query, CriteriaBuilder) -> CriteriaBuilder.equal(root.get(Product_.FACTORY), factory);
    }

    // factory
    public static Specification<Product> matchListFactory(List<String> factories) {
        return (root, query, CriteriaBuilder) -> CriteriaBuilder.in(root.get(Product_.FACTORY)).value(factories);
    }

    // target
    public static Specification<Product> matchListTarget(List<String> targets) {
        return (root, query, CriteriaBuilder) -> CriteriaBuilder.in(root.get(Product_.TARGET)).value(targets);
    }

    // price
    public static Specification<Product> matchPrice(double min, double max) {
        return (root, query, CriteriaBuilder) -> CriteriaBuilder.and(CriteriaBuilder.gt(root.get(Product_.PRICE), min),
                CriteriaBuilder.le(root.get(Product_.PRICE), max));
    }

    // multi price
    public static Specification<Product> matchMultiPrice(double min, double max) {
        return (root, query, CriteriaBuilder) -> CriteriaBuilder.between(root.get(Product_.PRICE), min, max);
    }
}
