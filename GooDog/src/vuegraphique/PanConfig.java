package vuegraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
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
	
	JButton boutonConfigTexte = new JButton();
	JButton boutonConfigImage = new JButton();
	JButton boutonConfigSon = new JButton();
	
	int puissance;
	int intervalle;
	int quantification;
	
	Box boxConfigSon1 = Box.createHorizontalBox();
	Box boxConfigSon2 = Box.createHorizontalBox();
	Box boxTop = Box.createVerticalBox();
	Box boxTopImg = Box.createVerticalBox();
	Box boxTopSon = Box.createVerticalBox();

	
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
		JLabel texteTop=new JLabel("                   CONFIGURATION DE L'INDEXATION"); //TROUVER UNE SOLUTION POUR AFFICHER LE TEXTE AU CENTRE
		texteTop.setFont(new Font("Poppins-Black", Font.BOLD,30));
		texteTop.setForeground(Color.WHITE);
		boxTop.add(texteTop);
		boxTop.add(Box.createRigidArea(new Dimension(0,20)));
		this.panTop.add(boxTop,BorderLayout.CENTER);
		

		boxMiseEnPageConfig.add(Box.createRigidArea(new Dimension(0,70)));
		
		initBoutonConfigTexte();
		initBoutonConfigImage();
		initBoutonConfigSon();
		boxMiseEnPageConfig.add(boutonConfigTexte);
		boxMiseEnPageConfig.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageConfig.add(boutonConfigImage);
		boxMiseEnPageConfig.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageConfig.add(boutonConfigSon);
		boxMiseEnPageConfig.add(Box.createRigidArea(new Dimension(0,50)));
		boutonRetour.setText("   RETOUR   "); //Ajout du bouton retour
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
				boxConfigImg1.removeAll();
				boutonConfigTexte.removeAll();
				boutonConfigImage.removeAll();
				boutonConfigSon.removeAll();
				boxConfigSon1.removeAll();
				boxConfigSon2.removeAll();
				boxConfigImg1.removeAll();				
				boutonRetour.removeAll();
				boutonRetourSon.removeAll();
				boutonRetourImg.removeAll();
				boutonRetourTxt.removeAll();
				boxTopImg.removeAll();
				boxTopSon.removeAll();
				removeAll();
				frame.showReglage();
			}
		});
		boxMiseEnPageConfig.add(boutonRetour);
		
		initBoxConfigTexte();
		initBoxConfigImage();
		initBoxConfigSon();
		this.panCenter.add(boxMiseEnPageConfig);
		this.panCenter.add(boxConfigTexte);
		this.panCenter.add(boxConfigImage);
		this.panCenter.add(boxConfigSon);
		boxMiseEnPageConfig.setVisible(true);
		boxConfigTexte.setVisible(false);
		boxConfigImage.setVisible(false);
		boxConfigSon.setVisible(false);
		
		this.add(panTop,BorderLayout.NORTH);
		this.add(panCenter,BorderLayout.CENTER);
		this.panCenter.setVisible(true);

		
	}


	private void initBoxConfigSon() {	
		
		JLabel texteEchantillon=new JLabel("Nombre d'échantillons par fenêtre:");
		texteEchantillon.setFont(new Font("Poppins-Black", Font.PLAIN,18));
		boxConfigSon1.add(texteEchantillon);
		boxConfigSon1.add(Box.createRigidArea(new Dimension(10,0)));
		

		 
		 comboBoxSon.addItem("");
		 comboBoxSon.addItem("256");
		 comboBoxSon.addItem("512");
		 comboBoxSon.addItem("1024");
		 comboBoxSon.addItem("2048");
		 comboBoxSon.addItem("4096");
		 comboBoxSon.addItem("8192");
		
		 
		 comboBoxSon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				puissance = comboBoxSon.getSelectedIndex()+7;	
			}
		});
		 this.boxConfigSon1.add(comboBoxSon);
		 this.boxConfigSon.add(boxConfigSon1);
		 boxConfigSon.add(Box.createRigidArea(new Dimension(0,70)));
		 
		 
		JLabel texteIntervalle=new JLabel("Nombre d'intervalle par fenêtre:");
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
		
		 
		comboBoxSon2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				intervalle = (comboBoxSon2.getSelectedIndex())*10;	
			}
		});
		 this.boxConfigSon2.add(comboBoxSon2);
		 this.boxConfigSon.add(boxConfigSon2);
		 boxConfigSon.add(Box.createRigidArea(new Dimension(0,70)));
		 
		JButton boutonConfigSon = new JButton();
		boutonConfigSon.setText("Configurer");
		
		
		JLabel texteOKCONFIG=new JLabel("Configuration réussi");
		texteOKCONFIG.setFont(new Font("Poppins-Black", Font.ITALIC,16));
		
		
		boutonConfigSon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((puissance>7) && (intervalle>1)) {
					fichier.effacer("DESCRIPTEURS/config_son.txt");
					fichier.ecrire(String.valueOf(Math.pow(2,puissance)),"DESCRIPTEURS/config_son.txt");
					fichier.ecrire(String.valueOf(intervalle),"DESCRIPTEURS/config_son.txt");
					boxConfigSon.add(texteOKCONFIG); 
					repaint();
				} else {
					System.out.println("Valeurs non valide");
				}
	
			}
		});
		boxConfigSon.add(boutonConfigSon);
		boxConfigSon.add(Box.createRigidArea(new Dimension(0,40)));
		
		boutonRetourSon.setText("   RETOUR   ");
		boutonRetourSon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boxTop.removeAll();
				boxTop.add(Box.createRigidArea(new Dimension(0,20)));
				JLabel texteTop=new JLabel("                   CONFIGURATION DE L'INDEXATION"); //TROUVER UNE SOLUTION POUR AFFICHER LE TEXTE AU CENTRE
				texteTop.setFont(new Font("Poppins-Black", Font.BOLD,30));
				texteTop.setForeground(Color.WHITE);
				boxTop.add(texteTop);
				boxTop.add(Box.createRigidArea(new Dimension(0,20)));
				boxTopSon.removeAll();
				panTop.removeAll();
				panTop.add(boxTop,BorderLayout.CENTER);
				
				
				boxConfigSon.remove(boutonRetourSon);
				boxConfigSon.remove(texteOKCONFIG);
				boxConfigSon.setVisible(false); 
				boxMiseEnPageConfig.setVisible(true);
				repaint(); 
			}
		});
		boxConfigSon.add(boutonRetourSon);
	}

	
	

	private void initBoxConfigImage() {
		
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

		comboBoxImg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quantification = comboBoxImg.getSelectedIndex();	
			}
		});
		 this.boxConfigImg1.add(comboBoxImg);
		 this.boxConfigImage.add(boxConfigImg1);
		 boxConfigImage.add(Box.createRigidArea(new Dimension(0,70)));
		 
		
		 
		JButton boutonConfigImage = new JButton();
		boutonConfigImage.setText("Configurer");
		
		
		JLabel texteOKCONFIG=new JLabel("Configuration rÃ©ussi");
		texteOKCONFIG.setFont(new Font("Poppins-Black", Font.ITALIC,16));
		
		
		boutonConfigImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (quantification>0) {
					fichier.effacer("DESCRIPTEURS/configTexte.txt");
					fichier.ecrire(String.valueOf(quantification),"DESCRIPTEURS/configTexte.txt");
					boxConfigImage.add(texteOKCONFIG); 
					repaint();
				} else {
					System.out.println("Valeur non valide");
				}
	
			}
		});
		boxConfigImage.add(boutonConfigImage);
		boxConfigImage.add(Box.createRigidArea(new Dimension(0,40)));
		boutonRetourImg.setText("   RETOUR   ");
		
		boutonRetourImg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boxTop.removeAll();
				boxTop.add(Box.createRigidArea(new Dimension(0,20)));
				JLabel texteTop=new JLabel("                   CONFIGURATION DE L'INDEXATION"); //TROUVER UNE SOLUTION POUR AFFICHER LE TEXTE AU CENTRE
				texteTop.setFont(new Font("Poppins-Black", Font.BOLD,30));
				texteTop.setForeground(Color.WHITE);
				boxTop.add(texteTop);
				boxTop.add(Box.createRigidArea(new Dimension(0,20)));
				boxTopImg.removeAll();
				panTop.removeAll();
				panTop.add(boxTop,BorderLayout.CENTER);
				
				boxConfigImage.remove(boutonRetourImg);
				boxConfigImage.remove(texteOKCONFIG);
				boxConfigImage.setVisible(false); 
				boxMiseEnPageConfig.setVisible(true);
				repaint(); 
			}
		});
		
		boxConfigImage.add(boutonRetourImg);
		
	}


	private void initBoxConfigTexte() {
		// A FINIR
		
	}


	private void initBoutonConfigTexte() {
		boutonConfigTexte.setText("TEXTE");
		boutonConfigTexte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//boxMiseEnPageConfig.setVisible(false); 
				//boxConfigTexte.setVisible(true);
				//repaint();

			}
		});
		
	}
	
	private void initBoutonConfigImage() {
		boutonConfigImage.setText("IMAGE");
		boutonConfigImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boxTopImg.removeAll();
				boxTopImg.add(Box.createRigidArea(new Dimension(0,20)));
				JLabel texteTopImg=new JLabel("           CONFIGURATION DE L'INDEXATION IMAGE"); //TROUVER UNE SOLUTION POUR AFFICHER LE TEXTE AU CENTRE
				texteTopImg.setFont(new Font("Poppins-Black", Font.BOLD,30));
				texteTopImg.setForeground(Color.WHITE);
				boxTopImg.add(texteTopImg);
				boxTopImg.add(Box.createRigidArea(new Dimension(0,20)));
				boxTop.removeAll();
				panTop.add(boxTopImg,BorderLayout.CENTER);
				
				boxMiseEnPageConfig.setVisible(false); 
				boxConfigImage.add(boutonRetourImg);
				boxConfigImage.setVisible(true);
				repaint();

			}
		});
		
	}
	
	private void initBoutonConfigSon() {
		boutonConfigSon.setText("SON");
		boutonConfigSon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boxTopSon.removeAll();
				boxTopSon.add(Box.createRigidArea(new Dimension(0,20)));
				JLabel texteTopImg=new JLabel("             CONFIGURATION DE L'INDEXATION SON"); //TROUVER UNE SOLUTION POUR AFFICHER LE TEXTE AU CENTRE
				texteTopImg.setFont(new Font("Poppins-Black", Font.BOLD,30));
				texteTopImg.setForeground(Color.WHITE);
				boxTopSon.add(texteTopImg);
				boxTopSon.add(Box.createRigidArea(new Dimension(0,20)));
				boxTop.removeAll();
				panTop.add(boxTopSon,BorderLayout.CENTER);
				
				boxMiseEnPageConfig.setVisible(false); 
				boxConfigSon.add(boutonRetourSon);
				boxConfigSon.setVisible(true);
				repaint();

			}
		});
		
	}
}
