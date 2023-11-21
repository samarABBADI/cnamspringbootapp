package com.cnam.democnam.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "utilisateur")
public class Utilisateur {

	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
	//@SequenceGenerator(name = "my_sequence", sequenceName = "my_sequence_name")
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	
	
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	 @ManyToOne (optional = false,fetch = FetchType.LAZY)
	 @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable=true, updatable=true) // Optional: Permet de personnaliser la colonne de jointure
	// @JsonIgnore
	  private Role role;
	
	//@ManyToOne (optional = true,fetch = FetchType.LAZY)
	 @ManyToOne (optional = true,fetch = FetchType.EAGER)
	 @JoinColumn(name = "sp_id", referencedColumnName = "sp_id", nullable = true, insertable=true, updatable=true) // Optional: Permet de personnaliser la colonne de jointure
	 
	  private Specialite specialite;

	 
	 @Column(name="created_on")
	 private Date dateCreation;
	 @Column (name="status")
	 private Integer status;
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	




	public Utilisateur(Integer userId, String username, String password, String email, Role role, Specialite specialite,
			Date dateCreation, Integer status) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.specialite = specialite;
		this.dateCreation = dateCreation;
		this.status = status;
	}







	public Integer getStatus() {
		return status;
	}







	public void setStatus(Integer status) {
		this.status = status;
	}







	public Date getDateCreation() {
		return dateCreation;
	}



	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	
	
}

