package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EtoileParameterizedTests
{

    /*
    Ce test paramétré à pour butte de tester la fonction contient de Etoile
    Le point à tester sera placé a différent point par rapport a l'étoile (a droite, a gauche, dedans,...)
     */
    private Etoile etoileATester;
    private Coordonnees coordonnees;
    private boolean attendu;

    public EtoileParameterizedTests(Etoile etoileATester, Coordonnees coordonnees, boolean attendu)
    {
        this.etoileATester = etoileATester;
        this.coordonnees = coordonnees;
        this.attendu = attendu;
    }


    @Parameterized.Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt()
    {
        Etoile uneEtoile1 = new Etoile(new Coordonnees(0, 0), 8, 4, 0, 0.6475);
        Coordonnees uneCoordonnees1 = new Coordonnees(4, 4);
        Coordonnees uneCoordonnees2 = new Coordonnees(9, 4);
        Coordonnees uneCoordonnees3 = new Coordonnees(6, 2);
        Coordonnees uneCoordonnees4 = new Coordonnees(4, 0);
        Coordonnees uneCoordonnees5 = new Coordonnees(2, 3.33);
        Coordonnees uneCoordonnees6 = new Coordonnees(4, 10);
        Coordonnees uneCoordonnees7 = new Coordonnees(4, 6);

        Object[][] data = new Object[][]{
                {uneEtoile1, uneCoordonnees1, true}, //Test centre étoile
                {uneEtoile1, uneCoordonnees2, false}, //Centre verticale mais a droite de l'étoile
                {uneEtoile1, uneCoordonnees3, false}, //Entre deux branche mais exterieur de l'étoile
                {uneEtoile1, uneCoordonnees4, true}, //Sur une pointe de l'étoile
                {uneEtoile1, uneCoordonnees5, true}, //Sur une arrete de l'étoile
                {uneEtoile1, uneCoordonnees6, false}, //Centre horizontale mais en dessous de l'étoile
                {uneEtoile1, uneCoordonnees7, true} //Point à l'interieur d'un branche (dans une étoile)
        };
        return Arrays.asList(data);
    }

    @Test
    public void testAjouterPoint()
    {
        Assert.assertEquals("Test de la méthode contient de étoile failed",
                this.attendu, this.etoileATester.contient(this.coordonnees));
    }
}
