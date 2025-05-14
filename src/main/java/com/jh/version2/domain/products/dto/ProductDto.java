package com.jh.version2.domain.products.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.common.variable.Category;
import com.jh.version2.domain.products.entity.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private Long productId;
    private String brandName;
    private Category category;
    private Integer price;

    @Builder
    public ProductDto(final Product product) {
        this.productId = product.getId();
        this.brandName = product.getBrand().getEngName();
        this.category = product.getCategory();
        this.price = product.getPrice();
    }

    public static ProductDto of (final Product product) {
        return ProductDto.builder()
                .product(product)
                .build();
    }

}
