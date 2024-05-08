package it.corso.dto;

import jakarta.validation.constraints.Pattern;

public class UserUpdateDto {

	@Pattern(regexp = "[a-zA-Z\\s']{1,50}")
	private String name;

	@Pattern(regexp = "[a-zA-Z\\s']{1,50}")
	private String surname;

	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
