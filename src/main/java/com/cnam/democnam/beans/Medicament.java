package com.cnam.democnam.beans;

public class Medicament {
	private String intitule ;
	private String description;
	
	public Medicament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicament(String intitule, String description) {
		super();
		this.intitule = intitule;
		this.description = description;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
