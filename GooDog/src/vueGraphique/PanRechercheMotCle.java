package vueGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ControlRecherche;

public class PanRechercheMotCle extends JPanel   {

	private static final long serialVersionUID = 7436674426036347114L;
	ControlRecherche controlRecherche;
	Font policeTitre = new Font("Calibri", Font.BOLD,24);
	Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE,16);
	Box boxMiseEnPageMotCle = Box.createVerticalBox();
	Box boxLogo = Box.createHorizontalBox();
	Box boxMotCle = Box.createHorizontalBox();
	Box boxBoutons = Box.createHorizontalBox();

	JButton validerRecherche = new JButton();
	Box boxMiseEnPageResultats = Box.createVerticalBox();

	private TextArea textAreaMotCle = new TextArea();
	
	public PanRechercheMotCle (ControlRecherche controlRecherche) {
		this.controlRecherche = controlRecherche;
	}

	public void initialisation() throws IOException {
		setBackground(Color.WHITE);
		BufferedImage logo = ImageIO.read(new File("LOGO.png"));
		JLabel logoLabel = new JLabel(new ImageIcon(logo));
		boxLogo.add(logoLabel);
		boxMiseEnPageMotCle.add(boxLogo);
		
		textAreaMotCle.setMaximumSize(new Dimension(800, 30));
		boxMotCle.add(textAreaMotCle);
		
		JButton validerMotCle = new JButton();
		validerMotCle.setText("Rechercher");
		validerMotCle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String entreeMotCle = (textAreaMotCle.getText());
				if (controlRecherche.verifierMotCle(entreeMotCle)) {
					controlRecherche.rechercheMotCle(entreeMotCle, 1);
				} else {
					System.out.println("Non valide");
				}
			}
		});
		boxMotCle.add(validerMotCle);
		boxMiseEnPageMotCle.add(boxMotCle);
		this.add(boxMiseEnPageMotCle);
		
	}


	
	public void rechercheMotCle() {
		this.setVisible(true); 
		this.repaint(); 
	  } 
		
		

}
