package vuegraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import autre.ImageJLabel;
import autre.Utilities;
import control.ControlRecherche;
import control.ControlSIdentifier;

public class PanUser extends JPanel {

	private static final long serialVersionUID = 1L;
	ControlRecherche controlRecherche;
	ControlSIdentifier controlSIdentifier;
	Utilities utilities = new Utilities() ;
	FrameAide aide;
	
	private FramePrincipal framePrincipal;
	
	Font policeTitre = new Font("Calibri", Font.BOLD,24);
	Font policeEntreeU = new Font("Poppins-Black", Font.PLAIN,20);
	Box boxMiseEnPageMotCleFinal= Box.createHorizontalBox();
	Box boxMiseEnPageMotCle = Box.createVerticalBox();
	Box boxLogo = Box.createHorizontalBox();
	Box boxMotCle = Box.createHorizontalBox();
	Box boxvaliderMotCle = Box.createHorizontalBox();
	Box boxBoutons = Box.createHorizontalBox();
	Box boxMiseEnPageResultat = Box.createHorizontalBox();
	Box boxListeResultats = Box.createVerticalBox();
	Box boxRetour = Box.createVerticalBox();
	Box boxErreur = Box.createHorizontalBox();
	Box boxBoutonRechercher =  Box.createVerticalBox(); 
	Box boxAvancee = Box.createHorizontalBox();
	Box boxModeNormal= Box.createHorizontalBox();
	Box boxModeAvance= Box.createHorizontalBox();
	JButton avancee = new JButton();
	
	boolean modeAvance = false; 
			
	JButton validerRecherche = new JButton();
	JButton boutonRetour = new JButton();
	JButton boutonAide = new JButton("Aide");
	JButton boutonAcceuil = new JButton("Acceuil");

	private JTextArea textAreaMotCle = new JTextArea();
	
	private JSpinner spinnerOccurrences=new JSpinner(new SpinnerNumberModel(1, 1, 9, 1));
	
	private JPanel panTop = new JPanel();
	private JPanel panBas = new JPanel();
	private JPanel panTop2 = new JPanel();
	private JPanel panCenter = new JPanel();
	
	private ImageJLabel labelConnect = new ImageJLabel("RESSOURCE/IMAGE/LogoAdmin.png");
	private ImageJLabel logoLabel = new ImageJLabel("RESSOURCE/IMAGE/LOGO_seul.png"); 
	private ImageJLabel labelFile = new ImageJLabel("RESSOURCE/IMAGE/folder2.png");
	private ImageJLabel labelCouleur = new ImageJLabel("RESSOURCE/IMAGE/Couleur2.png");
	private ImageJLabel labelAudio = new ImageJLabel("RESSOURCE/IMAGE/Audio2.png");
	private ImageJLabel dog = new ImageJLabel("RESSOURCE/IMAGE/DOG copy.png");

	
	
	public PanUser(FramePrincipal framePrincipal, ControlRecherche controlRecherche, ControlSIdentifier controlSIdentifier, FrameAide aide) {
		super();
		this.framePrincipal = framePrincipal;
		this.controlRecherche=controlRecherche;
		this.controlSIdentifier=controlSIdentifier;
		this.aide=aide;
	}


	public void initialisation() {
		this.setBackground(Color.WHITE);
		this.panTop.setBackground(Color.WHITE);
		this.panTop2.setBackground(Color.WHITE);
		this.panBas.setBackground(new Color(137,146,153));
		this.panCenter.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		boutonAide.setBackground(new Color(137,146,153));
		boutonAide.setForeground(Color.WHITE); 
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
					aide.aideUserFrancais();
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
		boutonAcceuil.setForeground(Color.WHITE); 
		boutonAcceuil.setFocusPainted(false);
		boutonAcceuil.setFont(new Font("Tahoma", Font.BOLD, 12));
		boutonAcceuil.setBorderPainted(false);
		boutonAcceuil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boutonAcceuil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				framePrincipal.showPanAcceuil();
			}
		});
		
		this.panBas.setLayout(new BorderLayout()); //Configuration du panel haut de la frame
		this.panTop.setLayout(new BorderLayout());
		this.panTop2.setLayout(new BorderLayout());
		this.labelConnect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//à ajouter et mettre pour chaque label
		this.labelConnect.addMouseListener(new MouseListener() {//creation de l'interaction avec l'image de connexion admin
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			      new FrameConnexion(framePrincipal,controlSIdentifier);
				boxModeNormal.setVisible(true);
				boxAvancee.setVisible(false);
				modeAvance=false;
				spinnerOccurrences.setValue(1);
				avancee.setText("Avancée");
				boxModeAvance.setVisible(false);
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
		this.panTop.add(labelConnect,BorderLayout.WEST); // ajout de l'image au panel haut
		this.panBas.add(boutonAide,BorderLayout.EAST);
		this.panBas.add(boutonAcceuil,BorderLayout.WEST);
		this.add(panTop,BorderLayout.NORTH); //ajout du panel haut au panel utilisateur
		this.add(panBas,BorderLayout.SOUTH);
		initBoxMiseEnPageMotCle();
		this.boxMiseEnPageMotCleFinal.add(boxMiseEnPageMotCle);
		this.panCenter.add(boxMiseEnPageMotCleFinal,BorderLayout.CENTER );
		boxMiseEnPageMotCle.setVisible(true);
		this.add(panCenter,BorderLayout.CENTER);

	}



	private void initBoxMiseEnPageMotCle() { // configuration du panel central

		boxLogo.add(logoLabel);		
		boxMotCle.add(Box.createRigidArea(new Dimension(60,0)));
		
		JLabel texteNbOccurrences = new JLabel("Occurrences:");
		texteNbOccurrences.setFont(new Font("Tahoma", Font.BOLD, 18));
		spinnerOccurrences.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spinnerOccurrences.setPreferredSize(new Dimension(50,40));
		spinnerOccurrences.setMaximumSize(new Dimension(50,40));
		spinnerOccurrences.setMinimumSize(new Dimension(50,40));
		spinnerOccurrences.setEditor(new JSpinner.DefaultEditor(spinnerOccurrences));

		boxModeNormal.add(Box.createRigidArea(new Dimension(75,0)));
		boxAvancee.add(texteNbOccurrences);
		boxAvancee.add(Box.createRigidArea(new Dimension(5,0)));
		boxAvancee.add(spinnerOccurrences);
		boxAvancee.add(Box.createRigidArea(new Dimension(20,0)));
		
		boxMotCle.add(boxAvancee);
		boxMotCle.add(boxModeNormal);
		boxModeNormal.setVisible(true);
		boxAvancee.setVisible(false);
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
		validerMotCle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		validerMotCle.setPreferredSize(new Dimension(130,40));
		validerMotCle.setMaximumSize(new Dimension(130,40));
		validerMotCle.setMinimumSize(new Dimension(130,40));
		
		
		textAreaMotCle.addKeyListener(new KeyListener(){
		    @Override
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_ENTER){
		        	e.consume();
					textAreaMotCle.setFont(policeEntreeU);
					String entreeMotCle = (textAreaMotCle.getText());

					if (controlRecherche.verifierMotCle(entreeMotCle)) {

						initBoxMiseEnPageResultat("Résulats de votre recherche par mots-clés");
						resultatsTextes(controlRecherche.rechercheMotCle(entreeMotCle,(int) spinnerOccurrences.getValue()   ));
						System.out.println("Recherche lancée");				
						textAreaMotCle.setText("");
						boxModeNormal.setVisible(true);
						boxAvancee.setVisible(false);
						modeAvance=false;
						spinnerOccurrences.setValue(1);
						boxModeAvance.setVisible(false);
						avancee.setText("Avancée");
					} 
					else {
						System.out.println("Non valide");
						boxErreur.setVisible(true);
					}
		        }
		    }

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});

		
		validerMotCle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textAreaMotCle.setFont(policeEntreeU);
				String entreeMotCle = (textAreaMotCle.getText());

				if (controlRecherche.verifierMotCle(entreeMotCle)) {

					initBoxMiseEnPageResultat("Résulats de votre recherche par mots-clés");

					resultatsTextes(controlRecherche.rechercheMotCle(entreeMotCle,(int) spinnerOccurrences.getValue()   ));
					System.out.println("Recherche lancée");				
					textAreaMotCle.setText("");
					boxModeNormal.setVisible(true);
					boxAvancee.setVisible(false);
					modeAvance=false;
					spinnerOccurrences.setValue(1);
					boxModeAvance.setVisible(false);
					avancee.setText("Avancée");
				} 
				else {
					System.out.println("Non valide");
					boxErreur.setVisible(true);
				}
			}
		});
		boxBoutonRechercher.add(Box.createRigidArea(new Dimension(0,25)));
		boxBoutonRechercher.add(validerMotCle);
		
		avancee.setText("Avancée");

		avancee.setBackground(Color.WHITE);
		avancee.setForeground(Color.BLACK); 
		avancee.setFocusPainted(false);
		avancee.setFont(new Font("Tahoma", Font.ITALIC, 12));
		avancee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		avancee.setPreferredSize(new Dimension(130,20));
		avancee.setMaximumSize(new Dimension(130,20));
		avancee.setMinimumSize(new Dimension(130,20));
		
		
		avancee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!modeAvance) {
					boxModeNormal.setVisible(false);
					boxAvancee.setVisible(true);
					boxModeAvance.setVisible(true);
					modeAvance=true;
					avancee.setText("Simple");
					spinnerOccurrences.setValue(1);
				} else {
					boxModeNormal.setVisible(true);
					boxAvancee.setVisible(false);
					modeAvance=false;
					boxModeAvance.setVisible(false);
					spinnerOccurrences.setValue(1);
					avancee.setText("Avancée");
				}
			}
		});
		boxBoutonRechercher.add(Box.createRigidArea(new Dimension(0,5)));
		boxBoutonRechercher.add(avancee);
		
		boxvaliderMotCle.add(boxBoutonRechercher);
		boxMotCle.add(Box.createRigidArea(new Dimension(20,0)));
		boxMotCle.add(boxvaliderMotCle);
		boxModeAvance.add(Box.createRigidArea(new Dimension(122,0)));
		boxMotCle.add(boxModeAvance);
		boxModeAvance.setVisible(false);

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
		//Bouton + interraction
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
		JLabel texteResultat=new JLabel(s);
		texteResultat.setFont(new Font("Poppins-Black", Font.BOLD,35));
		texteResultat.setForeground(Color.WHITE);
		texteResultat.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		boxMiseEnPageResultat.add(dog);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(50,0)));

		
		boutonRetour.setForeground(Color.WHITE); 
		boutonRetour.setFocusPainted(false);
		boutonRetour.setFont(new Font("Tahoma", Font.BOLD, 12));
		boutonRetour.setText("Retour");
		boutonRetour.setBorderPainted(false);
		boutonRetour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boutonRetour.setPreferredSize(new Dimension(80,80));
		boutonRetour.setMaximumSize(new Dimension(80,80));
		boutonRetour.setMinimumSize(new Dimension(80,80));
		boutonRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boxMiseEnPageResultat.setVisible(false); 
				setBackground(Color.WHITE);
				panCenter.setBackground(Color.WHITE);
				remove(panTop2);
				panTop2.removeAll();
				add(panTop,BorderLayout.NORTH); //ajout du panel haut au panel utilisateur
				boxListeResultats.removeAll();
				boxMiseEnPageResultat.remove(boutonRetour);
				boxMiseEnPageMotCle.setVisible(true);
				boxMiseEnPageResultat.removeAll();
				boxModeNormal.setVisible(true);
				boxAvancee.setVisible(false);
				modeAvance=false;
				boxModeAvance.setVisible(false);
				avancee.setText("Avancée");
				repaint(); 
			}
		});
		
		panTop2.add(boutonRetour,BorderLayout.WEST);
		panTop2.add(texteResultat,BorderLayout.CENTER);
		panCenter.add(boxMiseEnPageResultat);
		boxMiseEnPageMotCle.setVisible(false); 
		boxMiseEnPageResultat.setVisible(true); 
		repaint(); 
	}


	public void resultatsTextes(List<String> liste) { //sera valable pour tous les textes, ajouter ouverture texte
		boutonRetour.setBackground(new Color(85,98,133));
		panTop2.setBackground((new Color(85,98,133)));
		panCenter.setBackground(new Color(222, 239, 255));
		if(liste.size() != 0) {
			if (!liste.isEmpty()) {
				for(int i=0; i<liste.size(); i++) {
					Box boxListe=Box.createHorizontalBox();
						String results = liste.get(i);
						JLabel listeResultat=new JLabel(results);
						listeResultat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						listeResultat.addMouseListener(new MouseListener() {
							@Override
							public void mouseReleased(MouseEvent e) {
							}
		
							@Override
							public void mousePressed(MouseEvent e) {
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
								listeResultat.setForeground(Color.BLACK);
							}
		
							@Override
							public void mouseEntered(MouseEvent e) {
								listeResultat.setForeground(Color.GRAY);
							}
		
							@Override
							public void mouseClicked(MouseEvent e) {
							}
						});
				
	
					ImageJLabel os = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
					listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,26));
					boxListe.add(os);
					boxListe.add(Box.createRigidArea(new Dimension(20,0)));
					boxListe.add(listeResultat);
					boxListe.add(Box.createRigidArea(new Dimension(20,0)));
					boxListe.add(Box.createVerticalStrut(0));
					boxListeResultats.add(boxListe);
					boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));
	
				}
			} else {	
				System.out.println("GHBHJ");
				Box boxListe=Box.createHorizontalBox();
				boxListe.add(new JLabel("Aucun résultat"));
				boxListeResultats.add(boxListe);
				boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));
			}
		
		
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(150,0)));
		}
	}

	public void resultatImages(List<String> liste) { //sera valable pour toutes les images , Ajouter ouverture image
		boutonRetour.setBackground(new Color(85,98,133));
		panTop2.setBackground((new Color(85,98,133)));
		panCenter.setBackground(new Color(222, 239, 255));
		if(liste.size() != 0) {
			for(int i=0; i<liste.size(); i++) {
				Box boxListe=Box.createHorizontalBox();
				String results = liste.get(i);
				JLabel listeResultat=new JLabel(results);
				listeResultat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				listeResultat.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
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
						listeResultat.setForeground(Color.BLACK);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						listeResultat.setForeground(Color.GRAY);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});

				ImageJLabel os = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
				listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,26));
				boxListe.add(os);
				boxListe.add(Box.createRigidArea(new Dimension(20,0)));
				boxListe.add(listeResultat);
				boxListe.add(Box.createRigidArea(new Dimension(20,0)));
				boxListe.add(Box.createVerticalStrut(0));
				boxListeResultats.add(boxListe);
				boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

			}
		}
		
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(200,0)));
	}

	public void resultatSons(List<String> liste) { //sera valable pour tous les sons , Ajouter ouverture son
		boutonRetour.setBackground(new Color(85,98,133));
		panTop2.setBackground((new Color(85,98,133)));
		panCenter.setBackground(new Color(222, 239, 255));
		if(liste.size() != 0) {
			for(int i=0; i<liste.size(); i++) {
				Box boxListe=Box.createHorizontalBox();
				String results = liste.get(i);
				JLabel listeResultat=new JLabel(results);
				listeResultat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				listeResultat.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
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
						listeResultat.setForeground(Color.BLACK);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						listeResultat.setForeground(Color.GRAY);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});

				ImageJLabel os = new ImageJLabel("RESSOURCE/IMAGE/OS.png");
				listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,26));
				boxListe.add(os);
				boxListe.add(Box.createRigidArea(new Dimension(20,0)));
				boxListe.add(listeResultat);
				boxListe.add(Box.createRigidArea(new Dimension(20,0)));
				boxListe.add(Box.createVerticalStrut(0));
				boxListeResultats.add(boxListe);
				boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

			}
		}
		
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageResultat.add(boxListeResultats);
		boxMiseEnPageResultat.add(Box.createRigidArea(new Dimension(200,0)));

	}
	
	private Box getError(String s) { //recupere un bouton d'erreur
		JLabel errorLabel = new JLabel(s);
		errorLabel.setForeground(Color.red);
		boxErreur.add(errorLabel);
		boxErreur.setVisible(false);
		return boxErreur;
	}
}
