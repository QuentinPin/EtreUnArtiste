package fr.eseo.poo.projet.artiste.modele;

import fr.eseo.poo.projet.artiste.modele.formes.CercleTest;
import fr.eseo.poo.projet.artiste.modele.formes.EllipseTest;
import fr.eseo.poo.projet.artiste.modele.formes.EtoileParameterizedTests;
import fr.eseo.poo.projet.artiste.modele.formes.EtoileTest;
import fr.eseo.poo.projet.artiste.modele.formes.LigneTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CoordonneesTest.class, LigneTest.class, EllipseTest.class, CercleTest.class, EtoileTest.class, EtoileParameterizedTests.class})
public class ModeleTests
{
}
