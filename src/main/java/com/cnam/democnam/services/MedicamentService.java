package com.cnam.democnam.services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cnam.democnam.beans.MedicamentBean;
import com.cnam.democnam.beans.MedicamentRequest;
import com.cnam.democnam.beans.MedicamentResponse;
import com.cnam.democnam.beans.MedicamentTotal;
import com.cnam.democnam.beans.MedicamentsBean;
import com.cnam.democnam.beans.MessageBean;
import com.cnam.democnam.entities.Medicament;
import com.cnam.democnam.entities.Specialite;
import com.cnam.democnam.repositories.MedicamentRepository;
import com.cnam.democnam.repositories.SpecialiteRepository;


@Service
public class MedicamentService {
	
	@Autowired
	SpecialiteRepository specialiteRepository;
	
	@Autowired
	MedicamentRepository medicamentRepository;
	
	
	public MedicamentResponse addMedicament(Medicament medicament) {
		MedicamentResponse medResponse = new MedicamentResponse();
			MessageBean msg = new MessageBean();
			
			try {
			String ref = medicament.getRef();
			
			
			
			Medicament med = medicamentRepository.findById(ref).orElse(null);
			if(med!=null) {
				msg.setCode(0);
				msg.setMessage("medicament deja existe");
				medResponse.setMedicament(med);
				medResponse.setMsg(msg);
				
			} else {
				
			
				Medicament medicamentsaved = medicamentRepository.save(medicament);
				msg.setCode(1);
				msg.setMessage("medicament ajouté avec succés");
				medResponse.setMedicament(medicamentsaved);
				medResponse.setMsg(msg);
			}
		return medResponse;
			} catch(Exception e) {
				msg.setCode(2);
				msg.setMessage("error interne");
				medResponse.setMedicament(null);
				medResponse.setMsg(msg);
				return medResponse;
			}
		
	}
	
	
	
	
	
	
	
	

public MedicamentTotal totMedicaments(Integer sp) {
	
	List<MedicamentsBean> medicamentList = new ArrayList<MedicamentsBean>();
	MedicamentTotal medicamentTotal = new MedicamentTotal();
	medicamentList = medicamentRepository.findMedicamentSpec(sp);
	long nbreTotal =0;
	for(MedicamentsBean m :medicamentList  ) {
		
		nbreTotal+=m.getNbreMedicament();
	}
	
	
	medicamentTotal.setNbreTotal(nbreTotal);
	
	medicamentTotal.setMedicamentsBean(medicamentList);
	
	return medicamentTotal;
}




public MessageBean deleteMedicament (String id) {


MessageBean msg = new MessageBean();

//Utilisateur u = utilisateurRepository.findById(id).orElse(null);
Medicament m = medicamentRepository.findById(id).orElse(null);
	
 
		if(m!=null) {
			medicamentRepository.deleteById(id);
			msg.setCode(1);
			msg.setMessage("medicament deleted successuful");
			
		} else {
			msg.setCode(0);
			msg.setMessage("medicament not found" +id);
		
			
		}
 
	

return msg;

}














}
