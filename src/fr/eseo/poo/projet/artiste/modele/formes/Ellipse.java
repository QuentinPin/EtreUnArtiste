package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

import java.text.NumberFormat;
import java.util.Locale;

public class Ellipse extends Forme implements Remplissable
{

    private boolean estRempli;

    public Ellipse()
    {
        this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
    }

    public Ellipse(double largeur, double hauteur)
    {
        this(new Coordonnees(), largeur, hauteur);
    }

    public Ellipse(Coordonnees position)
    {
        this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
    }

    public Ellipse(Coordonnees position, double largeur, double hauteur)
    {
        super(position, largeur, hauteur);
        this.setRempli(false);
    }

    @Override
    public void setLargeur(double largeur)
    {
        if (largeur < 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            super.setLargeur(largeur);
        }
    }

    @Override
    public void setHauteur(double hauteur)
    {
        if (hauteur < 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            super.setHauteur(hauteur);
        }
    }

    @Override
    public double aire()
    {
        return Math.PI * (this.getHauteur() / 2) * (this.getLargeur() / 2);
    }

    @Override
    public double perimetre()
    {
        double a = Math.min(this.getLargeur(), this.getHauteur()) / 2;
        double b = Math.max(this.getLargeur(), this.getHauteur()) / 2;
        double h = Math.pow((a - b) / (a + b), 2);
        return Math.PI * (a + b) * (1 + ((3 * h) / (10 + Math.sqrt(4 - 3 * h))));
    }

    @Override
    public boolean contient(Coordonnees c)
    {
        // Formule trouver sur le lien suivant :
        // https://forums.futura-sciences.com/mathematiques-superieur/466564-savoir-un-point-a-linterieur
        // -dune-ellipse.html
        boolean res = false;
        double centreX = getPosition().getAbscisse() + getLargeur() / 2;
        double centreY = getPosition().getOrdonnee() + getHauteur() / 2;
        double resEquoition = Math.pow(c.getAbscisse() - centreX, 2) / Math.pow(getLargeur() / 2, 2) +
                Math.pow(c.getOrdonnee() - centreY, 2) / Math.pow(getHauteur() / 2, 2);
        if (resEquoition <= 1)
            res = true;
        return res;
    }

    @Override
    public boolean estRempli()
    {
        return estRempli;
    }

    @Override
    public void setRempli(boolean modeRemplissage)
    {
        this.estRempli = modeRemplissage;
    }

    @Override
    public String toString()
    {// Cette méthode est issu d'une réflexion de groupe avec Baptiste Guérin, Evan Delaunay et Adrien Castanier
        Locale locale = Locale.getDefault();
        NumberFormat format = NumberFormat.getInstance(locale);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(1);
        format.setGroupingUsed(false);
        String nomDeLaClass = (estRempli) ? getClass().getSimpleName() + "-Rempli" : getClass().getSimpleName();
        return "[" + nomDeLaClass + "] : pos (" + format.format(this.getX()) +
                " , " + format.format(this.getY()) + ") dim " + format.format(this.getLargeur()) +
                " x " + format.format(this.getHauteur()) + " périmètre : " +
                format.format(this.perimetre()) + " aire : " + format.format(this.aire())
                + " " + this.couleurToString();
    }
}
