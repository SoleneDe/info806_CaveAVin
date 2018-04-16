package fr.univ_smb.isc.m2.controllers.rest;

import fr.univ_smb.isc.m2.config.rest.ResourceNotFoundException;
import fr.univ_smb.isc.m2.domain.casier.Casier;
import fr.univ_smb.isc.m2.domain.casier.CasierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class RestCasierController {

    private final CasierService casierService;

    @Autowired()
    public RestCasierController(CasierService casierService) {
        this.casierService = casierService;
    }


    @RequestMapping(value = "/casiers", method = RequestMethod.GET)
    public List<Casier> casier() {
        return casierService.all();
    }

    @RequestMapping(value = "/casiers/{id}", method = RequestMethod.GET)
    public Casier casier(@PathVariable String id) {

        int casierId = parseInt(id);

        List<Casier> collect = casierService.all().stream().filter(u -> u.id == casierId).collect(toList());

        if (collect.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return collect.get(0);

    }
    
    @RequestMapping(value = "/casiers", method = RequestMethod.POST)
    public Casier createCasier(@RequestParam String nom) {
        return casierService.create(nom);
    }
    
    @RequestMapping(value = "/casiers/{id}", method = RequestMethod.PUT)
    public Casier modifCasier(@PathVariable String id, 
            @RequestParam(value = "nom", required=false) String nom, 
            @RequestParam(value = "idBouteille", required=false) String idBouteille,
            @RequestParam(value = "quantite", required=false) String quantite) {
        
        if (nom!=null) {
            casierService.modifNom(parseInt(id), nom);
        }
        if (idBouteille!=null && quantite!=null) {
            casierService.modifQuantity(parseInt(id), parseInt(idBouteille), parseInt(quantite));
        }
        
        return casierService.selectById(parseInt(id));
        
    }
    
    @RequestMapping(value = "/casiers/{id}", method = RequestMethod.DELETE)
    public Casier supprCasier(@PathVariable String id) {
        return casierService.delete(parseInt(id));
    }

}
