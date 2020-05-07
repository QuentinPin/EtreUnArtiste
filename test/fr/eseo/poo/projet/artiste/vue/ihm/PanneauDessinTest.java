package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;

public class PanneauDessinTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                PanneauDessinTest p = new PanneauDessinTest();
                p.testConstructeurParDefaut();
                p.testConstructeur();
            }
        });
    }

    public PanneauDessinTest()
    {
    }

    private void testConstructeurParDefaut()
    {
        JFrame maFenetre = new JFrame("Etre un Artiste");
        maFenetre.add(new PanneauDessin());
        maFenetre.setSize(new Dimension(1000, 1000));
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.setVisible(true);
    }

    private void testConstructeur()
    {
        JFrame maFenetre = new JFrame("Blues du Businessman");
        maFenetre.add(new PanneauDessin(200, 200, Color.BLACK));
        maFenetre.setSize(new Dimension(1000, 1000));
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.setVisible(true);
    }
}
