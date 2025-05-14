package com.jh.version2.domain.brand.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jh.version2.domain.products.dto.ProductCategoryDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandCategoryDto {

    @JsonProperty("브랜드")
    private String brandName;

    @JsonProperty("카테고리")
    private List<ProductCategoryDto> results;

    @JsonIgnore
    private int totalCost;

    @JsonProperty("총액")
    public String getFormattedPrice() {
        return String.format("%,d", this.totalCost);
    }

    @Builder
    public BrandCategoryDto(String brandName, List<ProductCategoryDto> results, int totalCost) {
        this.brandName = brandName;
        this.results = results;
        this.totalCost = totalCost;
    }

}
