package fr.eseo.poo.projet.artiste.vue.ihm;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class PanneauBarreOutils extends JPanel
{

    private PanneauDessin panneauDessin;

    public PanneauBarreOutils(PanneauDessin panneauDessin)
    {
        this.panneauDessin = panneauDessin;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    public void initComponents()
    {
        // Action effacer
        JButton boutonEffacer = new JButton(new ActionEffacer(this.panneauDessin));
        boutonEffacer.setName(ActionEffacer.NOM_ACTION);
        this.add(ActionEffacer.NOM_ACTION, boutonEffacer);

        //Action Ligne, Elllipse, Cercle
        ButtonGroup buttonGroup = new ButtonGroup();
        JToggleButton jToggleButtonLigne = new JToggleButton(
                new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE));
        jToggleButtonLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
        JToggleButton jToggleButtonEllipse = new JToggleButton(
                new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE));
        jToggleButtonEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
        JToggleButton jToggleButtonCercle = new JToggleButton(
                new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE));
        jToggleButtonCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
        buttonGroup.add(jToggleButtonLigne);
        buttonGroup.add(jToggleButtonEllipse);
        buttonGroup.add(jToggleButtonCercle);
        this.add(jToggleButtonLigne);
        this.add(jToggleButtonEllipse);
        this.add(jToggleButtonCercle);

        // Action selectionner
        JToggleButton jToggleButtonSelectionnee = new JToggleButton(
                new ActionSelectionner(this.panneauDessin));
        jToggleButtonSelectionnee.setName(ActionSelectionner.NOM_ACTION);
        buttonGroup.add(jToggleButtonSelectionnee);
        this.add(jToggleButtonSelectionnee);

        //Action ChoisirCouleur
        JButton jToggleButtonChoisirCouleur = new JButton(new ActionChoisirCouleur(this.panneauDessin));
        jToggleButtonChoisirCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
        buttonGroup.add(jToggleButtonChoisirCouleur);
        this.add(jToggleButtonChoisirCouleur);

        //Action ChoisirRemplisaage
        JCheckBox jCheckBoxChoisirRemplissage = new JCheckBox(new ActionChoisirRemplissage(this.panneauDessin));
        jCheckBoxChoisirRemplissage.setName(ActionChoisirRemplissage.NOM_ACTION);
        this.add(jCheckBoxChoisirRemplissage);
    }
}
