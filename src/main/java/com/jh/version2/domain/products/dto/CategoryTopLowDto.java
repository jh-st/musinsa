package com.jh.version2.domain.products.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryTopLowDto {

    @JsonProperty("카테고리")
    private String categoryName;

    @JsonProperty("최저가")
    private List<ProductCategoryDto> low;

    @JsonProperty("최고가")
    private List<ProductCategoryDto> top;

    @Builder
    public CategoryTopLowDto(String categoryName, List<ProductCategoryDto> low, List<ProductCategoryDto> top) {
        this.categoryName = categoryName;
        this.low = low;
        this.top = top;
    }

}
