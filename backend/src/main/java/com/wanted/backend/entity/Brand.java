package com.wanted.backend.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private String description;

    @Column(name = "logo_url")
    private String logoUrl;
    private String website;

    @Builder
    public Brand(String name, String slug, String description, String logo_url, String website) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.logoUrl = logo_url;
        this.website = website;
    }
}
