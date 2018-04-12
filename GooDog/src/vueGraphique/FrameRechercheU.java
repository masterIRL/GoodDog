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
	Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE,16);
	Box boxMiseEnPageMotCle = Box.createVerticalBox();
	Box boxLogo = Box.createHorizontalBox();
	Box boxMotCle = Box.createHorizontalBox();
	Box boxvaliderMotCle = Box.createHorizontalBox();
	Box boxBoutons = Box.createHorizontalBox();

	JButton validerRecherche = new JButton();
	Box boxMiseEnPageResultats = Box.createVerticalBox();
	private TextArea textAreaMotCle = new TextArea();
	
	private JPanel panRechercheU = new JPanel();
	JPanel panContents=new JPanel();
	CardLayout cartes = new CardLayout();
	
	
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
		BufferedImage logo1 = null;
		try {
			logo1 = ImageIO.read(new File("LOGO.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		BufferedImage logo=scale(logo1,0.5);
		JLabel logoLabel = new JLabel(new ImageIcon(logo));
		boxLogo.add(logoLabel);
		boxMiseEnPageMotCle.add(boxLogo);
		
		textAreaMotCle.setMaximumSize(new Dimension(800,30));
		boxMotCle.add(textAreaMotCle);
		
		JButton validerMotCle = new JButton();
		validerMotCle.setText("Rechercher");
		validerMotCle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String entreeMotCle = (textAreaMotCle.getText());
				if (controlRecherche.verifierMotCle(entreeMotCle)) {
					controlRecherche.rechercheMotCle(entreeMotCle, 1);
					System.out.println("Recherche lancée");
				} else {
					System.out.println("Non valide");
				}
			}
		});
		boxvaliderMotCle.add(validerMotCle);
		boxMotCle.add(Box.createRigidArea(new Dimension(0,40)));
		boxMotCle.add(boxvaliderMotCle);
		boxMiseEnPageMotCle.add(boxMotCle);
		this.panRechercheU.add(boxMiseEnPageMotCle);
		this.panRechercheU.setVisible(true);
		this.panContents.add(panRechercheU, "RECHERCHE");
		cartes.show(panContents, "RECHERCHE");  
		this.setVisible(true);		
	}
	
}
