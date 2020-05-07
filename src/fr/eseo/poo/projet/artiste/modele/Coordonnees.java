package fr.eseo.poo.projet.artiste.modele;

import java.text.NumberFormat;
import java.util.Locale;

public class Coordonnees
{
    /**
     * ABSCISSE par defaut
     */
    public static final double ABSCISSE_PAR_DEFAUT = 0.0d;
    /**
     * ORDONNEE par defaut
     */
    public static final double ORDONNEE_PAR_DEFAUT = 0.0d;


    /**
     * Les deux coordonnées du point
     */
    private double abscisse, ordonnee;


    public Coordonnees()
    {
        this(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT);
    }

    public Coordonnees(double abscisse, double ordonnee)
    {
        setAbscisse(abscisse);
        setOrdonnee(ordonnee);
    }

    /**
     * Permet de changer les coordonnée
     *
     * @param x nouvelle coordonnée
     * @param y nouvelle coordonnée
     */
    public void deplacerVers(double x, double y)
    {
        this.abscisse = x;
        this.ordonnee = y;
    }

    /**
     * Permet de déplacer les coordonées d'un deltat donner en param
     *
     * @param deltaX delta du x
     * @param deltaY delta du y
     */
    public void deplacerDe(double deltaX, double deltaY)
    {
        this.abscisse += deltaX;
        this.ordonnee += deltaY;
    }

    /**
     * Calcul de la distance entre deux points
     *
     * @param coord autre cordonnée vers la quel la distance doit être calculé
     * @return la distance entre les deux points
     */
    public double distanceVers(Coordonnees coord)
    {
        return Math.sqrt(Math.pow(coord.getAbscisse() - this.abscisse, 2) + Math.pow(coord.getOrdonnee() - this.ordonnee, 2));
    }

    /**
     * Permet de calculer l'angle entre les deux points et la ligne des abscisse
     *
     * @param coord autre point permetant de calculer l'angle
     * @return l'angle en radian
     */
    public double angleVers(Coordonnees coord)
    {
        return Math.atan2(coord.ordonnee - this.ordonnee, coord.abscisse - this.abscisse);
    }

    public double getAbscisse()
    {
        return abscisse;
    }

    public void setAbscisse(double abscisse)
    {
        this.abscisse = abscisse;
    }

    public double getOrdonnee()
    {
        return ordonnee;
    }

    public void setOrdonnee(double ordonnee)
    {
        this.ordonnee = ordonnee;
    }

    @Override
    public String toString()
    { // Cette méthode est issu d'une réflexion de groupe avec Baptiste Guérin, Evan Delaunay et Adrien Castanier
        Locale locale = Locale.getDefault();
        NumberFormat format = NumberFormat.getInstance(locale);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(1);
        return "(" + format.format(this.getAbscisse()) + " , " + format.format(this.getOrdonnee()) + ")";
    }

}