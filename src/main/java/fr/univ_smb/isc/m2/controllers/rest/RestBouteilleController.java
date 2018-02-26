package fr.univ_smb.isc.m2.controllers.rest;

import fr.univ_smb.isc.m2.config.rest.ResourceNotFoundException;
import fr.univ_smb.isc.m2.domain.bouteille.Bouteille;
import fr.univ_smb.isc.m2.domain.bouteille.BouteilleService;
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
public class RestBouteilleController {

    private final BouteilleService bouteilleService;

    @Autowired()
    public RestBouteilleController(BouteilleService bouteilleService) {
        this.bouteilleService = bouteilleService;
    }


    @RequestMapping(value = "/bouteilles", method = RequestMethod.GET)
    public List<Bouteille> bouteille() {
        return bouteilleService.all();
    }

    @RequestMapping(value = "/bouteilles/{id}", method = RequestMethod.GET)
    public Bouteille bouteille(@PathVariable String id) {

        int bouteilleId = parseInt(id);

        List<Bouteille> collect = bouteilleService.all().stream().filter(u -> u.id == bouteilleId).collect(toList());

        if (collect.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return collect.get(0);

    }
    
    @RequestMapping(value = "/bouteilles", method = RequestMethod.POST)
    public Bouteille createBouteille(@RequestParam String nom, @RequestParam String region, @RequestParam String annee, @RequestParam String photo) {
        return bouteilleService.create(nom, region, Integer.parseInt(annee), photo);
    }
    
    @RequestMapping(value = "/bouteilles/{id}", method = RequestMethod.PUT)
    public Bouteille modifBouteille(@PathVariable String id, 
            @RequestParam(value = "nom", required=false) String nom, 
            @RequestParam(value = "region", required=false) String region, 
            @RequestParam(value = "annee", required=false) String annee, 
            @RequestParam(value = "photo", required=false) String photo) {
        
        if (nom!=null)
            bouteilleService.modifNom(parseInt(id), nom);
        if (region!=null)
            bouteilleService.modifRegion(parseInt(id), region);
        if (annee!=null)
            bouteilleService.modifAnnee(parseInt(id), parseInt(annee));
        if (photo!=null)
            bouteilleService.modifPhoto(parseInt(id), photo);
        
        
        return bouteilleService.selectById(parseInt(id));
        
    }

}
