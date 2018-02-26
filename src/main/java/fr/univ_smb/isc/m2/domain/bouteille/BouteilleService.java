package fr.univ_smb.isc.m2.domain.bouteille;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class BouteilleService {

    private final ArrayList<Bouteille> bouteilles;

    public BouteilleService() {
        Bouteille.resetCounter();
        
        bouteilles = new ArrayList<>();
        bouteilles.add(new Bouteille("Bouteille 1", "Region 1", 2001, "bouteille.jpg"));
        bouteilles.add(new Bouteille("Bouteille 2", "Region 2", 2002, "bouteille.jpg"));
        bouteilles.add(new Bouteille("Bouteille 3", "Region 3", 2003, "bouteille.jpg"));
        bouteilles.add(new Bouteille("Bouteille 4", "Region 4", 2004, "bouteille.jpg"));
        bouteilles.add(new Bouteille("Bouteille 5", "Region 5", 2005, "bouteille.jpg"));
        bouteilles.add(new Bouteille("Bouteille 6", "Region 6", 2006, "bouteille.jpg"));
    }

    public List<Bouteille> all() {
        return bouteilles;
    }

    public Bouteille selectById(int id) {
        List<Bouteille> collect = bouteilles.stream()
                .filter(u -> u.id == id)
                .collect(toList());

        if (collect.isEmpty()) {
            return null;
        } else {
            return collect.get(0);
        }
    }
    
    public int findIndexById(int id) {
        for (int i=0; i<bouteilles.size(); i++) {
            if (bouteilles.get(i).id == id) {
                return i;
            }
        }
        return -1;
    }
    
    public Bouteille create(String nom, String region, int annee, String photo) {
        Bouteille bouteille = new Bouteille(nom, region, annee, photo);
        bouteilles.add(bouteille);
        return bouteille;
    }
    
    public void delete(int id) {
        bouteilles.remove(bouteilles.get(findIndexById(id)));
    }
    
    public void modifNom(int id, String nom) {
        bouteilles.get(findIndexById(id)).nom = nom;
    }
    
    public void modifRegion(int id, String region) {
        bouteilles.get(findIndexById(id)).region = region;
    }
    
    public void modifAnnee(int id, int annee) {
        bouteilles.get(findIndexById(id)).annee = annee;
    }
    
    public void modifPhoto(int id, String photo) {
        bouteilles.get(findIndexById(id)).photo = photo;
    }
}
