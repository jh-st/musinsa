package com.jh.version2.domain.brand.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandLowDto {

    @JsonProperty("최저가")
    private BrandCategoryDto results;

    @Builder
    public BrandLowDto(BrandCategoryDto results) {
        this.results = results;
    }

}
