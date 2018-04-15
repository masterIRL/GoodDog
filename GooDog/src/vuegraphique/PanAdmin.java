package vuegraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import autre.ImageJLabel;
import control.ControlRecherche;
import control.ControlSIdentifier;
import control.ControlVerifierIdentification;

public class PanAdmin extends JPanel {

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
	Box boxMiseEnPageMotCleResultat = Box.createVerticalBox();
	Box boxListeResultats = Box.createVerticalBox();
	Box boxRetour = Box.createVerticalBox();

	JButton validerRecherche = new JButton();
	JButton boutonRetour = new JButton();

	private TextArea textAreaMotCle = new TextArea();
	
	private JPanel panTop = new JPanel();
	private JPanel panCenter = new JPanel();
	
	private ImageJLabel labelConnect = new ImageJLabel("RESSOURCE/IMAGE/LogoAdmin.png");
	private ImageJLabel labelReglage = new ImageJLabel("RESSOURCE/IMAGE/IconeReglage.png");
	private ImageJLabel logoLabel = new ImageJLabel("RESSOURCE/IMAGE/LOGO.png");
	private ImageJLabel labelFile = new ImageJLabel("RESSOURCE/IMAGE/folder2.png");
	private ImageJLabel labelCouleur = new ImageJLabel("RESSOURCE/IMAGE/color-icon-12545.png");
	private ImageJLabel labelAudio = new ImageJLabel("RESSOURCE/IMAGE/music.png");
	
	
	public PanAdmin(FramePrincipal framePrincipal, ControlRecherche controlRecherche, ControlSIdentifier controlSIdentifier) {
		super();
		this.framePrincipal = framePrincipal;
		this.controlRecherche=controlRecherche;
		this.controlSIdentifier=controlSIdentifier;
	}


	public void initialisation() {
		this.setBackground(Color.WHITE);
		this.panTop.setBackground(Color.WHITE);
		this.panCenter.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		this.panTop.setLayout(new BorderLayout()); //Configuration du panel haut de la frame
		this.labelConnect.addMouseListener(new MouseListener() {//creation de l'interaction avec l'image de connexion admin
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//ajouter module de déconnexion
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
		
		this.labelReglage.addMouseListener(new MouseListener() { //creation de l'interaction avec l'image de réglage
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			      new FrameReglage(new ControlVerifierIdentification()).reglage();
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
		
		this.add(panTop,BorderLayout.NORTH); //ajout du panel haut au panel utilisateur

		
		boxLogo.add(logoLabel); // configuration du panel central 
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
					panTop.setVisible(false);
					boxMiseEnPageMotCleResultat.setVisible(true); 
					repaint(); 
					System.out.println("Recherche lancée");
				} else {
					System.out.println("Non valide");
				}
				textAreaMotCle.setText("");
			}
		});
		
		int espaceEntreBouton = 60;

		boxBoutons.add(labelFile);
		boxBoutons.add(Box.createRigidArea(new Dimension(espaceEntreBouton,0)));
		boxBoutons.add(labelCouleur);
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
		
		
		
		this.panCenter.add(boxMiseEnPageMotCle);
		this.panCenter.add(boxMiseEnPageMotCleResultat);
		boxMiseEnPageMotCle.setVisible(true);
		boxMiseEnPageMotCleResultat.setVisible(false);
		this.add(panCenter,BorderLayout.CENTER);
	
	}



	private void initBoxMiseEnPageMotCleResultat() {
	
		boxMiseEnPageMotCleResultat.add(Box.createRigidArea(new Dimension(0,70)));
		JLabel texteResultat=new JLabel("Résultats de votre recherche par mots clés:");
		texteResultat.setFont(new Font("Poppins-Black", Font.BOLD,30));
		boxMiseEnPageMotCleResultat.add(texteResultat);
		boxMiseEnPageMotCleResultat.add(Box.createRigidArea(new Dimension(0,70)));
		
		boutonRetour.setText("   RETOUR   ");
		
		boutonRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boxMiseEnPageMotCleResultat.setVisible(false); 
				setBackground(Color.WHITE);
				panCenter.setBackground(Color.WHITE);
				panTop.setVisible(true);
				boxListeResultats.removeAll();
				boxMiseEnPageMotCleResultat.remove(boutonRetour);
				boxMiseEnPageMotCle.setVisible(true); 
				repaint(); 
			}
		});
	}
	
	
	private void resultatsMotCles(List<String> liste) {
		panCenter.setBackground(new Color(220, 220, 255));
		setBackground(new Color(220, 220, 255));
		for(int i=0; i<liste.size(); i++) {
			JLabel listeResultat=new JLabel("-  "+ liste.get(i));
			listeResultat.setFont(new Font("Poppins-Black", Font.PLAIN,20));
			boxListeResultats.add(listeResultat);
			boxListeResultats.add(Box.createRigidArea(new Dimension(0,20)));

		}
		boxListeResultats.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageMotCleResultat.add(boxListeResultats);

		boxRetour.add(boutonRetour);
		boxMiseEnPageMotCleResultat.add(boxRetour);
	}
	
	
		
}
