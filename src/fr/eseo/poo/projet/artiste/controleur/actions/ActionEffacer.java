package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class ActionEffacer extends AbstractAction
{
    public static final String NOM_ACTION = "Effacer Tout";

    private PanneauDessin panneauDessin;

    public ActionEffacer(PanneauDessin panneauDessin)
    {
        super(NOM_ACTION);
        this.panneauDessin = panneauDessin;
    }

    public void actionPerformed(ActionEvent event)
    {
        Object[] options = {"Yes", "No"};
        int res = JOptionPane.showOptionDialog(this.panneauDessin, "Souhaitez-vous tout effecer ?",
                NOM_ACTION, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (res == 0)
        {
            this.panneauDessin.getVueFormes().clear();
            this.panneauDessin.repaint();
        }
    }
}
