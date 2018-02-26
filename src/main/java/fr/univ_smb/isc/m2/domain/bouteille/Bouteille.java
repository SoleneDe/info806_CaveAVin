package fr.univ_smb.isc.m2.domain.bouteille;

public class Bouteille {

    public String nom;
    public String region;
    public int annee;
    public int id; // TODO: remettre en final
    public String photo;

    private static int counter = 0;

    public Bouteille(String nom, String region, int annee, String photo) {
        this.nom = nom;
        this.region = region;
        this.annee = annee;
        id = counter++;
        this.photo = photo;
    }
    
    public Bouteille(Bouteille other) {
        nom = other.nom;
        region = other.region;
        annee = other.annee;
        id = other.id;
        photo = other.photo;
    }
    
    public static void resetCounter() {
        counter = 0;
        
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
        final Bouteille other = (Bouteille) obj;
        return this.id == other.id;
    }
    
}
