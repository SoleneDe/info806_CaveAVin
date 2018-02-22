package fr.univ_smb.isc.m2.domain.casier;

import fr.univ_smb.isc.m2.domain.bouteille.Bouteille;
import org.junit.Test;
import static org.junit.Assert.*;

public class CasierTest {
    
    @Test
    public void should_Not_Have_The_Same_Id() {
        Casier cas = new Casier("Casier");
        Casier cas2 = new Casier("Casier");
        
        assertNotEquals(cas.id, cas2.id);
    }
    
    @Test
    public void should_Start_By_Being_Empty() {
        Casier cas = new Casier("Casier");
        
        assertEquals(cas.nbBouteilles(), 0);
    }
    
    @Test
    public void should_Contain_One_Bottle_After_One_Add() {
        Casier cas = new Casier("Casier");
        Bouteille bout = new Bouteille("Bout", "Reg", 2000, "placeholder.jpg");
        
        cas.add(bout);
        
        assertEquals(cas.nbBouteilles(), 1);
    }
    
    @Test
    public void should_Contain_Two_Bottles_After_Two_Adds_Of_The_Same_Bottle() {
        Casier cas = new Casier("Casier");
        Bouteille bout = new Bouteille("Bout", "Reg", 2000, "placeholder.jpg");
        
        cas.add(bout);
        cas.add(bout);
        
        assertEquals(cas.nbBouteilles(), 2);
    }
    
    @Test
    public void should_Contain_Two_Bottles_After_Two_Adds_Of_Different_Bottle() {
        Casier cas = new Casier("Casier");
        Bouteille bout = new Bouteille("Bout", "Reg", 2000, "placeholder.jpg");
        Bouteille bout2 = new Bouteille("Bout", "Reg", 2000, "placeholder.jpg");
        
        cas.add(bout);
        cas.add(bout2);
        
        assertEquals(cas.nbBouteilles(), 2);
    }
    
    @Test
    public void should_Be_Able_To_Count_The_Different_Kind_Of_Bottle() {
        Casier cas = new Casier("Casier");
        Bouteille bout = new Bouteille("Bout", "Reg", 2000, "placeholder.jpg");
        Bouteille bout2 = new Bouteille("Bout", "Reg", 2000, "placeholder.jpg");
        
        cas.add(bout);
        cas.add(bout);
        cas.add(bout2);
        
        assertEquals(cas.nbBouteilles(bout), 2);
        assertEquals(cas.nbBouteilles(bout2), 1);
    }
    
    @Test
    public void should_Not_Find_Any_Of_This_Bottle() {
        Casier cas = new Casier("Casier");
        Bouteille bout = new Bouteille("Bout", "Reg", 2000, "placeholder.jpg");
        Bouteille bout2 = new Bouteille("Bout", "Reg", 2000, "placeholder.jpg");
        
        cas.add(bout);
        
        assertEquals(cas.nbBouteilles(bout2), 0);
    }
    
    @Test
    public void should_Find_Bottle_By_Its_Id() {
        Casier cas = new Casier("Casier");
        Bouteille bout = new Bouteille("Bout", "Reg", 2000, "placeholder.jpg");
        int id = bout.id;
        
        cas.add(bout);
        
        assertEquals(cas.findBouteilleById(id), bout);
    }
    
    @Test
    public void should_Not_Find_Unexisting_Bottle_By_Its_Id() {
        Casier cas = new Casier("Casier");
        Bouteille bout = new Bouteille("Bout", "Reg", 2000, "placeholder.jpg");
        int id = bout.id;
        
        assertNull(cas.findBouteilleById(id));
    }
    
}
