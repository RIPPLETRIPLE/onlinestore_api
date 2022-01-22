package com.example.api.controller;

import com.example.api.entity.Product;
import com.example.api.exception.EmptyArgumentException;
import com.example.api.exception.EntityNotFoundException;
import com.example.api.exception.NotUniqueFieldException;
import com.example.api.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color-management/")
public class ColorRestController {
    @Autowired
    private ColorService colorService;

    @GetMapping("color")
    public ResponseEntity<List<Product.Color>> getList() {
        return new ResponseEntity<>(colorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("color/{id}")
    public ResponseEntity<Product.Color> getColor(@PathVariable("id") Long id) {
        Product.Color color = colorService.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Color with id : %s not found", id)));
        return new ResponseEntity<>(color, HttpStatus.OK);
    }

    @PostMapping("color")
    public ResponseEntity<Product.Color> saveColor(@RequestBody Product.Color color) {
        if (color == null) {
            throw new EmptyArgumentException("color");
        }

        if (colorService.existsColor(color.getColor())) {
            throw new NotUniqueFieldException("color");
        }

        colorService.save(color);
        return new ResponseEntity<>(color, HttpStatus.CREATED);
    }

    @DeleteMapping("color/{id}")
    public ResponseEntity<String> deleteColor(@PathVariable Long id) throws EntityNotFoundException {
        Product.Color color = colorService.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Color with id : %s not found", id)));

        colorService.delete(color);
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("color")
    public ResponseEntity<Product.Color> updateColor(@RequestBody Product.Color color) {
        if (color == null) {
            throw new EmptyArgumentException("color");
        }

        if (colorService.findById(color.getId()).isEmpty()) {
            throw new EntityNotFoundException(String.format("Color with id : %s not found", color.getId()));
        }

        colorService.save(color);
        return new ResponseEntity<>(color, HttpStatus.OK);
    }
}
