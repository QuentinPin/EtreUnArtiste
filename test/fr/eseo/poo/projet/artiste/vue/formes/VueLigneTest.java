package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;


public class VueLigneTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                VueLigneTest p = new VueLigneTest();
                p.testVueLigne();
            }
        });
    }

    public VueLigneTest()
    {
    }

    private void testVueLigne()
    {
        JFrame maFenetre = new JFrame("Blues du Businessman");
        PanneauDessin panneauDessin = new PanneauDessin(200, 200, Color.WHITE);
        panneauDessin.ajouterVueForme(new VueLigne(new Ligne(new Coordonnees(50, 70), 200, 90)));
        panneauDessin.ajouterVueForme(new VueLigne(new Ligne(new Coordonnees(150, 150), 300, 300)));
        maFenetre.add(panneauDessin);
        maFenetre.setSize(new Dimension(1000, 1000));
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.setVisible(true);
    }
}
