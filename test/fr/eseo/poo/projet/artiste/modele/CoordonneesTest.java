package fr.eseo.poo.projet.artiste.modele;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class CoordonneesTest
{

    private static final double EPSILON = 1e-7d;

    @Test
    public void testConstructeurVide()
    {
        Coordonnees uneCoordonnees = new Coordonnees();
        assertEquals("Erreur sur le constructeur par default sur l'abscisse ! ",
                0., uneCoordonnees.getAbscisse(), EPSILON);
        assertEquals("Erreur sur le constructeur par default sur l'ordonnée ! ",
                0., uneCoordonnees.getOrdonnee(), EPSILON);
    }

    @Test
    public void testConstructeurAbscisseOrdonnee1()
    {
        Coordonnees uneCoordonnees = new Coordonnees(6.787878, 9.64645);
        assertEquals("Erreur sur le constructeur avec les paramètre sur l'abscisse ! ",
                6.787878, uneCoordonnees.getAbscisse(), EPSILON);
        assertEquals("Erreur sur le constructeur avec les paramètre sur l'ordonnée ! ",
                9.64645, uneCoordonnees.getOrdonnee(), EPSILON);
    }

    @Test
    public void testConstructeurAbscisseOrdonnee2()
    {
        Coordonnees uneCoordonnees = new Coordonnees(6.787878, 9.64645);
        assertEquals("Erreur sur le constructeur avec les paramètre sur l'abscisse ! ",
                6.787878, uneCoordonnees.getAbscisse(), EPSILON);
        assertEquals("Erreur sur le constructeur avec les paramètre sur l'ordonnée ! ",
                9.64645, uneCoordonnees.getOrdonnee(), EPSILON);
    }

    @Test
    public void testDeplacerVers1()
    {
        Coordonnees uneCoordonnees = new Coordonnees(6.787878, 9.64645);
        uneCoordonnees.deplacerVers(7, 9);
        assertEquals("Erreur fonction deplacerVers", 7, uneCoordonnees.getAbscisse(), EPSILON);
        assertEquals("Erreur fonction deplacerVers", 9, uneCoordonnees.getOrdonnee(), EPSILON);
    }

    @Test
    public void testDeplacerVers2()
    {
        Coordonnees uneCoordonnees = new Coordonnees(6.787878, 9.64645);
        uneCoordonnees.deplacerVers(-17, 90);
        assertEquals("Erreur fonction deplacerVers", -17, uneCoordonnees.getAbscisse(), EPSILON);
        assertEquals("Erreur fonction deplacerVers", 90, uneCoordonnees.getOrdonnee(), EPSILON);
    }

    @Test
    public void testDeplacerVers3()
    {
        Coordonnees uneCoordonnees = new Coordonnees(6.787878, 9.64645);
        uneCoordonnees.deplacerVers(0, 0);
        assertEquals("Erreur fonction deplacerVers", 0, uneCoordonnees.getAbscisse(), EPSILON);
        assertEquals("Erreur fonction deplacerVers", 0, uneCoordonnees.getOrdonnee(), EPSILON);
    }

    @Test
    public void testdeplacerDe1()
    {
        Coordonnees uneCoordonnees = new Coordonnees(6.787878, 9.64645);
        uneCoordonnees.deplacerDe(0, 0);
        assertEquals("Erreur fonction deplacerDe", 6.787878, uneCoordonnees.getAbscisse(), EPSILON);
        assertEquals("Erreur fonction deplacerDe", 9.64645, uneCoordonnees.getOrdonnee(), EPSILON);
    }

    @Test
    public void testdeplacerDe2()
    {
        Coordonnees uneCoordonnees = new Coordonnees(6.787878, 9.64645);
        uneCoordonnees.deplacerDe(-1, 90);
        assertEquals("Erreur fonction deplacerDe", 5.787878, uneCoordonnees.getAbscisse(), EPSILON);
        assertEquals("Erreur fonction deplacerDe", 99.64645, uneCoordonnees.getOrdonnee(), EPSILON);
    }

    @Test
    public void testDistanceVers1()
    {
        Coordonnees uneCoordonnees = new Coordonnees(0, 0);
        Coordonnees uneAutreCoordonnees = new Coordonnees(1, 1);
        Assert.assertEquals("Erreur sur DistanceVers", Math.sqrt(Math.pow(1, 2) + Math.pow(1, 2)),
                uneCoordonnees.distanceVers(uneAutreCoordonnees), EPSILON);
    }

    @Test
    public void testDistanceVers2()
    {
        Coordonnees uneCoordonnees = new Coordonnees(0, 0);
        Coordonnees uneAutreCoordonnees = new Coordonnees(6, 10);
        Assert.assertEquals("Erreur sur DistanceVers", Math.sqrt(Math.pow(6, 2) + Math.pow(10, 2)),
                uneCoordonnees.distanceVers(uneAutreCoordonnees), EPSILON);
    }

    @Test
    public void testToStringFR()
    {
        Coordonnees coordonnees = new Coordonnees(0, 1278.569);
        Locale.setDefault(new Locale("fr"));
        assertEquals("Erreur sur le toString en 'fr'", "(0,0 , 1 278,57)", coordonnees.toString());
    }

    @Test
    public void testToStringEN()
    {
        Coordonnees coordonnees = new Coordonnees(0, 1278.569);
        Locale.setDefault(new Locale("en"));
        assertEquals("Erreur sur le toString en 'en'", "(0.0 , 1,278.57)", coordonnees.toString());
    }

    @Test
    public void testAngleVers()
    {
        Coordonnees coordonnees = new Coordonnees(0, 3);
        Coordonnees coordonnees1 = new Coordonnees(5, 6);
        assertEquals("Erreur sur angleVers", 0.5404195002705842,
                coordonnees.angleVers(coordonnees1), EPSILON);
    }
}