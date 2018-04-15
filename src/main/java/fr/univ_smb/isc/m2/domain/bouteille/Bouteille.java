package fr.univ_smb.isc.m2.domain.bouteille;


import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bouteille implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4631564447766852726L;

	public static ArrayList<Bouteille> bouteilles = new ArrayList<Bouteille>();
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String nom;
    public String region; 
    public int annee;
    public String photo;

    public Bouteille() {
    	bouteilles.add(this);
    }
    
    public Bouteille(String nom, String region, int annee, String photo) {
        this.nom = nom;
        this.region = region;
        this.annee = annee;
        this.photo = photo;
    	bouteilles.add(this);
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
        final Bouteille other = (Bouteille) obj;
        return this.id == other.id;
    }
    
}
