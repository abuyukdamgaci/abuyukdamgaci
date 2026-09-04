package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Setter
@Entity
@Table(name="profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="bio")
    private String bio;
    @Column(name="phone_number")
    private String phonenumber;
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name="loyalty_point")
    private Integer loyaltyPoints;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    @MapsId
    @ToString.Exclude
    private User user;
}
