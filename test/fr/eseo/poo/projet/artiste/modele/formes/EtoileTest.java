package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class EtoileTest
{
    private static final double EPSILON = 1e-7d;


    @Test
    public void testConstructeurVide()
    {
        Etoile uneEtoile = new Etoile();
        Assert.assertEquals("testConstructeurVide failed sur la position abs", 0, uneEtoile.getPosition().getAbscisse(),
                EPSILON);
        Assert.assertEquals("testConstructeurVide failed sur la position ordo", 0, uneEtoile.getPosition().getOrdonnee(),
                EPSILON);
        Assert.assertEquals("testConstructeurVide failed sur la largeur", 40, uneEtoile.getLargeur(),
                EPSILON);
        Assert.assertEquals("testConstructeurVide failed sur la hauteur", 40, uneEtoile.getHauteur(),
                EPSILON);
        Assert.assertEquals("testConstructeurVide failed sur le nombre de branche", 4, uneEtoile.getNombreBranches());
        Assert.assertEquals("testConstructeurVide failed sur l'angle de la premiere branche", 0, uneEtoile.getAnglePremiereBranche(),
                EPSILON);
        Assert.assertEquals("testConstructeurVide failed sur la longueur des branches", 0.8, uneEtoile.getLongueurBranche(),
                EPSILON);
    }

    @Test
    public void testConstructeurTaille()
    {
        Etoile uneEtoile = new Etoile(1000);
        Assert.assertEquals("testConstructeurTaille failed sur la position abs", 0, uneEtoile.getPosition().getAbscisse(),
                EPSILON);
        Assert.assertEquals("testConstructeurTaille failed sur la position ordo", 0, uneEtoile.getPosition().getOrdonnee(),
                EPSILON);
        Assert.assertEquals("testConstructeurTaille failed sur la largeur", 1000, uneEtoile.getLargeur(),
                EPSILON);
        Assert.assertEquals("testConstructeurTaille failed sur la hauteur", 1000, uneEtoile.getHauteur(),
                EPSILON);
        Assert.assertEquals("testConstructeurTaille failed sur le nombre de branche", 4, uneEtoile.getNombreBranches());
        Assert.assertEquals("testConstructeurTaille failed sur l'angle première branche", 0, uneEtoile.getAnglePremiereBranche(),
                EPSILON);
        Assert.assertEquals("testConstructeurTaille failed sur la longueur des branche", 0.8, uneEtoile.getLongueurBranche(),
                EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurTailleIllegaleArgument()
    {
        Etoile uneEtoile = new Etoile(-79);
    }

    @Test
    public void testConstructeurPosition()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(12, 90));
        Assert.assertEquals("testConstructeurPosition failed sur la position abs", 12, uneEtoile.getPosition().getAbscisse(),
                EPSILON);
        Assert.assertEquals("testConstructeurPosition failed sur la position ordo", 90, uneEtoile.getPosition().getOrdonnee(),
                EPSILON);
        Assert.assertEquals("testConstructeurPosition failed sur la largeur", 40, uneEtoile.getLargeur(),
                EPSILON);
        Assert.assertEquals("testConstructeurPosition failed sur la hauteur", 40, uneEtoile.getHauteur(),
                EPSILON);
        Assert.assertEquals("testConstructeurPosition failed sur le nombre de branche", 4, uneEtoile.getNombreBranches());
        Assert.assertEquals("testConstructeurPosition failed sur l'angle première branche", 0, uneEtoile.getAnglePremiereBranche(),
                EPSILON);
        Assert.assertEquals("testConstructeurPosition failed sur la longueur des branche", 0.8, uneEtoile.getLongueurBranche(),
                EPSILON);
    }

    @Test
    public void testConstructeurPositionTaille()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(12, 90), 67);
        Assert.assertEquals("testConstructeurPositionTaille failed sur la position abs", 12, uneEtoile.getPosition().getAbscisse(),
                EPSILON);
        Assert.assertEquals("testConstructeurPositionTaille failed sur la position ordo", 90, uneEtoile.getPosition().getOrdonnee(),
                EPSILON);
        Assert.assertEquals("testConstructeurPositionTaille failed sur la largeur", 67, uneEtoile.getLargeur(),
                EPSILON);
        Assert.assertEquals("testConstructeurPositionTaille failed sur la hauteur", 67, uneEtoile.getHauteur(),
                EPSILON);
        Assert.assertEquals("testConstructeurPositionTaille failed sur le nombre de branche", 4, uneEtoile.getNombreBranches());
        Assert.assertEquals("testConstructeurPositionTaille failed sur l'angle première branche", 0, uneEtoile.getAnglePremiereBranche(),
                EPSILON);
        Assert.assertEquals("testConstructeurPositionTaille failed sur la longueur des branche", 0.8, uneEtoile.getLongueurBranche(),
                EPSILON);
    }

    @Test
    public void testConstructeurComplet()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(12, 90), 67, 12, Math.PI, 0.7);
        Assert.assertEquals("testConstructeurComplet failed sur la position abs", 12, uneEtoile.getPosition().getAbscisse(),
                EPSILON);
        Assert.assertEquals("testConstructeurComplet failed sur la position ordo", 90, uneEtoile.getPosition().getOrdonnee(),
                EPSILON);
        Assert.assertEquals("testConstructeurComplet failed sur la largeur", 67, uneEtoile.getLargeur(),
                EPSILON);
        Assert.assertEquals("testConstructeurComplet failed sur la hauteur", 67, uneEtoile.getHauteur(),
                EPSILON);
        Assert.assertEquals("testConstructeurComplet failed sur le nombre de branche", 12, uneEtoile.getNombreBranches());
        Assert.assertEquals("testConstructeurComplet failed sur l'angle première branche", Math.PI, uneEtoile.getAnglePremiereBranche(),
                EPSILON);
        Assert.assertEquals("testConstructeurComplet failed sur la longueur des branche", 0.7, uneEtoile.getLongueurBranche(),
                EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNombreBrancheSuperieurIllegaleArgument()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(12, 90), 67, 16, Math.PI, 0.7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNombreBrancheInferieurIllegaleArgument()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(12, 90), 67, 2, Math.PI, 0.7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnglePremiereBrancheInferieurIllegaleArgument()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(12, 90), 67, 15, -Math.PI, 0.7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnglePremiereBrancheSuperieurIllegaleArgument()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(12, 90), 67, 15, 5, 0.7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongueurBrancheSuperieurIllegaleArgument()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(12, 90), 67, 15, Math.PI, 1.7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongueurBrancheInferieurIllegaleArgument()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(12, 90), 67, 15, Math.PI, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLargeurIllegaleArgument()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(12, 90), 67, 15, Math.PI, -1);
        uneEtoile.setLargeur(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHauteurIllegaleArgument()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(12, 90), 67, 15, Math.PI, -1);
        uneEtoile.setHauteur(-10);
    }

    @Test
    public void testRecalculeCoordonneeApresSetLargeur()
    {
        Etoile uneEtoile = new Etoile();
        String coordonneesAvant = uneEtoile.getCoordonnees().toString();
        uneEtoile.setLargeur(10);
        Assert.assertNotEquals("testRecalculeCoordonneeApresSetLargeur failed les coordonnées n'on pas été recalculées",
                coordonneesAvant, uneEtoile.getCoordonnees().toString());
    }

    @Test
    public void testRecalculeCoordonneeApresSetHauteur()
    {
        Etoile uneEtoile = new Etoile();
        String coordonneesAvant = uneEtoile.getCoordonnees().toString();
        uneEtoile.setHauteur(10);
        Assert.assertNotEquals("testRecalculeCoordonneeApresSetHauteur failed les coordonnées n'on pas été recalculées",
                coordonneesAvant, uneEtoile.getCoordonnees().toString());
    }

    @Test
    public void testRecalculeCoordonneeApresSetNombreDeBranches()
    {
        Etoile uneEtoile = new Etoile();
        String coordonneesAvant = uneEtoile.getCoordonnees().toString();
        uneEtoile.setNombreBranches(10);
        Assert.assertNotEquals("testRecalculeCoordonneeApresSetNombreDeBranches failed les coordonnées n'on pas été recalculées",
                coordonneesAvant, uneEtoile.getCoordonnees().toString());
    }

    @Test
    public void testRecalculeCoordonneeApresSetAnglePremiereBranche()
    {
        Etoile uneEtoile = new Etoile();
        String coordonneesAvant = uneEtoile.getCoordonnees().toString();
        uneEtoile.setAnglePremiereBranche(Math.PI);
        Assert.assertNotEquals("testRecalculeCoordonneeApresSetAnglePremiereBranche failed les coordonnées n'on pas été recalculées",
                coordonneesAvant, uneEtoile.getCoordonnees().toString());
    }

    @Test
    public void testRecalculeCoordonneeApresSetLongueurBranche()
    {
        Etoile uneEtoile = new Etoile();
        String coordonneesAvant = uneEtoile.getCoordonnees().toString();
        uneEtoile.setLongueurBranche(0.6);
        Assert.assertNotEquals("testRecalculeCoordonneeApresSetLongueurBranche failed les coordonnées n'on pas été recalculées",
                coordonneesAvant, uneEtoile.getCoordonnees().toString());
    }

    @Test
    public void testEstRempli()
    {
        Etoile uneEtoile = new Etoile();
        Assert.assertEquals("testEstRempli failed la variable estRemplie n'est pas False",
                false, uneEtoile.estRempli());
        uneEtoile.setRempli(true);
        Assert.assertEquals("testEstRempli failed la variable estRemplie n'est pas True",
                true, uneEtoile.estRempli());
    }

    @Test
    public void testAire()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(0, 0), 8, 4, 0, 0.6475);
        Assert.assertEquals("testAire failed l'aire n'est pas bonne",
                15.952328983, uneEtoile.aire(), EPSILON);
    }

    @Test
    public void testPerimetre()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(0, 0), 8, 4, 0, 0.6475);
        Assert.assertEquals("testPerimetre failed le perimetre n'est pas bon",
                25.3133141355, uneEtoile.perimetre(), EPSILON);
    }

    @Test
    public void testToStringFR()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(0, 0), 8, 4, 0, 0.6475);
        Locale.setDefault(new Locale("fr"));
        assertEquals("Erreur sur le toString en 'fr'",
                "[Etoile] : pos (0,0 , 0,0) dim 8,0 x 8,0 périmètre : 25,31 aire : 15,95 couleur = R51,V51,B51", uneEtoile.toString());
    }

    @Test
    public void testToStringEN()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(0, 0), 8, 4, 0, 0.6475);
        Locale.setDefault(new Locale("en"));
        assertEquals("Erreur sur le toString en 'en'",
                "[Etoile] : pos (0.0 , 0.0) dim 8.0 x 8.0 périmètre : 25.31 aire : 15.95 couleur = R51,G51,B51", uneEtoile.toString());
    }

    @Test
    public void testToStringFRRempli()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(0, 0), 8, 4, 0, 0.6475);
        uneEtoile.setRempli(true);
        Locale.setDefault(new Locale("fr"));
        assertEquals("Erreur sur le toString en 'fr' pour rempli",
                "[Etoile-Rempli] : pos (0,0 , 0,0) dim 8,0 x 8,0 périmètre : 25,31 aire : 15,95 couleur = R51,V51,B51", uneEtoile.toString());
    }

    @Test
    public void testToStringENRempli()
    {
        Etoile uneEtoile = new Etoile(new Coordonnees(0, 0), 8, 4, 0, 0.6475);
        uneEtoile.setRempli(true);
        Locale.setDefault(new Locale("en"));
        assertEquals("Erreur sur le toString en 'en' pour rempli",
                "[Etoile-Rempli] : pos (0.0 , 0.0) dim 8.0 x 8.0 périmètre : 25.31 aire : 15.95 couleur = R51,G51,B51", uneEtoile.toString());
    }
}
