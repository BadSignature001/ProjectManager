package com.project.manager.response;

public class AuthResponse {
	
	private String jwt ;
	
	private String message ;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AuthResponse(String jwt, String message) {
		super();
		this.jwt = jwt;
		this.message = message;
	}

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AuthResponse [jwt=" + jwt + ", message=" + message + "]";
	}
	
	

}
