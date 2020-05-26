package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class ActionChoisirForme extends AbstractAction
{
    public static final String NOM_ACTION_LIGNE = "LIGNE";
    public static final String NOM_ACTION_ELLIPSE = "ELLIPSE";
    public static final String NOM_ACTION_CERCLE = "CERCLE";

    private PanneauDessin panneauDessin;
    private PanneauBarreOutils panneauBarreOutils;

    public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauBarreOutils, String choixAction)
    {
        super(choixAction);
        this.panneauDessin = panneauDessin;
        this.panneauBarreOutils = panneauBarreOutils;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case NOM_ACTION_LIGNE:
                this.panneauDessin.associerOutil(new OutilLigne());
                break;
            case NOM_ACTION_ELLIPSE:
                this.panneauDessin.associerOutil(new OutilEllipse());
                break;
            case NOM_ACTION_CERCLE:
                this.panneauDessin.associerOutil(new OutilCercle());
                break;
            default:
                System.err.println("L'action demander ne fait pas partie de la liste");
        }
    }
}
