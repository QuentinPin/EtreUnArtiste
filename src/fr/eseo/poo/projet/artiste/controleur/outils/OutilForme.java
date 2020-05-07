package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

import java.awt.event.MouseEvent;

public abstract class OutilForme extends Outil
{
    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        super.mouseReleased(e);
        if (this.getDebut().getAbscisse() != this.getFin().getAbscisse() ||
                this.getDebut().getOrdonnee() != this.getFin().getOrdonnee())
        {
            getPanneauDessin().ajouterVueForme(creerVueForme());
            getPanneauDessin().repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        super.mouseClicked(e);
        setDebut(new Coordonnees(e.getX(), e.getY()));
        setFin(new Coordonnees(e.getX() + Forme.LARGEUR_PAR_DEFAUT, e.getY() + Forme.HAUTEUR_PAR_DEFAUT));
        if (e.getClickCount() == 2)
        {
            getPanneauDessin().ajouterVueForme(creerVueForme());
            getPanneauDessin().repaint();
        }
    }

    protected abstract VueForme creerVueForme();
}
