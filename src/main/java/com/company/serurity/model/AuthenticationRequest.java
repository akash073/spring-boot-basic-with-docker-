package com.company.serurity.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class AuthenticationRequest {
	@Schema(example = "admin")
	private String username;
	@Schema(example = "admin")
	private String password;
	
	
	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public AuthenticationRequest()
	{
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
