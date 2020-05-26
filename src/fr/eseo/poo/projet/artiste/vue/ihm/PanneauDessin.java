package fr.eseo.poo.projet.artiste.vue.ihm;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class PanneauDessin extends JPanel
{
    // Même valeur par default que Evant Delaunay
    public static final int LARGEUR_PAR_DEFAUT = 500;
    public static final int HAUTEUR_PAR_DEFAUT = 300;
    public static final Color COULEUR_FOND_PAR_DEFAUT = Color.WHITE;

    private final List<VueForme> vueFormes;
    private Outil outilCourant;
    private Color couleurCourante;
    private boolean modeRemplissage;

    public PanneauDessin()
    {
        this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
    }

    public PanneauDessin(int largeur, int hauteur, Color fond)
    {
        super();
        super.setPreferredSize(new Dimension(largeur, hauteur));
        super.setBackground(fond);
        vueFormes = new ArrayList();
        setCouleurCourante(Forme.COULEUR_PAR_DEFAUT);
        setModeRemplissage(false);
    }

    public List<VueForme> getVueFormes()
    {
        return this.vueFormes;
    }

    public void ajouterVueForme(VueForme vueForme)
    {
        this.vueFormes.add(vueForme);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();
        for (VueForme vueForme : this.vueFormes)
            vueForme.affiche(g2D);
        g2D.dispose();
    }

    public void associerOutil(Outil outil)
    {
        if (outil != null)
        {
            dissocierOutil();
            setOutilCourant(outil);
            outil.setPanneauDessin(this);
            this.addMouseListener(outil);
            this.addMouseMotionListener(outil);
        }
    }

    private void dissocierOutil()
    {
        if (this.outilCourant != null)
        {
            this.removeMouseListener(this.outilCourant);
            this.removeMouseMotionListener(this.outilCourant);
            this.getOutilCourant().setPanneauDessin(null);
            this.outilCourant = null;
        }
    }

    public Outil getOutilCourant()
    {
        return outilCourant;
    }

    private void setOutilCourant(Outil outilCourant)
    {
        this.outilCourant = outilCourant;
    }

    public Color getCouleurCourante()
    {
        return couleurCourante;
    }

    public void setCouleurCourante(Color couleurCourante)
    {
        this.couleurCourante = couleurCourante;
    }

    public boolean getModeRemplissage()
    {
        return this.modeRemplissage;
    }

    public void setModeRemplissage(boolean modeRemplissage)
    {
        this.modeRemplissage = modeRemplissage;
    }
}
