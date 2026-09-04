package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, orphanRemoval = true)
    @Builder.Default
    public Set<Address> addresses = new HashSet<>();

    public void addAddress(Address address){
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address){
        addresses.remove(address);
        address.setUser(null);
    }

    public void addTag(String tagName){
        Tag tag = new Tag(tagName);
        tagSet.add(tag);
        tag.getUserSet().add(this);

    }

    @ManyToMany
    @Builder.Default
    @JoinTable(name="user_tag",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="tag_id"))
    private Set<Tag> tagSet = new HashSet<>();

    @OneToOne(mappedBy =  "user", cascade = CascadeType.REMOVE)
    private Profile profile;

    @ManyToMany
    @Builder.Default
    @JoinTable(name="wishlist",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
     private Set<Product> favoriteProducts = new HashSet<>();

    public void addFavoriteProduct(Product product) {
        favoriteProducts.add(product);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "email = " + email + ")";
    }
}
