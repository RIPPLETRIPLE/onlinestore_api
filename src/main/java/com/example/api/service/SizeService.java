package com.example.api.service;

import com.example.api.entity.Product;
import com.example.api.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeService {
    @Autowired
    private SizeRepository sizeRepository;


    public Optional<Product.Size> findById(Long id) {
        return sizeRepository.findById(id);
    }

    public List<Product.Size> findAll() {
        return sizeRepository.findAll();
    }

    public void save(Product.Size size) {
        sizeRepository.save(size);
    }

    public void delete(Product.Size size) {
        sizeRepository.delete(size);
    }

    public boolean existsSize(String size) {
        return sizeRepository.existsSizeBySize(size);
    }

    public boolean existsColor(String size) {
        return sizeRepository.existsSizeBySize(size);
    }
}
