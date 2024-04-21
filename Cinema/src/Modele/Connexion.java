package Modele;

import Controleur.AfficherInterfaceConnexion;
import Controleur.EspaceAdmin;
import Controleur.Generale;
import Controleur.RecuperationBouton;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;

public class Connexion {
    private final Connection conn;
    private final Statement stmt;
    public int getnbrplace;
    String databaseName="cinema";
    String username="root";
    String password="";

   /// String password="Jack123456";


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
    public void suppFilm(String nom,int heure) throws SQLException {
        String sqlSelect = "SELECT image_film FROM film WHERE nom_film = ? AND heure = ?";

        // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom);
        psSelect.setInt(2, heure);// Lier le paramètre à la valeur

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
                String entry = filmName+ "-" + filmheure + "-"+"heures";
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

    public int getnbrfilm(Personne personne, String nom, int nombreplce, int heure) throws SQLException {
        int prix = 0;
        int nbrplace;
        String sqlSelect = "SELECT nbrplace, prix_place FROM film WHERE nom_film = ? AND heure = ?";

        // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom); // Lier le paramètre à la valeur 57
        psSelect.setInt(2, heure);

        // Exécution de la requête et récupération du résultat
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            System.out.println("cokfd");
            nbrplace = rs.getInt("nbrplace");
            prix = rs.getInt("prix_place");
        }
        //invite
        if (personne.getClasse() == 0) {
            return (prix * nombreplce);
        }
        //enfant
        else if (personne.getClasse() == 2) {
            return (int) ((prix * nombreplce) * 0.5);
        }
        //regulier
        else if (personne.getClasse() == 3) {
            return (int) ((prix * nombreplce) * 0.9);
        }
        //senior
        else if (personne.getClasse() == 4) {
            return (int) ((prix * nombreplce) * 0.8);
        }
        return 0;


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
        conn.setAutoCommit(false);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO user (Utilisateur,mdp,type) VALUES (?,?,?)");
        ps.setString(1,nom);
        ps.setString(2,password);
        if (age >= 18 && age <= 64) {
            System.out.println("Le client est régulier.");
            ps.setInt(3,3);
        } else if (age >= 65) {
            System.out.println("Le client est senior.");
            ps.setInt(3,4);
        } else {
            System.out.println("Le client est un enfant.");
            ps.setInt(3,2);
        }
        ps.executeUpdate();

        //Validation la transaction
        conn.commit();
        System.out.println("Transactions réussies, les utilisateurs ont été ajoutés avec succès à la base de données.");
        AfficherInterfaceConnexion a = new AfficherInterfaceConnexion();
        a.afficherInterfaceConnexion(frame);
        frame.dispose();
    }

    public void InscriptionBDDFilm(String film, String auteur, int nbPlace, String lienImage,int prix,String resume,float note, int horaire,JFrame frame) throws SQLException, ClassNotFoundException {
        conn.setAutoCommit(false);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO film (nom_film,auteur,nbrplace,image_film,prix_place,resume,note,heure) VALUES (?,?,?,?,?,?,?,?)");
        ps.setString(1,film);
        ps.setString(2,auteur);
        ps.setInt(3,nbPlace);
        ps.setString(4,lienImage);
        ps.setInt(5,prix);
        ps.setString(6,resume);
        ps.setFloat(7,note);
        ps.setInt(8,horaire);
        ps.executeUpdate();

        //Validation la transaction
        conn.commit();
        System.out.println("Transactions réussies, le film a été ajoutés avec succès à la base de données.");
        EspaceAdmin espace= new EspaceAdmin();
        espace.afficherInterfaceAdmin();
        frame.dispose();
    }
    public void ModificationFilm(String film, String auteur, int nbPlace, String lienImage,int prix,String resume,float note, int horaire,String nomFilmBase, int heureFilmBase,JFrame frame) throws SQLException, ClassNotFoundException {
        // Requête SQL pour mettre à jour le film
        String sql = "UPDATE film SET nom_film=?,auteur=?,nbrplace=?,image_film=?,prix_place=?,resume=?,note=?,heure=?  WHERE nom_film = ? AND heure=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, film);   // Titre du film
            ps.setString(2, auteur);      // auteur du film
            ps.setInt(3, nbPlace);        // le nb de place
            ps.setString(4, lienImage);   // lien de l'image
            ps.setInt(5,prix); // prix du film
            ps.setString(6,resume); // resume du film
            ps.setFloat(7,note);   // note du film
            ps.setInt(8,horaire);  // horaire du film
            ps.setString(9,nomFilmBase); // comparaison avec nom de base
            ps.setInt(10,heureFilmBase); // et heure de base
            int affectedRows = ps.executeUpdate();  // variable qui permet de vérifié si elle a été mise a jour ou non
            if (affectedRows == 0) {
                // Aucune ligne affectée signifie que soit le film n'existe pas, soit il n'y avait pas assez de places
                throw new SQLException("Aucune mise à jour effectuée - vérifiez le titre ou la disponibilité des places.");
            }
        }
        EspaceAdmin espace= new EspaceAdmin();
        espace.afficherInterfaceAdmin();
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
    public boolean verificationInscriptionFilm(String film, String auteur,String nbPlace, String lienImage, String prix, String resume, String note){
        if(film.isEmpty() || auteur.isEmpty() || nbPlace.isEmpty() || lienImage.isEmpty() || prix.isEmpty() || resume.isEmpty() || note.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean verificationDoublonsInscription(String Utilisateur) throws SQLException{
        PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM user");
        ResultSet rs = ps1.executeQuery();
        String UtilisateurBDD;
        while(rs.next()){
            UtilisateurBDD = rs.getString("Utilisateur");
            if(Utilisateur.equals(UtilisateurBDD))
            {
                return false;
            }
            System.out.println(rs.getString("Utilisateur"));
        }
        return true;
    }
    public boolean verificationDoublonsInscriptionFilm(String film, int horaire) throws SQLException{
        String sql = "SELECT id_film FROM film WHERE nom_film = ? AND heure = ?";

        int resultat = 0;
        try {
            // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
            PreparedStatement psSelect = conn.prepareStatement(sql);
            psSelect.setString(1, film);
            psSelect.setInt(2, horaire);

            // Exécution de la requête et récupération du résultat
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                resultat = rs.getInt("id_film");
                System.out.println("Resultat Ajouter un film: ID_Film "+resultat);
                return false;
                //// System.out.println("Nombre de places disponibles pour le film " + nomFilm + " (" + idFilm + "): " + nbrPlaceDisponible);
                // Compare le nombre de places attendu avec le nombre disponible
                /////return nbrPlaceDisponible == nombrePlceAttendu;
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            throw e; // Propager l'exception après la journalisation
        }

        return true;
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

    public ArrayList<String> trierParNotes(FilmDAOimpl f) throws SQLException
    {
        ArrayList<String> listeFilmsTrieParNotes = new ArrayList<>();
        String sql = "SELECT id_film, nom_film, auteur, nbrplace, image_film, prix_place, resume, note, heure FROM film ORDER BY note DESC";
        try(PreparedStatement statement = conn.prepareStatement(sql))
        {
            ResultSet resultSet = statement.executeQuery();
            int i=0;
            String  classement;
            while(resultSet.next()){
                i++;
                classement = "N° " + i;
                int id_film = resultSet.getInt("id_film");
                String nom_film = resultSet.getString("nom_film");
                String auteur = resultSet.getString("auteur");
                int nbrplace = resultSet.getInt("nbrplace");
                String image_film = resultSet.getString("image_film");
                int prix_place = resultSet.getInt("prix_place");
                String resume = resultSet.getString("resume");
                float note = resultSet.getFloat("note");
                int heure = resultSet.getInt("heure");
                String total = classement + " " + nom_film + " de " + auteur + "/ note : " + note+" / 5";
                listeFilmsTrieParNotes.add(total);
            }
        }
        return listeFilmsTrieParNotes;
    }
    public void modifierFilm(String nomFilm, int heure1,JFrame ancienFrame) throws SQLException {
        //String sql = "UPDATE film SET nom_film=?,auteur=?,nbrplace=?,image_film=?,prix_place=?,resume=?,note=?,heure=?  WHERE nom_film = nomFilm AND heure= heure1";
        String sqlSelect = "SELECT * FROM film WHERE nom_film = ? AND heure = ?";
        int nouv;
        String nom = null,auteur=null,lien=null,resume=null;
        int nbplace=0,prix=0,heure=0;
        float note=0;

        try {
            // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
            PreparedStatement ps = conn.prepareStatement(sqlSelect);
            ps.setString(1,nomFilm);
            ps.setInt(2,heure1);
            // Exécution de la requête et récupération du résultat
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nom = rs.getString("nom_film");
                auteur=rs.getString("auteur");
                nbplace=rs.getInt("nbrplace");
                lien=rs.getString("image_film");
                prix=rs.getInt("prix_place");
                resume=rs.getString("resume");
                note=rs.getFloat("note");
                heure=rs.getInt("heure");
                System.out.println("PLACE: "+nbplace+" PRIX: "+prix+" HEURE: "+heure);
            }else {}
            JFrame frame = new JFrame("Modification Film");
            frame.setSize(450,500);
            frame.setLocationRelativeTo(ancienFrame);
            JPanel panel=new JPanel();
            panel.setLayout(null);
            panel.setBackground(new Color(173, 216, 230));
            frame.add(panel);

            JLabel label1=new JLabel("Formulaire d'ajouter un film");
            label1.setBounds(60,10,300,30);
            label1.setFont(new Font("Arial",Font.BOLD,22));
            label1.setForeground(new Color(64, 64, 64));
            panel.add(label1);

            JLabel label2=new JLabel("Nom du film :");
            label2.setBounds(20,60,300,30);
            label2.setFont(new Font("Arial",Font.BOLD,18));
            label2.setForeground(new Color(64, 64, 64));
            panel.add(label2);

            JTextField text1=new JTextField(nom);
            text1.setBounds(190,60,200,25);
            panel.add(text1);

            JLabel label3=new JLabel("Auteur du film :");
            label3.setBounds(20,100,300,30);
            label3.setFont(new Font("Arial",Font.BOLD,18));
            label3.setForeground(new Color(64, 64, 64));
            panel.add(label3);

            JTextField text2=new JTextField(auteur);
            text2.setBounds(190,100,200,25);
            panel.add(text2);

            JLabel label4=new JLabel("Nombre de place :");
            label4.setBounds(20,140,300,30);
            label4.setFont(new Font("Arial",Font.BOLD,18));
            label4.setForeground(new Color(64, 64, 64));
            panel.add(label4);

            JTextField text3=new JTextField(String.valueOf(nbplace));
            text3.setBounds(190,140,200,25);
            panel.add(text3);

            JLabel label5=new JLabel("Lien de l'image :");
            label5.setBounds(20,180,300,30);
            label5.setFont(new Font("Arial",Font.BOLD,18));
            label5.setForeground(new Color(64, 64, 64));
            panel.add(label5);

            JTextField text4=new JTextField(lien);
            text4.setBounds(190,180,200,25);
            panel.add(text4);

            JLabel label6=new JLabel("Prix du billet :");
            label6.setBounds(20,220,300,30);
            label6.setFont(new Font("Arial",Font.BOLD,18));
            label6.setForeground(new Color(64, 64, 64));
            panel.add(label6);

            JTextField text5=new JTextField(String.valueOf(prix));
            text5.setBounds(190,220,200,25);
            panel.add(text5);

            JLabel label7=new JLabel("Résumé du film :");
            label7.setBounds(20,260,300,30);
            label7.setFont(new Font("Arial",Font.BOLD,18));
            label7.setForeground(new Color(64, 64, 64));
            panel.add(label7);

            JTextField text6=new JTextField(resume);
            text6.setBounds(190,260,200,25);
            panel.add(text6);

            JLabel label8=new JLabel("Note du film :");
            label8.setBounds(20,300,300,30);
            label8.setFont(new Font("Arial",Font.BOLD,18));
            label8.setForeground(new Color(64, 64, 64));
            panel.add(label8);

            JTextField text7=new JTextField(String.valueOf(note));
            text7.setBounds(190,300,200,25);
            panel.add(text7);

            JLabel label9=new JLabel("Horaire du film :");
            label9.setBounds(20,340,300,30);
            label9.setFont(new Font("Arial",Font.BOLD,18));
            label9.setForeground(new Color(64, 64, 64));
            panel.add(label9);

            JComboBox comboBoxHoraire=new JComboBox();
            comboBoxHoraire.setBounds(190,340,200,25);
            for (int i = 1; i <= 24; i++) {
                if(i==heure) {

                }
                else{
                    comboBoxHoraire.addItem(i);
                }
            }
            panel.add(comboBoxHoraire);

            Bouton boutonEnregistrer = new BoutonAppuie(0,0,50,50,"Enregister");
            JButton boutonEnregister1 = boutonEnregistrer.CreaBouton();
            boutonEnregister1.setBounds(30,390,150,30);
            boutonEnregister1.setBackground(Color.orange);
            boutonEnregister1.setFont(new Font("Arial",Font.BOLD,18));
            boutonEnregister1.setForeground(new Color(64, 64, 64));
            RecuperationBouton listener1 = new RecuperationBouton(boutonEnregister1); // Création de l'écouteur avec le bouton
            listener1.ButtonEnregistrerFilm2(boutonEnregister1,text1,text2,text3,text4,text5,text6,text7,comboBoxHoraire,nomFilm,heure1,frame);
            panel.add(boutonEnregister1);

            Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
            JButton boutonRetour1 = boutonRetour.CreaBouton();
            boutonRetour1.setBounds(210,390,150,30);
            boutonRetour1.setBackground(Color.orange);
            boutonRetour1.setFont(new Font("Arial",Font.BOLD,18));
            boutonRetour1.setForeground(new Color(64, 64, 64));
            RecuperationBouton listener2 = new RecuperationBouton(boutonRetour1); // Création de l'écouteur avec le bouton
            listener2.ButtonRetourPageAdmin(boutonRetour1,frame);
            panel.add(boutonRetour1);


            frame.setVisible(true);

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            throw e; // Propager l'exception après la journalisation
        }

    }
    public void ajouterFacture(Personne personne, String titreFilm, int nombrePlaces, int prix, int heure) {
        String sql = "INSERT INTO facture (nom, nom_film, nbrplace, prix, heure, id_personne) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, personne.getNom());
            pstmt.setString(2, titreFilm);
            pstmt.setInt(3, nombrePlaces);
            pstmt.setInt(4, prix);
            pstmt.setInt(5, heure);
            pstmt.setInt(6, personne.getId());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JList<String>  lireFacture(Personne personne) throws SQLException {
        String query = "SELECT * FROM facture WHERE id_personne = ?";
        DefaultListModel<String> model = new DefaultListModel<>();  // Utiliser DefaultListModel pour stocker les données des factures
        JList<String> mod = new JList<>();

        try{
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, personne.getId());  // Assurez-vous que `Personne` a une méthode `getId()`
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Format: "Heure: [heure], Nom: [nom_personne], Film: [titre_film], Places: [nombre_places], Prix: [prix]"
                String factures = String.format("Heure: %d, Nom: %s, Film: %s, Places: %d, Prix: %.2f",
                        rs.getInt("heure"),
                        rs.getString("nom"),
                        rs.getString("nom_film"),
                        rs.getInt("nbrplace"),
                        rs.getDouble("prix"));
                model.addElement(factures);  // Ajouter chaque facture au modèle
            }
            mod.setModel(model);
            for(int i =0; i< model.getSize(); i++){
                System.out.println("facture : "+model.getElementAt(i));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return mod;
    }
}