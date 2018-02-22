package fr.univ_smb.isc.m2.domain.bouteille;

public class Bouteille {

    public final String nom;
    public final String region;
    public final int annee;
    public final int id;
    public final String photo;

    private static int counter = 0;

    public Bouteille(String nom, String region, int annee, String photo) {
        this.nom = nom;
        this.region = region;
        this.annee = annee;
        id = counter++;
        this.photo = photo;
    }
    
    @Override
    public String toString()
    {
        return id + " : " + nom + ", " + region + ", " + annee;
    }

}
