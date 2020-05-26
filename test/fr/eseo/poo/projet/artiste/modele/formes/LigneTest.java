package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class LigneTest
{
    private static final double EPSILON = 1e-7d;

    @Test
    public void testConstructeurVide()
    {
        Ligne uneLigne = new Ligne();
        Assert.assertEquals("Test du constructeur vide failed sur la largeur", 40, uneLigne.getLargeur(), EPSILON);
        Assert.assertEquals("Test du constructeur vide failed sur la hauteur", 20, uneLigne.getHauteur(), EPSILON);
    }

    @Test
    public void testConstructeurDeuxDouble()
    {
        Ligne uneLigne = new Ligne(55, 7.9);
        Assert.assertEquals("Test du constructeur 2 double failed sur la largeur", 55, uneLigne.getLargeur(), EPSILON);
        Assert.assertEquals("Test du constructeur 2 double failed sur la hauteur", 7.9, uneLigne.getHauteur(), EPSILON);
    }

    @Test
    public void testConstructeurUneCoordonnees()
    {
        Ligne uneLigne = new Ligne(new Coordonnees(6, 9));
        Assert.assertEquals("Test du constructeur 1 coordonées failed sur la largeur", 40, uneLigne.getLargeur(), EPSILON);
        Assert.assertEquals("Test du constructeur 1 coordonées failed sur la hauteur", 20, uneLigne.getHauteur(), EPSILON);
        Assert.assertEquals("Test du constructeur 1 coordonées failed sur l'abscisse", 6, uneLigne.getC1().getAbscisse(), EPSILON);
        Assert.assertEquals("Test du constructeur 1 coordonées failed sur l'oordonnées", 9, uneLigne.getC1().getOrdonnee(), EPSILON);
    }

    @Test
    public void testConstructeurComplet()
    {
        Ligne uneLigne = new Ligne(new Coordonnees(7.9, 9.3), 55.9, 98.0);
        Assert.assertEquals("Test du constructeur complet failed sur la largeur", 55.9, uneLigne.getLargeur(), EPSILON);
        Assert.assertEquals("Test du constructeur complet failed sur la hauteur", 98.0, uneLigne.getHauteur(), EPSILON);
        Assert.assertEquals("Test du constructeur complet failed sur l'abscisse", 7.9, uneLigne.getC1().getAbscisse(), EPSILON);
        Assert.assertEquals("Test du constructeur complet failed sur l'oordonnées", 9.3, uneLigne.getC1().getOrdonnee(), EPSILON);
    }

    @Test
    public void testAire()
    {
        Ligne uneLigne = new Ligne(new Coordonnees(7, 9), 55.9, 98.0);
        Assert.assertEquals("Test de l'aire failed", 0, uneLigne.aire(), EPSILON);
    }

    @Test
    public void testPerimetre()
    {
        Ligne uneLigne = new Ligne(new Coordonnees(0, 0), 4, 0);
        Assert.assertEquals("Test du perimetre failed", 4, uneLigne.perimetre(), EPSILON);
    }

    @Test
    public void testSetC2()
    {
        Ligne uneLigne = new Ligne();
        uneLigne.setC2(new Coordonnees(6, 0));
        Assert.assertEquals("Test de setC2 failed sur l'abscisse", 6, uneLigne.getC2().getAbscisse(), EPSILON);
        Assert.assertEquals("Test de setC2 failed sur l'oordonnées", 0, uneLigne.getC2().getOrdonnee(), EPSILON);
    }

    @Test
    public void testgetXMAX()
    {
        Ligne uneLigne = new Ligne(new Coordonnees(3, 8), 7, 0);
        Assert.assertEquals("Test de getXMAX failed", 10, uneLigne.getXMAX(), EPSILON);
    }

    @Test
    public void testgetYMAX()
    {
        Ligne uneLigne = new Ligne(new Coordonnees(3, 8), 7, 0);
        Assert.assertEquals("Test de getYMAX failed", 8, uneLigne.getYMAX(), EPSILON);
    }

    @Test
    public void testgetXMIN()
    {
        Ligne uneLigne = new Ligne(new Coordonnees(3, 8), 7, 0);
        Assert.assertEquals("Test de getXMIN failed", 3, uneLigne.getXMIN(), EPSILON);
    }

    @Test
    public void testgetYMIN()
    {
        Ligne uneLigne = new Ligne(new Coordonnees(3, 8), 7, 0);
        Assert.assertEquals("Test de getYMIN failed", 8, uneLigne.getYMIN(), EPSILON);
    }

    @Test
    public void testSetC1()
    {
        Ligne uneLigne = new Ligne(new Coordonnees(3, 8), 7, 0);
        uneLigne.setC1(new Coordonnees(5, 7));
        Assert.assertEquals("test de setC1 failed sur l'abcisse", 5, uneLigne.getC1().getAbscisse(), EPSILON);
        Assert.assertEquals("test de setC1 failed sur l'ordonné", 7, uneLigne.getC1().getOrdonnee(), EPSILON);
    }

    @Test
    public void testContient1()
    {
        Ligne uneLigne = new Ligne();
        Coordonnees uneCoordonnees = new Coordonnees();
        Assert.assertEquals("test de contient failed", true, uneLigne.contient(uneCoordonnees));
    }

    @Test
    public void testContient2()
    {
        Ligne uneLigne = new Ligne();
        Coordonnees uneCoordonnees = new Coordonnees(100, 10);
        Assert.assertEquals("test de contient failed", false, uneLigne.contient(uneCoordonnees));
    }

    @Test
    public void testToStringFR()
    {
        Ligne uneLigne = new Ligne(new Coordonnees(3, 8), 7, 0);
        Locale.setDefault(new Locale("fr"));
        assertEquals("Erreur sur le toString en 'fr'",
                "[Ligne] c1 : (3,0 , 8,0) c2 : (10,0 , 8,0) longueur : 7,0 angle : 0,0° couleur = R51,V51,B51", uneLigne.toString());
    }

    @Test
    public void testToStringEN()
    {
        Ligne uneLigne = new Ligne(new Coordonnees(3, 8), 7, 0);
        Locale.setDefault(new Locale("en"));
        assertEquals("Erreur sur le toString en 'en'",
                "[Ligne] c1 : (3.0 , 8.0) c2 : (10.0 , 8.0) longueur : 7.0 angle : 0.0° couleur = R51,G51,B51", uneLigne.toString());
    }

    @Test
    public void testToStringEN_angleNegatif()
    {
        // Adrien Castanié ma donné ce jeu de test
        Ligne uneLigne = new Ligne(new Coordonnees(3, 8), 5, -5);
        Locale.setDefault(new Locale("en"));
        assertEquals("Erreur sur le toString en 'en'",
                "[Ligne] c1 : (3.0 , 8.0) c2 : (8.0 , 3.0) longueur : 7.07 angle : 315.0° couleur = R51,G51,B51", uneLigne.toString());
    }
}