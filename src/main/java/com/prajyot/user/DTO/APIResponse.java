package com.prajyot.user.DTO;

import java.util.List;

import lombok.Data;

@Data
public class APIResponse<E> {

	public APIResponse() {}
	
	public APIResponse(String errorCode, String errorMessege, List<E> data) {
		this.responseCode = errorCode;
		this.data = data;
		this.responseMessege = errorMessege;
		
	}
	
	private String responseCode;
	private String responseMessege;
	private List<E> data;
}
