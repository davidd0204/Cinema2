package Controleur;

import Modele.Bouton;
import Modele.BoutonAppuie;

import javax.swing.*;
import java.awt.*;

public class FormulaireAjouterFilm {
    public void AfficherFormulaireAjouterFilm(JFrame ancienFrame){
        JFrame frame = new JFrame("AJOUTER FILM"); // creation d'un frame pour ajouter un film
        frame.setSize(450,500); // affecte la taille de l'interface
        frame.setLocationRelativeTo(ancienFrame); // actualisation de la page
        JPanel panel=new JPanel(); // creation d'un panel
        panel.setLayout(null);
        panel.setBackground(new Color(173, 216, 230)); // affectation d'une couleur en background
        frame.add(panel); // ajout du panel au frame

        JLabel label1=new JLabel("Formulaire d'ajouter un film"); // titre de l'interfaace
        label1.setBounds(60,10,300,30); // taille du titre
        label1.setFont(new Font("Arial",Font.BOLD,22)); // font et size du ttire
        label1.setForeground(new Color(64, 64, 64)); // couleur du titre
        panel.add(label1); // ajout du titre au panel

        JLabel label2=new JLabel("Nom du film :"); // ajout d'un label pour nom du film
        label2.setBounds(20,60,300,30); // affecte la taille du label
        label2.setFont(new Font("Arial",Font.BOLD,18)); // le font et size du label
        label2.setForeground(new Color(64, 64, 64)); // affecte la couleur du label
        panel.add(label2); // ajout du label au panel

        JTextField text1=new JTextField(); // ajout d'un zone de texte pour la saisis
        text1.setBounds(190,60,200,25); // ajout de la taille du zone de text
        panel.add(text1); // ajout du text au panel

        JLabel label3=new JLabel("Auteur du film :"); // ajout d'un label pour auteur du film
        label3.setBounds(20,100,300,30); // affecte la taille du label
        label3.setFont(new Font("Arial",Font.BOLD,18)); // le font et size du label
        label3.setForeground(new Color(64, 64, 64)); // affecte la couleur du label
        panel.add(label3); // ajout du label au panel

        JTextField text2=new JTextField(); // ajout d'un zone de texte pour l'auteur
        text2.setBounds(190,100,200,25); // affcete la taille du zone de texte
        panel.add(text2); // ajout dans le panel la zone de texte

        JLabel label4=new JLabel("Nombre de place :"); // ajout d'un label pour nombre de place
        label4.setBounds(20,140,300,30); // affecte la taille
        label4.setFont(new Font("Arial",Font.BOLD,18)); // affcet le font et size du label
        label4.setForeground(new Color(64, 64, 64)); // affecte la couleur du label
        panel.add(label4); // ajout du label au panel

        JTextField text3=new JTextField(); // AJOUT D'un zone de text pour nombre de place
        text3.setBounds(190,140,200,25); // affecte la taille du zone de text
        panel.add(text3); // ajout d'un text au panel

        JLabel label5=new JLabel("Lien de l'image :"); // Ajout d'un label pour lien de l'image
        label5.setBounds(20,180,300,30); // affecte la taille du label
        label5.setFont(new Font("Arial",Font.BOLD,18)); // affecte le font et size du label
        label5.setForeground(new Color(64, 64, 64)); // affecte la couleur ddde font du label
        panel.add(label5); // ajout du label dans le panel

        JTextField text4=new JTextField("/fermer.jpeg"); // ajout du zone de texte pour l'image
        text4.setBounds(190,180,200,25); // affecte la taille de la zone
        panel.add(text4); // ajout du text dans le panel

        JLabel label6=new JLabel("Prix du billet :"); // ajout d'un label prix
        label6.setBounds(20,220,300,30); // affecte la taille
        label6.setFont(new Font("Arial",Font.BOLD,18)); // affecte le font et size
        label6.setForeground(new Color(64, 64, 64)); // ajout d'une couleur
        panel.add(label6); // ajout dans le panel

        JTextField text5=new JTextField(); // creation d'un zone de text
        text5.setBounds(190,220,200,25); // ajout d'un bouton
        panel.add(text5); // ajout dans le panel

        JLabel label7=new JLabel("Résumé du film :"); // ajout d'un resume label
        label7.setBounds(20,260,300,30); // affecte la taille
        label7.setFont(new Font("Arial",Font.BOLD,18)); // le font et size du label
        label7.setForeground(new Color(64, 64, 64)); // affecte la couleur
        panel.add(label7); // ajout dans le panel

        JTextField text6=new JTextField(); // creation d'un zone de text pour le resume du film
        text6.setBounds(190,260,200,25); // affecte la taialle
        panel.add(text6); // ajout dans le panel

        JLabel label8=new JLabel("Note du film :"); // ajout d'un label pour les notes du films
        label8.setBounds(20,300,300,30); // affecte la taille du label
        label8.setFont(new Font("Arial",Font.BOLD,18)); // definit le font et la size
        label8.setForeground(new Color(64, 64, 64)); // ajout de la couleur
        panel.add(label8); // ajout dans le panel

        JTextField text7=new JTextField();// ajout d'un text
        text7.setBounds(190,300,200,25); // affecte la taille du text
        panel.add(text7); // ajout d'un panel

        JLabel label9=new JLabel("Horaire du film :"); // creation d'un label pour horaire
        label9.setBounds(20,340,300,30); // affecte la taille du label
        label9.setFont(new Font("Arial",Font.BOLD,18)); // font et size du label
        label9.setForeground(new Color(64, 64, 64)); // affecte la couleur au label
        panel.add(label9); // ajout dans le panel

        JComboBox comboBoxHoraire=new JComboBox(); // ajout d'un cmobobox pour horaire
        comboBoxHoraire.setBounds(190,340,200,25); // la taille
        for (int i = 1; i <= 24; i++) { // boucle de parcourire des heures
            comboBoxHoraire.addItem(i);
        }
        panel.add(comboBoxHoraire);

        Bouton boutonEnregistrer = new BoutonAppuie(0,0,50,50,"Enregister"); // bouton enregistrer
        JButton boutonEnregister1 = boutonEnregistrer.CreaBouton(); // JBOUTOON enregistrer
        boutonEnregister1.setBounds(30,390,150,30); // affecte la taille du jbouton
        boutonEnregister1.setBackground(Color.orange); // affeecte la couleur du jbouton en background
        boutonEnregister1.setFont(new Font("Arial",Font.BOLD,18)); // affecte la taille et font du bouton
        boutonEnregister1.setForeground(new Color(64, 64, 64)); // affecte la couleur du titre
        RecuperationBouton listener1 = new RecuperationBouton(boutonEnregister1); // Création de l'écouteur avec le bouton
        listener1.ButtonEnregistrerFilm(boutonEnregister1,text1,text2,text3,text4,text5,text6,text7,comboBoxHoraire,frame); // listener pour savor si c appuyer le bouton
        panel.add(boutonEnregister1);

        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour"); // bouton retour
        JButton boutonRetour1 = boutonRetour.CreaBouton(); // jbouton retour
        boutonRetour1.setBounds(210,390,150,30); // talle du bouton
        boutonRetour1.setBackground(Color.orange); // afffecte la couleur
        boutonRetour1.setFont(new Font("Arial",Font.BOLD,18)); // font et size du bouton
        boutonRetour1.setForeground(new Color(64, 64, 64)); // couleur du bouton
        RecuperationBouton listener2 = new RecuperationBouton(boutonRetour1); // Création de l'écouteur avec le bouton
        listener2.ButtonRetourPageAdmin(boutonRetour1,frame); // listener pour savoir si c appuyer ou non  pour le retour
        panel.add(boutonRetour1); // AJOUT D'UN PANEL


        frame.setVisible(true);
    }
}
