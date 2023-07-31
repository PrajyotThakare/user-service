package com.prajyot.user.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "USER")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ID")
	private Long id;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "AGE")
	private Integer age;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FNAME")
	private String firstName;
	
	@Column(name = "LNAME")
	private String lastName;
	
	@Column(name = "PHONE_NO")
	private String phoneNo;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
//	@Column(name = "PRODUCTS")
//	@OneToOne(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "cp_fk", referencedColumnName = "id")
//	private List<ProductEntity> products;
}
