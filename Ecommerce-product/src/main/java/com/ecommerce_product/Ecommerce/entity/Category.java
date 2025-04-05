package com.ecommerce_product.Ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_ecom_category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="t_ecom_cat_id")
	private Long id;
	
	@Column(name="t_ecom_cat_name")
	@NotBlank(message="Category name can't be blank")
	private String name;
	
	@Column(name="t_ecom_cat_desc")
	@NotBlank(message="Category desc can't be blank")
	private String desc;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	//@JoinColumn(name="t_ecom_prod_cat_id",referencedColumnName = "t_ecom_cat_id")
	private List<Product> products = new ArrayList<Product>();
	
	@CreatedDate
	@Column(name="t_ecom_cat_crt_at")
	private String created_at;
	
	@LastModifiedDate
	@Column(name="t_ecom_cat_updt_at")
	private String updated_at;
	
}
