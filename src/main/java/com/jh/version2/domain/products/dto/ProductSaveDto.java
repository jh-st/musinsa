package com.jh.version2.domain.products.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.common.variable.Category;
import com.jh.version2.domain.brand.entity.Brand;
import com.jh.version2.domain.products.entity.Product;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSaveDto {

    @NotBlank(message = "브랜드 정보는 필수입니다.")
    private Long brandId;

    @NotBlank(message = "카테고리 정보는 필수입니다.")
    private Category category;

    @NotBlank(message = "가격 정보는 필수입니다.")
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

    // 테스트 데이터 삽입용
    @Builder
    public ProductSaveDto(Long brandId, Category category, int price) {
        this.brandId = brandId;
        this.category = category;
        this.price = price;
    }

}
