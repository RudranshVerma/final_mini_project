package com.cts.project.response;

public class LoginResponse {
	String message;
	Boolean status;
	String role;
	Long id;

	public String getRole() {
		return role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LoginResponse(String message, Boolean status) {
		super();
		this.message = message;
		this.status = status;
		this.role="";
		this.id=(long) -1;
	}
	public LoginResponse(String message, Boolean status, String role , Long id) {
		super();
		this.message = message;
		this.status = status;
		this.role= role;
		this.id=id;
	}

}
