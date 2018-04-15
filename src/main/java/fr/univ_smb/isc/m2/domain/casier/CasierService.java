package fr.univ_smb.isc.m2.domain.casier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ_smb.isc.m2.domain.bouteille.Bouteille;

import java.util.List;

@Service
public class CasierService {

	private final CasierRepository casiersrep;

    @Autowired()
    public CasierService(CasierRepository rep) {
    	Casier roger = new Casier("Roger");
    	roger.add(Bouteille.bouteilles.get(1));
    	roger.add(Bouteille.bouteilles.get(2));
    	Casier dudu = new Casier("Dudu");
    	dudu.add(Bouteille.bouteilles.get(2));
    	dudu.add(Bouteille.bouteilles.get(2));
    	casiersrep = rep;
    	casiersrep.save(roger);
    	casiersrep.save(dudu);
    
    }

    public List<Casier> all() {
    	return casiersrep.findAll();
    }
}
