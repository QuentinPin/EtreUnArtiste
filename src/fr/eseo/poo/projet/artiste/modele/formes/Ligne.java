package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.text.NumberFormat;
import java.util.Locale;

public class Ligne extends Forme
{
    public static final double EPSILON = 0.9d;

    public Ligne()
    {
        super();
    }

    public Ligne(double largeur, double hauteur)
    {
        super(largeur, hauteur);
    }

    public Ligne(Coordonnees position)
    {
        super(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
    }

    public Ligne(Coordonnees position, double largeur, double hauteur)
    {
        super(position, largeur, hauteur);
    }

    public Coordonnees getC1()
    {
        return getPosition();
    }

    public void setC1(Coordonnees p1)
    {
        Coordonnees tempoC2 = this.getC2();
        setPosition(p1);
        setC2(tempoC2);
    }

    public Coordonnees getC2()
    {
        return new Coordonnees(getX() + getLargeur(), getY() + getHauteur());
    }

    public void setC2(Coordonnees p2)
    {
        setLargeur(p2.getAbscisse() - getC1().getAbscisse());
        setHauteur(p2.getOrdonnee() - getC1().getOrdonnee());
    }

    public double getXMIN()
    {
        return Math.min(getC1().getAbscisse(), getC2().getAbscisse());
    }

    public double getXMAX()
    {
        return Math.max(getC1().getAbscisse(), getC2().getAbscisse());
    }

    public double getYMIN()
    {
        return Math.min(getC1().getOrdonnee(), getC2().getOrdonnee());
    }

    public double getYMAX()
    {
        return Math.max(getC1().getOrdonnee(), getC2().getOrdonnee());
    }

    @Override
    public double aire()
    {
        return 0;
    }

    @Override
    public double perimetre()
    {
        return getC1().distanceVers(getC2());
    }

    @Override
    public boolean contient(Coordonnees c)
    {
        boolean res = false;
        double distanceC1C = getC1().distanceVers(c);
        double distanceC2C = getC2().distanceVers(c);
        double distanceTotale = distanceC1C + distanceC2C;
        if (distanceTotale <= perimetre() + 1)
            res = true;
        return res;
    }

    @Override
    public String toString()
    {
        Locale locale = Locale.getDefault();
        NumberFormat format = NumberFormat.getInstance(locale);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(1);
        // Pour l'affichage on convertie en degré
        double angle = Math.toDegrees(getC1().angleVers(getC2()));
        if (angle < 0)
        {
            angle = angle + 360;
        }
        return "[Ligne] c1 : " + getC1() + " c2 : " + getC2() + " longueur : " +
                format.format(getC1().distanceVers(getC2())) + " angle : " + format.format(angle) + "°";
    }
}