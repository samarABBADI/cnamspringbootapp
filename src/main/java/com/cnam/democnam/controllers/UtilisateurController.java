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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.cnam.democnam.entities.Utilisateur;
import com.cnam.democnam.repositories.UtilisateurRepository;
import com.cnam.democnam.services.UtilisateurService;
//@PreAuthorize(value = "")
//@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	UtilisateurService utilisateurService;
	
	@GetMapping("/all-users")
	public ResponseEntity<?> getAllUsers() {
try {
	    
		List<Utilisateur> listUser = utilisateurRepository.findAll();
		 System.out.println("testfff");
		if(listUser!=null && !listUser.isEmpty() ) {
			return ResponseEntity.status(HttpStatus.OK).body(listUser);
		} else {
			return ResponseEntity.noContent().build();
		}
		
} catch (Exception e) {
    return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
  }
	}
	
	@GetMapping("/all-users-page/{page}/{size}/{ordre}")
	public ResponseEntity<?> getAllUsersPagination(@PathVariable Integer page,@PathVariable Integer size,@PathVariable String ordre) {
try {
	Sort sort = Sort.by(ordre).descending();
	Pageable pageable = PageRequest.of(page-1,size,sort);
		//List<Utilisateur> listUser = utilisateurRepository.findAll(sort);
		Page<Utilisateur> listUser = utilisateurRepository.findAll(pageable);
		//System.out.println("nbr de page"+ listUser.getTotalPages());
		System.out.println("testfff");
		if(!listUser.isEmpty() && listUser!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(listUser.getContent());
			//return ResponseEntity.status(HttpStatus.OK).body(listUser);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
} catch (Exception e) {
    return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
  }
	}
	
	@GetMapping("/users-by")
	public ResponseEntity<?> getAllUserByUsername(@RequestParam String username) {
	//	Utilisateur user = utilisateurRepository.findByUserIdAndUsername(1, username);
		
		//Utilisateur user = utilisateurRepository.findByUsername(username);
		 try {	
		List<Utilisateur> listUser = utilisateurRepository.findByUsernameContaining(username);
		System.out.println("testfff");
	/*	if(user==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		*/
		if(listUser!=null && !listUser.isEmpty() ) {
			return ResponseEntity.status(HttpStatus.OK).body(listUser);
		} else {
			//return ResponseEntity.noContent().build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		 }catch(Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@GetMapping("/user-by-id-ex/{id}")
	public ResponseEntity<?> getUserByIdEx(@PathVariable Integer id) throws Exception {
	//	Utilisateur user = utilisateurRepository.findByUserIdAndUsername(1, username);
		System.out.println("id est " +id);
try {
		return ResponseEntity.status(HttpStatus.OK).body(utilisateurRepository.findById(id).orElseThrow(() -> new Exception("user not found with id=" +id)));
		//Utilisateur user = utilisateurRepository.findByUserId(id);
		//return ResponseEntity.status(HttpStatus.OK).body(user);
	}catch(Exception e) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	}
	@GetMapping(value ="/user-by")
	public ResponseEntity<?> getUserByUsername(@RequestParam(name="name") String username) {
	//	Utilisateur user = utilisateurRepository.findByUserIdAndUsername(1, username);
		
		Utilisateur user = utilisateurRepository.findByUsername(username);
		
	
		if(user==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
	
	}

	
	// creation d'un nouveau utilisateur
	//@RequestMapping(value ="/add-user" , method = RequestMethod.POST)
	@PostMapping("/add-user") 
	public ResponseEntity<?> addUser (@RequestBody Utilisateur user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurService.addUser(user));
	}
//	
	
// update user 
	
	@PutMapping("/update-user/{id}")
	public ResponseEntity<?> updateUser (@PathVariable Integer id,@RequestBody Utilisateur user) {
		return ResponseEntity.status(HttpStatus.OK).body(utilisateurService.updateUser(id,user));
	}

	// delete user 
	
 @DeleteMapping("/delete-user/{id}")
	public ResponseEntity<?> deleteUser (@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(utilisateurService.deleteUser(id));
	}
 
	
}
