package com.ecommerce_user.Ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "t_ecom_user_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_ecom_usr_add_id")
    private long id;

    @Column(nullable = false,name = "t_ecom_usr_add_l1")
    @NotBlank(message = "Address line 1 should not be blank")
    private String addressLine1;

    @Column(nullable = false,name = "t_ecom_usr_add_l2")
    @NotBlank(message = "Address line 2 should not be blank")
    private String addressLine2;

    @Column(nullable = false,name = "t_ecom_usr_add_city")
    @NotBlank(message = "City should not be blank")
    private String city;

    @Column(nullable = false,name = "t_ecom_usr_add_state")
    @NotBlank(message = "State should not be blank")
    private String state;

    @Column(nullable = false,name="t_ecom_usr_add_country")
    @NotBlank(message = "Country should not be blank")
    private String country;

    @Column(nullable = false,name = "t_ecom_usr_add_zip")
    @NotBlank(message = "Zip code should not be blank")
    private String zipCode;

    @Column(name = "t_ecom_usr_add_landmark")
    private String landmark;

    @Column(name = "fk_t_ecom_add_usr_id")
    private Long userId;

    @CreatedDate
    @Column(updatable = false,nullable = false,name = "t_ecom_usr_add_crt_at")
    @NotBlank(message = "Created date should not be blank")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false,name = "t_ecom_usr_add_upd_at")
    @NotBlank(message = "Updated date should not be blank")
    private LocalDateTime updatedAt;

}
