package com.wanted.backend.controller;

import com.wanted.backend.dto.ProductListDto;
import com.wanted.backend.dto.request.ProductListRequestDto;
import com.wanted.backend.entity.Product;
import com.wanted.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductListDto>> findProduct(ProductListRequestDto requestDto) {
        return ResponseEntity.ok(productService.findAll(requestDto));
    }

    @PostMapping(value = "/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    @DeleteMapping(value = "products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
