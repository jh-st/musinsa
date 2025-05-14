package com.jh.version2.function.controller;

import com.jh.version2.common.response.BaseResponse;
import com.jh.version2.domain.brand.dto.BrandLowDto;
import com.jh.version2.domain.products.dto.*;
import com.jh.version2.function.service.ApiProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@Slf4j
@Tag(name = "Products", description = "상품")
@RequestMapping(value = "/api/v1/products", name = "상품")
@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ApiProductsService apiProductsService;

    @Operation(summary = "구현 1) - 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API",
            description = "고객은 카테고리 별로 최저가격인 브랜드와 가격을 조회하고 총액이 얼마인지 확인할 수 있어야 합니다.")
    @GetMapping(value = "/product/low")
    public CategoryLowDto getProductLow() {
        log.info("ProductsController.getProductLow");
        return apiProductsService.getProductLow();
    }

    @Operation(summary = "구현 2) - 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API",
            description = "고객은 단일 브랜드로 전체 카테고리 상품을 구매할 경우 최저가격인 브랜드와 총액이 얼마인지 확인할 수 있어야 합니다.")
    @GetMapping(value = "/brand/low")
    public BrandLowDto getBrandLow() {
        log.info("ProductsController.getBrandLow");
        return apiProductsService.getBrandLow();
    }

    @Operation(summary = "구현 3) - 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API",
            description = "고객은 특정 카테고리에서 최저가격 브랜드와 최고가격 브랜드를 확인하고 각 브랜드 상품의 가격을 확인할 수 있어야 합니다.")
    @GetMapping(value = "/category/topLow")
    public CategoryTopLowDto getPriceByCategory(@RequestParam @NotBlank(message = "카테고리명은 필수입니다.") String categoryName) {
        log.info("ProductsController.getCategoryForTopLow");
        return apiProductsService.getCategoryForTopLow(categoryName);
    }

    @Operation(summary = "구현 4-1) 상품을 추가하는 API")
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse<ProductDto>> post(@RequestBody final ProductSaveDto saveDto) {
        log.info("ProductsController.post");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BaseResponse.ok(201, "등록 성공", apiProductsService.postProduct(saveDto)));
    }

    @Operation(summary = "구현 4-2) 상품을 업데이트하는 API")
    @PutMapping(value = "{id}"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse<ProductDto>> put(@Parameter(description = "상품 ID", required = true) @PathVariable final Long id
            , @RequestBody final ProductApplyDto applyDto) {
        log.info("ProductsController.put");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BaseResponse.ok(200, "수정 성공", apiProductsService.putProduct(id, applyDto)));
    }

    @Operation(summary = "구현 4-3) 상품을 삭제하는 API")
    @DeleteMapping(value = "{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse> delete(@Parameter(description = "상품 ID", required = true) @PathVariable final Long id) {
        log.info("ProductsController.delete");
        apiProductsService.deleteProduct(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BaseResponse.ok(204, "삭제 성공"));
    }

}
