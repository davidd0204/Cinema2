package Controleur;

import Modele.Bouton;
import Modele.BoutonAppuie;

import javax.swing.*;
import java.awt.*;

public class FormulaireAjouterFilm {
    public void AfficherFormulaireAjouterFilm(JFrame ancienFrame){
        JFrame frame = new JFrame("AJOUTER FILM");
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

        JTextField text1=new JTextField();
        text1.setBounds(190,60,200,25);
        panel.add(text1);

        JLabel label3=new JLabel("Auteur du film :");
        label3.setBounds(20,100,300,30);
        label3.setFont(new Font("Arial",Font.BOLD,18));
        label3.setForeground(new Color(64, 64, 64));
        panel.add(label3);

        JTextField text2=new JTextField();
        text2.setBounds(190,100,200,25);
        panel.add(text2);

        JLabel label4=new JLabel("Nombre de place :");
        label4.setBounds(20,140,300,30);
        label4.setFont(new Font("Arial",Font.BOLD,18));
        label4.setForeground(new Color(64, 64, 64));
        panel.add(label4);

        JTextField text3=new JTextField();
        text3.setBounds(190,140,200,25);
        panel.add(text3);

        JLabel label5=new JLabel("Lien de l'image :");
        label5.setBounds(20,180,300,30);
        label5.setFont(new Font("Arial",Font.BOLD,18));
        label5.setForeground(new Color(64, 64, 64));
        panel.add(label5);

        JTextField text4=new JTextField("/exemple.jpg");
        text4.setBounds(190,180,200,25);
        panel.add(text4);

        JLabel label6=new JLabel("Prix du billet :");
        label6.setBounds(20,220,300,30);
        label6.setFont(new Font("Arial",Font.BOLD,18));
        label6.setForeground(new Color(64, 64, 64));
        panel.add(label6);

        JTextField text5=new JTextField();
        text5.setBounds(190,220,200,25);
        panel.add(text5);

        JLabel label7=new JLabel("Résumé du film :");
        label7.setBounds(20,260,300,30);
        label7.setFont(new Font("Arial",Font.BOLD,18));
        label7.setForeground(new Color(64, 64, 64));
        panel.add(label7);

        JTextField text6=new JTextField();
        text6.setBounds(190,260,200,25);
        panel.add(text6);

        JLabel label8=new JLabel("Note du film :");
        label8.setBounds(20,300,300,30);
        label8.setFont(new Font("Arial",Font.BOLD,18));
        label8.setForeground(new Color(64, 64, 64));
        panel.add(label8);

        JTextField text7=new JTextField();
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
            comboBoxHoraire.addItem(i);
        }
        panel.add(comboBoxHoraire);

        Bouton boutonEnregistrer = new BoutonAppuie(0,0,50,50,"Enregister");
        JButton boutonEnregister1 = boutonEnregistrer.CreaBouton();
        boutonEnregister1.setBounds(30,390,150,30);
        boutonEnregister1.setBackground(Color.orange);
        boutonEnregister1.setFont(new Font("Arial",Font.BOLD,18));
        boutonEnregister1.setForeground(new Color(64, 64, 64));
        RecuperationBouton listener1 = new RecuperationBouton(boutonEnregister1); // Création de l'écouteur avec le bouton
        listener1.ButtonEnregistrerFilm(boutonEnregister1,text1,text2,text3,text4,text5,text6,text7,comboBoxHoraire,frame);
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
    }
}
