package vueGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


import vuetextuelle.Fichier;

public class PanConfig extends JPanel {
	
	private static final long serialVersionUID = 631353338464027426L;
	Box boxMiseEnPageConfig = Box.createVerticalBox();
	Box boxConfigTexte= Box.createVerticalBox();
	Box boxConfigImage= Box.createVerticalBox();
	Box boxConfigSon= Box.createVerticalBox();
	JButton boutonConfigTexte = new JButton();
	JButton boutonConfigImage = new JButton();
	JButton boutonConfigSon = new JButton();
	int puissance;
	int intervalle;
	int quantification;
	Box boxConfigSon1 = Box.createHorizontalBox();
	Box boxConfigSon2 = Box.createHorizontalBox();
	
	Box boxConfigImg1 = Box.createHorizontalBox();
	Fichier fichier=new Fichier();
	JButton boutonRetour = new JButton();
	JButton boutonRetourImg = new JButton();
	JButton boutonRetourTxt = new JButton();
	
	public PanConfig () {
		boxMiseEnPageConfig.add(Box.createRigidArea(new Dimension(0,70)));
		JLabel texteResultat=new JLabel("Configuration de l'indexation:");
		texteResultat.setFont(new Font("Poppins-Black", Font.BOLD,30));
		boxMiseEnPageConfig.add(texteResultat);
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
		
		initBoxConfigTexte();
		initBoxConfigImage();
		initBoxConfigSon();
		this.add(boxMiseEnPageConfig);
		this.add(boxConfigTexte);
		this.add(boxConfigImage);
		this.add(boxConfigSon);
		boxMiseEnPageConfig.setVisible(true);
		boxConfigTexte.setVisible(false);
		boxConfigImage.setVisible(false);
		boxConfigSon.setVisible(false);
		
	}


	private void initBoxConfigSon() {
		JLabel texteResultat=new JLabel("Configuration de l'indexation son:");
		texteResultat.setFont(new Font("Poppins-Black", Font.BOLD,25));
		boxConfigSon.add(texteResultat);
		boxConfigSon.add(Box.createRigidArea(new Dimension(0,70)));
		
		
		JLabel texteEchantillon=new JLabel("Nombre d'échantillons par fenêtre:");
		texteEchantillon.setFont(new Font("Poppins-Black", Font.PLAIN,18));
		boxConfigSon1.add(texteEchantillon);
		boxConfigSon1.add(Box.createRigidArea(new Dimension(10,0)));
		
		final JComboBox <String> comboBoxSon= new JComboBox<>();
		 
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
		
		final JComboBox <String> comboBoxSon2= new JComboBox<>();
		 
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
		boutonRetour.setText("◄  RETOUR   ");
		
		boutonRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boxConfigSon.remove(boutonRetour);
				boxConfigSon.remove(texteOKCONFIG);
				boxConfigSon.setVisible(false); 
				boxMiseEnPageConfig.setVisible(true);
				repaint(); 
			}
		});
		
		boxConfigSon.add(boutonRetour);
	}

	
	

	private void initBoxConfigImage() {
		JLabel texteResultat=new JLabel("Configuration de l'indexation image:");
		texteResultat.setFont(new Font("Poppins-Black", Font.BOLD,25));
		boxConfigImage.add(texteResultat);
		boxConfigImage.add(Box.createRigidArea(new Dimension(0,70)));
		
		
		JLabel texteQuanti=new JLabel("Nombre de bits de quantification:");
		texteQuanti.setFont(new Font("Poppins-Black", Font.PLAIN,18));
		boxConfigImg1.add(texteQuanti);
		boxConfigImg1.add(Box.createRigidArea(new Dimension(10,0)));
		
		final JComboBox <String> comboBoxImg= new JComboBox<>();
		 
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
		
		
		JLabel texteOKCONFIG=new JLabel("Configuration réussi");
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
		boutonRetourImg.setText("◄  RETOUR   ");
		
		boutonRetourImg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				boxMiseEnPageConfig.setVisible(false); 
				boxConfigSon.add(boutonRetour);
				boxConfigSon.setVisible(true);
				repaint();

			}
		});
		
	}
}
