package vuegraphique;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	      
	      //BufferedImage myPicture = ImageIO.read(new File("RESSOURCE/IMAGE/MoteurGooDog.png")); //genere exception (charge une image)
	      //ImageIcon image = new ImageIcon(myPicture); //transforme l'image en icon utilisable
	      ImageIcon image = new ImageIcon("RESSOURCE/IMAGE/MoteurGooDog.png");
	      JLabel labelAcceuil = new JLabel(image, JLabel.CENTER);  //Cree un label avec l'image 
	      this.panAccueil.add(labelAcceuil);
	      
	      this.panAccueil.setVisible(true);
	      
	      this.panContents.add(panAccueil, "ACCEUIL");
	      this.cartes.show(panContents, "ACCEUIL");    

	}
	
	
	
}
