package fr.univ_smb.isc.m2.domain.casier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univ_smb.isc.m2.config.rest.ResourceNotFoundException;

@RestController
public class CasierController {
	private final CasierRepository casierRepository;
	
	@Autowired(required = true)
	public CasierController(CasierRepository casierRepository) {
		this.casierRepository = casierRepository;
	}
	
	@RequestMapping(value = "/casier/{id}", method=RequestMethod.GET)
	public Casier casier(@PathVariable String id){
		Casier casier = casierRepository.findOne(Long.parseLong(id));
		
		if(casier == null) {
			throw new ResourceNotFoundException();
		}
		return casier;
	}
}
