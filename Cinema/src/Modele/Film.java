package Modele;

import Modele.Connexion;

import java.sql.*;

public class Film {
    private int id_auteur;
    private String nom_film;
    private String auteur;
    private int nbrplace;
    private String image_film;

    public Film(String nom_film){
        this.nom_film=nom_film;
        try{
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
            String requete = "SELECT id_auteur, auteur, nbrplace, image_film FROM film WHERE nom_film = ?";
            PreparedStatement statement = ((Connection) connexion).prepareStatement(requete);
            statement.setString(1, nom_film);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.id_auteur = resultSet.getInt("id_auteur");
                this.auteur = resultSet.getString("auteur");
                this.nbrplace = resultSet.getInt("nbrplace");
                this.image_film = resultSet.getString("image_film");
            }
            resultSet.close();
            statement.close();
            connexion.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Film(String nom_film, String auteur, int nbrplace, String image_film)
    {
        this.nom_film=nom_film;
        this.auteur=auteur;
        this.nbrplace=nbrplace;
        this.image_film=image_film;
    }

    public int getId_auteur()
    {
        return id_auteur;
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