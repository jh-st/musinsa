package com.jh.version2.function.service;

import com.jh.version2.common.variable.Category;
import com.jh.version2.domain.brand.dto.BrandCategoryDto;
import com.jh.version2.domain.brand.dto.BrandLowDto;
import com.jh.version2.domain.brand.entity.Brand;
import com.jh.version2.domain.brand.service.BrandService;
import com.jh.version2.domain.products.dto.*;
import com.jh.version2.domain.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiProductsService {

    private final ProductService productService;
    private final BrandService brandService;

    public CategoryLowDto getProductLow() {
        final List<ProductCategoryDto> results = productService.getProductsForLowCost();
        final int totalCost = results.stream()
                            .mapToInt(ProductCategoryDto::getPrice)
                            .sum();

        return CategoryLowDto.builder()
                .results(results)
                .totalCost(totalCost)
                .build();
    }

    public BrandLowDto getBrandLow() {
        final List<ProductCategoryDto> results = productService.getProductsForLowCostByBrand();
        final int totalCost = results.stream()
                .mapToInt(ProductCategoryDto::getPrice)
                .sum();
        final String brandName = results.stream()
                .findFirst()
                .map(ProductCategoryDto::getBrandName)
                .orElse("");

        results.forEach(dto -> dto.setBrandName(null));

        return BrandLowDto.builder()
                .results(BrandCategoryDto.builder()
                        .results(results)
                        .totalCost(totalCost)
                        .brandName(brandName)
                        .build())
                .build();
    }

    public CategoryTopLowDto getCategoryForTopLow(@Valid String categoryName) {
        Category category = Category.from(categoryName)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리: " + categoryName));

        return CategoryTopLowDto.builder()
                .low(productService.getCategoryForLow(category))
                .top(productService.getCategoryForTop(category))
                .categoryName(categoryName)
                .build();
    }

    public ProductDto postProduct(final ProductSaveDto saveDto) {
        saveDto.setBrand(checkBrand(saveDto.getBrandId()));
        saveDto.setCategory(checkCategory(saveDto.getCategory().getText()));
        return productService.save(saveDto.toEntity());
    }

    public ProductDto putProduct(final long id, final ProductApplyDto applyDto) {
        applyDto.setBrand(checkBrand(applyDto.getBrandId()));
        applyDto.setCategory(checkCategory(applyDto.getCategory().getText()));
        return productService.apply(productService.findByIdAndDeleteYn(id), applyDto);
    }

    public void deleteProduct(final Long id) {
        productService.delete(productService.findByIdAndDeleteYn(id));
    }

    private Category checkCategory(String categoryName) {
        return Category.from(categoryName)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리: " + categoryName));
    }

    private Brand checkBrand(long brandId) {
        return brandService.findByIdAndDeleteYn(brandId);
    }

}
