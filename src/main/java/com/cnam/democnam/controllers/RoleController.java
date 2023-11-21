package com.cnam.democnam.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cnam.democnam.entities.Role;

import com.cnam.democnam.repositories.RoleRepository;

//@PreAuthorize(value = "")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	RoleRepository roleRepository;
	

	@GetMapping("/list")
	public ResponseEntity<?> getAllRole() {
	List<Role> listRole = roleRepository.findAll();
	if(listRole!=null && !listRole.isEmpty())
	{
		return ResponseEntity.status(HttpStatus.OK).body(listRole);
		
	} else {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
		
		
		
		
	}
	
	@GetMapping("/get-role/{id}")
	public ResponseEntity<?> getRole(@PathVariable Integer id) {
		try {
		Role role=roleRepository.findById(id).orElse(null);
		if(role==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(role);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/get-role-lib")
	public ResponseEntity<?> getRoleByLibRole(@RequestParam(name="lib") String librole) {
		try {
		Role role=roleRepository.findByLibrol(librole);
		
		return ResponseEntity.status(HttpStatus.OK).body(role);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	

	
	
	
 
	
}
