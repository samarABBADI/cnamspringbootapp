package com.cnam.democnam.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.cnam.democnam.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	
         public Role findByLibrol (String librole);
	
	
}
