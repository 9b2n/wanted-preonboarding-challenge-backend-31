package com.wanted.backend.repository;

import com.wanted.backend.dto.request.ProductListRequestDto;
import com.wanted.backend.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductDSLRepository {
    List<Product> findAllBySearch(ProductListRequestDto productListRequestDto, Pageable pageable);
}
