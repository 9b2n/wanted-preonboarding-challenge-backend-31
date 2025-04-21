package com.wanted.backend.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String url;

    @Column(name = "alt_text")
    private String altText;

    @Column(name = "is_primary")
    private boolean isPrimary;

    @Column(name = "display_order")
    private int displayOrder;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private ProductOption option;

    @Builder
    public ProductImage(Product product, String url, String altText, boolean isPrimary, int displayOrder, ProductOption option) {
        this.product = product;
        this.url = url;
        this.altText = altText;
        this.isPrimary = isPrimary;
        this.displayOrder = displayOrder;
        this.option = option;
    }
}
