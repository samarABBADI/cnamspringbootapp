package com.cnam.democnam.beans;

import java.util.List;

public class MedicamentTotal {

	private long nbreTotal;
	private List<MedicamentsBean> medicamentsBean;
	public long getNbreTotal() {
		return nbreTotal;
	}
	public void setNbreTotal(long nbreTotal) {
		this.nbreTotal = nbreTotal;
	}
	public List<MedicamentsBean> getMedicamentsBean() {
		return medicamentsBean;
	}
	public void setMedicamentsBean(List<MedicamentsBean> medicamentsBean) {
		this.medicamentsBean = medicamentsBean;
	}
	public MedicamentTotal(long nbreTotal, List<MedicamentsBean> medicamentsBean) {
		super();
		this.nbreTotal = nbreTotal;
		this.medicamentsBean = medicamentsBean;
	}
	public MedicamentTotal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
