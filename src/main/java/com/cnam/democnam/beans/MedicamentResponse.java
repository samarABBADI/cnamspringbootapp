package com.cnam.democnam.beans;

import com.cnam.democnam.entities.Medicament;

public class MedicamentResponse {

	private MessageBean msg;
	private Medicament medicament;
	
	public MedicamentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicamentResponse(MessageBean msg, Medicament medicament) {
		super();
		this.msg = msg;
		this.medicament = medicament;
	}
	public MessageBean getMsg() {
		return msg;
	}
	public void setMsg(MessageBean msg) {
		this.msg = msg;
	}
	public Medicament getMedicament() {
		return medicament;
	}
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	
	
	
	
	
}
