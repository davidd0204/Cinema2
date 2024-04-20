package Modele;

import java.sql.*;
import java.util.ArrayList;

public class FilmDAOimpl implements FilmDAO{
    public Connection connection;
    public ArrayList<Film> liste_films;
    public final String driver = "jdbc:mysql://localhost:3306/cinema";
    public final String user = "root";
    //public final String mdp = "";
    public final String mdp = "Jack123456";


    public FilmDAOimpl()
    {
        try {
            // Connexion à la base de données
            connection = DriverManager.getConnection(driver, user, mdp);
            // Initialisation de la liste des films
            liste_films = new ArrayList<>();


            String query = "SELECT nom_film FROM film";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Création d'objets Film et ajout à la liste
            while (resultSet.next()) {
                String nom_film = resultSet.getString("nom_film");
                Film film = new Film(nom_film);
                liste_films.add(film);
            }


            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Film> getListe_films() {
        return liste_films;
    }
    @Override
    public void ajouterFilm(Film f) throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(driver, user, mdp);
        liste_films.add(f);
        String sqlInsert = "INSERT INTO film (nom_film , auteur, nbrplace, image_film) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sqlInsert);
        statement.setString(1, f.getNom_film());
        statement.setString(2, f.getAuteur());
        statement.setInt(3, f.getNbrplace());
        statement.setString(4, f.getImage_film());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
    @Override
    public void supprimerFilm(Film f) throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(driver, user, mdp);
        liste_films.remove(f);
        String sqlStatement = "DELETE FROM film WHERE nom_film = ?";
        PreparedStatement statement = connection.prepareStatement(sqlStatement);
        statement.setString(1, f.getNom_film());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }


}
