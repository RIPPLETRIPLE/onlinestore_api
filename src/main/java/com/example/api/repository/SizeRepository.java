package com.example.api.repository;

import com.example.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Product.Size, Long> {
    boolean existsSizeBySize(String size);
}