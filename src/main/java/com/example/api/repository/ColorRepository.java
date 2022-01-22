package com.example.api.repository;

import com.example.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Product.Color, Long> {
    boolean existsColorByColor(String color);
}