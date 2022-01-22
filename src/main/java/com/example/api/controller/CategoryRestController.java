package com.example.api.controller;

import com.example.api.entity.Product;
import com.example.api.exception.EmptyArgumentException;
import com.example.api.exception.EntityNotFoundException;
import com.example.api.exception.NotUniqueFieldException;
import com.example.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category-management/")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("category")
    public ResponseEntity<List<Product.Category>> getList() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<Product.Category> getCategory(@PathVariable("id") Long id) {
        Product.Category category = categoryService.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Category with id : %s not found", id)));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("category")
    public ResponseEntity<Product.Category> saveCategory(@RequestBody Product.Category category) {
        if (category == null) {
            throw new EmptyArgumentException("category");
        }

        if (categoryService.existsCategory(category.getName())) {
            throw new NotUniqueFieldException("category");
        }

        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws EntityNotFoundException {
        Product.Category category = categoryService.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Category with id : %s not found", id)));

        categoryService.delete(category);
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("category")
    public ResponseEntity<Product.Category> updateCategory(@RequestBody Product.Category category) {
        if (category == null) {
            throw new EmptyArgumentException("category");
        }

        if (categoryService.findById(category.getId()).isEmpty()) {
            throw new EntityNotFoundException(String.format("Category with id : %s not found", category.getId()));
        }

        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}

