package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;


public class VueCercleTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                VueCercleTest p = new VueCercleTest();
                p.testVueCercle();
            }
        });
    }

    public VueCercleTest()
    {
    }

    private void testVueCercle()
    {
        JFrame maFenetre = new JFrame("Blues du Businessman");
        PanneauDessin panneauDessin = new PanneauDessin(200, 200, Color.WHITE);
        panneauDessin.setModeRemplissage(true);
        Cercle cercle = new Cercle(new Coordonnees(50, 70), 200);
        cercle.setCouleur(Color.RED);
        cercle.setRempli(true);
        panneauDessin.ajouterVueForme(new VueCercle(cercle));
        panneauDessin.ajouterVueForme(new VueCercle(new Cercle(new Coordonnees(150, 150), 300)));
        maFenetre.add(panneauDessin);
        maFenetre.setSize(new Dimension(1000, 1000));
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.setVisible(true);
    }
}
