package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;


public class VueEllipseTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                VueEllipseTest p = new VueEllipseTest();
                p.testVueEllipse();
            }
        });
    }

    public VueEllipseTest()
    {
    }

    private void testVueEllipse()
    {
        JFrame maFenetre = new JFrame("Blues du Businessman");
        PanneauDessin panneauDessin = new PanneauDessin(200, 200, Color.WHITE);
        panneauDessin.ajouterVueForme(new VueEllipse(new Ellipse(new Coordonnees(50, 70), 200, 90)));
        panneauDessin.ajouterVueForme(new VueEllipse(new Ellipse(new Coordonnees(150, 150), 300, 30)));
        maFenetre.add(panneauDessin);
        maFenetre.setSize(new Dimension(1000, 1000));
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.setVisible(true);
    }
}
