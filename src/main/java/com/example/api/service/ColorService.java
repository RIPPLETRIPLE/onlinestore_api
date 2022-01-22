package com.example.api.service;

import com.example.api.entity.Product;
import com.example.api.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {
    @Autowired
    private ColorRepository colorRepository;


    public Optional<Product.Color> findById(Long id) {
        return colorRepository.findById(id);
    }

    public List<Product.Color> findAll() {
        return colorRepository.findAll();
    }

    public void save(Product.Color color) {
        colorRepository.save(color);
    }

    public void delete(Product.Color color) {
        colorRepository.delete(color);
    }

    public boolean existsColor(String color) {
        return colorRepository.existsColorByColor(color);
    }
}
