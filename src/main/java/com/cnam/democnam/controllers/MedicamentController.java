package com.cnam.democnam.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

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

import com.cnam.democnam.beans.MedicamentRequest;
import com.cnam.democnam.beans.MedicamentResponse;
import com.cnam.democnam.beans.MedicamentTotal;
import com.cnam.democnam.beans.MedicamentsBean;
import com.cnam.democnam.entities.Medicament;

import com.cnam.democnam.repositories.MedicamentRepository;

import com.cnam.democnam.services.MedicamentService;

//@PreAuthorize(value = "")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/medicaments")
public class MedicamentController {
	
	@Autowired
	MedicamentRepository medRepository;
	
	@Autowired 
	MedicamentService medService;
	

	
	@PostMapping("/add-med")
	public ResponseEntity<?> addMedicament(@RequestBody Medicament medReq) {
		
		MedicamentResponse medResponse = medService.addMedicament(medReq);
		  return ResponseEntity.status(HttpStatus.OK).body(medResponse);
				
			}

	@GetMapping("/list")
	public ResponseEntity<?> getAllMedicament() {
		try {
		List<Medicament> medList = new ArrayList<Medicament> ();
		medList=medRepository.findAll();
		
		List<MedicamentRequest> medReqList = new ArrayList<MedicamentRequest> ();
		
		
		
		if( medList==null || medList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		} else {
			
		
  return ResponseEntity.status(HttpStatus.OK).body(medList);
		
	}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	

	//@GetMapping("/get-med/{ref}")
//	public ResponseEntity<?> getMedicamentByRef(@PathVariable String ref) {
	@GetMapping("/get-med")
	public ResponseEntity<?> getMedicamentByRef(@RequestParam(name="r") String ref) {
		try {
		System.out.println();
		Medicament medicament=medRepository.findByRef(ref);
	
		if(medicament==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			
			
  return ResponseEntity.status(HttpStatus.OK).body(medicament);
		
	}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
 

	@GetMapping("/group-medicaments/{sp}")
	public ResponseEntity<?> getGroupMedicaments(@PathVariable Integer sp) {
try {
		List<MedicamentsBean> listMedicamentBean = medRepository.findMedicamentSpec(sp);

		if( listMedicamentBean!=null && !listMedicamentBean.isEmpty() ) {
			return ResponseEntity.status(HttpStatus.OK).body(listMedicamentBean);
		} else {
			return ResponseEntity.noContent().build();
		}
		
} catch (Exception e) {
    return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
  }
	}
	
	@GetMapping("/total-medicaments/{sp}")
	public ResponseEntity<?> getTotalGroupMedicaments(@PathVariable Integer sp) {
try {
		MedicamentTotal listMedicamentBean = medService.totMedicaments(sp);

		if( listMedicamentBean!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(listMedicamentBean);
		} else {
			return ResponseEntity.noContent().build();
		}
		
} catch (Exception e) {
    return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
  }
	}
	
	
	
}
