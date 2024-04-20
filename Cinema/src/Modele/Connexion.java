package Modele;

import Controleur.AfficherInterfaceConnexion;
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
    public void suppFilm(String nom) throws SQLException {
        String sqlSelect = "SELECT image_film FROM film WHERE nom_film = ?";

        // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom); // Lier le paramètre à la valeur

        // Exécution de la requête et récupération du résultat
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            // Fermeture du ResultSet et du PreparedStatement utilisé pour la sélection
            rs.close();
            psSelect.close();

            // Si le film existe, exécuter une instruction DELETE pour le supprimer
            String sqlDelete = "DELETE FROM film WHERE nom_film = ?";
            PreparedStatement psDelete = conn.prepareStatement(sqlDelete);
            psDelete.setString(1, nom);
            int rowsDeleted = psDelete.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Le film a été supprimé avec succès.");
            } else {
                System.out.println("Aucun film supprimé.");
            }
            psDelete.close();
        } else {
            // Si aucun résultat n'est trouvé, le film n'existe pas
            System.out.println("Aucun film trouvé avec ce nom.");
            rs.close();
            psSelect.close();
        }
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
    public int getnbrplace(String nom, int age) throws SQLException
    {
        int nbrplace = 0;
        String sqlSelect = "SELECT nbrplace FROM film WHERE nom_film = ? AND heure=?";
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom);
        psSelect.setInt(2, age);
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            nbrplace = rs.getInt("nbrplace");
        }

        // Fermeture des ressources
        rs.close();
        psSelect.close();

        return nbrplace;
    }

    public String getFilmName(String nom,int heure) throws SQLException {
        String filmName = "";
        String sqlSelect = "SELECT image_film FROM film WHERE nom_film = ? AND heure=?";

        // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom);
        psSelect.setInt(2, heure);// Lier le paramètre à la valeur 57

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
        String sqlSelect = "SELECT nom_film, nbrplace, prix_place,heure FROM film";
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
                int heure=rs.getInt("heure");
                // Format de chaque entrée : "Nom du film - Nombre de places - Prix"
                String entry = filmName + " - " + nbPlace + " places - " + prix + " €"+" début à "+heure+"h";
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
        String sqlSelect = "SELECT nom_film,heure FROM film";
        PreparedStatement psSelect = null;
        ResultSet rs = null;

        try {
            // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
            psSelect = conn.prepareStatement(sqlSelect);

            // Exécution de la requête et récupération du résultat
            rs = psSelect.executeQuery();
            while (rs.next()) {  // Utiliser while au lieu de if pour traiter tous les enregistrements
                String filmName = rs.getString("nom_film");
                    int filmheure = rs.getInt("heure");
                // Format de chaque entrée : "Nom du film - Nombre de places - Prix"
                String entry = filmName+ " - " + filmheure + "heures";
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
    public void InscriptionBDD(String nom, String prenom, int age, String password,JFrame frame) throws SQLException, ClassNotFoundException {
        Generale g = new Generale();
        conn.setAutoCommit(false);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO user (Utilisateur,mdp,type) VALUES (?,?,?)");
        ps.setString(1,nom);
        ps.setString(2,password);
        int type;
        if (age >= 18 && age <= 64) {
            System.out.println("Le client est régulier.");
            ps.setInt(3,3);
            type = 3;
        } else if (age >= 65) {
            System.out.println("Le client est senior.");
            ps.setInt(3,4);
            type = 4;
        } else {
            System.out.println("Le client est un enfant.");
            ps.setInt(3,2);
            type = 2;
        }
        ps.executeUpdate();

        //Validation la transaction
        conn.commit();
        System.out.println("Transactions réussies, les utilisateurs ont été ajoutés avec succès à la base de données.");
        AfficherInterfaceConnexion a = new AfficherInterfaceConnexion();
        a.afficherInterfaceConnexion(frame);
        frame.dispose();
    }
    public boolean verificationInscription(String nom, String prenom, int age, String password, String confirmationPassword){
        /*System.out.println("nom: "+nom);
        System.out.println("prenom: "+prenom);
        System.out.println("age: "+age);
        System.out.println("password: "+password);
        System.out.println("confirmerPassword: "+confirmationPassword);*/
        if(nom.isEmpty() || prenom.isEmpty() || password.isEmpty() || confirmationPassword.isEmpty() || !password.equals(confirmationPassword)){
            return false;
        }
        else {
            return true;
        }
    }
    public void decrementerPlaces(String nomFilm, int placesVendues, Integer heure) throws SQLException {
        // Requête SQL pour mettre à jour le nombre de places
        String sql = "UPDATE film SET nbrplace = nbrplace - ? WHERE nom_film = ? AND nbrplace >= ? AND heure= ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, placesVendues);   // Nombre de places à décrémenter
            pstmt.setString(2, nomFilm);      // Titre du film
            pstmt.setInt(3, placesVendues);
            pstmt.setInt(4, heure);// Condition pour s'assurer qu'il y a suffisamment de places

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                // Aucune ligne affectée signifie que soit le film n'existe pas, soit il n'y avait pas assez de places
                throw new SQLException("Aucune mise à jour effectuée - vérifiez le titre ou la disponibilité des places.");
            }
        }
    }
}