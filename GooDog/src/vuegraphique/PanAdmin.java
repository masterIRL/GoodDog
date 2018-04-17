package vuegraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import autre.ImageJLabel;
import control.ControlRecherche;
import control.ControlSIdentifier;

public class PanAdmin extends JPanel {

	private static final long serialVersionUID = 1L;
	ControlRecherche controlRecherche;
	ControlSIdentifier controlSIdentifier;
	
	private FramePrincipal framePrincipal;
	
	Font policeTitre = new Font("Calibri", Font.BOLD,24);
	Font policeEntreeU = new Font("Poppins-Black", Font.PLAIN,20);
	
	Box boxMiseEnPageMotCle = Box.createVerticalBox();
	Box boxLogo = Box.createHorizontalBox();
	Box boxMotCle = Box.createHorizontalBox();
	Box boxvaliderMotCle = Box.createHorizontalBox();
	Box boxBoutons = Box.createHorizontalBox();
	Box boxMiseEnPageResultat = Box.createVerticalBox();
	Box boxListeResultats = Box.createVerticalBox();
	Box boxRetour = Box.createVerticalBox();

	JButton validerRecherche = new JButton();
	JButton boutonRetour = new JButton();

	private TextArea textAreaMotCle = new TextArea();
	
	private JPanel panTop = new JPanel();
	private JPanel panCenter = new JPanel();
	
	private ImageJLabel labelConnect = new ImageJLabel("RESSOURCE/IMAGE/LogoUser.png");
	private ImageJLabel labelReglage = new ImageJLabel("RESSOURCE/IMAGE/settings.png");  //modifié
	private ImageJLabel logoLabel = new ImageJLabel("RESSOURCE/IMAGE/LOGO_seul.png"); //modifié
	private ImageJLabel labelFile = new ImageJLabel("RESSOURCE/IMAGE/folder2.png");
	private ImageJLabel labelCouleur = new ImageJLabel("RESSOURCE/IMAGE/color-icon-12545.png");
	private ImageJLabel labelAudio = new ImageJLabel("RESSOURCE/IMAGE/music.png");
	
	
	public PanAdmin(FramePrincipal framePrincipal, ControlRecherche controlRecherche, ControlSIdentifier controlSIdentifier) {
		super();
		this.framePrincipal = framePrincipal;
		this.controlRecherche=controlRecherche;
		this.controlSIdentifier=controlSIdentifier;
	}


	public void initialisation() {
		this.setBackground(Color.WHITE);
		this.panTop.setBackground(Color.WHITE);
		this.panCenter.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		this.panTop.setLayout(new BorderLayout()); //Configuration du panel haut de la frame
		this.labelConnect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		this.labelConnect.addMouseListener(new MouseListener() {//creation de l'interaction avec l'image de connexion admin
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(null, 
						"Voulez-vous vraiment vous déconnecter ?", 
						"Deconnexion", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);

				if(option == JOptionPane.OK_OPTION){
					framePrincipal.showPanUser(); //ajouter le control de deconnexion dans le controler et utiliser la fonction.	
				}
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
		this.panTop.add(labelConnect,BorderLayout.WEST); // ajout de l'image au panel haut
		
		this.labelReglage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		this.labelReglage.addMouseListener(new MouseListener() { //creation de l'interaction avec l'image de réglage
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			      new FrameReglage().reglage();
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
		this.panTop.add(labelReglage,BorderLayout.EAST); //ajout de l'image au panel haut
		
		this.add(panTop,BorderLayout.NORTH); //ajout du panel haut au panel utilisateur

		initBoxMiseEnPageMotCle();

		this.panCenter.add(boxMiseEnPageMotCle);
		boxMiseEnPageMotCle.setVisible(true);
		this.add(panCenter,BorderLayout.CENTER);

	}



	private void initBoxMiseEnPageMotCle() { // configuration du panel central

		boxLogo.add(logoLabel);
		boxMiseEnPageMotCle.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageMotCle.add(boxLogo);
		boxMiseEnPageMotCle.add(Box.createRigidArea(new Dimension(0,50)));
		boxMotCle.add(Box.createRigidArea(new Dimension(120,0)));
		textAreaMotCle.setMaximumSize(new Dimension(700,30));
		boxMotCle.add(textAreaMotCle);
		textAreaMotCle.setFont(policeEntreeU);

		JButton validerMotCle = new JButton();
		validerMotCle.setText("Rechercher");

		validerMotCle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textAreaMotCle.setFont(policeEntreeU);
				String entreeMotCle = (textAreaMotCle.getText());

				if (controlRecherche.verifierMotCle(entreeMotCle)) {

					initBoxMiseEnPageResultat("Recherche par mots Clés");

					resultatsTextes(controlRecherche.rechercheMotCle(entreeMotCle, 1));
					System.out.println("Recherche lancée");				
					textAreaMotCle.setText("");
				} 
				else {
					System.out.println("Non valide");
					//ajouter une interraction pour le signaler 
				}
			}
		});

		int espaceEntreBouton = 60;

		boxBoutons.add(labelFile);
		this.labelFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		labelFile.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				new FrameFichier(PanAdmin.this, controlRecherche);
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
			}
		});
		boxBoutons.add(Box.createRigidArea(new Dimension(espaceEntreBouton,0)));

		boxBoutons.add(labelCouleur);
		this.labelCouleur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		labelCouleur.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new FrameCouleur(PanAdmin.this, controlRecherche);
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
			}
		});
		boxBoutons.add(Box.createRigidArea(new Dimension(espaceEntreBouton,0)));

		boxBoutons.add(labelAudio);
		this.labelAudio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label

		boxvaliderMotCle.add(validerMotCle);
		boxMotCle.add(Box.createRigidArea(new Dimension(20,0)));
		boxMotCle.add(boxvaliderMotCle);
		boxMiseEnPageMotCle.add(boxMotCle);
		boxMiseEnPageMotCle.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageMotCle.add(boxBoutons);
	}



	public void initBoxMiseEnPageResultat(String s) {

		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(0,70)));
		JLabel texteResultat=new JLabel(s);
		texteResultat.setFont(new Font("Poppins-Black", Font.BOLD,30));
		boxMiseEnPageResultat.add(texteResultat);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(0,70)));

		boutonRetour.setText("   RETOUR   ");

		boutonRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boxMiseEnPageResultat.setVisible(false); 
				setBackground(Color.WHITE);
				panCenter.setBackground(Color.WHITE);
				panTop.setVisible(true);
				boxListeResultats.removeAll();
				boxMiseEnPageResultat.remove(boutonRetour);
				boxMiseEnPageMotCle.setVisible(true);
				boxMiseEnPageResultat.removeAll();
				repaint(); 
			}
		});
		panCenter.add(boxMiseEnPageResultat);
		boxMiseEnPageMotCle.setVisible(false); 
		panTop.setVisible(false);
		boxMiseEnPageResultat.setVisible(true); 
		repaint(); 
	}


	public void resultatsTextes(List<String> liste) { //sera valable pour tous les textes, ajouter ouverture texte
		panCenter.setBackground(new Color(220, 220, 255));
		setBackground(new Color(220, 220, 255));
		for(int i=0; i<liste.size(); i++) {
			JLabel listeResultat=new JLabel("-  "+ liste.get(i));
			listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,20));
			boxListeResultats.add(listeResultat);
			boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

		}
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);

		boxRetour.add(boutonRetour);
		boxMiseEnPageResultat.add(boxRetour);
	}

	public void resultatImages(List<String> liste) { //sera valable pour toutes les images , Ajouter ouverture image
		panCenter.setBackground(new Color(220, 220, 255));
		setBackground(new Color(220, 220, 255));
		for(int i=0; i<liste.size(); i++) {
			JLabel listeResultat=new JLabel("-  "+ liste.get(i));
			listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,20));
			boxListeResultats.add(listeResultat);
			boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

		}
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);

		boxRetour.add(boutonRetour);
		boxMiseEnPageResultat.add(boxRetour);
	}

	public void resultatSons(List<String> liste) { //sera valable pour tous les sons , Ajouter ouverture son
		panCenter.setBackground(new Color(220, 220, 255));
		setBackground(new Color(220, 220, 255));
		for(int i=0; i<liste.size(); i++) {
			JLabel listeResultat=new JLabel("-  "+ liste.get(i));
			listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,20));
			boxListeResultats.add(listeResultat);
			boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

		}
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);

		boxRetour.add(boutonRetour);
		boxMiseEnPageResultat.add(boxRetour);
	}
}
