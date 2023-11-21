package com.cnam.democnam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cnam.democnam.beans.MedicamentsBean;
import com.cnam.democnam.entities.Medicament;


@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, String>{

	public Medicament findByRef (String ref);
	public Medicament findByIntutile(String intutile);
	public Medicament findByIntutileAndDescription (String intutile, String description);
	public Medicament findByIntutileLike (String intutile);
	public Medicament findByIntutileContaining (String intutile);
	public boolean  existsByIntutile (String intutile);
	public boolean  existsByRef(String ref);
	

		@Query(value = "SELECT new com.cnam.democnam.beans.MedicamentsBean( m.specialite.libsp ,count(m)) "
				+ " FROM Medicament m"
				+ " where (m.specialite.spId=:sp and (:sp!=-1)) or (:sp=-1)"
				+ " GROUP BY m.specialite.libsp")
		List<MedicamentsBean> findMedicamentSpec(@Param("sp") Integer sp);
		
		


}
