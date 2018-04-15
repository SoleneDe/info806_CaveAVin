package fr.univ_smb.isc.m2.domain.bouteille;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BouteilleService {

    private final BouteilleRepository bouteillesrep;

    @Autowired()
    public BouteilleService(BouteilleRepository rep) {
    	bouteillesrep = rep;
    	bouteillesrep.save(new Bouteille("Domaine de la Romanée-Conti Romanée-Conti Grand Cru", "Côte de Nuits", 1975, "Romanee_Conti.JPG"));
    	bouteillesrep.save(new Bouteille("Egon Muller-Scharzhof Scharzhofberger Riesling Trockenbeerenauslese", "Moselle", 2015, "egon-muller-scharzhof-riesling-2015.jpg"));
    }

    public List<Bouteille> all() {
    	return bouteillesrep.findAll();
    }
}
