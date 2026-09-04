package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryJPA extends JpaRepository<Product, Long>, ProductCriteriaRepository, JpaSpecificationExecutor<Product> {
}