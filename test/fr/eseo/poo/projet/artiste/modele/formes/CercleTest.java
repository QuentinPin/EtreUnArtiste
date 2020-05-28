package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class CercleTest
{
    private static final double EPSILON = 1e-7d;

    @Test
    public void testConstructeurVide()
    {
        Cercle unCercle = new Cercle();
        Assert.assertEquals("Test constructeur vide failed sur la largeur", 40, unCercle.getLargeur(),
                EPSILON);
        Assert.assertEquals("Test constructeur vide failed sur la hauteur", 40, unCercle.getHauteur(),
                EPSILON);
    }

    @Test
    public void testConstructeurAvecUneValeurTaille()
    {
        Cercle unCercle = new Cercle(33);
        Assert.assertEquals("Test constructeur avec une valeur (taille) failed sur la largeur", 33,
                unCercle.getLargeur(), EPSILON);
        Assert.assertEquals("Test constructeur avec une valeur (taille) failed sur la hauteur", 33,
                unCercle.getHauteur(), EPSILON);
    }

    @Test
    public void testConstructeurAvecUneValeurPosition()
    {
        Cercle unCercle = new Cercle(new Coordonnees(8, 0));
        Assert.assertEquals("Test constructeur avec une valeur (position) failed sur l'abcisse", 8,
                unCercle.getPosition().getAbscisse(), EPSILON);
        Assert.assertEquals("Test constructeur avec une valeur (position) failed sur l'ordonnée'", 0,
                unCercle.getPosition().getOrdonnee(), EPSILON);
    }

    @Test
    public void testConstructeurAvecDeuxValeur()
    {
        Cercle unCercle = new Cercle(new Coordonnees(7, 10), 67);
        Assert.assertEquals("Test constructeur avec deux valeur failed sur la largeur", 67,
                unCercle.getLargeur(), EPSILON);
        Assert.assertEquals("Test constructeur avec deux valeur failed sur la hauteur", 67,
                unCercle.getHauteur(), EPSILON);
        Assert.assertEquals("Test constructeur avec deux valeur failed sur l'abcisse", 7,
                unCercle.getPosition().getAbscisse(), EPSILON);
        Assert.assertEquals("Test constructeur avec deux valeur failed sur l'ordonnée'", 10,
                unCercle.getPosition().getOrdonnee(), EPSILON);
    }

    @Test
    public void testContient1()
    {
        Cercle unCercle = new Cercle(new Coordonnees(4, 0), 10);
        Coordonnees uneCoordonnees = new Coordonnees(5, 4);
        Assert.assertEquals("test de contient failed", true, unCercle.contient(uneCoordonnees));
    }

    @Test
    public void testContient2()
    {
        Cercle unCercle = new Cercle(new Coordonnees(4, 0), 10);
        Coordonnees uneCoordonnees = new Coordonnees(100, 10);
        Assert.assertEquals("test de contient failed", false, unCercle.contient(uneCoordonnees));
    }

    @Test
    public void testToStringFR()
    {
        Cercle unCercle = new Cercle(new Coordonnees(8, 9), 26);
        Locale.setDefault(new Locale("fr"));
        assertEquals("Erreur sur le toString en 'fr'",
                "[Cercle] : pos (8,0 , 9,0) dim 26,0 x 26,0 périmètre : 81,68 aire : 530,93 couleur = R51,V51,B51",
                unCercle.toString());
    }

    @Test
    public void testToStringEN()
    {
        Cercle unCercle = new Cercle(new Coordonnees(8, 9), 26);
        Locale.setDefault(new Locale("en"));
        assertEquals("Erreur sur le toString en 'en'",
                "[Cercle] : pos (8.0 , 9.0) dim 26.0 x 26.0 périmètre : 81.68 aire : 530.93 couleur = R51,G51,B51",
                unCercle.toString());
    }

    @Test
    public void testToStringFRRempli()
    {
        Cercle unCercle = new Cercle(new Coordonnees(8, 9), 26);
        unCercle.setRempli(true);
        Locale.setDefault(new Locale("fr"));
        assertEquals("Erreur sur le toString en 'fr' pour rempli",
                "[Cercle-Rempli] : pos (8,0 , 9,0) dim 26,0 x 26,0 périmètre : 81,68 aire : 530,93 couleur = R51,V51,B51",
                unCercle.toString());
    }

    @Test
    public void testToStringENRempli()
    {
        Cercle unCercle = new Cercle(new Coordonnees(8, 9), 26);
        unCercle.setRempli(true);
        Locale.setDefault(new Locale("en"));
        assertEquals("Erreur sur le toString en 'en' pour rempli",
                "[Cercle-Rempli] : pos (8.0 , 9.0) dim 26.0 x 26.0 périmètre : 81.68 aire : 530.93 couleur = R51,G51,B51",
                unCercle.toString());
    }
}
