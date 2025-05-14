package com.jh.version2.domain.brand.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.domain.brand.entity.Brand;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandSaveDto {

    @NotBlank(message = "브랜드명(국문)은 필수입니다.")
    private String korName;

    @NotBlank(message = "브랜드명(영문)은 필수입니다.")
    private String engName;

    @Builder
    public BrandSaveDto(String korName, String engName) {
        this.korName = korName;
        this.engName = engName;
    }

    public Brand toEntity() {
        return Brand.builder()
                .korName(this.korName)
                .engName(this.engName)
                .build();
    }

}
