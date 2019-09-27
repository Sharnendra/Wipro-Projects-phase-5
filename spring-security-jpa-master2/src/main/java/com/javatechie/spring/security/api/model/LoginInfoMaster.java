package com.javatechie.spring.security.api.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="LOGIN_MST")
public class LoginInfoMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String username;
	@Column(name = "EMAIL",unique=true)
	private String email;	
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(mappedBy="loginInfoMaster",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<UserRoleMaster> userRoleMaster=new ArrayList<UserRoleMaster>();	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<UserRoleMaster> getUserRoleMaster() {
		return userRoleMaster;
	}

	public void setUserRoleMaster(Collection<UserRoleMaster> userRoleMaster) {
		this.userRoleMaster = userRoleMaster;
	}
	
}