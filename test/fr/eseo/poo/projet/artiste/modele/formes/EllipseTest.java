package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class EllipseTest
{
    private static final double EPSILON = 1e-7d;

    @Test
    public void testConstructeurVide()
    {
        Ellipse uneEllipse = new Ellipse();
        Assert.assertEquals("Test constructeur vide failed sur la largeur", 40, uneEllipse.getLargeur(), EPSILON);
        Assert.assertEquals("Test constructeur vide failed sur la hauteur", 20, uneEllipse.getHauteur(), EPSILON);
    }

    @Test
    public void testConstructeurAvecDeuxValeur()
    {
        Ellipse uneEllipse = new Ellipse(4, 7);
        Assert.assertEquals("Test constructeur avec deux valeur failed sur la largeur", 4, uneEllipse.getLargeur(), EPSILON);
        Assert.assertEquals("Test constructeur avec deux valeur failed sur la hauteur", 7, uneEllipse.getHauteur(), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurAvecDeuxValeur_largeurNégative()
    {
        new Ellipse(-4, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurAvecDeuxValeur_hauteurNégative()
    {
        new Ellipse(4, -7);
    }

    @Test
    public void testConstructeurAvecPosition()
    {
        Ellipse uneEllipse = new Ellipse(new Coordonnees(8, 9));
        Assert.assertEquals("Test constructeur avec position failed sur la largeur",
                40, uneEllipse.getLargeur(), EPSILON);
        Assert.assertEquals("Test constructeur avec position failed sur la hauteur",
                20, uneEllipse.getHauteur(), EPSILON);
        Assert.assertEquals("Test constructeur avec position failed sur l'abcisse'",
                8, uneEllipse.getPosition().getAbscisse(), EPSILON);
        Assert.assertEquals("Test constructeur avec position failed sur l'ordonnée'",
                9, uneEllipse.getPosition().getOrdonnee(), EPSILON);
    }

    @Test
    public void testConstructeurComplet()
    {
        Ellipse uneEllipse = new Ellipse(new Coordonnees(8, 9), 26, 80);
        Assert.assertEquals("Test constructeur avec position failed sur la largeur",
                26, uneEllipse.getLargeur(), EPSILON);
        Assert.assertEquals("Test constructeur avec position failed sur la hauteur",
                80, uneEllipse.getHauteur(), EPSILON);
        Assert.assertEquals("Test constructeur avec position failed sur l'abcisse'",
                8, uneEllipse.getPosition().getAbscisse(), EPSILON);
        Assert.assertEquals("Test constructeur avec position failed sur l'ordonnée'",
                9, uneEllipse.getPosition().getOrdonnee(), EPSILON);
    }

    @Test
    public void testContient1()
    {
        Ellipse uneEllipse = new Ellipse(new Coordonnees(4, 0), 10, 20);
        Coordonnees uneCoordonnees = new Coordonnees(5, 4);
        Assert.assertEquals("test de contient failed", true, uneEllipse.contient(uneCoordonnees));
    }

    @Test
    public void testContient2()
    {
        Ellipse uneEllipse = new Ellipse(new Coordonnees(4, 0), 10, 20);
        Coordonnees uneCoordonnees = new Coordonnees(100, 100);
        Assert.assertEquals("test de contient failed", false, uneEllipse.contient(uneCoordonnees));
    }

    @Test
    public void testContient3()
    {
        Ellipse uneEllipse = new Ellipse(new Coordonnees(4, 0), 10, 20);
        Coordonnees uneCoordonnees = new Coordonnees(5, 30);
        Assert.assertEquals("test de contient failed", false, uneEllipse.contient(uneCoordonnees));
    }


    @Test
    public void testContient4()
    {
        Ellipse uneEllipse = new Ellipse(new Coordonnees(4, 0), 10, 20);
        Coordonnees uneCoordonnees = new Coordonnees(2, 10);
        Assert.assertEquals("test de contient failed", false, uneEllipse.contient(uneCoordonnees));
    }

    @Test
    public void testContientMemeCoordonnee()
    {
        Ellipse uneEllipse = new Ellipse(new Coordonnees(4, 0), 10, 20);
        Coordonnees uneCoordonnees = new Coordonnees(4, 0);
        Assert.assertEquals("test de contient failed", false, uneEllipse.contient(uneCoordonnees));
    }

    @Test
    public void testToStringFR()
    {
        Ellipse uneEllipse = new Ellipse(new Coordonnees(8, 9), 26, 80);
        Locale.setDefault(new Locale("fr"));
        assertEquals("Erreur sur le toString en 'fr'", "[Ellipse] : pos (8,0 , 9,0) dim 26,0 x 80,0 périmètre : 177,5 aire : 1633,63", uneEllipse.toString());
    }

    @Test
    public void testToStringEN()
    {
        Ellipse uneEllipse = new Ellipse(new Coordonnees(8, 9), 26, 80);
        Locale.setDefault(new Locale("en"));
        assertEquals("Erreur sur le toString en 'en'", "[Ellipse] : pos (8.0 , 9.0) dim 26.0 x 80.0 périmètre : 177.5 aire : 1633.63", uneEllipse.toString());
    }
}
