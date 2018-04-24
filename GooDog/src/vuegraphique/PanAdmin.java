package vuegraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import autre.ImageJLabel;
import control.ControlModeGestion;
import control.ControlRecherche;
import control.ControlSIdentifier;
import control.ControlVerifierIdentification;

public class PanAdmin extends JPanel {

	private static final long serialVersionUID = 1L;
	ControlRecherche controlRecherche;
	ControlSIdentifier controlSIdentifier;
	ControlVerifierIdentification controlVerifier;
	ControlModeGestion controlModeGestion;
	FrameAide aide;

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
	private Box boxErreur = Box.createHorizontalBox();

	JButton validerRecherche = new JButton();
	JButton boutonRetour = new JButton();
	JButton boutonAide = new JButton("Aide");
	JButton boutonAcceuil = new JButton("Acceuil");
	private JTextArea textAreaMotCle = new JTextArea();
	
	private JSpinner spinnerOccurrences=new JSpinner(new SpinnerNumberModel(1, 1, 9, 1));
	
	private JPanel panTop = new JPanel();
	private JPanel panTop2 = new JPanel();
	private JPanel panCenter = new JPanel();
	private JPanel panBas = new JPanel();
	private ImageJLabel labelConnect = new ImageJLabel("RESSOURCE/IMAGE/LogoUser.png");
	private ImageJLabel labelReglage = new ImageJLabel("RESSOURCE/IMAGE/settings.png");  //modifié
	private ImageJLabel logoLabel = new ImageJLabel("RESSOURCE/IMAGE/LOGO_seul.png"); //modifié
	private ImageJLabel labelFile = new ImageJLabel("RESSOURCE/IMAGE/folder2.png");
	private ImageJLabel labelCouleur = new ImageJLabel("RESSOURCE/IMAGE/color-icon-12545.png");
	private ImageJLabel labelAudio = new ImageJLabel("RESSOURCE/IMAGE/music.png");
	private ImageJLabel dog = new ImageJLabel("RESSOURCE/IMAGE/DOG copy.png");

	
	
	public PanAdmin(FramePrincipal framePrincipal, ControlRecherche controlRecherche, ControlSIdentifier controlSIdentifier, ControlVerifierIdentification controlVerifier, ControlModeGestion controlModeGestion,	FrameAide aide
) {
		super();
		this.framePrincipal = framePrincipal;
		this.controlRecherche=controlRecherche;
		this.controlSIdentifier=controlSIdentifier;
		this.controlVerifier = controlVerifier;
		this.controlModeGestion=controlModeGestion;
		this.aide=aide;
	}


	public void initialisation() {
		this.setBackground(Color.WHITE);
		this.panTop.setBackground(Color.WHITE);
		this.panTop2.setBackground(Color.WHITE);
		this.panCenter.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.panBas.setBackground(new Color(137,146,153));
		this.setLayout(new BorderLayout());
		
		boutonAide.setBackground(new Color(137,146,153));
		boutonAide.setForeground(Color.WHITE); //new Color(59, 89, 182)
		boutonAide.setFocusPainted(false);
		boutonAide.setFont(new Font("Tahoma", Font.BOLD, 12));
		boutonAide.setBorderPainted(false);
		boutonAide.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.boutonAide.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					aide.aideAminFrancais();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {				
			}
			@Override
			public void mouseEntered(MouseEvent e) {				
			}
			@Override
			public void mouseClicked(MouseEvent e) {				
			}
		});
		
		boutonAcceuil.setBackground(new Color(137,146,153));
		boutonAcceuil.setForeground(Color.WHITE); //new Color(59, 89, 182)
		boutonAcceuil.setFocusPainted(false);
		boutonAcceuil.setFont(new Font("Tahoma", Font.BOLD, 12));
		boutonAcceuil.setBorderPainted(false);
		boutonAcceuil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boutonAcceuil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				framePrincipal.showPanAcceuil();
			}
		});
		
		this.panBas.setLayout(new BorderLayout()); //Configuration du panel haut de la frame
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
			      new FrameReglage(controlVerifier,controlModeGestion);
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
		
		this.panBas.add(boutonAide,BorderLayout.EAST);
		this.panBas.add(boutonAcceuil,BorderLayout.WEST);
		this.add(panTop,BorderLayout.NORTH); //ajout du panel haut au panel utilisateur
		this.add(panBas,BorderLayout.SOUTH);
		initBoxMiseEnPageMotCle();

		this.panCenter.add(boxMiseEnPageMotCle);
		boxMiseEnPageMotCle.setVisible(true);
		this.add(panCenter,BorderLayout.CENTER);

	}



	private void initBoxMiseEnPageMotCle() { // configuration du panel central

		boxLogo.add(logoLabel);
		//boxMiseEnPageMotCle.add(Box.createRigidArea(new Dimension(0,50)));
		
		boxMotCle.add(Box.createRigidArea(new Dimension(60,0)));
		
		JLabel texteNbOccurrences = new JLabel("Occurrences:");
		texteNbOccurrences.setFont(policeEntreeU);
		//texteNbOccurrences.setForeground(Color.WHITE);

		spinnerOccurrences.setPreferredSize(new Dimension(50,30));
		spinnerOccurrences.setEditor(new JSpinner.DefaultEditor(spinnerOccurrences));


		boxMotCle.add(texteNbOccurrences);
		boxMotCle.add(Box.createRigidArea(new Dimension(5,0)));
		boxMotCle.add(spinnerOccurrences);
		boxMotCle.add(Box.createRigidArea(new Dimension(20,0)));
		
		textAreaMotCle.setMaximumSize(new Dimension(700,30));
		boxMotCle.add(textAreaMotCle);
		textAreaMotCle.setFont(policeEntreeU);

		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textAreaMotCle.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textAreaMotCle.setPreferredSize(new Dimension(750,40));
		textAreaMotCle.setMaximumSize(new Dimension(750,40));
		textAreaMotCle.setMinimumSize(new Dimension(750,40));
		boxMotCle.add(textAreaMotCle);
		textAreaMotCle.setFont(policeEntreeU);

		JButton validerMotCle = new JButton();
		validerMotCle.setText("Rechercher");

		validerMotCle.setBackground(Color.WHITE);
		validerMotCle.setForeground(Color.BLACK); 
		validerMotCle.setFocusPainted(false);
		validerMotCle.setFont(new Font("Tahoma", Font.BOLD, 14));
		//validerMotCle.setBorderPainted(false);
		validerMotCle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		validerMotCle.setPreferredSize(new Dimension(130,40));
		validerMotCle.setMaximumSize(new Dimension(130,40));
		validerMotCle.setMinimumSize(new Dimension(130,40));
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
					boxErreur.setVisible(true);
					//ajouter une interraction pour le signaler 
				}
			}
		});
		boxvaliderMotCle.add(validerMotCle);
		boxMotCle.add(Box.createRigidArea(new Dimension(20,0)));
		boxMotCle.add(boxvaliderMotCle);

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
		//ajout du bouton + interaction
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
				labelFile.setIcon(folder11);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				labelFile.setIcon(folder22);
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
				labelCouleur.setIcon(couleur11);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				labelCouleur.setIcon(couleur22);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
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
		boxBoutons.add(labelAudio);
		this.labelAudio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		labelAudio.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new FrameAudio(PanAdmin.this, controlRecherche);
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
		
		boxMiseEnPageMotCle.add(boxLogo);
		boxMiseEnPageMotCle.add(Box.createRigidArea(new Dimension(0,35)));
		boxMiseEnPageMotCle.add(getError("Entrez des caractères correct"));
		boxMiseEnPageMotCle.add(Box.createRigidArea(new Dimension(0,15)));
		boxMiseEnPageMotCle.add(boxMotCle);
		boxMiseEnPageMotCle.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageMotCle.add(boxBoutons);
	}





	public void initBoxMiseEnPageResultat(String s) {
		this.remove(panTop);
		this.add(panTop2,BorderLayout.NORTH); //ajout du panel haut au panel utilisateur
		boxEnTete.add(Box.createRigidArea(new Dimension(0,60)));
		JLabel texteResultat=new JLabel(s);
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
		if(liste.size() != 0) {
			for(int i=0; i<liste.size(); i++) {
				Box boxListe=Box.createHorizontalBox();
				String results = liste.get(i);
				//System.out.println(results.length());
				JLabel listeResultat=new JLabel(results);
				listeResultat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				listeResultat.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						try {
							Desktop.getDesktop().open(new File("DATA/TEXTE/"+results));
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (NullPointerException e1) {
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						listeResultat.setForeground(Color.BLACK);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						listeResultat.setForeground(Color.GRAY);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});

				ImageJLabel os = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
				//ImageJLabel os2 = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
				listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,26));
				boxListe.add(os);
				boxListe.add(Box.createRigidArea(new Dimension(20,0)));
				boxListe.add(listeResultat);
				boxListe.add(Box.createRigidArea(new Dimension(20,0)));
				//boxListe.add(os2);
				boxListe.add(Box.createVerticalStrut(0));
				//boxListe.setBorder(BorderFactory.createEtchedBorder());
				boxListeResultats.add(boxListe);
				boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

			}
		}
		
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(150,0)));

		//boxRetour.add(boutonRetour);
		//boxMiseEnPageResultat.add(boxRetour);
	}

	public void resultatImages(List<String> liste) { //sera valable pour toutes les images , Ajouter ouverture image
		boutonRetour.setBackground(new Color(85,98,133));
		panTop2.setBackground((new Color(85,98,133)));
		panCenter.setBackground(new Color(222, 239, 255));
		if(liste.size() != 0) {
			for(int i=0; i<liste.size(); i++) {
				Box boxListe=Box.createHorizontalBox();
				String results = liste.get(i);
				//System.out.println(results.length());
				JLabel listeResultat=new JLabel(results);
				listeResultat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				listeResultat.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						try {
							Desktop.getDesktop().open(new File("DATA/IMAGE/RGB/"+results));
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (NullPointerException e1) {
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						listeResultat.setForeground(Color.BLACK);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						listeResultat.setForeground(Color.GRAY);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});

				ImageJLabel os = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
				//ImageJLabel os2 = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
				listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,26));
				boxListe.add(os);
				boxListe.add(Box.createRigidArea(new Dimension(20,0)));
				boxListe.add(listeResultat);
				boxListe.add(Box.createRigidArea(new Dimension(20,0)));
				//boxListe.add(os2);
				boxListe.add(Box.createVerticalStrut(0));
				//boxListe.setBorder(BorderFactory.createEtchedBorder());
				boxListeResultats.add(boxListe);
				boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

			}
		}
		
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(200,0)));

		//boxRetour.add(boutonRetour);
		//boxMiseEnPageResultat.add(boxRetour);
	}

	public void resultatSons(List<String> liste) { //sera valable pour tous les sons , Ajouter ouverture son
		boutonRetour.setBackground(new Color(85,98,133));
		panTop2.setBackground((new Color(85,98,133)));
		panCenter.setBackground(new Color(222, 239, 255));
		if(liste.size() != 0) {
			for(int i=0; i<liste.size(); i++) {
				Box boxListe=Box.createHorizontalBox();
				String results = liste.get(i);
				//System.out.println(results.length());
				JLabel listeResultat=new JLabel(results);
				listeResultat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				listeResultat.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						try {
							Desktop.getDesktop().open(new File("DATA/SON/"+results));
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (NullPointerException e1) {
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						listeResultat.setForeground(Color.BLACK);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						listeResultat.setForeground(Color.GRAY);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});

				ImageJLabel os = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
				//ImageJLabel os2 = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
				listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,26));
				boxListe.add(os);
				boxListe.add(Box.createRigidArea(new Dimension(20,0)));
				boxListe.add(listeResultat);
				boxListe.add(Box.createRigidArea(new Dimension(20,0)));
				//boxListe.add(os2);
				boxListe.add(Box.createVerticalStrut(0));
				//boxListe.setBorder(BorderFactory.createEtchedBorder());
				boxListeResultats.add(boxListe);
				boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

			}
		}
		
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(200,0)));

		//boxRetour.add(boutonRetour);
		//boxMiseEnPageResultat.add(boxRetour);
	}
	
	private Box getError(String s) { //recupere un bouton d'erreur
		JLabel errorLabel = new JLabel(s);
		errorLabel.setForeground(Color.red);
		boxErreur.add(errorLabel);
		boxErreur.setVisible(false);
		return boxErreur;
	}
}
