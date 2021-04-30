package com.company.serurity.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserDTO {
	@Schema(example = "admin")
	private String username;
	@Schema(example = "admin")
	private String password;
	@Schema(example = "ROLE_ADMIN")
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
