package com.jh.version2.domain.products.service;

import com.jh.version2.common.variable.Category;
import com.jh.version2.common.variable.YesOrNo;
import com.jh.version2.domain.products.dto.ProductApplyDto;
import com.jh.version2.domain.products.dto.ProductCategoryDto;
import com.jh.version2.domain.products.dto.ProductDto;
import com.jh.version2.domain.products.entity.Product;
import com.jh.version2.domain.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductDto save(final Product product) {
        productRepository.save(product);
        return ProductDto.of(product);
    }

    @Transactional
    public ProductDto apply(final Product product, final ProductApplyDto applyDto) {
        return ProductDto.of(product.update(applyDto));
    }

    @Transactional
    public void delete(final Product product) {
        product.delete();
    }

    public List<ProductCategoryDto> getProductsForLowCost() {
        return productRepository.findProductsForLowCost();
    }

    public List<ProductCategoryDto> getProductsForLowCostByBrand() {
        return productRepository.findProductsForLowCostByBrand();
    }

    public List<ProductCategoryDto> getCategoryForTop(Category category) {
        final List<ProductCategoryDto> results = productRepository.findCategoryForTop(category);
        results.forEach(dto -> dto.setCategory(null));
        return results;
    }

    public List<ProductCategoryDto> getCategoryForLow(Category category) {
        final List<ProductCategoryDto> results = productRepository.findCategoryForLow(category);
        results.forEach(dto -> dto.setCategory(null));
        return results;
    }

    public Product findByIdAndDeleteYn(Long id) {
        return productRepository.findByIdAndDeleteYn(id, YesOrNo.N)
                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다. id=" + id));
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다. id=" + id));
    }

}
