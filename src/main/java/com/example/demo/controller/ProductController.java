package com.example.demo.controller;
import com.example.demo.metier.ProductService;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductService productService;
    

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/getAllProduct")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        List<Product> products = productService.searchProductsByKeyword(keyword);
        return products;
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return product;
        } else {
            return null;
        }
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable Integer productId, @RequestBody Product updatedProduct) {
        productService.updateProduct(productId, updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
    }
   
    
    
    
}