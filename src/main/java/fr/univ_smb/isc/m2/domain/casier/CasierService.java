package fr.univ_smb.isc.m2.domain.casier;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasierService {

    private final ArrayList<Casier> casiers;

    public CasierService() {
        casiers = new ArrayList<>();
        casiers.add(new Casier("Ritchie", "Blackmore"));
        casiers.add(new Casier("Jon", "Lord"));
        casiers.add(new Casier("Ian", "Paice"));
        casiers.add(new Casier("Rod", "Evans"));
        casiers.add(new Casier("Nick", "Simper"));
    }

    public List<Casier> all() {
        return casiers;
    }
}
