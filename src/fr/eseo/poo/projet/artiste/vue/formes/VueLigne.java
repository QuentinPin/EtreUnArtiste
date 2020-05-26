package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

import java.awt.Color;
import java.awt.Graphics2D;


public class VueLigne extends VueForme
{

    public VueLigne(Ligne ligne)
    {
        super(ligne);
    }

    @Override
    public void affiche(Graphics2D g2d)
    {
        Ligne maLigne = (Ligne) this.forme;
        Color sauvegardeCouleurG2D = g2d.getColor();
        g2d.setColor(maLigne.getCouleur());
        g2d.drawLine((int) Math.round(maLigne.getC1().getAbscisse()), (int) Math.round(maLigne.getC1().getOrdonnee()),
                (int) Math.round(maLigne.getC2().getAbscisse()),
                (int) Math.round(maLigne.getC2().getOrdonnee()));
        g2d.setColor(sauvegardeCouleurG2D);
    }
}
