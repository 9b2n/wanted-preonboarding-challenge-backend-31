package com.wanted.backend.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "product_prices")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "base_price")
    private int basePrice;

    @Column(name = "sale_price")
    private int salePrice;

    @Column(name = "cost_price")
    private int costPrice;

    private String currency = "KRW";

    @Column(name = "tax_rate")
    private int taxRate;

    @Builder
    public ProductPrice(Product product, int basePrice, int salePrice, int costPrice, String currency, int taxRate) {
        this.product = product;
        this.basePrice = basePrice;
        this.salePrice = salePrice;
        this.costPrice = costPrice;
        this.currency = currency;
        this.taxRate = taxRate;
    }
}
