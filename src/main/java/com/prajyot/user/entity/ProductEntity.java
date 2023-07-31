package com.prajyot.user.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PRODUCT")
@Data
public class ProductEntity {
	
	@Id
	private long serial_no;
	
	private long user_id;
	
	private long product_id;
	
	private String category;
	
	private long qty;
	
	private double price;
	
	private Date purchase_date;
}
