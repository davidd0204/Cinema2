package Controleur;

import Modele.Bouton;
import Modele.BoutonAppuie;

import javax.swing.*;
import java.awt.*;

public class Inscription {
    public void afficherInterfaceInscription(JFrame frame) {
        JFrame frameConnexion = new JFrame("Connexion");
        frameConnexion.setSize(450, 300);
        frameConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConnexion.setLayout(new GridLayout(4, 1));

        // Positionner la nouvelle fenêtre par rapport à la fenêtre principale
        frameConnexion.setLocationRelativeTo(frame);

        // Ajouter des champs de saisie pour l'utilisateur et le mot de passe
        JTextField champUtilisateur = new JTextField();
        JPasswordField champMotDePasse = new JPasswordField();

        // Créer le bouton de validation
        Bouton boutonValider = new BoutonAppuie(0,0,50,50,"Valider");
        JButton boutonValider1 = boutonValider.CreaBouton();
        RecuperationBouton listener1 = new RecuperationBouton(boutonValider1); // Création de l'écouteur avec le bouton
        listener1.ButtonValider(boutonValider1,champUtilisateur,champMotDePasse,frameConnexion);

        // Ajouter les composants à la fenêtre de connexion
        frameConnexion.add(new JLabel("Utilisateur:"));
        frameConnexion.add(champUtilisateur);
        frameConnexion.add(new JLabel("Mot de passe:"));
        frameConnexion.add(champMotDePasse);
        frameConnexion.add(boutonValider1);

        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        RecuperationBouton listener2 = new RecuperationBouton(boutonRetour1); // Création de l'écouteur avec le bouton
        listener2.ButtonRetour(boutonRetour1,frameConnexion);

        // Ajouter le bouton de retour à la fenêtre des informations utilisateur
        frameConnexion.add(boutonRetour1);


        // Rendre la fenêtre de connexion visible
        frameConnexion.setVisible(true);
    }
}
