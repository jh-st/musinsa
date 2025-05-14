package com.jh.version2.domain.products.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.common.variable.Category;
import com.jh.version2.domain.brand.entity.Brand;
import com.jh.version2.domain.products.entity.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductApplyDto {

    private Long brandId;
    private Category category;
    private int price;

    @JsonIgnore
    private Brand brand;

    public Product toEntity() {
        return Product.builder()
                .brand(this.brand)
                .category(this.category)
                .price(this.price)
                .build();
    }

}
