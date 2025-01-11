package com.duongpham26.LaptopShop.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.duongpham26.LaptopShop.domain.Product;
import com.duongpham26.LaptopShop.service.ProductService;
import com.duongpham26.LaptopShop.service.UploadService;

import jakarta.validation.Valid;

// // Spring MVC
@Controller
public class ProductController {

    private final ProductService productService;

    private final UploadService uploadService;

    public ProductController(
            ProductService productService,
            UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        List<Product> products = this.productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String createProduct(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String doCreateProduct(
            Model model,
            @ModelAttribute("newProduct") @Valid Product product,
            BindingResult newProductBindingResult,
            @RequestParam("imageFile") MultipartFile file) {
        List<FieldError> errors = newProductBindingResult.getFieldErrors();

        for (FieldError error : errors) {
            System.out.println(">>> " + error.getField() + " - " + error.getDefaultMessage() + "\n");
        }

        if (newProductBindingResult.hasErrors()) {
            return "admin/product/create";
        }

        String pathImageProduct = this.uploadService.handleSaveUploadFile(file, "product");
        product.setImage(pathImageProduct);
        this.productService.handleSavaProduct(product);

        String redirectUrl = "/admin/product";
        return "redirect:" + redirectUrl;
    }

    @RequestMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(@PathVariable long id, Model model) {
        Product currentProduct = this.productService.getProductById(id);
        model.addAttribute("updateProduct", currentProduct);
        return "admin/product/update";
    }

    @PostMapping("/admin/product/update")
    public String postUpdateProduct(
        Model model, 
        @ModelAttribute("newProduct") @Valid Product product,
        BindingResult newProductBindingResult
    ) {
        List<FieldError> errors = newProductBindingResult.getFieldErrors();

        for (FieldError error : errors) {
            // System.out.println(">>> " + error.getField() + " - " + error.getDefaultMessage() + "\n");
        }

        if (newProductBindingResult.hasErrors()) {
            return "admin/product/create";
        }

        long id = product.getId();
        Product currentProduct = this.productService.getProductById(id);

        if (currentProduct != null) {
            currentProduct.setName(product.getName());
            currentProduct.setPrice(product.getPrice());
            currentProduct.setShortDesc(product.getShortDesc());
            currentProduct.setDetailDesc(product.getDetailDesc());
            currentProduct.setFactory(product.getFactory());
            currentProduct.setTarget(product.getTarget());
            currentProduct.setQuantity(product.getQuantity());
            this.productService.handleSavaProduct(currentProduct);
        }

        String redirectUrl = "/admin/product";
        return "redirect:" + redirectUrl;
    }

    @GetMapping("admin/product/delete/{id}")
    public String getDeleteProduct(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newProduct", new Product());
        return "/admin/product/delete";
    }
    
    @PostMapping("admin/product/delete")
    public String postDeleteProduct(@ModelAttribute("newProduct")Product product) throws IOException {

        String pathAvatar = this.productService.getProductById(product.getId()).getImage();
        this.uploadService.handleDeleteFile(pathAvatar);
        
        this.productService.deleteAProduct(product.getId());
        String redirectUrl = "/admin/product";
        return "redirect:" + redirectUrl;
    }

    @RequestMapping("/admin/product/{id}")
    public String getDetailProductPage(@PathVariable long id, Model model) {
        Product product = this.productService.getProductById(id);
        File file = new File(product.getImage());
        String fileName = file.getName();

        model.addAttribute("product", product);
        model.addAttribute("fileName", fileName);
        
        return "admin/product/detail";
   }
}
