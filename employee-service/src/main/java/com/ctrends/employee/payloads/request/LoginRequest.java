package com.ctrends.employee.payloads.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(description = "Details about employee's loginRequest")
public class LoginRequest {

	@NotBlank
	@ApiModelProperty(notes = "1. Username of an employee", required = true)
	private String username;

	@NotBlank
	@ApiModelProperty(notes = "2. Password of that employee", required = true)
	private String password;

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
