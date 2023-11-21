package com.cnam.democnam.beans;

public class MessageBean {

	
	private Integer code;
	private String message;
public MessageBean(Integer code, String message) {
		
		this.code = code;
		this.message = message;
	}
	public MessageBean() {
		
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
