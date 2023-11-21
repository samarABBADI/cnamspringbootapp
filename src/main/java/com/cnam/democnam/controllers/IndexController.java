package com.cnam.democnam.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.cnam.democnam.beans.Medicament;

@Controller
public class IndexController {

	
	@GetMapping("/index")
	public String getMessage(Model model) {
		
		List<Medicament> listmed=Arrays.asList(
				new Medicament("panadol", "calmant"),
				new Medicament("doliprane", "calmant"));
		model.addAttribute("listmed",listmed);
		return "index";
		 
		
	}	
}
