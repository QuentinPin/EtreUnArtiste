package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Etoile extends Forme implements Remplissable
{
    public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 4;
    public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = 0;
    public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.8;

    private List<Coordonnees> coordonnees;
    private Coordonnees centreEtoile;
    private int nombreDeBranche;
    private double anglePremiereBranche;
    private double longueurBranche;
    private boolean estRempli;

    public Etoile()
    {
        this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT,
                ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
    }

    public Etoile(double taille)
    {
        this(new Coordonnees(), taille, NOMBRE_BRANCHES_PAR_DEFAUT,
                ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
    }

    public Etoile(Coordonnees position)
    {
        this(position, Forme.LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT,
                ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
    }

    public Etoile(Coordonnees position, double taille)
    {
        this(position, taille, NOMBRE_BRANCHES_PAR_DEFAUT,
                ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
    }

    public Etoile(Coordonnees position, double taille, int nombreBranches, double anglePremiereBranche,
                  double longueurBranche)
    {
        super(position, taille, taille);
        if (taille < 0)
            throw new IllegalArgumentException();
        this.setNombreBranches(nombreBranches);
        this.setAnglePremiereBranche(anglePremiereBranche);
        this.setLongueurBranche(longueurBranche);
        this.calculeDesCoordonnee();
        this.setRempli(false);
    }

    private void calculeDesCoordonnee()
    {
        // Source d'un forum qui ma aider : https://forums.futura-sciences.com/mathematiques-superieur/505846-geometrie
        // -liens-entres-coordonnees-sommet-dun-polygone-regulier.html
        if (this.coordonnees == null)
            this.coordonnees = new ArrayList<>();
        else
            this.coordonnees.clear();

        this.centreEtoile = new Coordonnees(this.getPosition().getAbscisse() + (getLargeur() / 2),
                this.getPosition().getOrdonnee() + (getLargeur() / 2));

        // Ajout des autre autre sommet
        double x0 = centreEtoile.getAbscisse();
        double y0 = centreEtoile.getOrdonnee();
        for (int i = 0; i < this.getNombreBranches() * 2; i++)
        {
            if (i % 2 == 0) // Il s'agit d'un sommet externe
            {
                double cosVal = Math.cos(this.getAnglePremiereBranche() + i * (Math.PI / nombreDeBranche));
                double sinVal = Math.sin(this.getAnglePremiereBranche() + i * (Math.PI / nombreDeBranche));
                double r = (this.getLargeur() / 2);
                this.coordonnees.add(new Coordonnees(x0 + r * cosVal, y0 + r * sinVal));
            } else // Il s'agit d'un sommet interne
            {
                double cosVal = Math.cos(this.getAnglePremiereBranche() + i * (Math.PI / nombreDeBranche));
                double sinVal = Math.sin(this.getAnglePremiereBranche() + i * (Math.PI / nombreDeBranche));
                double r = ((this.getLargeur() / 2) * (1 - getLongueurBranche()));
                this.coordonnees.add(new Coordonnees(x0 + r * cosVal, y0 + r * sinVal));
            }
        }
    }

    @Override
    public void setLargeur(double largeur)
    {
        if (largeur < 0)
            throw new IllegalArgumentException("La largeur ne peut pas être négative");
        super.setLargeur(largeur);
        super.setHauteur(largeur);
        this.calculeDesCoordonnee();
    }

    @Override
    public void setHauteur(double hauteur)
    {
        if (hauteur < 0)
            throw new IllegalArgumentException("La hauteur ne peut pas être négative");
        super.setLargeur(hauteur);
        super.setHauteur(hauteur);
        this.calculeDesCoordonnee();
    }

    public int getNombreBranches()
    {
        return nombreDeBranche;
    }

    public void setNombreBranches(int nbBranches)
    {
        if (nbBranches >= 3 && nbBranches <= 15)
        {
            this.nombreDeBranche = nbBranches;
            this.calculeDesCoordonnee();
        } else throw new IllegalArgumentException();
    }

    public double getAnglePremiereBranche()
    {
        return anglePremiereBranche;
    }

    public List<Coordonnees> getCoordonnees()
    {
        return coordonnees;
    }

    public void setAnglePremiereBranche(double anglePremiereBranche)
    {
        if (anglePremiereBranche > (-Math.PI) && anglePremiereBranche <= Math.PI)
        {
            this.anglePremiereBranche = anglePremiereBranche;
            this.calculeDesCoordonnee();
        } else throw new IllegalArgumentException();
    }

    public double getLongueurBranche()
    {
        return longueurBranche;
    }

    public void setLongueurBranche(double longueurBranche)
    {
        if (longueurBranche >= 0 && longueurBranche <= 1.0)
        {
            this.longueurBranche = longueurBranche;
            this.calculeDesCoordonnee();
        } else throw new IllegalArgumentException();
    }

    @Override
    public boolean estRempli()
    {
        return this.estRempli;
    }

    @Override
    public void setRempli(boolean modeRemplissage)
    {
        this.estRempli = modeRemplissage;
    }

    @Override
    public double aire()
    {
        double base = Math.abs(coordonnees.get(1).distanceVers(coordonnees.get(3)));
        Coordonnees centreBase = new Coordonnees(
                (coordonnees.get(1).getAbscisse() + coordonnees.get(3).getAbscisse()) / 2,
                (coordonnees.get(1).getOrdonnee() + coordonnees.get(3).getOrdonnee()) / 2);
        double hauteurPointe = Math.abs(centreBase.distanceVers(coordonnees.get(2)));
        double hauteurCentre = Math.abs(centreBase.distanceVers(centreEtoile));
        return ((base * hauteurPointe / 2) + (base * hauteurCentre / 2)) * getNombreBranches();
    }

    @Override
    public double perimetre()
    {
        return Math.abs(coordonnees.get(0).distanceVers(coordonnees.get(1))) * nombreDeBranche * 2;
    }

    @Override
    public boolean contient(Coordonnees coordonneesACheck)
    {
        double[] xp = new double[getCoordonnees().size()];
        double[] yp = new double[getCoordonnees().size()];
        for (Coordonnees uneCoordonnees : getCoordonnees())
        {
            xp[getCoordonnees().indexOf(uneCoordonnees)] = uneCoordonnees.getAbscisse();
            yp[getCoordonnees().indexOf(uneCoordonnees)] = uneCoordonnees.getOrdonnee();
        }
        return estDansEtoile(getCoordonnees().size(), xp, yp, coordonneesACheck) || estSurUnSegmentEtoile(coordonneesACheck);
    }

    private boolean estSurUnSegmentEtoile(Coordonnees coordonneesACheck)
    {
        Coordonnees ancienneCoordonnees = null;
        for (Coordonnees uneCoordonnees : getCoordonnees())
        {
            if (getCoordonnees().indexOf(uneCoordonnees) != 0)
            {
                Ligne uneLigne = new Ligne(uneCoordonnees);
                uneLigne.setC2(ancienneCoordonnees);
                if (uneLigne.contient(coordonneesACheck))
                    return true;
            }
            ancienneCoordonnees = uneCoordonnees;
        }
        return false;
    }

    // Cette méthode provien du site : http://www.faqs.org/faqs/graphics/algorithms-faq/
    public boolean estDansEtoile(int npol, double[] xp, double[] yp, Coordonnees coordonneesACheck)
    {
        double x = coordonneesACheck.getAbscisse();
        double y = coordonneesACheck.getOrdonnee();
        boolean c = false;
        for (int i = 0, j = npol - 1; i < npol; j = i++)
        {
            boolean bool1 = (yp[i] <= y && y < yp[j] || yp[j] <= y && y < yp[i]);
            boolean bool2 = x < (xp[j] - xp[i]) * (y - yp[i]) / (yp[j] - yp[i]) + xp[i];
            if (bool1 && bool2)
            {
                c = !c;
            }
        }
        return c;
    }


    @Override
    public String toString()
    {
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
