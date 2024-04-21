package Modele;

import Modele.Connexion;

import java.sql.*;

public class Film {
    private int id_film;
    private String nom_film;
    private String auteur;
    private int nbrplace;
    private String image_film;
    private int prix_place;
    private String resume;
    private float note;
    private int heure;
    //String mdp="";
    String mdp="Proxecom2007$";
    ///String mdp="Jack123456";


    public Film(String nom_film){
        this.nom_film=nom_film;
        try{
            //Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", mdp);
            String requete = "SELECT id_film, auteur, nbrplace, image_film, prix_place, resume, note, heure FROM film WHERE nom_film = ?";
            PreparedStatement statement = ((Connection) connexion).prepareStatement(requete);
            statement.setString(1, nom_film);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.id_film = resultSet.getInt("id_film"); // affecte l'id du film
                this.auteur = resultSet.getString("auteur"); // affecte l'auteur du film
                this.nbrplace = resultSet.getInt("nbrplace"); // affecte le nombre de place
                this.image_film = resultSet.getString("image_film"); // affecte le lien de l'image
            }
            resultSet.close(); // fermer le resultat
            statement.close(); // fermer le statement
            connexion.close(); // fermer le connexion
        }
        catch (SQLException e) { // activation de l'exception en cas de requete sql non valider
            e.printStackTrace();
        }
    }

    public Film(int id_film, String nom_film, String auteur, int nbrplace, String image_film, int prix_place, String resume, float note, int heure)
    {
        this.nom_film=nom_film;
        this.auteur=auteur;
        this.nbrplace=nbrplace;
        this.image_film=image_film;
        this.id_film=id_film;
        this.prix_place=prix_place;
        this.resume=resume;
        this.note=note;
        this.heure=heure;
    }

    public int getId_film()
    {
        return id_film;
    }
    public String getNom_film()
    {
        return nom_film;
    }
    public String getAuteur()
    {
        return auteur;
    }
    public int getNbrplace()
    {
        return nbrplace;
    }
    public String getImage_film()
    {
        return image_film;
    }
}