package com.javatechie.spring.security.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="USER_ROLE_MAP")
public class UserRoleMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ROLE_ID")
	private int roleId;
	@Column(name = "ROLE_NAME")
	private String roleName;
	
	@ManyToOne
	private LoginInfoMaster loginInfoMaster;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public LoginInfoMaster getLoginInfoMaster() {
		return loginInfoMaster;
	}

	public void setLoginInfoMaster(LoginInfoMaster loginInfoMaster) {
		this.loginInfoMaster = loginInfoMaster;
	}	

}
