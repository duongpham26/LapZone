package com.duongpham26.LaptopShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duongpham26.LaptopShop.domain.Product;
import com.duongpham26.LaptopShop.repository.ProductRepository;

@Service
public class ProductService {
   
   private final ProductRepository  productRepository;

   public ProductService(
      ProductRepository productRepository
   ) {
      this.productRepository = productRepository;
   }


   public List<Product> getAllProducts() {
      return this.productRepository.findAll();
   }

   public Product getProductById(long id) {
      return this.productRepository.findById(id);
   }

   public Product handleSavaProduct(Product product) {
      return this.productRepository.save(product);
   }

   public void deleteAProduct(long id) {
      this.productRepository.deleteById(id);
   }
}
