package vuegraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import autre.ImageJLabel;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panAccueil = new JPanel();
	private JPanel panContents = new JPanel();
	private PanUser panUser = new PanUser();
	private PanAdmin panAdmin = new PanAdmin();
	
	private CardLayout cartes = new CardLayout();

	public FramePrincipal() {
		this.setTitle("GooDog");  //Définit un titre
		this.setSize(1300, 900); //Définit sa taille 
		this.setLocationRelativeTo(null); //Positionne au centre la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus lorsqu'on clique sur la croix rouge
		
		this.panUser.initialisation();
		this.panAdmin.initialisation();
		this.panContents.setLayout(cartes); //ajoute à panContents le Layout de cartes
		this.panContents.add(this.panUser,"USER");
		this.panContents.add(this.panAdmin,"ADMIN");
		
		this.getContentPane().add(panContents);
		this.initialisationAcceuil();

		this.setVisible(true);
	}
	
	private void initialisationAcceuil(){
	      this.panAccueil.setBackground(Color.WHITE);
			
	      ImageJLabel labelConnexion = new ImageJLabel("RESSOURCE/IMAGE/LogoAdmin.png");
//	      labelConnexion.setBounds(0, 0, 0, 0);
//	      labelConnexion.setLayout(null);
	      
	      ImageJLabel labelAcceuil = new ImageJLabel("RESSOURCE/IMAGE/MoteurGooDog.png"); //Cree un label avec l'image
	      
	      this.panAccueil.add(labelConnexion);
	      this.panAccueil.add(labelAcceuil);
//	      panAccueil.setLayout(null);
	      
	      labelConnexion.setLocation(0, 0);
	      
	      labelAcceuil.setLocation((int)JPanel.CENTER_ALIGNMENT, (int)JPanel.CENTER_ALIGNMENT);
	      this.panAccueil.setVisible(true);
	      
	      this.panContents.add(panAccueil, "ACCEUIL");
	      this.cartes.show(panContents, "ACCEUIL");    

	}
	
	
	
}
