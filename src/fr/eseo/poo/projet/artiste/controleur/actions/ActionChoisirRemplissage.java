package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;


public class ActionChoisirRemplissage extends AbstractAction
{
    public static final String NOM_ACTION = "Remplissage";
    private PanneauDessin panneauDessin;

    public ActionChoisirRemplissage(PanneauDessin panneauDessin)
    {
        super(NOM_ACTION);
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JCheckBox maCheckbox = (JCheckBox) e.getSource();
        panneauDessin.setModeRemplissage(maCheckbox.isSelected());
    }
}
