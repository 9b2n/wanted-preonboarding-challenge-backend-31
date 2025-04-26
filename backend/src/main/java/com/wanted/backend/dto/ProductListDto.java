package com.wanted.backend.dto;

import com.wanted.backend.entity.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductListDto {
    private Long id;
    private String name;
    private String slug;
    private String shortDescription;
    private int basePrice;
    private int salePrice;
    private String currency;
    private ProductImageDto primaryImage;
    private BrandDto brand;
    private SellerDto seller;
    private float rating;
    private int reviewCount;
    private boolean inStock;
    private String status;
    private LocalDateTime createdAt;

    @Getter
    public static class ProductImageDto {
        private String url;
        private String altText;

        public ProductImageDto(ProductImage productImage) {
            this.url = productImage.getUrl();
            this.altText = productImage.getAltText();
        }
    }

    @Getter
    public static class BrandDto {
        private Long id;
        private String name;

        public BrandDto(Brand brand) {
            this.id = brand.getId();
            this.name = brand.getName();
        }
    }

    @Getter
    public static class SellerDto {
        private Long id;
        private String name;

        public SellerDto(Seller seller) {
            this.id = seller.getId();
            this.name = seller.getName();
        }
    }

    public ProductListDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.slug = product.getSlug();
        this.shortDescription = product.getShortDescription();
        this.basePrice = product.getPriceInfo().getBasePrice();
        this.salePrice = product.getPriceInfo().getSalePrice();
        this.currency = product.getPriceInfo().getCurrency();
        ProductImageDto primaryImage = null;
        if (!product.getImages().isEmpty()) {
            primaryImage = new ProductImageDto(product.getImages().getFirst());
        }
        this.primaryImage = primaryImage;
        this.brand = new BrandDto(product.getBrand());
        this.seller = new SellerDto(product.getSeller());
        float ratingAvg = (float) product.getReviews().stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
        this.rating = (float) (Math.round(ratingAvg * 10) / 10.0);
        this.reviewCount = product.getReviews().size();
        this.inStock = product.getOptionGroups().stream()
                .filter(group -> group.getOptions() != null)
                .flatMap(group -> group.getOptions().stream())
                .anyMatch(option -> option.getStock() > 0);
        this.status = product.getStatus();
        this.createdAt = product.getCreatedAt();
    }
}
