package com.cnam.democnam.beans;

public class MedicamentRequest {
	
	private String intitule ;
	private String description;
	private Integer spId;
	private Integer nbreMed;
	public MedicamentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicamentRequest(String intitule, String description, Integer spId, Integer nbreMed) {
		super();
		this.intitule = intitule;
		this.description = description;
		this.spId = spId;
		this.nbreMed = nbreMed;
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
	public Integer getSpId() {
		return spId;
	}
	public void setSpId(Integer spId) {
		this.spId = spId;
	}
	public Integer getNbreMed() {
		return nbreMed;
	}
	public void setNbreMed(Integer nbreMed) {
		this.nbreMed = nbreMed;
	}
	
	

}
