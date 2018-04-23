package fr.univ_smb.isc.m2.domain.bouteille;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import fr.univ_smb.isc.m2.domain.casier.Casier;
import fr.univ_smb.isc.m2.domain.casier.CasierRepository;

import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class BouteilleService {

    private final BouteilleRepository bouteillesrep;
    private final CasierRepository casiersrep;

    @Autowired()
    public BouteilleService(BouteilleRepository rep, @Lazy CasierRepository casierrep) {
    	casiersrep = casierrep;
    	bouteillesrep = rep;
    	bouteillesrep.save(new Bouteille("Bouteille 1", "Region 1", 2001, "bouteille.jpg"));
    	bouteillesrep.save(new Bouteille("Bouteille 2", "Region 2", 2001, "bouteille.jpg"));
    	bouteillesrep.save(new Bouteille("Bouteille 3", "Region 3", 2001, "bouteille.jpg"));
    	bouteillesrep.save(new Bouteille("Bouteille 4", "Region 4", 2001, "bouteille.jpg"));
    	bouteillesrep.save(new Bouteille("Bouteille 5", "Region 5", 2001, "bouteille.jpg"));
    	bouteillesrep.save(new Bouteille("Bouteille 6", "Region 6", 2001, "bouteille.jpg"));
    	
    }

    public List<Bouteille> all() {
        return bouteillesrep.findAll();
    }

    public Bouteille selectById(int id) {
        List<Bouteille> collect = all().stream()
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
    
    public Bouteille create(String nom, String region, int annee, String photo) {
        Bouteille bouteille = new Bouteille(nom, region, annee, photo);
        bouteillesrep.save(bouteille);
        return bouteille;
    }
    
    public Bouteille create(Bouteille other) {
        Bouteille bouteille = new Bouteille(other);
        bouteillesrep.save(bouteille);
        return bouteille;
    }
    
    public Bouteille delete(int id) {
        int index = all().indexOf(all().get(findIndexById(id)));
        Bouteille toDestroy = all().get(index);
        bouteillesrep.delete(toDestroy);
        
        List<Casier> casiers = casiersrep.findAll();
        for(int i = 0 ; i < casiers.size() ; i++){
        	if(casiers.get(i).contains(toDestroy))
        		casiers.get(i).modifQuantity(toDestroy, 0);
        }
        
        return toDestroy;
    }
    
    public void modifNom(int id, String nom) {
    	Bouteille toModif = all().get(findIndexById(id));
    	toModif.nom = nom;
    	bouteillesrep.save(toModif);
    }
    
    public void modifRegion(int id, String region) {
    	Bouteille toModif = all().get(findIndexById(id));
    	toModif.region = region;
    	bouteillesrep.save(toModif);
    }
    
    public void modifAnnee(int id, int annee) {
    	Bouteille toModif = all().get(findIndexById(id));
    	toModif.annee = annee;
    	bouteillesrep.save(toModif);
    }
    
    public void modifPhoto(int id, String photo) {
    	Bouteille toModif = all().get(findIndexById(id));
    	toModif.photo = photo;
    	bouteillesrep.save(toModif);
    }
}
