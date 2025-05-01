package com.wanted.backend.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "product_options")
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "option_group_id")
    private ProductOptionGroup optionGroup;

    private String name;

    @Column(name = "additional_price", precision = 12, scale = 2)
    private BigDecimal additionalPrice;

    private String sku;
    private int stock;

    @Column(name = "display_order")
    private int displayOrder;

    @Builder
    public ProductOption(String name, ProductOptionGroup optionGroup, BigDecimal additionalPrice, String sku, int stock, int displayOrder) {
        this.name = name;
        this.optionGroup = optionGroup;
        this.additionalPrice = additionalPrice;
        this.sku = sku;
        this.stock = stock;
        this.displayOrder = displayOrder;
    }
}
