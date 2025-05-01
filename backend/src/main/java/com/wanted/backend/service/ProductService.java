package com.wanted.backend.service;

import com.wanted.backend.dto.ProductListDto;
import com.wanted.backend.dto.request.ProductListRequestDto;
import com.wanted.backend.entity.Product;
import com.wanted.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductListDto> findAll(ProductListRequestDto requestDto) {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductListDto::new)
                .toList();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        Product p = productRepository.findById(id).orElseThrow();
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
