package com.buy.group.framework.config;

import java.io.Serializable;
import java.util.List;

import com.buy.group.framework.entity.EntityRole;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final String email;
	private final String name;
	private final String deviceToken;
	private final String userName;
	private final List<String> roles;

	public JwtResponse(String jwttoken, String email, String name, String deviceToken, String userName,
			List<String> roles) {
		this.jwttoken = jwttoken;
		this.email = email;
		this.name = name;
		this.deviceToken = deviceToken;
		this.userName = userName;
		this.roles = roles;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getEmail() {
		return this.email;
	}

	public String getName() {
		return this.name;
	}

	public String getDeviceToken() {
		return this.deviceToken;
	}

	public String getUserName() {
		return this.userName;
	}

	public List<String> getRoles() {
		return this.roles;
	}
}