package com.example.api.repository;

import com.example.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Product.Category, Long> {
    boolean existsCategoryByName(String category);
}