package com.example.api.service;

import com.example.api.entity.Product;
import com.example.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public Optional<Product.Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Product.Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(Product.Category category) {
        categoryRepository.save(category);
    }

    public void delete(Product.Category category) {
        categoryRepository.delete(category);
    }

    public boolean existsCategory(String name) {
        return categoryRepository.existsCategoryByName(name);
    }
}
