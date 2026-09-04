package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Byte id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "category")
    @Builder.Default
    private Set<Product> products = new HashSet<>();

    public Category(byte id) {
        this.id = id;
    }

    public void addProduct(String name, BigDecimal price){
        var product = new Product(name,price);
        products.add(product);
        product.setCategory(this);
    }


    public void addProduct(Product product) {
        products.add(product);
    }
}