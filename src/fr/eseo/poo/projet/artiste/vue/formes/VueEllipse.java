package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
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
        Color sauvegardeCouleurG2D = g2d.getColor();
        Color sauvegardeBackgrounfCouleur = g2d.getBackground();
        g2d.setColor(monEllipse.getCouleur());
        Shape monShape = new Ellipse2D.Double(monEllipse.getX(), monEllipse.getY(), monEllipse.getLargeur(),
                monEllipse.getHauteur());
        if (monEllipse.estRempli())
            g2d.fill(monShape);
        g2d.draw(monShape);
        g2d.setColor(sauvegardeCouleurG2D);
        g2d.setBackground(sauvegardeBackgrounfCouleur);
    }
}
