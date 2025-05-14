package com.jh.version2.function.controller;

import com.jh.version2.common.response.BaseResponse;
import com.jh.version2.domain.brand.dto.BrandApplyDto;
import com.jh.version2.domain.brand.dto.BrandDto;
import com.jh.version2.domain.brand.dto.BrandSaveDto;
import com.jh.version2.function.service.ApiBrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "Brand", description = "브랜드")
@RequestMapping(value = "/api/v1/brand", name = "브랜드")
@RestController
@RequiredArgsConstructor
public class BrandController {

    private final ApiBrandService apiBrandService;

    @Operation(summary = "구현 5-1) 브랜드를 추가하는 API")
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse<BrandDto>> post(@RequestBody final BrandSaveDto saveDto) {
        log.info("BrandController.post");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BaseResponse.ok(201, "등록 성공", apiBrandService.postBrand(saveDto)));
    }

    @Operation(summary = "구현 5-2) 브랜드를 업데이트하는 API")
    @PutMapping(value = "{id}"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse<BrandDto>> put(@Parameter(description = "상품 ID", required = true) @PathVariable final Long id
            , @RequestBody final BrandApplyDto applyDto) {
        log.info("BrandController.put");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BaseResponse.ok(200, "수정 성공", apiBrandService.putBrand(id, applyDto)));
    }

    @Operation(summary = "구현 5-3) 브랜드를 삭제하는 API")
    @DeleteMapping(value = "{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse> delete(@Parameter(description = "브랜드 ID", required = true) @PathVariable final Long id) {
        log.info("BrandController.delete");
        apiBrandService.deleteBrand(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BaseResponse.ok(204, "삭제 성공"));
    }

}
