package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByReferenceContainingOrDesignationContaining(String keyword, String keyword1);
}
