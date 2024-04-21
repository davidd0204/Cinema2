package Modele;

import Controleur.Generale;

import java.sql.*;
import java.util.Objects;
import javax.swing.*;

public class Connexion {
    private final Connection conn;
    private final Statement stmt;
    public int getnbrplace;
    String databaseName="Cinema";
    String username="root";
    //String password="";

    String password="Jack123456";

    //String password="Jack123456";


    public Connexion() throws SQLException, ClassNotFoundException {
        // Chargement du pilote JDBC moderne
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connexion à la base de données
        String urlDatabase = "jdbc:mysql://localhost:3306/" + databaseName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        conn = DriverManager.getConnection(urlDatabase, username, password);

        // Préparation de l'instruction SQL pour l'insertion d'un film, sans inclure l'ID
        String sqlInsert = "INSERT INTO film (nom_film, auteur, nbrplace) VALUES (?, ?, ?)";
        PreparedStatement psInsert = conn.prepareStatement(sqlInsert);

        // Exemple d'ajout d'un film
      /*  psInsert.setString(1, "Les Évadés"); // Nom du film
        psInsert.setString(2, "Frank Darabont"); // Auteur
        psInsert.setInt(3, 100); // Nombre de places
        psInsert.executeUpdate(); // Exécution de l'insertion*/

        // Pour ajouter d'autres films, répétez le processus avec différents paramètres

        // Fermeture du PreparedStatement après utilisation
        psInsert.close();

        // Création d'une Statement pour exécuter d'autres requêtes si nécessaire
        stmt = conn.createStatement();
    }
    public String getresume(String nom) throws SQLException {
        String filmName="";
        String sqlSelect = "SELECT resume FROM film WHERE nom_film = ?";
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom); // Lier le paramètre à la valeur 57

        // Exécution de la requête et récupération du résultat
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            ////System.out.println("cokfd");
            filmName = rs.getString("resume");
        }

        // Fermeture des ressources
        rs.close();
        psSelect.close();

        return filmName;

    }
    public int getnbrplace(String nom) throws SQLException 
    {
        int nbrplace = 0;
        String sqlSelect = "SELECT nbrplace FROM film WHERE nom_film = ?";
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom);
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            nbrplace = rs.getInt("nbrplace");
        }

        // Fermeture des ressources
        rs.close();
        psSelect.close();

        return nbrplace;
    }
    public String getFilmName(String nom) throws SQLException {
        String filmName = "";
        String sqlSelect = "SELECT image_film FROM film WHERE nom_film = ?";

        // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom); // Lier le paramètre à la valeur 57

        // Exécution de la requête et récupération du résultat
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            System.out.println("cokfd");
            filmName = rs.getString("image_film");
        }

        // Fermeture des ressources
        rs.close();
        psSelect.close();

        return filmName;
    }

    public JList<String> getlistFilms(JList<String> ok) throws SQLException {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        String sqlSelect = "SELECT nom_film, nbrplace, prix_place FROM film";
        PreparedStatement psSelect = null;
        ResultSet rs = null;

        try {
            // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
            psSelect = conn.prepareStatement(sqlSelect);

            // Exécution de la requête et récupération du résultat
            rs = psSelect.executeQuery();
            while (rs.next()) {  // Utiliser while au lieu de if pour traiter tous les enregistrements
                String filmName = rs.getString("nom_film");
                int nbPlace = rs.getInt("nbrplace");
                float prix = rs.getFloat("prix_place");
                // Format de chaque entrée : "Nom du film - Nombre de places - Prix"
                String entry = filmName + " - " + nbPlace + " places - " + prix + " €";
                listModel.addElement(entry);  // Ajout de l'entrée au modèle de liste
            }

            ok.setModel(listModel);  // Mettre à jour le modèle de la JList
        } finally {
            // Assurer la fermeture des ressources dans un bloc finally
            if (rs != null) rs.close();
            if (psSelect != null) psSelect.close();
        }

        return ok;
    }
    public JList<String> getlistFilmsuniquement(JList<String> ok) throws SQLException {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        String sqlSelect = "SELECT nom_film FROM film";
        PreparedStatement psSelect = null;
        ResultSet rs = null;

        try {
            // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
            psSelect = conn.prepareStatement(sqlSelect);

            // Exécution de la requête et récupération du résultat
            rs = psSelect.executeQuery();
            while (rs.next()) {  // Utiliser while au lieu de if pour traiter tous les enregistrements
                String filmName = rs.getString("nom_film");

                // Format de chaque entrée : "Nom du film - Nombre de places - Prix"
                String entry = filmName;
                listModel.addElement(entry);  // Ajout de l'entrée au modèle de liste
            }

            ok.setModel(listModel);  // Mettre à jour le modèle de la JList
        } finally {
            // Assurer la fermeture des ressources dans un bloc finally
            if (rs != null) rs.close();
            if (psSelect != null) psSelect.close();
        }

        return ok;
    }


    // Méthode pour fermer les ressources et éviter les fuites de mémoire
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
        if (stmt != null) {
            stmt.close();
        }
    }

    public int getnbrfilm(String nom, int nombreplce) throws SQLException {
        int prix = 0;
        int nbrplace;
        String sqlSelect = "SELECT nbrplace,prix_place FROM film WHERE nom_film = ?";

        // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom); // Lier le paramètre à la valeur 57

        // Exécution de la requête et récupération du résultat
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            System.out.println("cokfd");
            nbrplace = rs.getInt("nbrplace");
            prix = rs.getInt("prix_place");
        }
        return (prix * nombreplce);


    }

    public boolean verifierDisponibiliteFilm(String nom, String mdp) throws SQLException {
        String sqlSelect = "SELECT Utilisateur FROM user WHERE Utilisateur = ? AND mdp = ?";
        // Assure-toi que cette connexion est correctement initialisée

        try {
            // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
            PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
            psSelect.setString(1, nom);
            psSelect.setString(2, mdp);

            // Exécution de la requête et récupération du résultat
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                String nouv = rs.getString("Utilisateur");
                if(Objects.equals(nouv, nom))
                {
                    return true;
                }
               //// System.out.println("Nombre de places disponibles pour le film " + nomFilm + " (" + idFilm + "): " + nbrPlaceDisponible);
                // Compare le nombre de places attendu avec le nombre disponible
                /////return nbrPlaceDisponible == nombrePlceAttendu;
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            throw e; // Propager l'exception après la journalisation
        }
        return false; // Retourner false si aucun enregistrement n'est trouvé
    }

    public int getType(String nom, String mdp) throws SQLException {


            // Si la connexion est établie avec succès
        String sqlSelect = "SELECT type FROM user WHERE Utilisateur = ? AND mdp = ?";
        // Assure-toi que cette connexion est correctement initialisée
    int nouv = 0;
        try {
            // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
            PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
            psSelect.setString(1, nom);
            psSelect.setString(2, mdp);

            // Exécution de la requête et récupération du résultat
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                nouv = rs.getInt("type");

                //// System.out.println("Nombre de places disponibles pour le film " + nomFilm + " (" + idFilm + "): " + nbrPlaceDisponible);
                // Compare le nombre de places attendu avec le nombre disponible
                /////return nbrPlaceDisponible == nombrePlceAttendu;
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            throw e; // Propager l'exception après la journalisation
        }
        return nouv;
    }

    public int getID(String nom, String mdp) throws SQLException {
        String sqlSelect = "SELECT userId FROM user WHERE Utilisateur = ? AND mdp = ?";
        // Assure-toi que cette connexion est correctement initialisée
        int nouv = 0;
        try {
            // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
            PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
            psSelect.setString(1, nom);
            psSelect.setString(2, mdp);

            // Exécution de la requête et récupération du résultat
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                nouv = rs.getInt("userId");

                //// System.out.println("Nombre de places disponibles pour le film " + nomFilm + " (" + idFilm + "): " + nbrPlaceDisponible);
                // Compare le nombre de places attendu avec le nombre disponible
                /////return nbrPlaceDisponible == nombrePlceAttendu;
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            throw e; // Propager l'exception après la journalisation
        }
        return nouv;
    }
}