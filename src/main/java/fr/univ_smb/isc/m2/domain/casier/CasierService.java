package fr.univ_smb.isc.m2.domain.casier;

import fr.univ_smb.isc.m2.domain.bouteille.Bouteille;
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
        
        Bouteille bout1 = new Bouteille("Bouteille 1", "Region 1", 2001, "placeholder.jpg");
        Bouteille bout2 = new Bouteille("Bouteille 2", "Region 2", 2002, "placeholder.jpg");
        Bouteille bout3 = new Bouteille("Bouteille 3", "Region 3", 2003, "placeholder.jpg");
        
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
}
