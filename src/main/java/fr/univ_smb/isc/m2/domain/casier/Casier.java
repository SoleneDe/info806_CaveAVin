package fr.univ_smb.isc.m2.domain.casier;

import fr.univ_smb.isc.m2.domain.bouteille.Bouteille;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Casier {
	
	private static long lastId = 1;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
	
    public final String nom;
    @Column(columnDefinition="TEXT")
    public HashMap<Bouteille, Integer> contenu;

    public Casier(){
    	nom = "Casier "+id;
    	contenu = new HashMap();
    }
    
    public Casier(String nom) {
        this.nom = nom;
        contenu = new HashMap();
        id = lastId++;
    }
    
    public void add(Bouteille bout){
        if(contains(bout)){
            contenu.put(bout, contenu.get(bout) + 1);
        } else {
            contenu.put(bout, 1);
        }
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
    
    public Bouteille findBouteilleById(long id2){
        for(Map.Entry<Bouteille, Integer> entry : contenu.entrySet()) {
            if (entry.getKey().id == id2)
                return entry.getKey();
        }
        
        return null;
        
    }
    
    public ArrayList<Bouteille> getAllBouteilles(){
    	ArrayList<Bouteille> b = new ArrayList<Bouteille>();
    	for(Map.Entry<Bouteille, Integer> entry : contenu.entrySet()) {
    		b.add(entry.getKey());
    	}
    	return b;
    }
    
    @Override
    public String toString(){
        return id+"";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = (int) (97 * hash + this.id);
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
