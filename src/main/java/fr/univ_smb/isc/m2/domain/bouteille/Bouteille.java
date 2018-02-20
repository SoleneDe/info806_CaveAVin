package fr.univ_smb.isc.m2.domain.bouteille;

public class Bouteille {

    public final String nom;
    public final String region;
    public final int annee;
    public final int id;

    private static int counter = 0;

    public Bouteille(String nom, String region, int annee) {
        this.nom = nom;
        this.region = region;
        this.annee = annee;
        id = counter++;
    }

}
