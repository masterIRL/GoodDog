package vuegraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import autre.ImageJLabel;
import control.ControlModeGestion;
import control.ControlRecherche;
import control.ControlSIdentifier;
import control.ControlVerifierIdentification;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	ControlRecherche controlRecherche = new ControlRecherche();
	ControlSIdentifier controlSIdentifier = new ControlSIdentifier();
	ControlVerifierIdentification controlVerifier = new ControlVerifierIdentification();
	ControlModeGestion controlModeGestion = new ControlModeGestion();
	FrameAide aide= new FrameAide(); 
	
	private JPanel panAccueil = new JPanel();
	private JPanel panContents = new JPanel();
	private PanUser panUser;
	private PanAdmin panAdmin;
	private CardLayout cartes = new CardLayout();

	
	@SuppressWarnings("static-access")
	public FramePrincipal(int l1, int l2) {
		this.setTitle("GooDog");  //Définit un titre
		this.setSize(l1, l2); //Définit sa taille //modifié pour garder format 16:9
		this.setLocationRelativeTo(null); //Positionne au centre la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus lorsqu'on clique sur la croix rouge
		
		this.panUser = new PanUser(this,controlRecherche,controlSIdentifier,aide);
		this.panAdmin = new PanAdmin(this,controlRecherche,controlSIdentifier,controlVerifier,controlModeGestion,aide);
		this.panUser.initialisation();
		this.panAdmin.initialisation();
		this.panContents.setLayout(cartes); //ajoute à panContents le Layout de cartes
		this.panContents.add(this.panUser,"USER");
		this.panContents.add(this.panAdmin,"ADMIN");
		
		this.pack();
		this.setExtendedState(this.MAXIMIZED_BOTH);
		
		this.initialisationAcceuil();
		this.getContentPane().add(panContents);

		this.setVisible(true);
	}

	
	private void initialisationAcceuil(){
		
		  ImageJLabel labelAcceuil = new ImageJLabel("RESSOURCE/IMAGE/acceuil.png"); //Cree un label avec l'image
		  this.panAccueil.add(labelAcceuil);
		  this.panAccueil.setBackground(Color.WHITE);
		  labelAcceuil.addMouseListener(new MouseListener() {
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
		if(controlVerifier.verifierIdentification()) {
			this.cartes.show(panContents, "ADMIN");
		}
		this.repaint();
	}
	
	public void showPanAcceuil() {
		this.cartes.show(panContents, "ACCEUIL");
		this.repaint();
	}

	public JPanel getPanContents() {
		return panContents;
	}

	public CardLayout getCartes() {
		return cartes;
	}
	
	
	
}
