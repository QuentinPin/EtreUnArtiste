package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme
{
    @Override
    protected VueForme creerVueForme()
    {
        double minX = Math.min(getDebut().getAbscisse(), getFin().getAbscisse());
        double minY = Math.min(getDebut().getOrdonnee(), getFin().getOrdonnee());
        double maxX = Math.max(getDebut().getAbscisse(), getFin().getAbscisse());
        double maxY = Math.max(getDebut().getOrdonnee(), getFin().getOrdonnee());
        Ellipse ellipse = new Ellipse(new Coordonnees(minX, minY), maxX - minX, maxY - minY);
        ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
        ellipse.setRempli(getPanneauDessin().getModeRemplissage());
        return new VueEllipse(ellipse);
    }
}
