package com.wanted.backend.dto.request;

import com.wanted.backend.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductListRequestDto {
    private Integer page;
    private Integer perPage;
    private String sort;
    private String status;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer[] category;
    private Integer seller;
    private Integer brand;
    private boolean inStock;
    private String search;

    @Builder
    public ProductListRequestDto(
        Integer page,
        Integer perPage,
        String sort,
        String status,
        Integer minPrice,
        Integer maxPrice,
        Integer[] category,
        Integer seller,
        Integer brand,
        boolean inStock,
        String search
    ) {
        this.page = page;
        this.perPage = perPage;
        this.sort = sort;
        this.status = status;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.category = category;
        this.seller = seller;
        this.brand = brand;
        this.inStock = inStock;
        this.search = search;
    }
}
