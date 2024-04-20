package Controleur;

import Modele.Bouton;
import Modele.BoutonAppuie;
import Modele.Personne;

import javax.swing.*;
import java.awt.*;

public class AfficherInterfaceConnexion {
    public void afficherInterfaceConnexion(JFrame ancienFrame) {
        JFrame frame = new JFrame("ECE CINEMA");
        frame.setSize(400,250);
        frame.setLocationRelativeTo(ancienFrame);
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173, 216, 230));
        frame.add(panel);

        JLabel label1=new JLabel("Interface de connexion");
        label1.setBounds(60,10,300,30);
        label1.setFont(new Font("Arial",Font.BOLD,22));
        label1.setForeground(new Color(64, 64, 64));
        panel.add(label1);

        JLabel label2=new JLabel("Utilisateur :");
        label2.setBounds(20,60,300,30);
        label2.setFont(new Font("Arial",Font.BOLD,18));
        label2.setForeground(new Color(64, 64, 64));
        panel.add(label2);

        JTextField text1=new JTextField();
        text1.setBounds(160,60,200,25);
        panel.add(text1);

        JLabel label3=new JLabel("Mot de passe :");
        label3.setBounds(20,100,300,30);
        label3.setFont(new Font("Arial",Font.BOLD,18));
        label3.setForeground(new Color(64, 64, 64));
        panel.add(label3);

        JPasswordField text2=new JPasswordField();
        text2.setBounds(160,100,200,25);
        panel.add(text2);

        /*JFrame frameConnexion = new JFrame("Connexion");
        frameConnexion.setSize(450, 300);
        frameConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConnexion.setLayout(new GridLayout(4, 1));*/

        // Positionner la nouvelle fenêtre par rapport à la fenêtre principale
        //frameConnexion.setLocationRelativeTo(frame);

        // Ajouter des champs de saisie pour l'utilisateur et le mot de passe
      //  JTextField champUtilisateur = new JTextField();
        //JPasswordField champMotDePasse = new JPasswordField();

        // Créer le bouton de validation
        Bouton boutonValider = new BoutonAppuie(0,0,50,50,"Valider");
        JButton boutonValider1 = boutonValider.CreaBouton();
        boutonValider1.setBounds(30,150,150,30);
        boutonValider1.setBackground(Color.orange);
        boutonValider1.setFont(new Font("Arial",Font.BOLD,18));
        boutonValider1.setForeground(new Color(64, 64, 64));
        RecuperationBouton listener1 = new RecuperationBouton(boutonValider1); // Création de l'écouteur avec le bouton
        listener1.ButtonValider(boutonValider1,text1,text2,frame);
        panel.add(boutonValider1);

        // Ajouter les composants à la fenêtre de connexion
       /* frameConnexion.add(new JLabel("Utilisateur:"));
        frameConnexion.add(champUtilisateur);
        frameConnexion.add(new JLabel("Mot de passe:"));
        frameConnexion.add(champMotDePasse);
        frameConnexion.add(boutonValider1);*/

        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        boutonRetour1.setBounds(210,150,150,30);
        boutonRetour1.setBackground(Color.orange);
        boutonRetour1.setFont(new Font("Arial",Font.BOLD,18));
        boutonRetour1.setForeground(new Color(64, 64, 64));
        RecuperationBouton listener2 = new RecuperationBouton(boutonRetour1); // Création de l'écouteur avec le bouton
        listener2.ButtonRetour(boutonRetour1,frame);
        panel.add(boutonRetour1);
        // Ajouter le bouton de retour à la fenêtre des informations utilisateur
        //frameConnexion.add(boutonRetour1);


        // Rendre la fenêtre de connexion visible
        //frameConnexion.setVisible(true);

        frame.setVisible(true);
    }
    /*public void afficherInfosErreur(JFrame frame){
        JFrame frameInfos = new JFrame("Erreur");
        frameInfos.setSize(450, 300);
        frameInfos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInfos.setLayout(new GridLayout(3, 1));
        frameInfos.setLocationRelativeTo(frame);

        // Positionner la nouvelle fenêtre par rapport à la fenêtre principale
        frameInfos.setLocationRelativeTo(frame);
        JLabel labelErreur = new JLabel("Le nom d'utilisateur ou le mot de passe saisi est incorrect.");
        frameInfos.add(labelErreur);

        // Créer un bouton pour revenir à la page principale
        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        RecuperationBouton listener = new RecuperationBouton(boutonRetour1); // Création de l'écouteur avec le bouton
        listener.ButtonRetour1(boutonRetour1,frameInfos);

        // Ajouter le bouton de retour à la fenêtre des informations utilisateur
        frameInfos.add(boutonRetour1);

        // Rendre la fenêtre des informations utilisateur visible
        frameInfos.setVisible(true);
    }*/
    public void FormulaireInscription(JFrame ancienFrame){
        //int age;
        JFrame frame = new JFrame("Inscription");
        frame.setSize(400,380);
        frame.setLocationRelativeTo(ancienFrame);
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173, 216, 230));
        frame.add(panel);

        JLabel label1=new JLabel("Formulaire d'inscription");
        label1.setBounds(60,10,300,30);
        label1.setFont(new Font("Arial",Font.BOLD,22));
        label1.setForeground(new Color(64, 64, 64));
        panel.add(label1);

        JLabel label2=new JLabel("Nom :");
        label2.setBounds(20,60,300,30);
        label2.setFont(new Font("Arial",Font.BOLD,18));
        label2.setForeground(new Color(64, 64, 64));
        panel.add(label2);

        JTextField text1=new JTextField();
        text1.setBounds(160,60,200,25);
        panel.add(text1);

        JLabel label3=new JLabel("Prénom :");
        label3.setBounds(20,100,300,30);
        label3.setFont(new Font("Arial",Font.BOLD,18));
        label3.setForeground(new Color(64, 64, 64));
        panel.add(label3);

        JTextField text2=new JTextField();
        text2.setBounds(160,100,200,25);
        panel.add(text2);

        JLabel label4=new JLabel("Age :");
        label4.setBounds(20,140,300,30);
        label4.setFont(new Font("Arial",Font.BOLD,18));
        label4.setForeground(new Color(64, 64, 64));
        panel.add(label4);

        JComboBox comboBoxAge=new JComboBox();
        comboBoxAge.setBounds(160,140,200,25);
        for (int i = 1; i <= 100; i++) {
            comboBoxAge.addItem(i);
        }

        panel.add(comboBoxAge);

        JLabel password =new JLabel("Mot de passe :");
        password.setBounds(20,180,300,30);
        password.setFont(new Font("Arial",Font.BOLD,18));
        password.setForeground(new Color(64, 64, 64));
        panel.add(password);

        JTextField textPassword=new JTextField();
        textPassword.setBounds(160,180,200,25);
        panel.add(textPassword);

        JLabel ConfirmatonPassword =new JLabel("Confirmation :");
        ConfirmatonPassword.setBounds(20,220,300,30);
        ConfirmatonPassword.setFont(new Font("Arial",Font.BOLD,18));
        ConfirmatonPassword.setForeground(new Color(64, 64, 64));
        panel.add(ConfirmatonPassword);

        JTextField textConfirmationPassword=new JTextField();
        textConfirmationPassword.setBounds(160,220,200,25);
        panel.add(textConfirmationPassword);

        Bouton boutonEnregistrer = new BoutonAppuie(0,0,50,50,"Enregister");
        JButton boutonEnregister1 = boutonEnregistrer.CreaBouton();
        boutonEnregister1.setBounds(30,270,150,30);
        boutonEnregister1.setBackground(Color.orange);
        boutonEnregister1.setFont(new Font("Arial",Font.BOLD,18));
        boutonEnregister1.setForeground(new Color(64, 64, 64));
        RecuperationBouton listener1 = new RecuperationBouton(boutonEnregister1); // Création de l'écouteur avec le bouton
        listener1.ButtonEnregistrer(boutonEnregister1,text1,text2,comboBoxAge,textPassword,textConfirmationPassword,frame);
        panel.add(boutonEnregister1);

        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        boutonRetour1.setBounds(210,270,150,30);
        boutonRetour1.setBackground(Color.orange);
        boutonRetour1.setFont(new Font("Arial",Font.BOLD,18));
        boutonRetour1.setForeground(new Color(64, 64, 64));
        RecuperationBouton listener2 = new RecuperationBouton(boutonRetour1); // Création de l'écouteur avec le bouton
        listener2.ButtonRetour(boutonRetour1,frame);
        panel.add(boutonRetour1);

        frame.setVisible(true);
    }
}