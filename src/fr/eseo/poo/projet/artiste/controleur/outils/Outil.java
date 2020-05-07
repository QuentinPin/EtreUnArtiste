package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public abstract class Outil implements MouseInputListener
{
    private Coordonnees debut;
    private Coordonnees fin;
    private PanneauDessin panneauDessin;

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        setDebut(new Coordonnees(e.getX(), e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        setFin(new Coordonnees(e.getX(), e.getY()));
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }

    public Coordonnees getDebut()
    {
        return debut;
    }

    public void setDebut(Coordonnees debut)
    {
        this.debut = debut;
    }

    public Coordonnees getFin()
    {
        return fin;
    }

    public void setFin(Coordonnees fin)
    {
        this.fin = fin;
    }

    public PanneauDessin getPanneauDessin()
    {
        return panneauDessin;
    }

    public void setPanneauDessin(PanneauDessin panneauDessin)
    {
        this.panneauDessin = panneauDessin;
    }
}
