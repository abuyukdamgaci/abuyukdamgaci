package com.codewithmosh.store.repositories;

import com.codewithmosh.store.dtos.ProductSummary;
import com.codewithmosh.store.dtos.ProductSummaryDTO;
import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    //String
    //select * from product where name = ?
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameLikeIgnoreCase(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameEndsWith(String name);

    //Numbers
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    //Null
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    //Multiple conditions
    List<Product> findByDescriptionNullAndNameNull();

    //Sort
    List<Product> findByNameOrderByDescriptionAsc(String name);

    //Limit
    List<Product> findTop5ByNameOrderByPrice(String name);
    List<Product> findFirst5ByNameOrderByPrice(String name);

    //Find products whose price are in a given range and sort by name
//    List<Product> findByPriceBetweenOrderByName(BigDecimal min, BigDecimal max);
    //SQL
//    @Query(value = "select * from product p where p.price between :min and :max order by p.name", nativeQuery = true)
//    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
    //or
    //JPQL
//    @Query("select p from Product p where p.price between :min and :max order by p.name")
//    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query("select p from Product p where p.price between :min and :max order by p.name")
    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query("select count(*) from Product p where p.price between :min and :max")
    Integer countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying
    @Query("update Product p set p.price =:price where p.category.id =:categoryId")
    void updatePriceByCategory(BigDecimal price, Integer categoryId);

//    List<Product> findByCategory(Category category);

//    List<ProductSummaryDTO> findByCategory(Category category);

//    @Query("select p.id,p.name from Product p where p.category = :category")
//    List<ProductSummary> findByCategory(@Param("category") Category category);

    @Query("select new com.codewithmosh.store.dtos.ProductSummaryDTO(p.id,p.name) from Product p where p.category = :category")
    List<ProductSummaryDTO> findByCategory(@Param("category") Category category);

    @Procedure("findProduct")
    List<Product> findProductsByPrice(BigDecimal min, BigDecimal max);




}