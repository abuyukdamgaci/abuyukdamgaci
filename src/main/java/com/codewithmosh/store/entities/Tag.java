package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tagSet")
    @ToString.Exclude
    public Set<User> userSet = new HashSet<>();


    public Tag(String name) {
        this.name = name;
    }
}
