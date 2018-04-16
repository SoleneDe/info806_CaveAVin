package fr.univ_smb.isc.m2.domain.bouteille;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univ_smb.isc.m2.config.rest.ResourceNotFoundException;

@RestController
public class BouteilleController {
	private final BouteilleRepository bouteilleRepository;
	
	@Autowired(required = true)
	public BouteilleController(BouteilleRepository bouteilleRepository) {
		this.bouteilleRepository = bouteilleRepository;
	}
	
	@RequestMapping(value = "/bouteille/{id}", method=RequestMethod.GET)
	public Bouteille bouteille(@PathVariable String id){
		Bouteille bouteille = bouteilleRepository.findOne(Long.parseLong(id));
		
		if(bouteille == null) {
			throw new ResourceNotFoundException();
		}
		return bouteille;
	}
}
