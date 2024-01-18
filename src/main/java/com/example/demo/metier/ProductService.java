package com.example.demo.metier;

import com.example.demo.entity.Product;

import java.util.List;

public interface  ProductService {
    Product addProduct(Product product);

    List<Product> getAllProducts();

    List<Product> searchProductsByKeyword(String keyword);

    Product getProductById(Integer productId);

    void updateProduct(Integer productId, Product updatedProduct);

    void deleteProduct(Integer productId);
}

