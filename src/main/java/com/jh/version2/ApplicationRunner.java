package com.jh.version2;

import com.jh.version2.common.variable.Category;
import com.jh.version2.domain.brand.dto.BrandDto;
import com.jh.version2.domain.brand.dto.BrandSaveDto;
import com.jh.version2.domain.products.dto.ProductSaveDto;
import com.jh.version2.function.service.ApiBrandService;
import com.jh.version2.function.service.ApiProductsService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

    @Autowired
    ApiProductsService productsService;

    @Autowired
    ApiBrandService brandService;

    @Override
    public void run(ApplicationArguments args) {
        final BrandDto brandDtoA = brandService.postBrand(new BrandSaveDto("A1", "A"));
        final BrandDto brandDtoB = brandService.postBrand(new BrandSaveDto("B1", "B"));
        final BrandDto brandDtoC = brandService.postBrand(new BrandSaveDto("C1", "C"));
        final BrandDto brandDtoD = brandService.postBrand(new BrandSaveDto("D1", "D"));
        final BrandDto brandDtoE = brandService.postBrand(new BrandSaveDto("E1", "E"));
        final BrandDto brandDtoF = brandService.postBrand(new BrandSaveDto("F1", "F"));
        final BrandDto brandDtoG = brandService.postBrand(new BrandSaveDto("G1", "G"));
        final BrandDto brandDtoH = brandService.postBrand(new BrandSaveDto("H1", "H"));
        final BrandDto brandDtoI = brandService.postBrand(new BrandSaveDto("I1", "I"));

        productsService.postProduct(new ProductSaveDto(brandDtoA.getBrandId(), Category.TOP, 11200));
        productsService.postProduct(new ProductSaveDto(brandDtoA.getBrandId(), Category.OUT, 5500));
        productsService.postProduct(new ProductSaveDto(brandDtoA.getBrandId(), Category.BOT, 4200));
        productsService.postProduct(new ProductSaveDto(brandDtoA.getBrandId(), Category.SNK, 9000));
        productsService.postProduct(new ProductSaveDto(brandDtoA.getBrandId(), Category.BAG, 2000));
        productsService.postProduct(new ProductSaveDto(brandDtoA.getBrandId(), Category.CAP, 1700));
        productsService.postProduct(new ProductSaveDto(brandDtoA.getBrandId(), Category.SCK, 1800));
        productsService.postProduct(new ProductSaveDto(brandDtoA.getBrandId(), Category.ACC, 2300));

        productsService.postProduct(new ProductSaveDto(brandDtoB.getBrandId(), Category.TOP, 10500));
        productsService.postProduct(new ProductSaveDto(brandDtoB.getBrandId(), Category.OUT, 5900));
        productsService.postProduct(new ProductSaveDto(brandDtoB.getBrandId(), Category.BOT, 3800));
        productsService.postProduct(new ProductSaveDto(brandDtoB.getBrandId(), Category.SNK, 9100));
        productsService.postProduct(new ProductSaveDto(brandDtoB.getBrandId(), Category.BAG, 2100));
        productsService.postProduct(new ProductSaveDto(brandDtoB.getBrandId(), Category.CAP, 2000));
        productsService.postProduct(new ProductSaveDto(brandDtoB.getBrandId(), Category.SCK, 2000));
        productsService.postProduct(new ProductSaveDto(brandDtoB.getBrandId(), Category.ACC, 2200));

        productsService.postProduct(new ProductSaveDto(brandDtoC.getBrandId(), Category.TOP, 10000));
        productsService.postProduct(new ProductSaveDto(brandDtoC.getBrandId(), Category.OUT, 6200));
        productsService.postProduct(new ProductSaveDto(brandDtoC.getBrandId(), Category.BOT, 3300));
        productsService.postProduct(new ProductSaveDto(brandDtoC.getBrandId(), Category.SNK, 9200));
        productsService.postProduct(new ProductSaveDto(brandDtoC.getBrandId(), Category.BAG, 2200));
        productsService.postProduct(new ProductSaveDto(brandDtoC.getBrandId(), Category.CAP, 1900));
        productsService.postProduct(new ProductSaveDto(brandDtoC.getBrandId(), Category.SCK, 2200));
        productsService.postProduct(new ProductSaveDto(brandDtoC.getBrandId(), Category.ACC, 2100));

        productsService.postProduct(new ProductSaveDto(brandDtoD.getBrandId(), Category.TOP, 10100));
        productsService.postProduct(new ProductSaveDto(brandDtoD.getBrandId(), Category.OUT, 5100));
        productsService.postProduct(new ProductSaveDto(brandDtoD.getBrandId(), Category.BOT, 3000));
        productsService.postProduct(new ProductSaveDto(brandDtoD.getBrandId(), Category.SNK, 9500));
        productsService.postProduct(new ProductSaveDto(brandDtoD.getBrandId(), Category.BAG, 2500));
        productsService.postProduct(new ProductSaveDto(brandDtoD.getBrandId(), Category.CAP, 1500));
        productsService.postProduct(new ProductSaveDto(brandDtoD.getBrandId(), Category.SCK, 2400));
        productsService.postProduct(new ProductSaveDto(brandDtoD.getBrandId(), Category.ACC, 2000));

        productsService.postProduct(new ProductSaveDto(brandDtoE.getBrandId(), Category.TOP, 10700));
        productsService.postProduct(new ProductSaveDto(brandDtoE.getBrandId(), Category.OUT, 5000));
        productsService.postProduct(new ProductSaveDto(brandDtoE.getBrandId(), Category.BOT, 3800));
        productsService.postProduct(new ProductSaveDto(brandDtoE.getBrandId(), Category.SNK, 9900));
        productsService.postProduct(new ProductSaveDto(brandDtoE.getBrandId(), Category.BAG, 2300));
        productsService.postProduct(new ProductSaveDto(brandDtoE.getBrandId(), Category.CAP, 1800));
        productsService.postProduct(new ProductSaveDto(brandDtoE.getBrandId(), Category.SCK, 2100));
        productsService.postProduct(new ProductSaveDto(brandDtoE.getBrandId(), Category.ACC, 2100));

        productsService.postProduct(new ProductSaveDto(brandDtoF.getBrandId(), Category.TOP, 11200));
        productsService.postProduct(new ProductSaveDto(brandDtoF.getBrandId(), Category.OUT, 7200));
        productsService.postProduct(new ProductSaveDto(brandDtoF.getBrandId(), Category.BOT, 4000));
        productsService.postProduct(new ProductSaveDto(brandDtoF.getBrandId(), Category.SNK, 9300));
        productsService.postProduct(new ProductSaveDto(brandDtoF.getBrandId(), Category.BAG, 2100));
        productsService.postProduct(new ProductSaveDto(brandDtoF.getBrandId(), Category.CAP, 1600));
        productsService.postProduct(new ProductSaveDto(brandDtoF.getBrandId(), Category.SCK, 2300));
        productsService.postProduct(new ProductSaveDto(brandDtoF.getBrandId(), Category.ACC, 1900));

        productsService.postProduct(new ProductSaveDto(brandDtoG.getBrandId(), Category.TOP, 10500));
        productsService.postProduct(new ProductSaveDto(brandDtoG.getBrandId(), Category.OUT, 5800));
        productsService.postProduct(new ProductSaveDto(brandDtoG.getBrandId(), Category.BOT, 3900));
        productsService.postProduct(new ProductSaveDto(brandDtoG.getBrandId(), Category.SNK, 9000));
        productsService.postProduct(new ProductSaveDto(brandDtoG.getBrandId(), Category.BAG, 2200));
        productsService.postProduct(new ProductSaveDto(brandDtoG.getBrandId(), Category.CAP, 1700));
        productsService.postProduct(new ProductSaveDto(brandDtoG.getBrandId(), Category.SCK, 2100));
        productsService.postProduct(new ProductSaveDto(brandDtoG.getBrandId(), Category.ACC, 2000));

        productsService.postProduct(new ProductSaveDto(brandDtoH.getBrandId(), Category.TOP, 10800));
        productsService.postProduct(new ProductSaveDto(brandDtoH.getBrandId(), Category.OUT, 6300));
        productsService.postProduct(new ProductSaveDto(brandDtoH.getBrandId(), Category.BOT, 3100));
        productsService.postProduct(new ProductSaveDto(brandDtoH.getBrandId(), Category.SNK, 9700));
        productsService.postProduct(new ProductSaveDto(brandDtoH.getBrandId(), Category.BAG, 2100));
        productsService.postProduct(new ProductSaveDto(brandDtoH.getBrandId(), Category.CAP, 1600));
        productsService.postProduct(new ProductSaveDto(brandDtoH.getBrandId(), Category.SCK, 2000));
        productsService.postProduct(new ProductSaveDto(brandDtoH.getBrandId(), Category.ACC, 2000));

        productsService.postProduct(new ProductSaveDto(brandDtoI.getBrandId(), Category.TOP, 11400));
        productsService.postProduct(new ProductSaveDto(brandDtoI.getBrandId(), Category.OUT, 6700));
        productsService.postProduct(new ProductSaveDto(brandDtoI.getBrandId(), Category.BOT, 3200));
        productsService.postProduct(new ProductSaveDto(brandDtoI.getBrandId(), Category.SNK, 9500));
        productsService.postProduct(new ProductSaveDto(brandDtoI.getBrandId(), Category.BAG, 2400));
        productsService.postProduct(new ProductSaveDto(brandDtoI.getBrandId(), Category.CAP, 1700));
        productsService.postProduct(new ProductSaveDto(brandDtoI.getBrandId(), Category.SCK, 1700));
        productsService.postProduct(new ProductSaveDto(brandDtoI.getBrandId(), Category.ACC, 2400));
    }
}
;