package fr.univ_smb.isc.m2.domain.casier;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasierService {

    private final ArrayList<Casier> casiers;

    public CasierService() {
        casiers = new ArrayList<>();
        casiers.add(new Casier("Casier 1"));
        casiers.add(new Casier("Casier 2"));
        casiers.add(new Casier("Casier 3"));
        casiers.add(new Casier("Casier 4"));
    }

    public List<Casier> all() {
        return casiers;
    }
}
