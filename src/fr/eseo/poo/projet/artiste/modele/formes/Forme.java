package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Forme
{
    public static final double LARGEUR_PAR_DEFAUT = 40;
    public static final double HAUTEUR_PAR_DEFAUT = 20;

    private double largeur;
    private double hauteur;
    private Coordonnees position;

    public Forme()
    {
        this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
    }

    public Forme(Coordonnees uneCoordonnees)
    {
        this(uneCoordonnees, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
    }

    public Forme(Coordonnees position, double largeur, double hauteur)
    {
        this.setPosition(position);
        this.setLargeur(largeur);
        this.setHauteur(hauteur);
    }

    public Forme(double largeur, double hauteur)
    {
        this(new Coordonnees(), largeur, hauteur);
    }

    public Forme(double x, double y, double largeur, double hauteur)
    {
        this(new Coordonnees(x, y), largeur, hauteur);
    }

    public double getLargeur()
    {
        return largeur;
    }

    public void setLargeur(double largeur)
    {
        this.largeur = largeur;
    }

    public double getHauteur()
    {
        return hauteur;
    }

    public void setHauteur(double hauteur)
    {
        this.hauteur = hauteur;
    }

    public Coordonnees getPosition()
    {
        return position;
    }

    public void setPosition(Coordonnees position)
    {
        this.position = position;
    }

    public double getX()
    {
        return this.position.getAbscisse();
    }

    public double getY()
    {
        return this.position.getOrdonnee();
    }

    public void setX(double x)
    {
        position.setAbscisse(x);
    }

    public void setY(double y)
    {
        position.setOrdonnee(y);
    }

    public double getCadreMaxX()
    {
        return Math.max(this.position.getAbscisse(), this.position.getAbscisse() + this.largeur);
    }

    public double getCadreMaxY()
    {
        return Math.max(this.position.getOrdonnee(), this.position.getOrdonnee() + this.hauteur);
    }

    public double getCadreMinX()
    {
        return Math.min(this.position.getAbscisse(), this.position.getAbscisse() + this.largeur);
    }

    public double getCadreMinY()
    {
        return Math.min(this.position.getOrdonnee(), this.position.getOrdonnee() + this.hauteur);
    }

    public void deplacerVers(double x, double y)
    {
        this.position.setAbscisse(x);
        this.position.setOrdonnee(y);
    }

    public void deplacerDe(double deltaX, double deltaY)
    {
        this.position.setAbscisse(this.position.getAbscisse() + deltaX);
        this.position.setOrdonnee(this.position.getOrdonnee() + deltaY);
    }

    public abstract double aire();

    public abstract double perimetre();

    public abstract boolean contient(Coordonnees c);

    public String toString()
    {
        Locale locale = Locale.getDefault();
        NumberFormat format = NumberFormat.getInstance(locale);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(1);
        format.setGroupingUsed(false);
        return "[" + getClass().getSimpleName() + "] : pos (" + format.format(this.getX()) +
                " , " + format.format(this.getY()) + ") dim " + format.format(this.getLargeur()) +
                " x " + format.format(this.getHauteur()) + " périmètre : " +
                format.format(this.perimetre()) + " aire : " + format.format(this.aire()) + "";
    }
}
