package com.prajyot.user.DTO;

import lombok.Data;

@Data
public class UserDetailsInDTO {

	private Long id;
	
	private String address;
	
	private Integer age;
	
	private String createdBy;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String phoneNo;
	
	private String modifiedBy;
}
