package com.alkemy.entidades;

public class AutenticacionResponse {
	
	private final String jwt;
	

	public AutenticacionResponse(String jwt) {
		this.jwt = jwt;
	}


	public String getJwt() {
		return jwt;
	}
	
	

}
