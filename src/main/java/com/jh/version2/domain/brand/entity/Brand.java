package com.jh.version2.domain.brand.entity;

import com.jh.version2.common.variable.YesOrNo;
import com.jh.version2.domain.brand.dto.BrandApplyDto;
import com.jh.version2.domain.products.entity.Product;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "KOR_NAME")
    private String korName;

    @Column(name = "ENG_NAME")
    private String engName;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Product> products;

    @Column(name = "USE_YN")
    @Enumerated(value = EnumType.STRING)
    private YesOrNo useYn = YesOrNo.Y;

    @Column(name = "DELETE_YN")
    @Enumerated(value = EnumType.STRING)
    private YesOrNo deleteYn = YesOrNo.N;

    @Builder
    public Brand(String korName, String engName) {
        this.korName = korName;
        this.engName = engName;
    }

    public Brand update(BrandApplyDto applyDto) {
        this.engName = StringUtils.defaultString(applyDto.getEngName(), engName);
        this.korName = StringUtils.defaultString(applyDto.getKorName(), korName);
        return this;
    }

    public Brand delete() {
        this.useYn = YesOrNo.N;
        this.deleteYn = YesOrNo.Y;
        return this;
    }

}
