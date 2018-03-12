package fr.univ_smb.isc.m2.domain.casier;

import fr.univ_smb.isc.m2.domain.bouteille.Bouteille;
import java.util.HashMap;
import java.util.Map;

public class Casier {

    public String nom;
    public HashMap<Bouteille, Integer> contenu;
    public final int id;

    private static int counter = 0;

    public Casier(String nom) {
        this.nom = nom;
        contenu = new HashMap();
        id = counter++;
    }
    
    public static void resetCounter() {
        counter = 0;
        
    }
    
    public void add(Bouteille bout){
        if(contains(bout)){
            contenu.put(bout, contenu.get(bout) + 1);
        } else {
            contenu.put(bout, 1);
        }
    }
    
    public void modifQuantity(Bouteille bout, int nouvQuantite){
        contenu.put(bout, nouvQuantite);
    }
    
    public boolean contains(Bouteille bout){
        return contenu.containsKey(bout);
    }
    
    public int nbBouteilles() {
        int result = 0;

        for(Map.Entry<Bouteille, Integer> entry : contenu.entrySet()) {
            result += entry.getValue();
        }
        
        return result;
    }
    
    public int nbBouteilles(Bouteille bout) {
        if (contenu.get(bout) != null)
            return contenu.get(bout);
        else
            return 0;
    }
    
    public Bouteille findBouteilleById(int id){
        for(Map.Entry<Bouteille, Integer> entry : contenu.entrySet()) {
            if (entry.getKey().id == id)
                return entry.getKey();
        }
        
        return null;
        
    }
    
    @Override
    public String toString(){
        return id+"";
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
