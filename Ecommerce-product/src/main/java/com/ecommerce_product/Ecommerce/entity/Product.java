package com.ecommerce_product.Ecommerce.entity;

import java.time.LocalDateTime;
import java.util.HashSet;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.ecommerce_product.Ecommerce.constant.ProductSize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor //It will create the default constructor without any parameters
@AllArgsConstructor //It will create a constructor with all parameters
@Table(name="t_ecom_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="t_ecom_prod_id")
	private Long id;
	
	@Column(name="t_ecom_prod_name")
	@NotBlank(message="name can't be blank")
	private String name;

	@Column(name="t_ecom_prod_desc")
	@NotBlank(message="desc can't be blank")
	private String desc;
	
	@Column(name="t_ecom_prod_price")
	@NotBlank(message="price can't be blank")
	private Double price;

	@Enumerated(EnumType.STRING)
	@Column(name="t_ecom_prod_size")
	@NotBlank(message="size can't be blank")
	private ProductSize size;
	
	/*@Column(name="t_ecom_prod_cat_id")
	private Long category_id;*/
	
	@ManyToOne
	@JoinColumn(name="fk_t_ecom_prod_cat_id")
	private Category category;
	
	//@Column(name="t_ecom_prod_inv_id")
	@OneToOne
	@JoinColumn(name="t_ecom_prod_inv_id")
	private Inventory inventory;
	
	//@Column(name="t_ecom_prod_discnt_id")
	@ManyToMany(mappedBy = "product")
	private HashSet<Discount> discount = new HashSet<Discount>();
	
	@CreatedDate
	@Column(name="t_ecom_prod_crt_at")
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(name="t_ecom_prod_updt_at")
	private LocalDateTime updateAt;
	
}
