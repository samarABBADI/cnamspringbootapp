package com.cnam.democnam.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnam.democnam.beans.Medicament;

@RestController
public class HomeController {

	
	
	@GetMapping("/hello")
	public List<Medicament> getMessage() {
		// listPerson = new ArrayList<String>();
		List<Medicament> listmed=Arrays.asList(
				new Medicament("panadol", "calmant"),
				new Medicament("doliprane", "calmant"));
	
		
		return listmed; 
		
	}	
}
