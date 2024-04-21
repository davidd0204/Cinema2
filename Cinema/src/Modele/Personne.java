package Modele;

import java.util.ArrayList;

public class Personne {
    private int classe;
    private String nom;
    private int idpersonne;

    ///private ArrayList<Integer> idfilm = new ArrayList<Integer>();
    public Personne(int classe, String nom,int idpersonne) {
        this.classe = classe;
        this.nom = nom;
        this.idpersonne=idpersonne;
    }
    public int getId(){return idpersonne;}
    public int getClasse() {
        return classe;
    }
    public int getIdpersonne() {return idpersonne;}
    public String getNom() {return nom;}
}
