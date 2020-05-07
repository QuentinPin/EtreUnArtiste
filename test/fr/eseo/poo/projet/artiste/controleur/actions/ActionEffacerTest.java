package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class ActionEffacerTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                ActionEffacerTest p = new ActionEffacerTest();
                p.testActionEffacer();
            }
        });
    }

    public ActionEffacerTest()
    {
    }

    private void testActionEffacer()
    {
        JFrame maFenetre = new JFrame("Blues du Businessman");
        PanneauDessin panneauDessin = new PanneauDessin(200, 200, Color.WHITE);
        PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauDessin);
        OutilLigne outilLigne = new OutilLigne();
        panneauDessin.associerOutil(outilLigne);
        maFenetre.add(panneauDessin);
        maFenetre.add(panneauBarreOutils, BorderLayout.EAST);
        maFenetre.setSize(new Dimension(1000, 1000));
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.setVisible(true);
    }
}
