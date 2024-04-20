package Controleur;

import Modele.*;
import Vue.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.sql.*;

public class Generale extends JFrame {
    public JFrame frame;
    public int type;
    Personne personne;

    public Generale(){
    }
    public Generale(Personne personne){
        this.personne= personne;
    }

    public void Generale() throws SQLException, ClassNotFoundException {
        
        frame = new JFrame("ECE CINEMA");
        frame.setSize(590,200);
        JPanel panel=new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(frame);
        panel.setLayout(null);
        panel.setBackground(new Color(173, 216, 230));
        frame.add(panel);

        JLabel label1=new JLabel("BIEVENUE A L' ECE CINEMA");
        label1.setBounds(135,10,300,40);
        label1.setFont(new Font("Arial",Font.BOLD,22));
        label1.setForeground(new Color(64, 64, 64));
        panel.add(label1);

        Bouton connexion = new BoutonAppuie(0,0,0,0,"Connexion");
        JButton connexion1 = connexion.CreaBouton();
        connexion1.setBounds(30,60,150,30);
        connexion1.setBackground(Color.orange);
        connexion1.setFont(new Font("Arial",Font.BOLD,18));
        connexion1.setForeground(new Color(64, 64, 64));
        RecuperationBouton listener1 = new RecuperationBouton(connexion1); // Création de l'écouteur avec le bouton
        listener1.ButtonConnexion(personne,connexion1,frame);
        //listener1.ButtonConnexion(connexion1,frame);
        panel.add(connexion1);

        Bouton invite = new BoutonAppuie(0,0,50,50,"Invité");
        JButton invite1 = invite.CreaBouton();
        invite1.setBounds(210,60,150,30);
        invite1.setBackground(Color.orange);
        invite1.setFont(new Font("Arial",Font.BOLD,18));
        invite1.setForeground(new Color(64, 64, 64));
        RecuperationBouton listener2 = new RecuperationBouton(invite1); // Création de l'écouteur avec le bouton
        listener2.ButtonInvite(invite1,frame);
        panel.add(invite1);

        Bouton inscription = new BoutonAppuie(0,0,50,50,"Inscription");
        JButton inscription1 = inscription.CreaBouton();
        inscription1.setBounds(390,60,150,30);
        inscription1.setBackground(Color.orange);
        inscription1.setFont(new Font("Arial",Font.BOLD,18));
        inscription1.setForeground(new Color(64, 64, 64));
        RecuperationBouton listener3 = new RecuperationBouton(inscription1); // Création de l'écouteur avec le bouton
        listener3.ButtonInscription(inscription1,frame);
        panel.add(inscription1);
        // Création du bouton de connexion
        //Bouton connexion = new BoutonAppuie(0,0,50,50,"Connexion");
        //JButton connexion1 = connexion.CreaBouton();
        //RecuperationBouton listener1 = new RecuperationBouton(connexion1); // Création de l'écouteur avec le bouton
        //listener1.ButtonConnexion(connexion1,frame);


        // Création du bouton d'invité
        /*Bouton invite = new BoutonAppuie(0,0,50,50,"Invité");
        JButton invite1 = invite.CreaBouton();
        RecuperationBouton listener2 = new RecuperationBouton(invite1); // Création de l'écouteur avec le bouton
        listener2.ButtonInvite(invite1,frame);


        // Création du bouton de connexion
        Bouton inscription = new BoutonAppuie(0,0,50,50,"Inscription");
        JButton inscription1 = inscription.CreaBouton();
        RecuperationBouton listener3 = new RecuperationBouton(inscription1); // Création de l'écouteur avec le bouton
        listener3.ButtonInscription(inscription1,frame);

        // Ajout des boutons à la fenêtre principale
        frame.add(connexion1);
        frame.add(invite1);
        frame.add(inscription1);*/

        // Rendre la fenêtre principale visible
        frame.setVisible(true);
    }
    public void LancementJeux(Personne personne) throws SQLException, ClassNotFoundException {
        String nomfilm;
        Page Acceuil;
        Connexion conn=null;
        System.out.println(personne.getNom());

        System.out.println("Hello Palkis!");
        System.out.println("ECE PARIS TYPE: "+type);
        // Remplacez par votre mot de passe
        try {
            Connexion connexion = new Connexion();
            System.out.println("Connexion à la base de données réussie !");



            UIManager.setLookAndFeel(new NimbusLookAndFeel());

            // Start my window
            ///Acceuil.getListPanel().
            //// Acceuil.getFrame().setSize(500, 500);
            ListPanel PAN=new ListPanel();
            JList<String> Liste= PAN.listecrea();
            RecuperationList listen =new RecuperationList(Liste);
            listen.ajouterListen(Liste);
            Acceuil=new Page(Liste);
            Bouton appuie=new BoutonAppuie(0,0,50,50,"accueil");
            JButton bouton = appuie.CreaBouton(); // Création du bouton
            Acceuil.ajouterbouton(bouton,0,0,120,50); // Ajout du bouton à la page
            RecuperationBouton listener=new RecuperationBouton(bouton); // Création de l'écouteur avec le bouton
            listener.ajouterListener(Acceuil);
            Acceuil.getPanel().add(bouton, BorderLayout.NORTH);


            Bouton recherche=new BoutonRecherche(0,0,50,50,"Recherche");
            JButton bouton1=recherche.CreaBouton();
            Acceuil.ajouterbouton(bouton1,0,0,120,20);
            Acceuil.getPanel().add(bouton1, BorderLayout.WEST);
            Acceuil.getListPanel().setVisible(true);
            Acceuil.getPanel().add(Acceuil.getListPanel(), BorderLayout.WEST);
            Bouton recherche2=new BoutonRecherche(0,0,50,50,"CalculerPrix");
            JButton bouton2=recherche2.CreaBouton();
            Acceuil.ajouterbouton(bouton2,0,0,120,20);




            JTextField field=recherche.text();
            Acceuil.ajouterbarre(field,0,0,450,200);
            RecuperationBouton listener2=new RecuperationBouton(bouton1);




            Acceuil.getPanel().add(Acceuil.getbuffer());

            JTextField field2=recherche.text();
            Acceuil.ajouterbarre(field,0,0,450,200);
            RecuperationBouton listener3=new RecuperationBouton(bouton2);

            Acceuil.getbuffer().add(field2,BorderLayout.CENTER);
            Acceuil.getbuffer().add(bouton2, BorderLayout.CENTER);
            Acceuil.getbuffer().add(field,BorderLayout.CENTER);
            Acceuil.getbuffer().add(bouton1, BorderLayout.CENTER);
            Acceuil.getPanel().add(Acceuil.getbuffer());

            Acceuil.afficherImageURL("/fermer.jpeg",Acceuil.getHeight(),0);
            Acceuil.ajouterResume("RESUME ICI");
            JComboBox box=new JComboBox<>();
            box=Acceuil.ajoutercombo(box);/*/
          /*  JComboBox comboBoxAge=new JComboBox();
            comboBoxAge.setBounds(160,140,200,25);
            for (int i = 1; i <= 100; i++) {
                comboBoxAge.addItem(i);
            }*/
          ////  Acceuil.getbuffer().add(comboBoxAge);

            //box=Acceuil.ajoutercombo(box);;
            listener3.ajouterListenernbrfilm(field,Acceuil,field2,personne,box);
            Acceuil.ajoutertext("Indiquer l'heure ");
            listener2.ajouterListener2(field,Acceuil,box);
            Acceuil.setVisible(true);
            Acceuil.revalidate();
            Acceuil.getPanel().setPreferredSize(new Dimension(1100,600));
            Acceuil.getPanel().repaint();
            Acceuil.pack();
            Acceuil.repaint();
            ///Acceuil.getFrame().setLayout(null); // Utilisation d'un layout null pour le JFrame
            //// Acceuil.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ////Acceuil.getFrame().setVisible(true);

        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Driver non trouvé.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données.");
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
}
