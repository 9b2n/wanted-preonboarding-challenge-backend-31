package com.wanted.backend.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "is_primary")
    private boolean isPrimary;

    @Builder
    public ProductCategory(Product product, Category category, boolean isPrimary) {
        this.product = product;
        this.category = category;
        this.isPrimary = isPrimary;
    }
}
