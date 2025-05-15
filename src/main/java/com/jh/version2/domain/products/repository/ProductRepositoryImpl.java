package com.jh.version2.domain.products.repository;

import com.jh.version2.common.variable.Category;
import com.jh.version2.common.variable.YesOrNo;
import com.jh.version2.domain.products.dto.ProductCategoryDto;
import com.jh.version2.domain.products.entity.Product;
import com.jh.version2.domain.products.entity.QProduct;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    public ProductRepositoryImpl(EntityManager em, JPAQueryFactory jpaQueryFactory) {
        super(Product.class);
        this.em = em;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<ProductCategoryDto> findProductsForLowCost() {
        String sql = ""
                + "SELECT category, price, eng_name "
                + "FROM ( "
                + "    SELECT "
                + "        p.category, "
                + "        p.price, "
                + "        b.eng_name, "
                + "        ROW_NUMBER() OVER (PARTITION BY p.category ORDER BY p.price ASC, b.eng_name DESC) AS rn "
                + "    FROM product p "
                + "    JOIN brand b ON p.brand_id = b.id AND b.delete_yn = 'N' "
                + "    WHERE p.delete_yn = 'N' "
                + ") ranked "
                + "WHERE rn = 1";

        Query nativeQuery = em.createNativeQuery(sql);
        List<Object[]> results = nativeQuery.getResultList();

        return results.stream()
                .map(row -> new ProductCategoryDto(
                        Category.valueOf((String) row[0]),
                        ((Number) row[1]).intValue(),
                        (String) row[2]
                ))
                .sorted(Comparator.comparing(dto -> dto.getCategory().getOrder()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductCategoryDto> findProductsForLowCostByBrand() {
        QProduct product = QProduct.product;

        // 총액이 최저가인 브랜드 확인
        long brandId = jpaQueryFactory
                .select(product.brand.id)
                .from(product)
                .where(product.deleteYn.eq(YesOrNo.N))
                .groupBy(product.brand.id)
                .orderBy(product.price.sum().asc())
                .fetchFirst();

        // 해당 브랜드의 상품 검색
        List<ProductCategoryDto> result = jpaQueryFactory
                .select(Projections.constructor(
                        ProductCategoryDto.class,
                        product
                ))
                .from(product)
                .where(product.brand.id.eq(brandId)
                        .and(product.deleteYn.eq(YesOrNo.N)))
                .fetch();

        result.sort(Comparator.comparing(dto -> dto.getCategory().getOrder()));
        return result;
    }

    @Override
    public List<ProductCategoryDto> findCategoryForLow(Category category) {
        QProduct product = QProduct.product;

        // 최저가 구하기
        Integer minPrice = jpaQueryFactory
                .select(product.price.min())
                .from(product)
                .where(product.category.eq(category)
                        .and(product.deleteYn.eq(YesOrNo.N)))
                .fetchOne();

        return jpaQueryFactory
                .select(Projections.constructor(ProductCategoryDto.class, product))
                .from(product)
                .where(product.category.eq(category)
                        .and(product.deleteYn.eq(YesOrNo.N))
                        .and(product.price.eq(minPrice)))
                .fetch();
    }

    @Override
    public List<ProductCategoryDto> findCategoryForTop(Category category) {
        QProduct product = QProduct.product;

        // 최고가 구하기
        Integer maxPrice = jpaQueryFactory
                .select(product.price.max())
                .from(product)
                .where(product.category.eq(category)
                        .and(product.deleteYn.eq(YesOrNo.N)))
                .fetchOne();

        return jpaQueryFactory
                .select(Projections.constructor(ProductCategoryDto.class, product))
                .from(product)
                .where(product.category.eq(category)
                        .and(product.deleteYn.eq(YesOrNo.N))
                        .and(product.price.eq(maxPrice)))
                .fetch();
    }

}
