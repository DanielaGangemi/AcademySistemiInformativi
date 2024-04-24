package it.corso.dto;

import jakarta.validation.constraints.Pattern;

public class UserUpdateDto {

	@Pattern(regexp = "[a-zA-Z\\s']{1,50}")
	private String name;

	@Pattern(regexp = "[a-zA-Z\\s']{1,50}")
	private String surname;

	private String password;

	private int roleId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
