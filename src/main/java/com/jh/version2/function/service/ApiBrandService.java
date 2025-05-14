package com.jh.version2.function.service;

import com.jh.version2.domain.brand.dto.BrandApplyDto;
import com.jh.version2.domain.brand.dto.BrandDto;
import com.jh.version2.domain.brand.dto.BrandSaveDto;
import com.jh.version2.domain.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiBrandService {

    private final BrandService brandService;

    public BrandDto postBrand(final BrandSaveDto saveDto) {
        return brandService.save(saveDto.toEntity());
    }

    public BrandDto putBrand(final long id, final BrandApplyDto applyDto) {
        return brandService.apply(brandService.findByIdAndDeleteYn(id), applyDto);
    }

    public void deleteBrand(final Long id) {
        brandService.delete(brandService.findByIdAndDeleteYn(id));
    }
    
}
