package com.cnam.democnam.beans;



public class MedicamentsBean {

	private String specialite;
	private long nbreMedicament;
	
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public long getNbreMedicament() {
		return nbreMedicament;
	}
	public void setNbreMedicament(long nbreMedicament) {
		this.nbreMedicament = nbreMedicament;
	}
	public MedicamentsBean(String specialite, long nbreMedicament) {
		super();
		this.specialite = specialite;
		this.nbreMedicament = nbreMedicament;
	}
	public MedicamentsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
