package fr.univ_smb.isc.m2.domain.bouteille;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BouteilleService {

    private final ArrayList<Bouteille> bouteilles;

    public BouteilleService() {
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
}
