package com.jh.version2.domain.brand.repository;

import com.jh.version2.common.variable.YesOrNo;
import com.jh.version2.domain.brand.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findByIdAndDeleteYn(Long id, YesOrNo deleteYn);

}
