package com.ecommerce_user.Ecommerce.entity;

import com.ecommerce_user.Ecommerce.constant.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.HashSet;

@Entity
@Getter
@Setter
@NoArgsConstructor //It will create the default constructor without any parameters
@AllArgsConstructor //It will create a constructor with all parameters
@Table(name = "t_ecom_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_ecom_usr_id")
    private long id;

    @Column(nullable = false, name = "t_ecom_usr_f_name")
    @NotBlank(message = "First name should not be blank")
    private String firstName;

    @Column(nullable = false, name = "t_ecom_usr_l_name")
    @NotBlank(message = "Last name should not be blank")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email should not be blank")
    @Column(unique = true, nullable = false, name = "t_ecom_usr_email")
    private String email;

    //One user can have multiple addresses
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_t_ecom_add_usr_id", referencedColumnName = "t_ecom_usr_id")
    private HashSet<Address> address = new HashSet<>();

    @NotBlank(message = "Password should not be blank")
    @Column(nullable = false, name = "t_ecom_usr_password")
    private String password;

    @NotBlank(message = "Phone number should not be blank")
    @Column(unique = true, nullable = false, name = "t_ecom_usr_phone")
    private String phone;

    @Column(name = "t_ecom_usr_alt_phone")
    private String alternatePhone;

    @Enumerated(EnumType.STRING)
    @Column(name = "t_ecom_usr_gender")
    private Gender gender;

    @CreatedDate
    @Column(updatable = false, nullable = false, name = "t_ecom_usr_crt_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, name = "t_ecom_usr_updt_at")
    private LocalDateTime updatedAt;
}
