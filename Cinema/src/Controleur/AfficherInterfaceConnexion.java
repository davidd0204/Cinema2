package Controleur;

import Modele.Bouton;
import Modele.BoutonAppuie;
import Modele.Personne;

import javax.swing.*;
import java.awt.*;

public class AfficherInterfaceConnexion {
    public void afficherInterfaceConnexion(JFrame ancienFrame) {

        JFrame frame = new JFrame("ECE CINEMA"); // AFFECTE DU TITRE
        frame.setSize(400,250); // LA TAILLE DE L'INTERFACE
        frame.setLocationRelativeTo(ancienFrame); // ACTUALISE SUR LA PAGE D'AVANT
        JPanel panel=new JPanel(); // creer un panel
        panel.setLayout(null);
        panel.setBackground(new Color(173, 216, 230)); // affecte la couleur en background
        frame.add(panel); // ajout dans le frame

        JLabel label1=new JLabel("Interface de connexion"); // titre de l'interface
        label1.setBounds(60,10,300,30); // affecte la taille
        label1.setFont(new Font("Arial",Font.BOLD,22)); // affecte la taille et font du titre
        label1.setForeground(new Color(64, 64, 64)); // affecte la couleur
        panel.add(label1); // ajout dans le panel

        JLabel label2=new JLabel("Utilisateur :"); // zone d'utilisateur
        label2.setBounds(20,60,300,30); // la taille du bouton
        label2.setFont(new Font("Arial",Font.BOLD,18)); // font et size du text
        label2.setForeground(new Color(64, 64, 64)); // affecte la couleur en background du text
        panel.add(label2); // ajout dans le panel

        JTextField text1=new JTextField(); // ajout d'un zone de text
        text1.setBounds(160,60,200,25); // taille du bouton
        panel.add(text1); // ajout dans le panel

        JLabel label3=new JLabel("Mot de passe :"); // zone mdp
        label3.setBounds(20,100,300,30); // taille du mdp
        label3.setFont(new Font("Arial",Font.BOLD,18)); // font et size du mdp
        label3.setForeground(new Color(64, 64, 64)); // couleur du mdp
        panel.add(label3); // ajout dans le panel

        JPasswordField text2=new JPasswordField(); //creer un zone de text
        text2.setBounds(160,100,200,25); // la taille de la zone
        panel.add(text2); // ajout dans le panel

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
        Bouton boutonValider = new BoutonAppuie(0,0,50,50,"Valider"); // ajout d'un bouton valider
        JButton boutonValider1 = boutonValider.CreaBouton();// creation d'un jbouton
        boutonValider1.setBounds(30,150,150,30);// affecte la taille
        boutonValider1.setBackground(Color.orange); // affecte la couleur en background
        boutonValider1.setFont(new Font("Arial",Font.BOLD,18)); // affecte la size et font
        boutonValider1.setForeground(new Color(64, 64, 64)); // affecte la couleur du text
        RecuperationBouton listener1 = new RecuperationBouton(boutonValider1); // Création de l'écouteur avec le bouton
        listener1.ButtonValider(boutonValider1,text1,text2,frame); // appel du listener si le bouton est appuyer
        panel.add(boutonValider1); // ajout dans le panel

        // Ajouter les composants à la fenêtre de connexion
       /* frameConnexion.add(new JLabel("Utilisateur:"));
        frameConnexion.add(champUtilisateur);
        frameConnexion.add(new JLabel("Mot de passe:"));
        frameConnexion.add(champMotDePasse);
        frameConnexion.add(boutonValider1);*/

        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour"); // ajout d'un bouton retour
        JButton boutonRetour1 = boutonRetour.CreaBouton(); // creation d'un jbouton retour
        boutonRetour1.setBounds(210,150,150,30); //affecte la taille
        boutonRetour1.setBackground(Color.orange); // affecte la couleur orange
        boutonRetour1.setFont(new Font("Arial",Font.BOLD,18)); // font et size du bouton
        boutonRetour1.setForeground(new Color(64, 64, 64)); // taille du bouton en texte
        RecuperationBouton listener2 = new RecuperationBouton(boutonRetour1); // Création de l'écouteur avec le bouton
        listener2.ButtonRetour(boutonRetour1,frame); // appel le programme qui permet de retour
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
        JFrame frame = new JFrame("Inscription"); // nom de la page inscription
        frame.setSize(400,380); // formater la page
        frame.setLocationRelativeTo(ancienFrame); // actualiser la page au meme endroit
        JPanel panel=new JPanel(); // creation d'un panel comme un bufer
        panel.setLayout(null);
        panel.setBackground(new Color(173, 216, 230)); // Ajout de la couleur en fond d'écran
        frame.add(panel); // Ajout du panel au frame

        JLabel label1=new JLabel("Formulaire d'inscription"); // titre de la page
        label1.setBounds(60,10,300,30); // tailel du bouton
        label1.setFont(new Font("Arial",Font.BOLD,22)); // le texte et la taille du text
        label1.setForeground(new Color(64, 64, 64)); // le fond d'écran du page
        panel.add(label1); // ajout au titre au buffer 'panel'

        JLabel label2=new JLabel("Nom :"); // ajoute placement d'un nom
        label2.setBounds(20,60,300,30); // taille du nom
        label2.setFont(new Font("Arial",Font.BOLD,18)); // le font et la taille
        label2.setForeground(new Color(64, 64, 64)); // ajout de la couleur
        panel.add(label2);

        JTextField text1=new JTextField(); // ajout d'un emplacement pour écrire le texte
        text1.setBounds(160,60,200,25); // taille du texte
        panel.add(text1); // ajout de la zone de texte dans le panel

        JLabel label3=new JLabel("Prénom :"); //ajout d'un prénom
        label3.setBounds(20,100,300,30); // la taille du prenom
        label3.setFont(new Font("Arial",Font.BOLD,18)); // le font et la size des caracteres
        label3.setForeground(new Color(64, 64, 64)); // le fond de couleur du prenom
        panel.add(label3); // ajout du prenom du buffer

        JTextField text2=new JTextField(); // zone de texte pour le prenom
        text2.setBounds(160,100,200,25); // la taille de la zone
        panel.add(text2); // ajout de la zone dans le buffer

        JLabel label4=new JLabel("Age :"); // ajout d'un age
        label4.setBounds(20,140,300,30); // la taille de l'age
        label4.setFont(new Font("Arial",Font.BOLD,18)); // le font et la taille du texte
        label4.setForeground(new Color(64, 64, 64)); // ajout de la couleur
        panel.add(label4); // ajout de l'age dans le buffer

        JComboBox comboBoxAge=new JComboBox(); // aajoute d'un combobox qui permet de scroller l'age
        comboBoxAge.setBounds(160,140,200,25); // taille du combobox
        for (int i = 1; i <= 100; i++) { // boucle qui nous donne tout les choix possible
            comboBoxAge.addItem(i);
        }

        panel.add(comboBoxAge); // ajout du combobox dans le panel

        JLabel password =new JLabel("Mot de passe :"); //ajout d'un mot de passe
        password.setBounds(20,180,300,30); // taille du mot de passe
        password.setFont(new Font("Arial",Font.BOLD,18)); // font et size du mdp
        password.setForeground(new Color(64, 64, 64)); // couleur du mdp
        panel.add(password); // ajout dans le panel

        JTextField textPassword=new JTextField(); // zone de texte du mdp
        textPassword.setBounds(160,180,200,25); // taille de la zone
        panel.add(textPassword); // ajout du mdp dans le panel

        JLabel ConfirmatonPassword =new JLabel("Confirmation :"); // text confirmation mdp
        ConfirmatonPassword.setBounds(20,220,300,30); // taille de la zone de text
        ConfirmatonPassword.setFont(new Font("Arial",Font.BOLD,18)); // size et font du text
        ConfirmatonPassword.setForeground(new Color(64, 64, 64)); // couleur du text
        panel.add(ConfirmatonPassword); // ajout dans le buffer

        JTextField textConfirmationPassword=new JTextField(); // creer un zone de texte
        textConfirmationPassword.setBounds(160,220,200,25); // taille du text
        panel.add(textConfirmationPassword);// ajout de la zone dans le panel

        Bouton boutonEnregistrer = new BoutonAppuie(0,0,50,50,"Enregister"); // creation du bouton enregistrer
        JButton boutonEnregister1 = boutonEnregistrer.CreaBouton(); // creation d'un JBOUTON
        boutonEnregister1.setBounds(30,270,150,30); // affecte la taille
        boutonEnregister1.setBackground(Color.orange); // affecte la couleur
        boutonEnregister1.setFont(new Font("Arial",Font.BOLD,18)); // affeecte le font et size
        boutonEnregister1.setForeground(new Color(64, 64, 64)); // affecte la couleur du text
        RecuperationBouton listener1 = new RecuperationBouton(boutonEnregister1); // Création de l'écouteur avec le bouton
        listener1.ButtonEnregistrer(boutonEnregister1,text1,text2,comboBoxAge,textPassword,textConfirmationPassword,frame); // permet de savoir si le bouton est cliqué
        panel.add(boutonEnregister1); // ajout dans le panel

        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour"); //creation d'un bouton retour
        JButton boutonRetour1 = boutonRetour.CreaBouton(); // ajout d'un JBouton
        boutonRetour1.setBounds(210,270,150,30); // affecte la taille
        boutonRetour1.setBackground(Color.orange); //affecte la couleur en background
        boutonRetour1.setFont(new Font("Arial",Font.BOLD,18)); //affecte le font et size
        boutonRetour1.setForeground(new Color(64, 64, 64)); // affecte la couleur du text
        RecuperationBouton listener2 = new RecuperationBouton(boutonRetour1); // Création de l'écouteur avec le bouton
        listener2.ButtonRetour(boutonRetour1,frame); // appelle si le bouton est appuyé
        panel.add(boutonRetour1); // ajout du bouton dans le panel

        frame.setVisible(true); // rendre l'interface visible
    }
}