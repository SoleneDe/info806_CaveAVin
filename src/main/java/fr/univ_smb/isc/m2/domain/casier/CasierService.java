package fr.univ_smb.isc.m2.domain.casier;

import fr.univ_smb.isc.m2.domain.bouteille.Bouteille;
import fr.univ_smb.isc.m2.domain.bouteille.BouteilleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class CasierService {

	private final CasierRepository casiersrep;
	private final BouteilleRepository bouteillesrep;

    @Autowired()
    public CasierService(CasierRepository rep, BouteilleRepository bout) {  
    	bouteillesrep = bout;
    	List<Bouteille> list = bouteillesrep.findAll();
        Bouteille bout1 = list.get(0);
        Bouteille bout2 = list.get(1);
        Bouteille bout3 = list.get(2);
        
        casiersrep = rep;
        Casier casier1 = new Casier("Casier 1");
        Casier casier2 = new Casier("Casier 2");
        Casier casier3 = new Casier("Casier 3");
        Casier casier4 = new Casier("Casier 4");
        
        casier1.add(bout1);
        casier1.add(bout2);
        casier2.add(bout1);
        casier2.add(bout1);
        casier2.add(bout1);
        casier2.add(bout2);
        casier2.add(bout2);
        casier2.add(bout3);
        casier2.add(bout3);
        casier3.add(bout1);
        casier3.add(bout2);
        casier3.add(bout3);
        
        casiersrep.save(casier1);
        casiersrep.save(casier2);
        casiersrep.save(casier3);
        casiersrep.save(casier4);
    }

    public List<Casier> all() {
        return casiersrep.findAll();
    }

    public Casier selectById(int id) {
        List<Casier> collect = all().stream()
                .filter(u -> u.id == id)
                .collect(toList());

        if (collect.isEmpty()) {
            return null;
        } else {
            return collect.get(0);
        }
    }
    
    public int findIndexById(int id) {
        for (int i=0; i<all().size(); i++) {
            if (all().get(i).id == id) {
                return i;
            }
        }
        return -1;
    }
    
    public Casier create(String nom) {
        Casier casier = new Casier(nom);
        casiersrep.save(casier);
        return casier;
    }
    
    public void modifQuantity(int id, int idBouteille, int nouvQuantite) {
        Casier casier = all().get(findIndexById(id));
        Bouteille bouteille = casier.findBouteilleById(idBouteille);
        
        if(bouteille != null) {
            casier.modifQuantity(bouteille, nouvQuantite);
            casiersrep.save(casier);
        }else{
        	
        	bouteille = selectBottleById(idBouteille);
        	casier.add(bouteille);
        	casier.modifQuantity(bouteille, nouvQuantite);
        	casiersrep.save(casier);
        }
    }
    
    public Casier delete(int id) {
        int index = all().indexOf(all().get(findIndexById(id)));
        Casier toDestroy = all().get(index);
        casiersrep.delete(toDestroy);
        return toDestroy;
    }
    
    public void modifNom(int id, String nom) {
    	Casier toModif = all().get(findIndexById(id));
    	toModif.nom = nom;
    	casiersrep.save(toModif);
    }

	public void empty(Bouteille toDestroy) {
		for(int i = 0 ; i < casiersrep.count() ; i++){
			Casier temp = casiersrep.findAll().get(i);
			if(temp.contains(toDestroy)){
				temp.modifQuantity(toDestroy, 0);
				casiersrep.save(temp);
			}
		}
	}
	
	private Bouteille selectBottleById(int id) {
        List<Bouteille> collect = bouteillesrep.findAll().stream()
                .filter(u -> u.id == id)
                .collect(toList());

        if (collect.isEmpty()) {
            return null;
        } else {
            return collect.get(0);
        }
    }
    
    
}
