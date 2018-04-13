package vueGraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import control.ControlRecherche;

public class FrameRechercheU extends JFrame {
	
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
	
	private JPanel panRechercheU = new JPanel();
	JPanel panContents=new JPanel();
	CardLayout cartes = new CardLayout();
	
	Box boxListeResultats = Box.createVerticalBox();
	//Box boxRetour = Box.createHorizontalBox();
	
	//REDIMENTSIONNER UNE IMAGE
	public static BufferedImage scale(BufferedImage bImage, double factor) {
        int destWidth=(int) (bImage.getWidth() * factor);
        int destHeight=(int) (bImage.getHeight() * factor);
        //créer l'image de destination
        GraphicsConfiguration configuration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        BufferedImage bImageNew = configuration.createCompatibleImage(destWidth, destHeight);
        Graphics2D graphics = bImageNew.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        //dessiner l'image de destination
        graphics.drawImage(bImage, 0, 0, destWidth, destHeight, 0, 0, bImage.getWidth(), bImage.getHeight(), null);
        graphics.dispose();
 
        return bImageNew;
    }
	
	
	
	
	public FrameRechercheU (ControlRecherche controlRecherche) {
		this.controlRecherche=controlRecherche;
		
		this.setSize(1200,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panContents.setLayout(cartes);
		panContents.add(panRechercheU, "RECHERCHE"); 
		this.getContentPane().add(panContents);
		
		this.panRechercheU.setBackground(Color.WHITE);
		
/*		BufferedImage imageConnect=null;
		try {
			imageConnect = ImageIO.read(new File("LogoAdmin.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		JLabel labelConnexion = new JLabel(new ImageIcon(imageConnect));
		labelConnexion.setLayout(null);
		labelConnexion.setBounds(0, 0, 0, 0);
		panRechercheU.add(labelConnexion); */
		
		BufferedImage logo1 = null;
		try {
			logo1 = ImageIO.read(new File("LOGO.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		
		BufferedImage logo=scale(logo1,0.5);
		JLabel logoLabel = new JLabel(new ImageIcon(logo));
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
					resultatsMotCles(controlRecherche.rechercheMotCle(entreeMotCle, 1));
					boxMiseEnPageMotCle.setVisible(false); 
					boxMiseEnPageMotCleResultat.setVisible(true); 
					panRechercheU.repaint(); 
					System.out.println("Recherche lancée");
				} else {
					System.out.println("Non valide");
				}
			}
		});
		
		BufferedImage logoFiles1 = null;
		try {
			logoFiles1 = ImageIO.read(new File("folder2.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		JLabel labelFile = new JLabel(new ImageIcon(logoFiles1));
		boxBoutons.add(labelFile);
		
		int espaceEntreBouton = 60;
		
		BufferedImage logoCouleu1= null;
		try {
			logoCouleu1 = ImageIO.read(new File("color-icon-12545.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		JLabel labelCouleur = new JLabel(new ImageIcon(logoCouleu1));
		boxBoutons.add(Box.createRigidArea(new Dimension(espaceEntreBouton,0)));
		boxBoutons.add(labelCouleur);
		
		BufferedImage logoAudio= null;
		try {
			logoAudio = ImageIO.read(new File("music.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		JLabel labelAudio = new JLabel(new ImageIcon(logoAudio));
		boxBoutons.add(Box.createRigidArea(new Dimension(espaceEntreBouton,0)));
		boxBoutons.add(labelAudio);
		//boxBoutons.add(Box.createRigidArea(new Dimension(100,0)));

		
		initBoxMiseEnPageMotCleResultat();
		
		boxvaliderMotCle.add(validerMotCle);
		boxMotCle.add(Box.createRigidArea(new Dimension(20,0)));
		boxMotCle.add(boxvaliderMotCle);
		boxMiseEnPageMotCle.add(boxMotCle);
		boxMiseEnPageMotCle.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageMotCle.add(boxBoutons);
		this.panRechercheU.add(boxMiseEnPageMotCle);
		this.panRechercheU.add(boxMiseEnPageMotCleResultat);
		boxMiseEnPageMotCle.setVisible(true);
		boxMiseEnPageMotCleResultat.setVisible(false);
		this.panRechercheU.setVisible(true);
		this.panContents.add(panRechercheU, "RECHERCHE");
		cartes.show(panContents, "RECHERCHE");  
		this.setVisible(true);		
	}




	private void initBoxMiseEnPageMotCleResultat() {
	
		boxMiseEnPageMotCleResultat.add(Box.createRigidArea(new Dimension(0,70)));
		JLabel texteResultat=new JLabel("Résultats de votre recherche par mots clés:");
		texteResultat.setFont(new Font("Poppins-Black", Font.BOLD,30));
		boxMiseEnPageMotCleResultat.add(texteResultat);
		boxMiseEnPageMotCleResultat.add(Box.createRigidArea(new Dimension(0,70)));
	
	}
	
	
	private void resultatsMotCles(List<String> liste) {
		panRechercheU.setBackground(new Color(220, 220, 255));
		for(int i=0; i<liste.size(); i++) {
			JLabel listeResultat=new JLabel("-  "+ liste.get(i));
			listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,20));
			boxListeResultats.add(listeResultat);
			boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

		}
		boxMiseEnPageMotCleResultat.add(boxListeResultats);

		JButton boutonRetour = new JButton();
		boutonRetour.setText("◄  RETOUR   ");
		boutonRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boxMiseEnPageMotCleResultat.setVisible(false); 
				panRechercheU.setBackground(Color.WHITE);
				boxListeResultats.removeAll();
				boxMiseEnPageMotCleResultat.remove(boutonRetour);
				boxMiseEnPageMotCle.setVisible(true); 
				panRechercheU.repaint(); 
			}
		});

		//boxRetour.add(boutonRetour);
		boxMiseEnPageMotCleResultat.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageMotCleResultat.add(boutonRetour);
	}
	
	
	
	
}
