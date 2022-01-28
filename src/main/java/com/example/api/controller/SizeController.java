package com.example.api.controller;

import com.example.api.entity.Product;
import com.example.api.exception.EmptyArgumentException;
import com.example.api.exception.EntityNotFoundException;
import com.example.api.exception.NotUniqueFieldException;
import com.example.api.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/size-management/")
public class SizeController {
    @Autowired
    private SizeService sizeService;

    @GetMapping("size")
    public ResponseEntity<List<Product.Size>> getList() {
        return new ResponseEntity<>(sizeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("size/{id}")
    public ResponseEntity<Product.Size> getSize(@PathVariable("id") Long id) {
        Product.Size size = sizeService.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Size with id : %s not found", id)));
        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    @PostMapping("size")
    public ResponseEntity<Product.Size> saveSize(@RequestBody Product.Size size) {
        if (size == null) {
            throw new EmptyArgumentException("size");
        }

        if (sizeService.existsColor(size.getSize())) {
            throw new NotUniqueFieldException("size");
        }

        sizeService.save(size);
        return new ResponseEntity<>(size, HttpStatus.CREATED);
    }

    @DeleteMapping("size/{id}")
    public ResponseEntity<String> deleteSize(@PathVariable Long id) throws EntityNotFoundException {
        Product.Size size = sizeService.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Size with id : %s not found", id)));

        sizeService.delete(size);
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("size")
    public ResponseEntity<Product.Size> updateSize(@RequestBody Product.Size size) {
        if (size == null) {
            throw new EmptyArgumentException("size");
        }

        if (sizeService.findById(size.getId()).isEmpty()) {
            throw new EntityNotFoundException(String.format("Size with id : %s not found", size.getId()));
        }

        sizeService.save(size);
        return new ResponseEntity<>(size, HttpStatus.OK);
    }
}
