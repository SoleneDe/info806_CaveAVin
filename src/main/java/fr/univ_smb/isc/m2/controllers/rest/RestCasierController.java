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

}
