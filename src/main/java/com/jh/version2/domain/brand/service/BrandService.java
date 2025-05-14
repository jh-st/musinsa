package com.jh.version2.domain.brand.service;

import com.jh.version2.common.variable.YesOrNo;
import com.jh.version2.domain.brand.dto.BrandApplyDto;
import com.jh.version2.domain.brand.dto.BrandDto;
import com.jh.version2.domain.brand.entity.Brand;
import com.jh.version2.domain.brand.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    @Transactional
    public BrandDto save(final Brand brand) {
        brandRepository.save(brand);
        return BrandDto.of(brand);
    }

    @Transactional
    public BrandDto apply(final Brand brand, final BrandApplyDto applyDto) {
        return BrandDto.of(brand.update(applyDto));
    }

    @Transactional
    public void delete(final Brand brand) {
        brand.delete();
    }

    public Brand findByIdAndDeleteYn(Long id) {
        return brandRepository.findByIdAndDeleteYn(id, YesOrNo.N)
                .orElseThrow(() -> new EntityNotFoundException("브랜드를 찾을 수 없습니다. id=" + id));
    }

    public Brand findById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("브랜드를 찾을 수 없습니다. id=" + id));
    }

}
