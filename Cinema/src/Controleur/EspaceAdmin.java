package Controleur;

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
        frame.add(panel, BorderLayout.NORTH);
    }

    public void afficherInterfaceAdmin() {
        ListPanel liste=new ListPanel();
        ListPanel liste2=new ListPanel();

        panel.add(liste,BorderLayout.NORTH);
        RecuperationBouton Jliste=new RecuperationBouton(liste.listeJusteNom());
        RecuperationBouton Jliste2=new RecuperationBouton(liste2.listeJusteNom());
        ///Jliste.ListenerJ(liste.listeJusteNom());
        Bouton boutonajout = new BoutonAppuie(0,0,50,50,"Ajouter");
        JButton boutonajout1 = boutonajout.CreaBouton();
        RecuperationBouton listener2 = new RecuperationBouton(boutonajout1);
        listener2.ButtonAjouterFilm(boutonajout1,frame);

        Bouton boutonsupp = new BoutonAppuie(0,0,50,50,"Supprimer");
        JButton boutonsupp1 = boutonsupp.CreaBouton();
        RecuperationBouton listenersupp = new RecuperationBouton(boutonsupp1);
       /// listenersupp.boutetList(liste.listeJusteNom(),boutonsupp1,Jliste);
////


        Bouton boutonmodif = new BoutonAppuie(0,0,50,50," Modifier  ");
        JButton boutonmod = boutonmodif.CreaBouton();
        RecuperationBouton listenersmod = new RecuperationBouton(boutonmod);

        listenersupp.setupComponents(liste.listeJusteNom(),boutonsupp1,frame);
        buffer2.add(liste2);
        listenersmod.setupComponents2(liste2.listeJusteNom(),boutonmod,frame);


        Bouton boutontop = new BoutonAppuie(0,0,50,50,"Tendances");
        JButton boutontendence = boutontop.CreaBouton();
        RecuperationBouton listenerstop = new RecuperationBouton(boutontendence);
        listenerstop.ButtonTendance(boutontendence, frame);


        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        RecuperationBouton listener = new RecuperationBouton(boutonRetour1);
        listener.ButtonRetour(boutonRetour1,frame);
        buffer.add(boutonRetour1);
        panel.add(boutonsupp1);
        buffer.add(boutonajout1);
        buffer2.add(boutonmod);
        buffer.add(boutontendence);

        buffer.setVisible(true);
        frame.add(buffer2,BorderLayout.SOUTH);
        frame.add(buffer,BorderLayout.CENTER);
        frame.add(panel,BorderLayout.NORTH);
        frame.pack();



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
        frame.add(buffer,BorderLayout.CENTER);
        frame.add(panel,BorderLayout.NORTH);
    }

}