package com.cnam.democnam.entities;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table (name = "specialite")
public class Specialite {

	
	@Id
	@Column(name = "sp_id")
	private Integer spId;
	
	@Column(name = "libsp")
	private String libsp;

	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Specialite(Integer spId, String libsp) {
		super();
		this.spId = spId;
		this.libsp = libsp;
	}

	public Integer getSpId() {
		return spId;
	}

	public void setSpId(Integer spId) {
		this.spId = spId;
	}

	public String getLibsp() {
		return libsp;
	}

	public void setLibsp(String libsp) {
		this.libsp = libsp;
	}
	
	
	
	
}
