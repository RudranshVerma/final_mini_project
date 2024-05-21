package com.cts.project.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(unique = true)
	@Length(min = 5)
	@NotEmpty(message = "Please Enter Username of minimum of 5 characters")
	private String userName;

	@NotEmpty
	@Email(message = "Please Enter a valid Email Address")
	@Column(unique = true)
	private String emailId;

	
//	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$", message = "password must be min 8 and max 16 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
	
	@NotEmpty
	private String password;

	@NotEmpty(message = "UserType must be either Admin/User")
	private String userRole;
	private Long attendance;

//	public User(Long userId,
//			@Length(min = 5) @NotEmpty(message = "Please Enter Username of minimum of 5 characters") String userName,
//			@NotEmpty @Email(message = "Please Enter a valid Email Address") String emailId,
//			@NotEmpty String password,
//			@NotEmpty(message = "UserType must be either Admin/User") String role,Long attendance) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.emailId = emailId;
//		this.password = password;
//		this.userRole = role;
//		this.attendance=attendance;
//
//	}

	public Long getAttendance() {
		return attendance;
	}

	public void setAttendance(Long attendance) {
		this.attendance = attendance;
	}

	public Long getUserId() { 
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return userRole;
	}

	public void setRole(String role) {
		this.userRole = role;
	}

//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}


}
