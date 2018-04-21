package vuegraphique;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vuetextuelle.Fichier;

public class PanConfig extends JPanel {
	
	private static final long serialVersionUID = 631353338464027426L;
	private FrameReglage frame;
	
	Box boxMiseEnPageConfig = Box.createVerticalBox();
	private JPanel panTop = new JPanel();
	private JPanel panCenter = new JPanel();
	Box boxConfigTexte= Box.createVerticalBox();
	Box boxConfigImage= Box.createVerticalBox();
	Box boxConfigSon= Box.createVerticalBox();
	
	JComboBox <String> comboBoxSon= new JComboBox<>();
	JComboBox <String> comboBoxSon2= new JComboBox<>();
	JComboBox <String> comboBoxImg= new JComboBox<>();


	
	JLabel boutonConfigTexte = new JLabel();
	JLabel boutonConfigImage = new JLabel();
	JLabel boutonConfigSon = new JLabel();
	
	int puissance;
	int intervalle;
	int quantification;
	String seuil; //ajouter par Stezen
	String nombreMot; //ajouter par Stezen
	String nombreLettre; //ajouter par Stezen
	
	Box boxConfigSon1 = Box.createHorizontalBox();
	Box boxConfigSon2 = Box.createHorizontalBox();
	Box boxTop = Box.createVerticalBox();
	Box boxTopImg = Box.createVerticalBox();
	Box boxTopSon = Box.createVerticalBox();
	Box boxTopTexte = Box.createVerticalBox();
	Box boxConfigTexte1 = Box.createHorizontalBox();//rajouter stezen
	Box boxConfigTexte2 = Box.createHorizontalBox();//rajouter stezen
	Box boxConfigTexte3 = Box.createHorizontalBox();//rajouter stezen



	
	Box boxConfigImg1 = Box.createHorizontalBox();
	Fichier fichier=new Fichier();
	
	JButton boutonRetour = new JButton();
	JButton boutonRetourSon = new JButton();
	JButton boutonRetourImg = new JButton();
	JButton boutonRetourTxt = new JButton();

	public PanConfig (FrameReglage frame) {
		super();
		this.frame = frame;
	}
	
	public void initialisation() {
		
		this.panTop.setBackground(new Color(75,91,157));
		this.panCenter.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.panTop.setLayout(new BorderLayout());
		
		boxTop.add(Box.createRigidArea(new Dimension(0,20)));
		JLabel texteTop=new JLabel("        CONFIGURATION DE L'INDEXATION"); //TROUVER UNE SOLUTION POUR AFFICHER LE TEXTE AU CENTRE
		texteTop.setFont(new Font("Poppins-Black", Font.BOLD,30));
		texteTop.setForeground(Color.WHITE);
		boxTop.add(texteTop);
		boxTop.add(Box.createRigidArea(new Dimension(0,20)));
		this.panTop.add(boxTop,BorderLayout.CENTER);
		
		boxTopImg.add(Box.createRigidArea(new Dimension(0,20)));
		JLabel texteTopImg=new JLabel("   CONFIGURATION DE L'INDEXATION IMAGE"); //TROUVER UNE SOLUTION POUR AFFICHER LE TEXTE AU CENTRE
		texteTopImg.setFont(new Font("Poppins-Black", Font.BOLD,30));
		texteTopImg.setForeground(Color.WHITE);
		boxTopImg.add(texteTopImg);
		boxTopImg.add(Box.createRigidArea(new Dimension(0,20)));

		
		boxTopSon.add(Box.createRigidArea(new Dimension(0,20)));
		JLabel texteTopSon=new JLabel("   CONFIGURATION DE L'INDEXATION SON"); //TROUVER UNE SOLUTION POUR AFFICHER LE TEXTE AU CENTRE
		texteTopSon.setFont(new Font("Poppins-Black", Font.BOLD,30));
		texteTopSon.setForeground(Color.WHITE);
		boxTopSon.add(texteTopSon);
		boxTopSon.add(Box.createRigidArea(new Dimension(0,20)));
		
		//debut de la partie rajout�e concernat le texte
		boxTopTexte.add(Box.createRigidArea(new Dimension(0,20)));
		JLabel texteTopTexte=new JLabel("   CONFIGURATION DE L'INDEXATION TEXTE"); //TROUVER UNE SOLUTION POUR AFFICHER LE TEXTE AU CENTRE
		texteTopTexte.setFont(new Font("Poppins-Black", Font.BOLD,30));
		texteTopTexte.setForeground(Color.WHITE);
		boxTopTexte.add(texteTopTexte);
		boxTopTexte.add(Box.createRigidArea(new Dimension(0,20)));
		//fin de la partie rajout�e concernat le texte
		
		boxMiseEnPageConfig.add(Box.createRigidArea(new Dimension(0,70)));
		
		initBoutonConfigTexte();
		initBoutonConfigImage();
		initBoutonConfigSon();
		boxMiseEnPageConfig.add(boutonConfigTexte);
		boxMiseEnPageConfig.add(Box.createRigidArea(new Dimension(0,25)));
		boxMiseEnPageConfig.add(boutonConfigImage);
		boxMiseEnPageConfig.add(Box.createRigidArea(new Dimension(0,25)));
		boxMiseEnPageConfig.add(boutonConfigSon);
		boxMiseEnPageConfig.add(Box.createRigidArea(new Dimension(0,25)));
		//boutonRetour.setText("   RETOUR   "); //Ajout du bouton retour
		
		
		boutonRetour.setBackground(new Color(75,91,157));
		boutonRetour.setForeground(Color.WHITE); //new Color(59, 89, 182)
		boutonRetour.setFocusPainted(false);
		boutonRetour.setFont(new Font("Tahoma", Font.BOLD, 12));
		boutonRetour.setText("Retour");
		boutonRetour.setBorderPainted(false);
		boutonRetour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boutonRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boxTop.removeAll();
				panCenter.removeAll();
				boxMiseEnPageConfig.removeAll();
				boxConfigImage.removeAll();
				boxConfigSon.removeAll();
				boxConfigTexte.removeAll();
				comboBoxSon2.removeAllItems();
				comboBoxSon.removeAllItems();
				comboBoxImg.removeAllItems();
			/*	comboBoxTexte1.removeAllItems();
				comboBoxTexte2.removeAllItems();
				comboBoxTexte3.removeAllItems();*/
				boxConfigImg1.removeAll();
				boutonConfigTexte.removeAll();
				boutonConfigImage.removeAll();
				boutonConfigSon.removeAll();
				boxConfigSon1.removeAll();
				boxConfigSon2.removeAll();
				boxConfigImg1.removeAll();				
				boutonRetour.removeAll();
				boutonConfigTexte.removeAll();
				boutonRetourSon.removeAll();
				boutonRetourImg.removeAll();
				boxConfigTexte.removeAll();
				boutonRetourTxt.removeAll();
				boxTopTexte.removeAll();
				boxTopImg.removeAll();
				boxTopSon.removeAll();
				boxTopTexte.removeAll();
				boxConfigTexte1.removeAll();
				boxConfigTexte2.removeAll();
				boxConfigTexte3.removeAll();
				boutonRetourTxt.removeAll();
				removeAll();
				frame.showReglage();
			}
		});
		panTop.add(boutonRetour,BorderLayout.WEST);

		initBoxConfigTexte();
		initBoxConfigImage();
		initBoxConfigSon();
		this.panCenter.add(boxMiseEnPageConfig,BorderLayout.CENTER);
		this.panCenter.add(boxConfigTexte,BorderLayout.CENTER);
		this.panCenter.add(boxConfigImage,BorderLayout.CENTER);
		this.panCenter.add(boxConfigSon,BorderLayout.CENTER);
		boxMiseEnPageConfig.setVisible(true);
		boxConfigTexte.setVisible(false);
		boxConfigImage.setVisible(false);
		boxConfigSon.setVisible(false);
		
		this.add(panTop,BorderLayout.NORTH);
		this.add(panCenter,BorderLayout.CENTER);
		this.panCenter.setVisible(true);

		
	}


	private void initBoxConfigSon() {	
		
		JLabel texteEchantillon=new JLabel("Nombre d'�chantillons par fen�tre:");
		texteEchantillon.setFont(new Font("Poppins-Black", Font.PLAIN,18));
		boxConfigSon.add(Box.createRigidArea(new Dimension(0,50)));
		boxConfigSon1.add(texteEchantillon);
		boxConfigSon1.add(Box.createRigidArea(new Dimension(10,0)));
		

		 
		 comboBoxSon.addItem("");
		 comboBoxSon.addItem("256");
		 comboBoxSon.addItem("512");
		 comboBoxSon.addItem("1024");
		 comboBoxSon.addItem("2048");
		 comboBoxSon.addItem("4096");
		 comboBoxSon.addItem("8192");
		comboBoxSon.setPreferredSize(new Dimension(90,30));
		//comboBoxSon.setMinimumSize(new Dimension(90,30));
		//comboBoxSon.setMaximumSize(new Dimension(90,30));
		 
		 comboBoxSon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				puissance = comboBoxSon.getSelectedIndex()+7;	
			}
		});
		 this.boxConfigSon1.add(comboBoxSon);
		 this.boxConfigSon.add(boxConfigSon1);
		 boxConfigSon.add(Box.createRigidArea(new Dimension(0,70)));
		 
		 
		JLabel texteIntervalle=new JLabel("Nombre d'intervalle par fen�tre:");
		texteIntervalle.setFont(new Font("Poppins-Black", Font.PLAIN,18));
		boxConfigSon2.add(texteIntervalle);
		boxConfigSon2.add(Box.createRigidArea(new Dimension(10,0)));
		
		
		 
		comboBoxSon2.addItem("");
		comboBoxSon2.addItem("10");
		comboBoxSon2.addItem("20");
		comboBoxSon2.addItem("30");
		comboBoxSon2.addItem("40");
		comboBoxSon2.addItem("50");
		comboBoxSon2.addItem("60");
		comboBoxSon2.setPreferredSize(new Dimension(90,30));
		//comboBoxSon2.setMinimumSize(new Dimension(90,30));
		//comboBoxSon2.setMaximumSize(new Dimension(90,30));
		comboBoxSon2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				intervalle = (comboBoxSon2.getSelectedIndex())*10;	
			}
		});
		 this.boxConfigSon2.add(comboBoxSon2);
		 this.boxConfigSon.add(boxConfigSon2);
		 boxConfigSon.add(Box.createRigidArea(new Dimension(0,70)));
		 
		JLabel boutonConfigSon = new JLabel();
		
		
		JLabel texteOKCONFIG=new JLabel("Configuration r�ussi");
		texteOKCONFIG.setFont(new Font("Poppins-Black", Font.ITALIC,16));
		
		
		
		BufferedImage configIndex=null;
		try {
			configIndex = ImageIO.read(new File("RESSOURCE/IMAGE/Appliquer.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIcon=new ImageIcon(configIndex);
		BufferedImage configIndexClick=null;
		try {
			configIndexClick = ImageIO.read(new File("RESSOURCE/IMAGE/AppliquerClick.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		
		BufferedImage configIndexClickClick=null;
		try {
			configIndexClickClick = ImageIO.read(new File("RESSOURCE/IMAGE/AppliquerClickClick.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIconClickClick=new ImageIcon(configIndexClickClick);
		
		ImageIcon configIndexIconClick=new ImageIcon(configIndexClick);
		boutonConfigSon.setIcon(configIndexIcon);
		boutonConfigSon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//� ajouter et mettre pour chaque label
		boutonConfigSon.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				boutonConfigSon.setIcon(configIndexIcon);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if ((puissance>7) && (intervalle>1)) {
					boutonConfigSon.setIcon(configIndexIconClickClick);
					fichier.effacer("DESCRIPTEURS/config_son.txt");
					fichier.ecrire(String.valueOf(Math.pow(2,puissance)),"DESCRIPTEURS/config_son.txt");
					fichier.ecrire(String.valueOf(intervalle),"DESCRIPTEURS/config_son.txt");
					boxConfigSon.add(texteOKCONFIG); 
					repaint();
				} else {
					System.out.println("Valeurs non valide");
				}
			}
            @Override
            public void mouseEntered(MouseEvent e) {
            	boutonConfigSon.setIcon(configIndexIconClick);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	boutonConfigSon.setIcon(configIndexIcon);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		
		boxConfigSon.add(boutonConfigSon);
		
		//BOUTON RETOUR Son//
		boutonRetourSon.setBackground(new Color(75,91,157));
		boutonRetourSon.setForeground(Color.WHITE); //new Color(59, 89, 182)
		boutonRetourSon.setFocusPainted(false);
		boutonRetourSon.setFont(new Font("Tahoma", Font.BOLD, 12));
		boutonRetourSon.setText("Retour"); 
		boutonRetourSon.setBorderPainted(false);
		boutonRetourSon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boutonRetourSon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panTop.remove(boxTopSon);
				panTop.add(boxTop,BorderLayout.CENTER);
				panTop.add(boutonRetour,BorderLayout.WEST);
				panTop.remove(boutonRetourSon);
				
				boxConfigSon.setVisible(false);
				boxMiseEnPageConfig.setVisible(true);
				repaint(); 
			}
		});
	}

	
	

	private void initBoxConfigImage() {
		boxConfigImage.add(Box.createRigidArea(new Dimension(0,50)));
		JLabel texteQuanti=new JLabel("Nombre de bits de quantification:");
		texteQuanti.setFont(new Font("Poppins-Black", Font.PLAIN,18));
		boxConfigImg1.add(texteQuanti);
		boxConfigImg1.add(Box.createRigidArea(new Dimension(10,0)));
		
		
		 
		comboBoxImg.addItem("");
		comboBoxImg.addItem("1");
		comboBoxImg.addItem("2");
		comboBoxImg.addItem("3");
		comboBoxImg.addItem("4");
		comboBoxImg.addItem("5");
		comboBoxImg.setPreferredSize(new Dimension(50,30));
		comboBoxImg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quantification = comboBoxImg.getSelectedIndex();	
			}
		});
		 this.boxConfigImg1.add(comboBoxImg);
		 this.boxConfigImage.add(boxConfigImg1);
		 boxConfigImage.add(Box.createRigidArea(new Dimension(0,70)));
		 
		
		 
		JLabel boutonConfigImage = new JLabel();
		
		
		JLabel texteOKCONFIG=new JLabel("Configuration r�ussi");
		texteOKCONFIG.setFont(new Font("Poppins-Black", Font.ITALIC,16));
		
		
		
		BufferedImage configIndex=null;
		try {
			configIndex = ImageIO.read(new File("RESSOURCE/IMAGE/Appliquer.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIcon=new ImageIcon(configIndex);
		BufferedImage configIndexClick=null;
		try {
			configIndexClick = ImageIO.read(new File("RESSOURCE/IMAGE/AppliquerClick.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIconClick=new ImageIcon(configIndexClick);

		BufferedImage configIndexClickClick=null;
		try {
			configIndexClickClick = ImageIO.read(new File("RESSOURCE/IMAGE/AppliquerClickClick.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIconClickClick=new ImageIcon(configIndexClickClick);
		boutonConfigImage.setIcon(configIndexIcon);
		boutonConfigImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//� ajouter et mettre pour chaque label
		boutonConfigImage.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				boutonConfigImage.setIcon(configIndexIcon);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				boutonConfigImage.setIcon(configIndexIconClickClick);
				if (quantification>0) {
					//fichier.effacer("DESCRIPTEURS/configTexte.txt"); tu t'es tromp� de fichier de cofig Charles
					fichier.effacer("DESCRIPTEURS/ImageConfig"); //ajouter par stezen
					//fichier.ecrire(String.valueOf(quantification),"DESCRIPTEURS/ImageConfig"); pareil que l�
					fichier.ecrire(String.valueOf(quantification),"DESCRIPTEURS/ImageConfig"); //j'ai modifier
					boxConfigImage.add(texteOKCONFIG); 
					repaint();
				} else {
					System.out.println("Valeur non valide");
				}
			}
            @Override
            public void mouseEntered(MouseEvent e) {
            	boutonConfigImage.setIcon(configIndexIconClick);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	boutonConfigImage.setIcon(configIndexIcon);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		boxConfigImage.add(boutonConfigImage);
		boxConfigImage.add(Box.createRigidArea(new Dimension(0,40)));

		//BOUTON RETOUR IMAGE//
		boutonRetourImg.setBackground(new Color(75,91,157));
		boutonRetourImg.setForeground(Color.WHITE); //new Color(59, 89, 182)
		boutonRetourImg.setFocusPainted(false);
		boutonRetourImg.setFont(new Font("Tahoma", Font.BOLD, 12));
		boutonRetourImg.setText("Retour"); 
		boutonRetourImg.setBorderPainted(false);
		boutonRetourImg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boutonRetourImg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panTop.remove(boxTopImg);
				panTop.add(boxTop,BorderLayout.CENTER);
				panTop.add(boutonRetour,BorderLayout.WEST);
				panTop.remove(boutonRetourImg);
				
				boxConfigImage.setVisible(false); 
				boxMiseEnPageConfig.setVisible(true);
				repaint(); 
			}
		});
		
		
	}


	private void initBoxConfigTexte() {
		JComboBox <String> comboBoxTexte= new JComboBox<>();//nouveau stezen
		JComboBox <String> comboBoxTexte2= new JComboBox<>();//nouveau stezen
		JComboBox <String> comboBoxTexte3= new JComboBox<>();//nouveau stezen
		// ce qui � �t� rajout�. debut stezen
		JLabel texteSeuil=new JLabel("Valeur du seuil :                  ");
		texteSeuil.setFont(new Font("Poppins-Black", Font.PLAIN,18));
		boxConfigTexte.add(Box.createRigidArea(new Dimension(0,50)));
		boxConfigTexte1.add(texteSeuil);
		boxConfigTexte1.add(Box.createRigidArea(new Dimension(10,0)));
		
		List<String> listeValeurLettre3 = new ArrayList<>();
		for(int i = 0; i<=100; i++) {
			listeValeurLettre3.add(""+i);
		}
		comboBoxTexte.addItem("");
		 for(String s : listeValeurLettre3) {
			 comboBoxTexte.addItem(s);
		 }
		 
		 comboBoxTexte.setPreferredSize(new Dimension(90,30));
		 
		 comboBoxTexte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seuil = listeValeurLettre3.get(comboBoxTexte.getSelectedIndex()-1);
				System.out.println("Seuil choisi : "+seuil);
			}
		});
		 this.boxConfigTexte1.add(comboBoxTexte);
		 this.boxConfigTexte.add(boxConfigTexte1);
		 boxConfigTexte.add(Box.createRigidArea(new Dimension(0,70)));
		JLabel texteNombreMot=new JLabel("Valeur du nombre de mots: ");
		texteNombreMot.setFont(new Font("Poppins-Black", Font.PLAIN,18));
			boxConfigTexte2.add(texteNombreMot);
			boxConfigTexte2.add(Box.createRigidArea(new Dimension(10,0)));
			
			List<String> listeValeurLettre2 = new ArrayList<>();
			listeValeurLettre2.add("3000"); 
			listeValeurLettre2.add("3001"); 
			listeValeurLettre2.add("3002"); 
			listeValeurLettre2.add("3003"); 
			listeValeurLettre2.add("3004"); 
			listeValeurLettre2.add("3005"); 

			comboBoxTexte2.addItem("");
			 for(String s : listeValeurLettre2) {
				 comboBoxTexte2.addItem(s);
			 }
			 
			 comboBoxTexte2.setPreferredSize(new Dimension(90,30));
			
			comboBoxTexte2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					nombreMot = listeValeurLettre2.get(comboBoxTexte2.getSelectedIndex()-1);
					System.out.println("nombre de mots choisi : "+nombreMot);
				}
			});
			 this.boxConfigTexte2.add(comboBoxTexte2);
			 this.boxConfigTexte.add(boxConfigTexte2);
			 boxConfigTexte.add(Box.createRigidArea(new Dimension(0,70)));
			 

				JLabel texteNombreLettre=new JLabel("Valeur du nombre de lettre:");
				texteNombreLettre.setFont(new Font("Poppins-Black", Font.PLAIN,18));
					boxConfigTexte3.add(texteNombreLettre);
					boxConfigTexte3.add(Box.createRigidArea(new Dimension(10,0)));
					
					List<String> listeValeurLettre = new ArrayList<>();
					listeValeurLettre.add("4000"); 
					listeValeurLettre.add("4001"); 
					listeValeurLettre.add("4002"); 
					listeValeurLettre.add("4003"); 
					listeValeurLettre.add("4004"); 
					listeValeurLettre.add("4005"); 

					comboBoxTexte3.addItem("");
					 for(String s : listeValeurLettre) {
						 comboBoxTexte3.addItem(s);
					 }
					comboBoxTexte3.setPreferredSize(new Dimension(90,30));
					
					comboBoxTexte3.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							nombreLettre = listeValeurLettre.get(comboBoxTexte3.getSelectedIndex()-1);
							System.out.println("nombre de lettre choisi : "+nombreLettre);
						}
					});
					 this.boxConfigTexte3.add(comboBoxTexte3);
					 this.boxConfigTexte.add(boxConfigTexte3);
					 boxConfigTexte.add(Box.createRigidArea(new Dimension(0,70)));
						
					 
				JLabel boutonConfigTexte = new JLabel();
						
						
					JLabel texteOKCONFIG=new JLabel("Configuration r�ussi");
					texteOKCONFIG.setFont(new Font("Poppins-Black", Font.ITALIC,16));
						
						
						
						BufferedImage configIndex=null;
						try {
							configIndex = ImageIO.read(new File("RESSOURCE/IMAGE/Appliquer.png"));
						} catch (IOException e1) {
							e1.printStackTrace();
						}		
						ImageIcon configIndexIcon=new ImageIcon(configIndex);
						BufferedImage configIndexClick=null;
						try {
							configIndexClick = ImageIO.read(new File("RESSOURCE/IMAGE/AppliquerClick.png"));
						} catch (IOException e1) {
							e1.printStackTrace();
						}		
						
						BufferedImage configIndexClickClick=null;
						try {
							configIndexClickClick = ImageIO.read(new File("RESSOURCE/IMAGE/AppliquerClickClick.png"));
						} catch (IOException e1) {
							e1.printStackTrace();
						}		
						ImageIcon configIndexIconClickClick=new ImageIcon(configIndexClickClick);
						
						ImageIcon configIndexIconClick=new ImageIcon(configIndexClick);
						boutonConfigTexte.setIcon(configIndexIcon);
						boutonConfigTexte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//� ajouter et mettre pour chaque label
						boutonConfigTexte.addMouseListener(new MouseListener() {
							@Override
							public void mouseReleased(MouseEvent e) {
								boutonConfigTexte.setIcon(configIndexIcon);
							}
							@Override
							public void mousePressed(MouseEvent e) {
									boutonConfigTexte.setIcon(configIndexIconClickClick);
									fichier.effacer("DESCRIPTEURS/configTexte.txt");
									fichier.ecrire(String.valueOf(seuil),"DESCRIPTEURS/configTexte.txt");
									fichier.ecrire(String.valueOf(nombreMot),"DESCRIPTEURS/configTexte.txt");
									fichier.ecrire(String.valueOf(nombreLettre),"DESCRIPTEURS/configTexte.txt");
									boxConfigTexte.add(texteOKCONFIG); 
									repaint();
							}
				            @Override
				            public void mouseEntered(MouseEvent e) {
				            	boutonConfigTexte.setIcon(configIndexIconClick);
				            }

				            @Override
				            public void mouseExited(MouseEvent e) {
				            	boutonConfigTexte.setIcon(configIndexIcon);
				            }
							@Override
							public void mouseClicked(MouseEvent e) {
							}
						});
						
						
						
						boxConfigTexte.add(boutonConfigTexte);
						
						//BOUTON RETOUR Texte//
						boutonRetourTxt.setBackground(new Color(75,91,157));
						boutonRetourTxt.setForeground(Color.WHITE); //new Color(59, 89, 182)
						boutonRetourTxt.setFont(new Font("Tahoma", Font.BOLD, 12));
						boutonRetourTxt.setText("Retour"); 
						boutonRetourTxt.setBorderPainted(false);
						boutonRetourTxt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						boutonRetourTxt.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								panTop.remove(boxTopTexte);
								panTop.add(boxTop,BorderLayout.CENTER);
								panTop.add(boutonRetour,BorderLayout.WEST);
								panTop.remove(boutonRetourTxt);
								
								boxConfigTexte.setVisible(false);
								boxMiseEnPageConfig.setVisible(true);
								repaint(); 
							}
						});				 
	
		
		
	}//fin ajout stezen 

	private void initBoutonConfigTexte() {
		BufferedImage configIndex=null;
		try {
			configIndex = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigTexte.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIcon=new ImageIcon(configIndex);
		BufferedImage configIndexClick=null;
		try {
			configIndexClick = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigIndexTexte.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIconClick=new ImageIcon(configIndexClick);
		boutonConfigTexte.setIcon(configIndexIcon);
		boutonConfigTexte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//� ajouter et mettre pour chaque label
		boutonConfigTexte.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panTop.remove(boxTop);
				panTop.remove(boutonRetour);
				panTop.add(boxTopTexte,BorderLayout.CENTER);
				panTop.add(boutonRetourTxt,BorderLayout.WEST);
				boxMiseEnPageConfig.setVisible(false); 
				boxConfigTexte.setVisible(true);
				repaint();
			}
            @Override
            public void mouseEntered(MouseEvent e) {
            	boutonConfigTexte.setIcon(configIndexIconClick);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	boutonConfigTexte.setIcon(configIndexIcon);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
	}
	
	private void initBoutonConfigImage() {
		BufferedImage configIndex=null;
		try {
			configIndex = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigImage.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIcon=new ImageIcon(configIndex);
		BufferedImage configIndexClick=null;
		try {
			configIndexClick = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigIndexImage.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIconClick=new ImageIcon(configIndexClick);
		boutonConfigImage.setIcon(configIndexIcon);
		boutonConfigImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//� ajouter et mettre pour chaque label
		boutonConfigImage.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panTop.remove(boxTop);
				panTop.remove(boutonRetour);
				panTop.add(boxTopImg,BorderLayout.CENTER);
				panTop.add(boutonRetourImg,BorderLayout.WEST);
				boxMiseEnPageConfig.setVisible(false); 
				boxConfigImage.setVisible(true);
				repaint();
			}
            @Override
            public void mouseEntered(MouseEvent e) {
            	boutonConfigImage.setIcon(configIndexIconClick);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	boutonConfigImage.setIcon(configIndexIcon);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
	}
	
	private void initBoutonConfigSon() {
		BufferedImage configIndex=null;
		try {
			configIndex = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigSon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIcon=new ImageIcon(configIndex);
		BufferedImage configIndexClick=null;
		try {
			configIndexClick = ImageIO.read(new File("RESSOURCE/IMAGE/ConfigIndexSon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		ImageIcon configIndexIconClick=new ImageIcon(configIndexClick);
		boutonConfigSon.setIcon(configIndexIcon);
		boutonConfigSon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//� ajouter et mettre pour chaque label
		boutonConfigSon.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panTop.remove(boxTop);
				panTop.remove(boutonRetour);
				panTop.add(boxTopSon,BorderLayout.CENTER);
				panTop.add(boutonRetourSon,BorderLayout.WEST);
				boxMiseEnPageConfig.setVisible(false); 
				boxConfigSon.setVisible(true);
				repaint();
			}
            @Override
            public void mouseEntered(MouseEvent e) {
            	boutonConfigSon.setIcon(configIndexIconClick);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	boutonConfigSon.setIcon(configIndexIcon);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		
	
		
	}
}
