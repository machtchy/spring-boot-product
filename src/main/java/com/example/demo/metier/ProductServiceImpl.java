package com.example.demo.metier;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> searchProductsByKeyword(String keyword) {
        return productRepository.findByReferenceContainingOrDesignationContaining(keyword, keyword);
    }

    @Override
    public Product getProductById(Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    @Override
    public void updateProduct(Integer productId, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setReference(updatedProduct.getReference());
            existingProduct.setDesignation(updatedProduct.getDesignation());
            existingProduct.setPrice(updatedProduct.getPrice());
            productRepository.save(existingProduct);
        }
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
