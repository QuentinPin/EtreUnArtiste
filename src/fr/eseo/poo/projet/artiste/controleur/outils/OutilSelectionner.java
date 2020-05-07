package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;

public class OutilSelectionner extends Outil
{
    private Coordonnees coordonneesClique;
    private VueForme formeSelectionnee;

    @Override
    public void mouseClicked(MouseEvent e)
    {
        super.mouseClicked(e);
        this.coordonneesClique = new Coordonnees(e.getX(), e.getY());
        selectionnerForme();
    }

    private void selectionnerForme()
    {
        for (VueForme vueForme : this.getPanneauDessin().getVueFormes())
        {
            if (vueForme.getForme().contient(this.coordonneesClique))
            {
                this.formeSelectionnee = vueForme;
            }
        }
        if (this.formeSelectionnee != null)
        {
            JOptionPane.showMessageDialog(this.getPanneauDessin(), this.formeSelectionnee.toString(),
                    ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
