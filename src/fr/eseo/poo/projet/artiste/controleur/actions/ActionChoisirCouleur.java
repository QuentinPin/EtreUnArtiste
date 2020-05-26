package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class ActionChoisirCouleur extends AbstractAction
{
    public static final String NOM_ACTION = "COULEUR";
    private PanneauDessin panneauDessin;

    public ActionChoisirCouleur(PanneauDessin panneauDessin)
    {
        super(NOM_ACTION);
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Color resColor = JColorChooser.showDialog(this.panneauDessin, NOM_ACTION, this.panneauDessin.getCouleurCourante());
        if (resColor != null)
            this.panneauDessin.setCouleurCourante(resColor);
    }
}
