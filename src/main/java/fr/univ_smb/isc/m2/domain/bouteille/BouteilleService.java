package fr.univ_smb.isc.m2.domain.bouteille;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BouteilleService {

    private final ArrayList<Bouteille> bouteilles;

    public BouteilleService() {
        bouteilles = new ArrayList<>();
        bouteilles.add(new Bouteille("Ritchie", "Blackmore"));
        bouteilles.add(new Bouteille("Jon", "Lord"));
        bouteilles.add(new Bouteille("Ian", "Paice"));
        bouteilles.add(new Bouteille("Rod", "Evans"));
        bouteilles.add(new Bouteille("Nick", "Simper"));
    }

    public List<Bouteille> all() {
        return bouteilles;
    }
}
