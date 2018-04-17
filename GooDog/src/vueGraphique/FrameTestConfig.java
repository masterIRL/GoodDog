package vueGraphique;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import control.ControlRecherche;

public class FrameTestConfig extends JFrame {
	
	private static final long serialVersionUID = -6467763041527641676L;
	ControlRecherche controlRecherche;
	
	Font policeTitre = new Font("Calibri", Font.BOLD,24);
	Font policeEntreeU = new Font("Poppins-Black", Font.PLAIN,20);
	Box boxMiseEnPageMotCle = Box.createVerticalBox();
	Box boxLogo = Box.createHorizontalBox();
	Box boxMotCle = Box.createHorizontalBox();
	Box boxvaliderMotCle = Box.createHorizontalBox();
	Box boxBoutons = Box.createHorizontalBox();

	JButton validerRecherche = new JButton();
	Box boxMiseEnPageMotCleResultat = Box.createVerticalBox();
	
	private TextArea textAreaMotCle = new TextArea();
	
	private JPanel panRechercheA = new JPanel();
	private JPanel panTopRechercheA = new JPanel();
	private JPanel panFinalRechercheA = new JPanel();
	JPanel panContents=new JPanel();
	CardLayout cartes = new CardLayout();
	
	Box boxListeResultats = Box.createVerticalBox();
	Box boxRetour = Box.createVerticalBox();
	JButton boutonRetour = new JButton();
	
	PanConfig panConfig= new PanConfig() ;
	
	
	public FrameTestConfig (ControlRecherche controlRecherche) {
	
		this.controlRecherche=controlRecherche;
		
		this.setSize(1366,768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panContents.setLayout(cartes);
		panContents.add(panConfig, "CONFIG"); 

		this.getContentPane().add(panContents);
		this.panConfig.setBackground(Color.WHITE);

		this.panConfig.setVisible(true);
		//this.panContents.add(panFinalRechercheA, "RECHERCHE");
		
		cartes.show(panContents, "CONFIG");  
		this.setVisible(true);		
	}


	
	
	
}
