package Vue;

import Controleur.RecuperationBouton;
import Modele.Bouton;
import Modele.BoutonAppuie;
import Modele.ListPanel;
import Modele.Personne;

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
        buffer2=new JPanel();



    }
    public void lireFacture (JList<String> liste, Personne personne){
        panel.add(liste);
        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        RecuperationBouton listener = new RecuperationBouton(boutonRetour1);
        listener.BoutonPage(boutonRetour1,personne, frame);
        buffer.add(boutonRetour1);
        panel.setVisible(true);
        buffer.setVisible(true);
        frame.add(buffer, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH); ///afficher une lecture de facture
    }

    public void afficherInterfaceAdmin() {
        panel.setBackground(new Color(173, 216, 230));
        buffer.setBackground(new Color(173, 216, 230));
        // Titre
     /*   JLabel titreLabel = new JLabel("Liste des Films");
        titreLabel.setFont(new Font("Arial",Font.BOLD,15));
        titreLabel.setBounds(190, 30, 200, 25);

        panel.add(titreLabel, BorderLayout.NORTH);*/

        ListPanel liste=new ListPanel(); ///creation d un panel pour afficher la liste des films
        liste.setFont(new Font("Arial",Font.BOLD,22));
        liste.setBounds(190,60,200,25);
        panel.add(liste,BorderLayout.NORTH);

        //RecuperationBouton Jliste=new RecuperationBouton(liste.listeJusteNom());
        ///Jliste.ListenerJ(liste.listeJusteNom());

        Bouton boutonajout = new BoutonAppuie(0,0,50,50,"Ajouter");
        JButton boutonajout1 = boutonajout.CreaBouton();
        boutonajout1.setFont(new Font("Arial",Font.BOLD,18));
        boutonajout1.setForeground(new Color(64, 64, 64));
        boutonajout1.setBackground(Color.orange);
        RecuperationBouton listener2 = new RecuperationBouton(boutonajout1);
        listener2.ButtonAjouterFilm(boutonajout1,frame);

        Bouton boutonsupp = new BoutonAppuie(0,0,50,50,"Supprimer");
        JButton boutonsupp1 = boutonsupp.CreaBouton();
        boutonsupp1.setFont(new Font("Arial",Font.BOLD,18));
        boutonsupp1.setForeground(new Color(64, 64, 64));
        boutonsupp1.setBackground(Color.orange);
        //RecuperationBouton listenersupp = new RecuperationBouton(boutonsupp1);
        /// listenersupp.boutetList(liste.listeJusteNom(),boutonsupp1,Jliste);
        //listenersupp.detectionBoutonSupprimer(liste.listeJusteNom(),boutonsupp1,frame);

        Bouton boutonmodif = new BoutonAppuie(0,0,50,50,"Modifier");
        JButton boutonmod = boutonmodif.CreaBouton();
        boutonmod.setFont(new Font("Arial",Font.BOLD,18));
        boutonmod.setForeground(new Color(64, 64, 64));
        boutonmod.setBackground(Color.orange); ////met la couleur orange au bouton
        RecuperationBouton listenersmod = new RecuperationBouton(boutonmod);
        listenersmod.detectionBoutonModifier(liste.listeJusteNom(),boutonsupp1,boutonmod,frame);////implementation de boutons qui vont rendre jolie la page

        Bouton boutontop = new BoutonAppuie(0,0,50,50,"Tendances");
        JButton boutontendence = boutontop.CreaBouton();
        boutontendence.setFont(new Font("Arial",Font.BOLD,18));
        boutontendence.setForeground(new Color(64, 64, 64));
        boutontendence.setBackground(Color.orange);
        RecuperationBouton listenerstop = new RecuperationBouton(boutontendence);
        listenerstop.ButtonTendance(boutontendence, frame);

        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        boutonRetour1.setFont(new Font("Arial",Font.BOLD,18));
        boutonRetour1.setForeground(new Color(64, 64, 64));
        boutonRetour1.setBackground(Color.orange);
        RecuperationBouton listener = new RecuperationBouton(boutonRetour1);
        listener.ButtonRetour(boutonRetour1,frame);

        buffer.add(boutonRetour1);
        buffer.add(boutonsupp1); ///affichage de tous les boutons sur des buffers.
        buffer.add(boutonajout1);
        buffer.add(boutonmod);
        //buffer.add(boutonsuppr1);
        buffer.add(boutontendence);

        buffer.setVisible(true);
        frame.add(buffer,BorderLayout.CENTER);
        frame.add(panel,BorderLayout.NORTH);



    }

    public void afficherTendances (JList<String> liste){
        ListPanel nv_liste = new ListPanel(liste);
        panel.add(nv_liste,BorderLayout.NORTH);
        //RecuperationBouton Jliste=new RecuperationBouton(liste.listeJusteNom());
        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        RecuperationBouton listener = new RecuperationBouton(boutonRetour1);
        listener.ButtonRetourTendance(boutonRetour1,frame);
        buffer.add(boutonRetour1);
        buffer.setVisible(true);
        frame.add(buffer,BorderLayout.CENTER); ///affichage sur les buffers
        frame.add(panel,BorderLayout.NORTH);
    }

}