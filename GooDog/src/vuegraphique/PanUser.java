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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import autre.ImageJLabel;
import control.ControlRecherche;
import control.ControlSIdentifier;

public class PanUser extends JPanel {

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
	Box boxMiseEnPageResultat = Box.createHorizontalBox();
	Box boxListeResultats = Box.createVerticalBox();
	Box boxRetour = Box.createVerticalBox();
	Box boxEnTete = Box.createHorizontalBox();
			
	JButton validerRecherche = new JButton();
	JButton boutonRetour = new JButton();

	private TextArea textAreaMotCle = new TextArea();
	
	private JPanel panTop = new JPanel();
	private JPanel panTop2 = new JPanel();
	private JPanel panCenter = new JPanel();
	
	private ImageJLabel labelConnect = new ImageJLabel("RESSOURCE/IMAGE/LogoAdmin.png");
	private ImageJLabel logoLabel = new ImageJLabel("RESSOURCE/IMAGE/LOGO_seul.png"); 
	private ImageJLabel labelFile = new ImageJLabel("RESSOURCE/IMAGE/folder2.png");
	private ImageJLabel labelCouleur = new ImageJLabel("RESSOURCE/IMAGE/Couleur2.png");
	private ImageJLabel labelAudio = new ImageJLabel("RESSOURCE/IMAGE/Audio2.png");
	private ImageJLabel dog = new ImageJLabel("RESSOURCE/IMAGE/DOG copy.png");

	
	
	public PanUser(FramePrincipal framePrincipal, ControlRecherche controlRecherche, ControlSIdentifier controlSIdentifier) {
		super();
		this.framePrincipal = framePrincipal;
		this.controlRecherche=controlRecherche;
		this.controlSIdentifier=controlSIdentifier;
	}


	public void initialisation() {
		this.setBackground(Color.WHITE);
		this.panTop.setBackground(Color.WHITE);
		this.panTop2.setBackground(Color.WHITE);
		this.panCenter.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		this.panTop.setLayout(new BorderLayout()); //Configuration du panel haut de la frame
		this.panTop2.setLayout(new BorderLayout());
		this.labelConnect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		this.labelConnect.addMouseListener(new MouseListener() {//creation de l'interaction avec l'image de connexion admin
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			      new FrameConnexion(framePrincipal,controlSIdentifier);
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

					initBoxMiseEnPageResultat("Résulats de votre recherche par mots-clés");

					resultatsTextes(controlRecherche.rechercheMotCle(entreeMotCle, 1));
					System.out.println("Recherche lancée");				
					textAreaMotCle.setText("");
				} 
				else {
					System.out.println("Non valide");
					//ajouter une interraction pour le signaler !!
				}
			}
		});

		int espaceEntreBouton = 60;
		
		//ajout des images pour l'interaction avec la souris du label fichier 
		BufferedImage folder=null;
		try {
			folder = ImageIO.read(new File("RESSOURCE/IMAGE/Fichier2.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon folder11=new ImageIcon(folder);
		BufferedImage folder2=null;
		try {
			folder2 = ImageIO.read(new File("RESSOURCE/IMAGE/FichierClick.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		ImageIcon folder22=new ImageIcon(folder2);
		labelFile.setIcon(folder11);
		//Bouton + interaction
		boxBoutons.add(labelFile);
		this.labelFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		labelFile.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				new FrameFichier(PanUser.this, controlRecherche);
			}
            @Override
            public void mouseEntered(MouseEvent e) {
                labelFile.setIcon(folder22);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	labelFile.setIcon(folder11);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		boxBoutons.add(Box.createRigidArea(new Dimension(espaceEntreBouton,0)));

		//ajout des images pour l'interaction avec la souris du label couleur
		BufferedImage couleur=null;
		try {
			couleur = ImageIO.read(new File("RESSOURCE/IMAGE/Couleur2.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon couleur11=new ImageIcon(couleur);
		BufferedImage couleur2=null;
		try {
			couleur2 = ImageIO.read(new File("RESSOURCE/IMAGE/CouleurClick.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		ImageIcon couleur22=new ImageIcon(couleur2);
		labelCouleur.setIcon(couleur11);
		//Bouton + interaction
		boxBoutons.add(labelCouleur);
		this.labelCouleur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		labelCouleur.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new FrameCouleur(PanUser.this, controlRecherche);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labelCouleur.setIcon(couleur11);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				labelCouleur.setIcon(couleur22);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
		});
		boxBoutons.add(Box.createRigidArea(new Dimension(espaceEntreBouton,0)));

		//ajout des images pour l'interaction avec la souris du label audio
		BufferedImage audio=null;
		try {
			audio = ImageIO.read(new File("RESSOURCE/IMAGE/Audio2.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon audio11=new ImageIcon(audio);
		BufferedImage audio2=null;
		try {
			audio2 = ImageIO.read(new File("RESSOURCE/IMAGE/AudioClick.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		ImageIcon audio22=new ImageIcon(audio2);
		labelAudio.setIcon(audio11);
		//Bouton + interaction
		boxBoutons.add(labelAudio);
		this.labelAudio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		labelAudio.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new FrameAudio(PanUser.this, controlRecherche);
			}
            @Override
            public void mouseEntered(MouseEvent e) {
            	labelAudio.setIcon(audio22);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	labelAudio.setIcon(audio11);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		boxvaliderMotCle.add(validerMotCle);
		boxMotCle.add(Box.createRigidArea(new Dimension(20,0)));
		boxMotCle.add(boxvaliderMotCle);
		boxMiseEnPageMotCle.add(boxMotCle);
		boxMiseEnPageMotCle.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageMotCle.add(boxBoutons);
	}



	public void initBoxMiseEnPageResultat(String s) {
		this.remove(panTop);
		this.add(panTop2,BorderLayout.NORTH); //ajout du panel haut au panel utilisateur
		boxEnTete.add(Box.createRigidArea(new Dimension(0,60)));
		JLabel texteResultat=new JLabel("                                "+s);
		texteResultat.setFont(new Font("Poppins-Black", Font.BOLD,35));
		texteResultat.setForeground(Color.WHITE);
		boxEnTete.add(texteResultat);
		boxEnTete.add(Box.createRigidArea(new Dimension(0,100)));
		boxMiseEnPageResultat.add(dog);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(50,0)));

		
		boutonRetour.setForeground(Color.WHITE); //new Color(59, 89, 182)
		boutonRetour.setFocusPainted(false);
		boutonRetour.setFont(new Font("Tahoma", Font.BOLD, 12));
		boutonRetour.setText("Retour");
		boutonRetour.setBorderPainted(false);
		boutonRetour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boutonRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boxMiseEnPageResultat.setVisible(false); 
				setBackground(Color.WHITE);
				panCenter.setBackground(Color.WHITE);
				remove(panTop2);
				boxEnTete.removeAll();
				panTop2.remove(boxEnTete);
				panTop2.removeAll();
				add(panTop,BorderLayout.NORTH); //ajout du panel haut au panel utilisateur
				//panTop.setVisible(true);
				boxListeResultats.removeAll();
				boxMiseEnPageResultat.remove(boutonRetour);
				boxMiseEnPageMotCle.setVisible(true);
				boxMiseEnPageResultat.removeAll();
				repaint(); 
			}
		});
		
		panTop2.add(boutonRetour,BorderLayout.WEST);
		//panTop2.add(Box.createRigidArea(new Dimension(0,100)));
		panTop2.add(boxEnTete);
		panCenter.add(boxMiseEnPageResultat);
		boxMiseEnPageMotCle.setVisible(false); 
		//panTop.setVisible(false);
		


		boxMiseEnPageResultat.setVisible(true); 
		repaint(); 
	}


	public void resultatsTextes(List<String> liste) { //sera valable pour tous les textes, ajouter ouverture texte
		//panCenter.setBackground(new Color(157, 228, 234));
		boutonRetour.setBackground(new Color(85,98,133));
		panTop2.setBackground((new Color(85,98,133)));
		panCenter.setBackground(new Color(222, 239, 255));
		//setBackground(new Color(157, 228, 234));
		for(int i=0; i<liste.size(); i++) {
			Box boxListe=Box.createHorizontalBox();
			JLabel listeResultat=new JLabel(liste.get(i));
			ImageJLabel os = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
			//ImageJLabel os2 = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
			listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,26));
			boxListe.add(os);
			boxListe.add(Box.createRigidArea(new Dimension(20,0)));
			boxListe.add(listeResultat);
			boxListe.add(Box.createRigidArea(new Dimension(20,0)));
			//boxListe.add(os2);
			boxListeResultats.add(boxListe, BorderLayout.WEST);
			boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

		}
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(200,0)));

		//boxRetour.add(boutonRetour);
		//boxMiseEnPageResultat.add(boxRetour);
	}

	public void resultatImages(List<String> liste) { //sera valable pour toutes les images , Ajouter ouverture image
		boutonRetour.setBackground(new Color(85,98,133));
		panTop2.setBackground((new Color(85,98,133)));
		panCenter.setBackground(new Color(222, 239, 255));
		for(int i=0; i<liste.size(); i++) {
			Box boxListe=Box.createHorizontalBox();
			JLabel listeResultat=new JLabel(liste.get(i));
			ImageJLabel os = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
			//ImageJLabel os2 = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
			listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,26));
			boxListe.add(os);
			boxListe.add(Box.createRigidArea(new Dimension(20,0)));
			boxListe.add(listeResultat);
			boxListe.add(Box.createRigidArea(new Dimension(20,0)));
			//boxListe.add(os2);
			boxListeResultats.add(boxListe, BorderLayout.WEST);
			boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

		}
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(300,0)));

		//boxRetour.add(boutonRetour);
		//boxMiseEnPageResultat.add(boxRetour);
	}

	public void resultatSons(List<String> liste) { //sera valable pour tous les sons , Ajouter ouverture son
		boutonRetour.setBackground(new Color(85,98,133));
		panTop2.setBackground((new Color(85,98,133)));
		panCenter.setBackground(new Color(222, 239, 255));
		for(int i=0; i<liste.size(); i++) {
			Box boxListe=Box.createHorizontalBox();
			JLabel listeResultat=new JLabel(liste.get(i));
			ImageJLabel os = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
			//ImageJLabel os2 = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
			listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,26));
			boxListe.add(os);
			boxListe.add(Box.createRigidArea(new Dimension(20,0)));
			boxListe.add(listeResultat);
			boxListe.add(Box.createRigidArea(new Dimension(20,0)));
			//boxListe.add(os2);
			boxListeResultats.add(boxListe, BorderLayout.WEST);
			boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

		}
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(300,0)));

		//boxRetour.add(boutonRetour);
		//boxMiseEnPageResultat.add(boxRetour);
	}
}
