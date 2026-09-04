package com.codewithmosh.store.repositories.specifications;

import com.codewithmosh.store.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpec {
    public static Specification<Product> hasName(String name){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }
    public static Specification<Product> priceGreater(BigDecimal minPrice){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("price"), minPrice));
    }

    public static Specification<Product> priceLess(BigDecimal maxPrice){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("price"), maxPrice));
    }
}
