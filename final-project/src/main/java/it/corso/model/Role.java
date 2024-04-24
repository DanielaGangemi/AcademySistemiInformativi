package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ruolo")
public class Role {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_G")
	private int id;
	
	@Column(name = "TIPOLOGIA")
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(
			
			name = "utente_ruolo",
			joinColumns = @JoinColumn(name="FK_R", referencedColumnName = "ID_G"),
			inverseJoinColumns = @JoinColumn(name = "FK_U", referencedColumnName = "ID_U")
			
			)
	List<User> userList = new ArrayList<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public RoleType getRoleType() {
		return roleType;
	}


	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}


	public List<User> getUserList() {
		return userList;
	}


	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
