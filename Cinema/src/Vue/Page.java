package Vue;

import Modele.ListPanel;

import javax.swing.*;
import java.awt.*;

public class Page extends JFrame {
    private static final long serialVersionUID = -4939554401128745304L;
    int x;
    int y;
    JPanel panel;
    JPanel buffer2;
    JFrame frame;
    JPanel buffer,bufferText;
    ListPanel pan;
    JList<String>nameList;

    public Page(JList<String> nameList){
        super("My first Swing application!");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900, 800);
        this.setLocationRelativeTo(null);
        panel=(JPanel) this.getContentPane();
        buffer=new JPanel();
        buffer2=new JPanel();
         nameList = new JList<>();
         pan = new ListPanel();
         bufferText=new JPanel();

        bufferText.setPreferredSize(new Dimension(350, 100));
         pan.setPreferredSize(new Dimension(350, 400));




        ////  panel2=new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //// frame.getContentPane().setBackground(Color.BLUE);
        ////buffer=new JPanel();
        //// frame.add(buffer);

        //// panel.setLayout(new BorderLayout());
        ///// panel2.setLayout(new BorderLayout());
        ////buffer.setLayout(new BorderLayout());

// Créer un panel sans marge interne
        ////panel.setBorder(BorderFactory.createEmptyBorder());
        buffer2.setLayout(new GridLayout(2, 2));

        ////frame.add(buffer2);





    }
    public JList<String > getList(){return nameList;}
    public ListPanel getListPanel(){return pan;}
    public JPanel getPanel(){
        return panel;
    }
    public JPanel getbuffer(){
        return buffer2;
    }
    public void ajouterbouton(JButton bouton,int x,int y,int largeur,int hauteur){
        ////bouton.setBounds(1920 / 2 - largeur / 2, 80, largeur, hauteur);
        bouton.setPreferredSize(new Dimension(250, hauteur));
        bouton.setLocation(x,y);
        panel.add(bouton);
    }
    public void ajouterbarre(JTextField bouton, int x, int y, int largeur, int hauteur){
        bouton.setPreferredSize(new Dimension(largeur, hauteur));
        ////bouton.setBounds(x,y,largeur,hauteur);
        buffer2.add(bouton);  // Redessine le buffer
    }

    public void afficherImageURL(String nomimage,int coordonnex,int coordonney) {
        SwingUtilities.invokeLater(() -> {
            try {
                ImageIcon image = new ImageIcon(getClass().getResource(nomimage));
                Image image1=image.getImage();
                panel.revalidate();
                panel.repaint();
                Image newimg = image1.getScaledInstance(300,getHeight(),Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(newimg);
                JLabel label = new JLabel(resizedIcon);
                buffer.removeAll();
                // Définir explicitement la position et la taille
               /* label.setBounds(coordonnex, coordonney, 40, 40); // Ajuste selon les besoins
                label.setSize(10,10);
                L*/
                ////buffer.setBounds(0,60,40,40);

                buffer.add(label);
                panel.add(buffer,BorderLayout.EAST);
                buffer.revalidate();
                buffer.repaint();
                buffer.setVisible(true);


                //// frame.setLocationRelativeTo(null);

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(panel, "Impossible de charger l'image", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    public void ajouterResume(String resume) {
        SwingUtilities.invokeLater(() -> {
            JTextArea textArea = new JTextArea(resume);
            textArea.setLineWrap(true); // Active le retour à la ligne
            textArea.setWrapStyleWord(true); // Le retour à la ligne se fait entre les mots
            textArea.setEditable(false); // Rend le JTextArea non éditable
            textArea.setPreferredSize(new Dimension(1000, 80)); // Définit la taille préférée

            // Crée un JScrollPane pour gérer le défilement
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(1000, 80)); // Définit la taille préférée du JScrollPane
            scrollPane.setBorder(null); // Enlève la bordure pour garder l'apparence simple si désiré

            // Ajoute une bordure invisible pour créer une marge
            // Les valeurs dans EmptyBorder sont (top, left, bottom, right)
            scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // Ajoute une marge de 10 pixels au bas

            bufferText.removeAll();
            bufferText.add(scrollPane, BorderLayout.SOUTH); // Ajoute le JScrollPane au panel
            panel.add(bufferText, BorderLayout.SOUTH);
            panel.revalidate();
            panel.repaint();
        });
    }



    public void calculerPrix(String valeur, int nombreplce) {

    }
}
