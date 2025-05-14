package com.jh.version2.domain.products.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jh.version2.common.variable.Category;
import com.jh.version2.common.variable.YesOrNo;
import com.jh.version2.domain.brand.entity.Brand;
import com.jh.version2.domain.products.dto.ProductApplyDto;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "DELETE_YN")
    @Enumerated(value = EnumType.STRING)
    private YesOrNo deleteYn = YesOrNo.N;

    @Builder
    public Product(Brand brand, Category category, Integer price) {
        this.brand = brand;
        this.category = category;
        this.price = price;
    }

    public Product update(ProductApplyDto applyDto) {
        this.category = applyDto.getCategory();
        this.price = applyDto.getPrice();
        this.brand = applyDto.getBrand();
        return this;
    }

    public Product delete() {
        this.deleteYn = YesOrNo.Y;
        return this;
    }

}
