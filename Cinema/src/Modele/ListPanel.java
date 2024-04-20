package Modele;

import Vue.Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ListPanel extends JPanel {
    JList<String> list;
    public ListPanel() {
        list= new JList<>();
        setLayout(new BorderLayout());

        try {
            Connexion conn = new Connexion();
            JList<String> nameList = new JList<>();
            nameList = conn.getlistFilms(nameList);

            // Ajout de la JList à un JScrollPane
            JScrollPane scrollPane = new JScrollPane(nameList);
            add(scrollPane, BorderLayout.CENTER);

            // Ajouter un MouseListener à la JList
            JList<String> finalNameList = nameList;
            nameList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) { // Un seul clic
                        int index = finalNameList.locationToIndex(e.getPoint());
                        if (index >= 0) {
                            String selectedName = finalNameList.getModel().getElementAt(index);
                            System.out.println("Selected Name: " + selectedName);
                            // Additional actions with the selected name here
                        }
                    }
                }
            });
            list=nameList;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "JDBC Driver not found: " + e.getMessage(),
                    "Driver Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }
    public JList<String> listeJusteNom()
    {
        list= new JList<>();
        setLayout(new BorderLayout());

        try {
            Connexion conn = new Connexion();
            JList<String> nameList = new JList<>();
            nameList = conn.getlistFilmsuniquement(nameList);

            // Ajout de la JList à un JScrollPane
            JScrollPane scrollPane = new JScrollPane(nameList);
            add(scrollPane, BorderLayout.CENTER);

            // Ajouter un MouseListener à la JList

            list=nameList;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "JDBC Driver not found: " + e.getMessage(),
                    "Driver Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
        return list;
    }
    public JList<String> getList() {return this.list;}

    public JList<String> listecrea() {
        return  list;
    }
}