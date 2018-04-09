package vue;

import control.ControlSIdentifier;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EcranAcceuil extends JFrame {


    private JLabel jLabel,labelAdmin;
    private JPanel panelPrincipal;

    public EcranAcceuil(){
        this.setTitle("Acceuil");
        this.setSize(new Dimension(920,700));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(920,700));
        initIHM();
    }

    private void initIHM() {

        getPanelPrincipal().add(getjLabel());
        this.setContentPane(getPanelPrincipal());
        this.setVisible(true);
    }

    /*
        Modifie l'ecran pour affichier le contenue réserver a l'administrateur
     */
    public void setAcceuilAdmin(){
        getPanelPrincipal().removeAll();
        getPanelPrincipal().add(getLabelAdmin());
        getPanelPrincipal().repaint();
        this.setContentPane(getPanelPrincipal());
    }

    public JPanel getPanelPrincipal() {
        if(panelPrincipal == null){
           panelPrincipal = new JPanel(new FlowLayout());
        }
        return panelPrincipal;
    }

    /*
        Getter en lazy loading
        ( optimisation de la memoire , on instancie les classe que si on en a besion )
        ajout du listener sur le button
     */
    public JLabel getjLabel() {
      if(jLabel == null){
          BufferedImage image = null;
          try {
              image = ImageIO.read(new File("D:\\Téléchargements\\Img\\Kappa.png"));
              jLabel = new JLabel(new ImageIcon(image));

              jLabel.addMouseListener(new MouseListener() {
                  @Override
                  public void mouseClicked(MouseEvent e) {
                      ControlSIdentifier.getInstance().showEcranConnexionAdmin();
                  }

                  @Override
                  public void mousePressed(MouseEvent e) {

                  }

                  @Override
                  public void mouseReleased(MouseEvent e) {

                  }

                  @Override
                  public void mouseEntered(MouseEvent e) {

                  }

                  @Override
                  public void mouseExited(MouseEvent e) {

                  }
              });

          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      return jLabel;
    }

    public JLabel getLabelAdmin() {
        if(labelAdmin == null){
            labelAdmin = new JLabel("Ecran de l'admin ");
        }
        return labelAdmin;
    }
}
