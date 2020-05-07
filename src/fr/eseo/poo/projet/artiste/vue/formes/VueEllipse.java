package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class VueEllipse extends VueForme
{
    public VueEllipse(Ellipse ellipse)
    {
        super(ellipse);
    }

    @Override
    public void affiche(Graphics2D g2d)
    {
        Ellipse monEllipse = (Ellipse) this.forme;
        g2d.draw(new Ellipse2D.Double(monEllipse.getX(), monEllipse.getY(), monEllipse.getLargeur(),
                monEllipse.getHauteur()));
    }
}
