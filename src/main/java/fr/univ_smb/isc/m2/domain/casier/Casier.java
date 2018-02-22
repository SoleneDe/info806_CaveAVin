package fr.univ_smb.isc.m2.domain.casier;

import fr.univ_smb.isc.m2.domain.bouteille.Bouteille;
import java.util.HashMap;

public class Casier {

    public final String nom;
    public HashMap<Bouteille, Integer> contenu;
    public final int id;

    private static int counter = 0;

    public Casier(String nom) {
        this.nom = nom;
        contenu = new HashMap();
        id = counter++;
    }
    
    public void add(Bouteille bout){
        // chercher si la bouteille existe déjà
        // oui : +1
        // non : on rajoute à la liste
        if(contains(bout)){
            contenu.put(bout, contenu.get(bout) + 1);
        } else {
            contenu.put(bout, 1);
        }
    }
    
    public boolean contains(Bouteille bout){
        return contenu.containsKey(bout);
    }
    
    @Override
    public String toString(){
        return id + " : " + nom;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Casier other = (Casier) obj;
        return this.id == other.id;
    }
    
    

}
