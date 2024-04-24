package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "corso")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_C")
	private int id;
	
	@Column(name = "Nome_Corso")
	private String courseName;
	
	@Column(name = "Descrizione_breve")
	private String shortDescription;
	
	@Column(name = "Descrizione_completa")
	private String longDescription;
	
	@Column(name = "Durata")
	private int duration;
	
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(
			
			name = "utenti_corsi",
			joinColumns = @JoinColumn(name = "FK_CU", referencedColumnName = "ID_C"),
			inverseJoinColumns = @JoinColumn(name = "FK_UC", referencedColumnName = "ID_U")
			
			)
	private List<User> userList = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(
			
			name = "FK_CA", referencedColumnName = "ID_CA"
			
			)
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
		
}
