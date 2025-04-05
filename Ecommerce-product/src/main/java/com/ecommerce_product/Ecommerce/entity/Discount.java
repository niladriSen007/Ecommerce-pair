package com.ecommerce_product.Ecommerce.entity;

import java.time.LocalDateTime;
import java.util.HashSet;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_ecom_discount")
public class Discount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="t_ecom_dis_id")
	private Long id;
	
	@Column(name="t_ecom_dis_name")
	@NotBlank(message="Discount name con't be blank")
	private String name;
	
	@Column(name="t_ecom_dis_desc")
	@NotBlank(message="Discount desc con't be blank")
	private String desc;
	
	@Column(name="t_ecom_dis_percentage")
	@NotBlank(message="Discount Percentage con't be blank")
	private Float discountPercentage;
	
	@Column(name="t_ecom_dis_active")
	@NotBlank(message="Discount status con't be blank")
	private Boolean active;
	
	@ManyToMany
	@JoinTable(name="t_ecom_prod_dis",
	joinColumns = @JoinColumn(name="t_ecom_dis_id"),
	inverseJoinColumns = @JoinColumn(name="t_ecom_prod_id"))
	private HashSet<Product> product = new HashSet<Product>();
	
	@CreatedDate
	@Column(name="t_ecom_dis_crt_at")
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(name="t_ecom_dis_updt_at")
	private LocalDateTime updatedAt;
}