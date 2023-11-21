package com.cnam.democnam.beans;

import com.cnam.democnam.entities.Medicament;

public class MedicamentBean {
	private MessageBean messageBean;
	private Medicament medicament;
	public MessageBean getMessageBean() {
		return messageBean;
	}
	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
	}
	public Medicament getMedicament() {
		return medicament;
	}
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	public MedicamentBean(MessageBean messageBean, Medicament medicament) {
		super();
		this.messageBean = messageBean;
		this.medicament = medicament;
	}
	public MedicamentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}
