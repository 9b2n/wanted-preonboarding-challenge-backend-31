package com.wanted.backend.entity;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "product_details")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private float weight;

    @Type(JsonType.class)
    private Map<String, Integer> dimensions;

    private String materials;

    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    @Column(name = "warranty_info")
    private String warrantyInfo;

    @Column(name = "care_instructions")
    private String careInstructions;

    @Type(JsonBinaryType.class)
    @Column(name = "additional_info")
    private Map<String, Object> additionalInfo;

    @Builder
    public ProductDetail(
            Product product,
            float weight,
            Map<String, Integer> dimensions,
            String materials,
            String countryOfOrigin,
            String warrantyInfo,
            String careInstructions,
            Map<String, Object> additionalInfo
    ) {
        this.product = product;
        this.weight = weight;
        this.dimensions = dimensions;
        this.materials = materials;
        this.countryOfOrigin = countryOfOrigin;
        this.warrantyInfo = warrantyInfo;
        this.careInstructions = careInstructions;
        this.additionalInfo = additionalInfo;
    }
}
