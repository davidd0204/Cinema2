package Controleur;

import Modele.Connexion;
import Modele.RechercheSql;
import Vue.*;

import Vue.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class RecuperationBouton {
    private JButton JB;

    public RecuperationBouton(JButton bouton) {
        this.JB = bouton;
    }

    public void ajouterListener(Page accueil) {
        JB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Generale General = new Generale();
                try {
                    accueil.dispose();
                    General.Generale();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                // Vous pouvez faire d'autres traitements avec la valeur récupérée ici
            }
        });
    }



    public void ajouterListener2(JTextField field, Page Acceuil) {
        JB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valeur;
                String resume;

                ////String motDePasse = "Jack123456";
                String valeurBouton = field.getText();


                System.out.println("La valeur du bouton est : " + valeurBouton);
                Connexion sql = null; // Passer la connexion à la classe RechercheSql
                try {
                    sql = new Connexion();
                    valeur=sql.getFilmName(valeurBouton);
                    System.out.println("yey "+valeur);
                    Acceuil.afficherImageURL(valeur,200,200);
                    resume= sql.getresume(valeurBouton);
                    Acceuil.ajouterResume(resume);



                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                // Vous pouvez faire d'autres traitements avec la valeur récupérée ici
                try {
                    String val = sql.getFilmName(valeurBouton);
                    System.out.println(val);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void ButtonConnexion(JButton boutonConnexion, JFrame frame){
        boutonConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton de connexion est cliqué
                frame.dispose(); // Fermer la fenêtre actuelle

                // Afficher l'interface de saisie utilisateur et mot de passe
                AfficherInterfaceConnexion a = new AfficherInterfaceConnexion();
                System.out.println("Affichage de l'interface de connexion");
                a.afficherInterfaceConnexion(frame);
            }
        });
    }
    public void ButtonInvite(JButton boutonInvite, JFrame frame){
        boutonInvite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*String databaseName = "cinema"; // Remplacez par le nom de votre base de données
                String utilisateur = "root"; // Utilisateur par défaut pour MySQL
                //String motDePasse = ""; // Remplacez par votre mot de passe
                String motDePasse = "Jack123456"; // mdp pour jack
                Connexion connexionBDD = null; */
                frame.dispose(); // Fermer la fenêtre actuelle

                Generale g = new Generale();
                try {
                    g.LancementJeux(0);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void ButtonInscription(JButton boutonInscription, JFrame frame){
        boutonInscription.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton de connexion est cliqué
                frame.dispose(); // Fermer la fenêtre actuelle

                // Afficher l'interface de saisie utilisateur et mot de passe

                // CODE D'INSCRIPTION ICI
            }
        });
    }
    public void ButtonValider(JButton boutonValider,JTextField champUtilisateur, JPasswordField champMotDePasse, JFrame frame){
        boutonValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupérer les valeurs saisies par l'utilisateur
                String utilisateur = champUtilisateur.getText();
                String motDePasse = new String(champMotDePasse.getPassword());
                Connexion v = null;
                Generale g = new Generale();
                int type=0;
                AfficherInterfaceConnexion a = new AfficherInterfaceConnexion();
                try {
                    v = new Connexion();
                    v.verifierDisponibiliteFilm(utilisateur,motDePasse);
                    if(v.verifierDisponibiliteFilm(utilisateur, motDePasse))
                    {
                        System.out.println("yep");
                        type=v.getType(utilisateur,motDePasse);
                        g.LancementJeux(type);
                    }
                    else{
                        a.afficherInfosErreur(frame);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                ////Generale g = new Generale();
                // Afficher les informations saisies dans une nouvelle interface
                System.out.println("BOUTON VALDER APPUUYER");
               /* try {
                    if(v.Verification(utilisateur,motDePasse)){
                        frame.dispose();
                        g.LancementJeux(v.getType(utilisateur,motDePasse));
                        // CODE DU JEUX
                    }
                    else {
                        a.afficherInfosErreur(frame);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }*/

                // Fermer la fenêtre de connexion
                frame.dispose();
            }
        });
    }
    public void ButtonRetour(JButton boutonRetour,JFrame frame){
        boutonRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre des informations utilisateur
                frame.dispose();
                Generale g = new Generale();
                try {
                    g.Generale();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void ButtonRetour1(JButton boutonRetour,JFrame frame){
        boutonRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AfficherInterfaceConnexion a = new AfficherInterfaceConnexion();
                a.afficherInterfaceConnexion(frame);
                // Fermer la fenêtre des informations utilisateur
                frame.dispose();

                // Afficher à nouveau la fenêtre principale
                //frame.setVisible(true);
            }
        });
    }


    public void ajouterListenernbrfilm(JTextField field, Page Acceuil, JTextField field2) {
        JB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valeurBouton = field.getText().trim();
                String getText = field2.getText();
                int nombrePlce;
                int prix;

                // Validation du nombre de places
                try {
                    nombrePlce = Integer.parseInt(getText);
                    if (nombrePlce < 0) {
                        JOptionPane.showMessageDialog(null, "Le nombre de places ne peut pas être négatif.", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
                        throw new IllegalArgumentException("Le nombre de places ne peut pas être négatif.");
                    }

                     // Mot de passe

                    try {Connexion sql = new Connexion();
                        prix = sql.getnbrfilm(valeurBouton,nombrePlce);
                        System.out.println("Nom du film récupéré : " + prix);
                        // Vous pouvez effectuer d'autres actions ici, comme mettre à jour l'interface utilisateur avec le nom du film
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur SQL: " + ex.getMessage(), "Erreur SQL", JOptionPane.ERROR_MESSAGE);
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Driver JDBC non trouvé: " + ex.getMessage(), "Erreur de Driver", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide pour les places.", "Erreur de format", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur de validation", JOptionPane.ERROR_MESSAGE);
                    return; // Sortir de la méthode si le nombre est négatif
                }

                System.out.println("La valeur du bouton est : " + valeurBouton);

                // Connexion à la base de données et récupération de données

            }
        });
    }

}
