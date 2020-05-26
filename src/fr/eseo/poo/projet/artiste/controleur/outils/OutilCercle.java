package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

import java.awt.event.MouseEvent;

public class OutilCercle extends OutilForme
{

    @Override
    public void mouseClicked(MouseEvent e)
    {
        super.mouseClicked(e);
    }

    @Override
    protected VueForme creerVueForme()
    {
        double minX = Math.min(getDebut().getAbscisse(), getFin().getAbscisse());
        double minY = Math.min(getDebut().getOrdonnee(), getFin().getOrdonnee());
        double maxX = Math.max(getDebut().getAbscisse(), getFin().getAbscisse());
        double maxY = Math.max(getDebut().getOrdonnee(), getFin().getOrdonnee());
        double positionX;
        double positionY;
        double diametre = Math.max(maxX - minX, maxY - minY);
        if (getDebut().getAbscisse() == minX)
        {
            positionX = minX;
            if (getDebut().getOrdonnee() == minY)
                positionY = minY;
            else
                positionY = getDebut().getOrdonnee() - diametre;
        } else
        {
            positionX = getDebut().getAbscisse() - diametre;
            if (getDebut().getOrdonnee() == minY)
                positionY = minY;
            else
                positionY = getDebut().getOrdonnee() - diametre;
        }
        Cercle cercle = new Cercle(new Coordonnees(positionX, positionY), diametre);
        cercle.setCouleur(getPanneauDessin().getCouleurCourante());
        cercle.setRempli(getPanneauDessin().getModeRemplissage());
        return new VueCercle(cercle);
    }
}
