package com.cnam.democnam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnam.democnam.entities.Specialite;

@Repository
public interface SpecialiteRepository extends JpaRepository<Specialite, Integer>{
	
	

}
