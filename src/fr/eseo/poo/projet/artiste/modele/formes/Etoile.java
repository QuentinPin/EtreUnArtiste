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
        super.setLargeur(largeur);
        super.setHauteur(largeur);
        this.calculeDesCoordonnee();
    }

    @Override
    public void setHauteur(double hauteur)
    {
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
    public boolean contient(Coordonnees c)
    {
        //TODO : faire la méthode contient
        return isInside(coordonnees.size(), c);
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

    // Toutes les fonction si dessous vienne du site : https://www.sanfoundry.com/java-program-check-whether-given-point-lies-given-polygon/
    public boolean onSegment(Coordonnees p, Coordonnees q, Coordonnees r)
    {
        if (q.getAbscisse() <= Math.max(p.getAbscisse(), r.getAbscisse()) && q.getAbscisse() >= Math.min(p.getAbscisse(), r.getAbscisse())
                && q.getOrdonnee() <= Math.max(p.getOrdonnee(), r.getOrdonnee()) && q.getOrdonnee() >= Math.min(p.getOrdonnee(), r.getOrdonnee()))
            return true;
        return false;
    }

    public int orientation(Coordonnees p, Coordonnees q, Coordonnees r)
    {
        double val = (q.getOrdonnee() - p.getOrdonnee()) * (r.getAbscisse() - q.getAbscisse()) -
                (q.getAbscisse() - p.getAbscisse()) * (r.getOrdonnee() - q.getOrdonnee());
        if (val == 0)
            return 0;
        return (val > 0) ? 1 : 2;
    }

    public boolean doIntersect(Coordonnees p1, Coordonnees q1, Coordonnees p2, Coordonnees q2)
    {
        boolean res = false;
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
        if (o1 != o2 && o3 != o4)
            res = true;
        if (o1 == 0 && onSegment(p1, p2, q1))
            res = true;
        if (o2 == 0 && onSegment(p1, q2, q1))
            res = true;
        if (o3 == 0 && onSegment(p2, p1, q2))
            res = true;
        if (o4 == 0 && onSegment(p2, q1, q2))
            res = true;
        return res;
    }

    public boolean isInside(int n, Coordonnees p)
    {
        int inf = 10000;
        if (n < 3)
            return false;
        Coordonnees extreme = new Coordonnees(inf, p.getOrdonnee());
        int count = 0, i = 0;
        do
        {
            int next = (i + 1) % n;
            if (doIntersect(coordonnees.get(i), coordonnees.get(next), p, extreme))
            {
                if (orientation(coordonnees.get(i), p, coordonnees.get(next)) == 0)
                    return onSegment(coordonnees.get(i), p, coordonnees.get(next));
                count++;
            }
            i = next;
        } while (i != 0);
        return (count & 1) == 1 ? true : false;
    }
}
