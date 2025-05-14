package com.jh.version2.domain.products.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryLowDto {

    @JsonProperty("결과")
    private List<ProductCategoryDto> results;

    @JsonIgnore
    private int totalCost;

    @JsonProperty("총액")
    public String getFormattedPrice() {
        return String.format("%,d", this.totalCost);
    }

    @Builder
    public CategoryLowDto(List<ProductCategoryDto> results, int totalCost) {
        this.results = results;
        this.totalCost = totalCost;
    }

}
