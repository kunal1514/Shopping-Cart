package com.springboot.crud.api.dto;

import org.springframework.stereotype.Component;

@Component
public class ResponseDto {
	
	private String msg;

	public ResponseDto() {
		
	}

	public ResponseDto(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ResponseDto [msg=" + msg + "]";
	}

}
