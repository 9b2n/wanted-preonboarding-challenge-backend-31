package com.wanted.backend.dto.request;

import com.wanted.backend.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductListRequestDto {
    private int page;
    private int perPage;
    private String sort;
    private String status;
    private int minPrice;
    private int maxPrice;
    private int[] category;
    private int seller;
    private int brand;
    private boolean inStock;
    private String search;

    @Builder
    public ProductListRequestDto(
        int page,
        int perPage,
        String sort,
        String status,
        int minPrice,
        int maxPrice,
        int[] category,
        int seller,
        int brand,
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
