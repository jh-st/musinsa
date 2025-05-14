package com.jh.version2.domain.products.repository;

import com.jh.version2.common.variable.YesOrNo;
import com.jh.version2.domain.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    Optional<Product> findByIdAndDeleteYn(Long id, YesOrNo deleteYn);

}
