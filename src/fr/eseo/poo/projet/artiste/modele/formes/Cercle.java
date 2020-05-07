package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse
{
    public Cercle()
    {
        this(new Coordonnees(), LARGEUR_PAR_DEFAUT);
    }

    public Cercle(double taille)
    {
        this(new Coordonnees(), taille);
    }

    public Cercle(Coordonnees position)
    {
        this(position, LARGEUR_PAR_DEFAUT);
    }

    public Cercle(Coordonnees coordonnee, double taille)
    {
        super(coordonnee, taille, taille);
    }

    @Override
    public void setLargeur(double largeur)
    {
        super.setLargeur(largeur);
        super.setHauteur(largeur);
    }

    @Override
    public void setHauteur(double hauteur)
    {
        super.setLargeur(hauteur);
        super.setHauteur(hauteur);
    }

    @Override
    public double aire()
    {
        return Math.PI * Math.pow(getHauteur() / 2, 2);
    }

    @Override
    public double perimetre()
    {
        return 2 * Math.PI * (getHauteur() / 2);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}