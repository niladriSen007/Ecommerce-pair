package com.ecommerce_user.Ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_ecom_wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_ecom_wishlist_id")
    private Long id;

    @OneToOne(mappedBy="wishlist")
    private User user;

    @Column(name = "t_ecom_wishlist_product_ids")
    private Set<Long> productIds = new HashSet<>();
}
