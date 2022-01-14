package org.springframework.samples.petclinic.product;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends NamedEntity{
	
	@Min(value = 0)
	private double price;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "product_type_id")
	private ProductType productType;
}
