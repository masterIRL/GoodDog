package vuegraphique;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ControlVerifierIdentification;

public class FrameReglage extends JFrame {

	private static final long serialVersionUID = 1L;
    private ControlVerifierIdentification controler;
	
	private JPanel panContents = new JPanel();
	private JPanel panReglage = new JPanel();
	
	private CardLayout cartes = new CardLayout();


	public FrameReglage(ControlVerifierIdentification controler) {
        this.controler = controler;
        
		this.setTitle("Réglage");  //Définit un titre
		this.setSize(800, 500); //Définit sa taille 
		this.setLocationRelativeTo(null); //Positionne au centre la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus lorsqu'on clique sur la croix rouge
		
		this.panContents.setLayout(cartes); //ajoute à panContents le Layout de cartes

		this.getContentPane().add(panContents);
		this.setVisible(true);
	}
	
	public void reglage(){
	      this.panReglage.setBackground(Color.WHITE);
	      if(this.controler.verifierIdentification()) {
	    	  
	      }
	      
	}
}
