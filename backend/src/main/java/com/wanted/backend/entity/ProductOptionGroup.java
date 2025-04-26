package com.wanted.backend.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "product_option_groups")
public class ProductOptionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String name;

    @Column(name = "display_order")
    private int displayOrder;

    @OneToMany(mappedBy = "optionGroup")
    private List<ProductOption> options;

    @Builder
    public ProductOptionGroup(Product product, String name, int displayOrder) {
        this.product = product;
        this.name = name;
        this.displayOrder = displayOrder;
    }
}
