package vuegraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import autre.ImageJLabel;
import control.ControlRecherche;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	ControlRecherche controlRecherche = new ControlRecherche();
	
	private JPanel panAccueil = new JPanel();
	private JPanel panContents = new JPanel();
	private PanUser panUser;
	private PanAdmin panAdmin;
	
	private CardLayout cartes = new CardLayout();

	public FramePrincipal() {
		this.setTitle("GooDog");  //Définit un titre
		this.setSize(1500, 1300); //Définit sa taille 
		this.setLocationRelativeTo(null); //Positionne au centre la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus lorsqu'on clique sur la croix rouge
		
		this.panUser = new PanUser(controlRecherche);
		this.panAdmin = new PanAdmin(controlRecherche);
		this.panUser.initialisation();
		this.panAdmin.initialisation();
		this.panContents.setLayout(cartes); //ajoute à panContents le Layout de cartes
		this.panContents.add(this.panUser,"USER");
		this.panContents.add(this.panAdmin,"ADMIN");
		
		this.initialisationAcceuil();
		this.getContentPane().add(panContents);

		this.setVisible(true);
	}
	
	private void initialisationAcceuil(){
	      this.panAccueil.setBackground(Color.WHITE);
			
	      ImageJLabel labelAcceuil = new ImageJLabel("RESSOURCE/IMAGE/MoteurGooDog.png"); //Cree un label avec l'image
	      this.panAccueil.add(labelAcceuil);
	      this.panAccueil.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			      cartes.show(panContents, "USER");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
	      this.panAccueil.setVisible(true);
	      
	      this.panContents.add(panAccueil, "ACCEUIL");
	      this.cartes.show(panContents, "ACCEUIL");

	}
	
	
	
}
