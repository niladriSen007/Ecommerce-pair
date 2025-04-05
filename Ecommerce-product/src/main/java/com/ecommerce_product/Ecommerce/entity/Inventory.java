package com.ecommerce_product.Ecommerce.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="t_ecom_inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="t_ecom_invent_id")
	private Long id;
	
	@Column(name="t_ecom_invent_quant")
	@NotBlank(message="product quantity can't be blank")
	private Long quantity;
	
	@CreatedDate
	@Column(name="t_ecom_crt_at")
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(name="t_ecom_updt_at")
	private LocalDateTime updatedAt;
	
	@OneToOne(mappedBy = "inventory")
	private Product product;
}
