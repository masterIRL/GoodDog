package vuegraphique;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import autre.ImageJLabel;
import control.ControlRecherche;
import control.ControlSIdentifier;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	ControlRecherche controlRecherche = new ControlRecherche();
	ControlSIdentifier controlSIdentifier = new ControlSIdentifier();
	
	private JPanel panAccueil = new JPanel();
	private JPanel panContents = new JPanel();
	private PanUser panUser;
	private PanAdmin panAdmin;
//	private ImageJLabel backgroundAcceuil = new ImageJLabel("RESSOURCE/IMAGE/acceuil_background.jpg"); //modifié
	private CardLayout cartes = new CardLayout();

//	private BufferedImage backgroundAcceuil1;
	
	public FramePrincipal() {
		this.setTitle("GooDog");  //Définit un titre
		this.setSize(1500, 843); //Définit sa taille //modifié pour garder format 16:9
		this.setLocationRelativeTo(null); //Positionne au centre la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus lorsqu'on clique sur la croix rouge
		
		this.panUser = new PanUser(this,controlRecherche,controlSIdentifier);
		this.panAdmin = new PanAdmin(this,controlRecherche,controlSIdentifier);
		this.panUser.initialisation();
		this.panAdmin.initialisation();
		this.panContents.setLayout(cartes); //ajoute à panContents le Layout de cartes
		this.panContents.add(this.panUser,"USER");
		this.panContents.add(this.panAdmin,"ADMIN");
		this.initialisationAcceuil();
		this.getContentPane().add(panContents);

		this.setVisible(true);
	}
	/*
		public void paint (Graphics g)
		{
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(backgroundAcceuil1, 0,0, null);
		}*/

	
	private void initialisationAcceuil(){
		 // this.panAccueil.setBackground();
		  //this.panAccueil(backgroundAcceuil.getImage());
			
	/*	this.setLayout(new BorderLayout());
		this.setContentPane(backgroundAcceuil);
		this.setLayout(new FlowLayout());*/
		/*
		try {
			backgroundAcceuil1 = ImageIO.read(new File("RESSOURCE/IMAGE/acceuil_background.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
*/
		
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
		      showPanUser();
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
	
	public void showPanUser() {
		this.cartes.show(panContents, "USER");
		this.repaint();
	}
	
	public void showPanAdmin() {
		this.cartes.show(panContents, "ADMIN");
		this.repaint();
	}

	public JPanel getPanContents() {
		return panContents;
	}

	public CardLayout getCartes() {
		return cartes;
	}
	
	
	
}
