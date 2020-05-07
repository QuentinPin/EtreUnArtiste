package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class PanneauBarreOutilsTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                PanneauBarreOutilsTest p = new PanneauBarreOutilsTest();
                p.testPanneauBarreOutils();
            }
        });
    }

    public PanneauBarreOutilsTest()
    {
    }

    private void testPanneauBarreOutils()
    {
        JFrame maFenetre = new JFrame("Blues du Businessman");
        PanneauDessin panneauDessin = new PanneauDessin(200, 200, Color.WHITE);
        PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauDessin);
        maFenetre.add(panneauDessin);
        maFenetre.add(panneauBarreOutils, BorderLayout.EAST);
        maFenetre.setSize(new Dimension(1000, 1000));
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.setVisible(true);
    }
}
