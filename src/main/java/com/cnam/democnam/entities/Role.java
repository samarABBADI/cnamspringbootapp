package com.cnam.democnam.entities;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table (name = "role")
public class Role {


	@Id
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name = "librol")
	private String librol;
/*	
	@OneToMany(mappedBy = "role")
    private Collection<Utilisateur> utilisateurs;*/

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer roleId, String librol) {
		super();
		this.roleId = roleId;
		this.librol = librol;
		
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getLibrol() {
		return librol;
	}

	public void setLibrol(String librol) {
		this.librol = librol;
	}

	
	
	
	
	
}
