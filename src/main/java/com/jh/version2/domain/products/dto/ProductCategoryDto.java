package com.jh.version2.domain.products.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jh.version2.common.variable.Category;
import com.jh.version2.domain.products.entity.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCategoryDto {

    @JsonProperty("브랜드")
    private String brandName;

    @JsonProperty("카테고리")
    private Category category;

    @JsonIgnore
    private int price;

    @JsonProperty("가격")
    public String getFormattedPrice() {
        return String.format("%,d", this.price);
    }

    public ProductCategoryDto(Product product) {
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.brandName = product.getBrand().getEngName();
    }

    public ProductCategoryDto(Category category, Integer price, String engName) {
        this.category = category;
        this.price = price;
        this.brandName = engName;
    }


}
