package fr.univ_smb.isc.m2.domain.casier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ_smb.isc.m2.domain.bouteille.Bouteille;
import fr.univ_smb.isc.m2.domain.bouteille.BouteilleService;

import java.util.List;

@Service
public class CasierService {

	private final CasierRepository casiersrep;

    @Autowired()
    public CasierService(CasierRepository rep) {
    	List<Bouteille> list = BouteilleService.all();
    	Casier roger = new Casier("Roger");
    	roger.add(list.get(0));
    	Casier dudu = new Casier("Dudu");
    	dudu.add(list.get(1));
    	dudu.add(list.get(1));
    	
    	casiersrep = rep;
    	casiersrep.save(roger);
    	casiersrep.save(dudu);
    
    }

    public List<Casier> all() {
    	return casiersrep.findAll();
    }
}
