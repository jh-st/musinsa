package com.jh.version2.domain.products.repository;

import com.jh.version2.common.variable.Category;
import com.jh.version2.domain.products.dto.ProductCategoryDto;

import java.util.List;

public interface ProductRepositoryCustom {

    List<ProductCategoryDto> findProductsForLowCost();

    List<ProductCategoryDto> findProductsForLowCostByBrand();

    List<ProductCategoryDto> findCategoryForTopLow(Category category);
}
