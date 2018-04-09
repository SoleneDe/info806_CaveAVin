package fr.univ_smb.isc.m2.domain.casier;

import fr.univ_smb.isc.m2.domain.bouteille.Bouteille;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class CasierService {

    private final ArrayList<Casier> casiers;

    public CasierService() {  
        Casier.resetCounter();
        
        casiers = new ArrayList<>();
        casiers.add(new Casier("Casier 1"));
        casiers.add(new Casier("Casier 2"));
        casiers.add(new Casier("Casier 3"));
        casiers.add(new Casier("Casier 4"));
        
        Bouteille bout1 = new Bouteille("Bouteille 1", "Region 1", 2001, "placeholder.jpg");
        bout1.id = 0;
        Bouteille bout2 = new Bouteille("Bouteille 2", "Region 2", 2002, "placeholder.jpg");
        bout2.id = 1;
        Bouteille bout3 = new Bouteille("Bouteille 3", "Region 3", 2003, "placeholder.jpg");
        bout3.id = 2;
        
        casiers.get(0).add(bout1);
        casiers.get(0).add(bout1);
        casiers.get(0).add(bout2);
        casiers.get(1).add(bout1);
        casiers.get(1).add(bout1);
        casiers.get(3).add(bout3);
        casiers.get(3).add(bout3);
        casiers.get(3).add(bout3);
    }

    public List<Casier> all() {
        return casiers;
    }

    public Casier selectById(int id) {
        List<Casier> collect = casiers.stream()
                .filter(u -> u.id == id)
                .collect(toList());

        if (collect.isEmpty()) {
            return null;
        } else {
            return collect.get(0);
        }
    }
    
    public int findIndexById(int id) {
        for (int i=0; i<casiers.size(); i++) {
            if (casiers.get(i).id == id) {
                return i;
            }
        }
        return -1;
    }
    
    public Casier create(String nom) {
        Casier casier = new Casier(nom);
        casiers.add(casier);
        return casier;
    }
    
    public void modifQuantity(int id, int idBouteille, int nouvQuantite) {
        Casier casier = casiers.get(findIndexById(id));
        Bouteille bouteille = casier.findBouteilleById(idBouteille);
        
        //TODO: la bouteille n'existe pas vraiment (à corriger avec bdd ?)
        if (bouteille == null)
            bouteille = new Bouteille("Bouteille test", "Region test", 1000, "bouteille.jpg");
            
        casier.modifQuantity(bouteille, nouvQuantite);
            
        
    }
    
    public Casier delete(int id) {
        int index = casiers.indexOf(casiers.get(findIndexById(id)));
        return casiers.remove(index);
    }
    
    public void modifNom(int id, String nom) {
        casiers.get(findIndexById(id)).nom = nom;
    }
    
    
}
