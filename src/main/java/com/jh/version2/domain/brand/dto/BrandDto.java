package com.jh.version2.domain.brand.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.domain.brand.entity.Brand;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandDto {

    private Long brandId;
    private String korName;
    private String engName;

    @Builder
    public BrandDto(Long brandId, String korName, String engName) {
        this.brandId = brandId;
        this.korName = korName;
        this.engName = engName;
    }

    public static BrandDto of (final Brand brand) {
        return BrandDto.builder()
                .brandId(brand.getId())
                .korName(brand.getKorName())
                .engName(brand.getEngName())
                .build();
    }

}
