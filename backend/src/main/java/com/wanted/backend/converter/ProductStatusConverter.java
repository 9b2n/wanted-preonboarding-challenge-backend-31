package com.wanted.backend.converter;

import com.wanted.backend.enums.ProductStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;

@Converter
@Slf4j
public class ProductStatusConverter implements AttributeConverter<ProductStatus, String> {
    @Override
    public String convertToDatabaseColumn(ProductStatus productStatus) {
        return productStatus.name();
    }

    @Override
    public ProductStatus convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        try {
            return ProductStatus.valueOf(s);
        } catch (IllegalArgumentException e) {
            log.error("failure to convert {} to ProductStatus", s);
            throw e;
        }
    }
}
