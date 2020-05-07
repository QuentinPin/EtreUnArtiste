package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;

public class OutilCercleTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                OutilCercleTest p = new OutilCercleTest();
                p.testOutilCercle();
            }
        });
    }

    public OutilCercleTest()
    {
    }

    private void testOutilCercle()
    {
        JFrame maFenetre = new JFrame("Blues du Businessman");
        PanneauDessin panneauDessin = new PanneauDessin(200, 200, Color.WHITE);
        OutilCercle outilCercle = new OutilCercle();
        panneauDessin.associerOutil(outilCercle);
        maFenetre.add(panneauDessin);
        maFenetre.setSize(new Dimension(1000, 1000));
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.setVisible(true);
    }
}
