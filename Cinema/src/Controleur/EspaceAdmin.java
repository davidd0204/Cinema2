package Controleur;

import Modele.Bouton;
import Modele.BoutonAppuie;
import Modele.ListPanel;

import javax.swing.*;
import java.awt.*;

public class EspaceAdmin extends JFrame {
    JPanel panel;
    JPanel buffer2;
    JFrame frame;
    JPanel buffer,bufferText;
    ListPanel pan;
    JList<String>nameList;

    public EspaceAdmin() {
        ///super("ma page");
        frame = new JFrame("Espace Admin");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(450, 400);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        panel=new JPanel();
        buffer=new JPanel();

      /*  panel=(JPanel) this.getContentPane();
        buffer=new JPanel();

        nameList = new JList<>();
        pan = new ListPanel();
        bufferText=new JPanel();

        bufferText.setPreferredSize(new Dimension(350, 100));
        pan.setPreferredSize(new Dimension(350, 400));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ///buffer2.setLayout(new GridLayout(2, 2));
*/

    }

    public void afficherInterfaceAdmin() {
        ListPanel liste=new ListPanel();

        panel.add(liste,BorderLayout.NORTH);
        RecuperationBouton Jliste=new RecuperationBouton(liste.listeJusteNom());
        ///Jliste.ListenerJ(liste.listeJusteNom());
        Bouton boutonajout = new BoutonAppuie(0,0,50,50,"Ajouter");
        JButton boutonajout1 = boutonajout.CreaBouton();
        RecuperationBouton listener2 = new RecuperationBouton(boutonajout1);


        Bouton boutonsupp = new BoutonAppuie(0,0,50,50,"Supprimer");
        JButton boutonsupp1 = boutonsupp.CreaBouton();
        RecuperationBouton listenersupp = new RecuperationBouton(boutonsupp1);
       /// listenersupp.boutetList(liste.listeJusteNom(),boutonsupp1,Jliste);
        listenersupp.setupComponents(liste.listeJusteNom(),boutonsupp1,frame);

        Bouton boutonmodif = new BoutonAppuie(0,0,50,50,"Modifier");
        JButton boutonmod = boutonmodif.CreaBouton();
        RecuperationBouton listenersmod = new RecuperationBouton(boutonmod);

        Bouton boutontop = new BoutonAppuie(0,0,50,50,"Tendence");
        JButton boutontendence = boutontop.CreaBouton();
        RecuperationBouton listenerstop = new RecuperationBouton(boutontendence);


        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        RecuperationBouton listener = new RecuperationBouton(boutonRetour1);
        listener.ButtonRetour(boutonRetour1,frame);
        buffer.add(boutonRetour1);
        buffer.add(boutonsupp1);
        buffer.add(boutonajout1);
        buffer.add(boutonmod);
        buffer.add(boutontendence);

        buffer.setVisible(true);
        frame.add(buffer,BorderLayout.CENTER);
        frame.add(panel,BorderLayout.NORTH);



    }
       /*JFrame frameConnexion = new JFrame("Admin");
        frameConnexion.setSize(450, 300);
        frameConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConnexion.setLayout(new GridLayout(4, 1));
*/
    // Positionner la nouvelle fenêtre par rapport à la fenêtre principale
    /// panel.setLocationRelativeTo(frame);


       /* JTextField champUtilisateur = new JTextField();
        frameConnexion.add(new JLabel("Nom Film"));
        frameConnexion.add(champUtilisateur);
        JTextField Auteur = new JTextField();
        frameConnexion.add(Auteur);
        JTextField Nbrplace = new JTextField();
        frameConnexion.add(Nbrplace);
        ///frameConnexion.add(champMotDePasse);
        ///frameConnexion.add(boutonValider1);
*/



        // Création de l'écouteur avec le bouton
        ////listener2.ButtonRetour(boutonRetour1,frameConnexion);

        // Ajouter le bouton de retour à la fenêtre des informations utilisateur
        ///frameConnexion.add(boutonRetour1);



    // Création de l'écouteur avec le bouton
    ////listener2.ButtonRetour(boutonRetour1,frameConnexion);

    // Ajouter le bouton de retour à la fenêtre des informations utilisateur
    ///frameConnexion.add(boutonRetour1);


    // Rendre la fenêtre de connexion visible
    ////  frameConnexion.setVisible(true);
}