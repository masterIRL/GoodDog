package vuegraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ControlVerifierIdentification;

public class FrameReglage extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panContents = new JPanel();
	private JPanel panReglage = new JPanel();
	private PanConfig panConfig;
	private PanIndexer panIndexation;
	
	private CardLayout cartes = new CardLayout();
	
	Box boxMiseEnPageReglage = Box.createVerticalBox();
	JButton boutonConfig = new JButton();
	JButton boutonIndexation = new JButton();
	JButton boutonMode = new JButton();


	public FrameReglage(ControlVerifierIdentification controlVerifier) {
		
		this.setTitle("Réglage");  //Définit un titre
		this.setSize(800, 500); //Définit sa taille 
		this.setLocationRelativeTo(null); //Positionne au centre la fenetre
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.panIndexation = new PanIndexer(this, controlVerifier);
        this.panConfig = new PanConfig(this);

        this.panContents.setLayout(cartes); //ajoute à panContents le Layout de cartes
		this.panContents.add(this.panIndexation,"INDEXER");
		this.panContents.add(this.panConfig,"CONFIG");
	
		this.initialisation(); //initialisation de la page de reglage
		this.getContentPane().add(panContents);
		this.setVisible(true);
	}
	
	
	private void initialisation() {
		this.panReglage.setBackground(Color.WHITE);

		boutonConfig.setText("CONFIGURATION DE L'INDEXATION");
		boutonConfig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panConfig.initialisation(); //initialisation de la page de configuration
				showConfig();
			}
		});

		boutonIndexation.setText("INDEXER");
		boutonIndexation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        panIndexation.initialisation(); //initialisation de la page d'indexation
				showIndexer();
			}
		});

		boutonMode.setText("Changer de mode");
		boutonMode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//activation de controlModeGestion
			}
		});

		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageReglage.add(boutonConfig);
		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageReglage.add(boutonIndexation);
		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageReglage.add(boutonMode);
		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,50)));

		boxMiseEnPageReglage.setVisible(true);
		this.panReglage.add(boxMiseEnPageReglage);
		
		this.panReglage.setVisible(true);
		this.panContents.add(panReglage,"REGLAGE");
		this.cartes.show(panContents, "REGLAGE");
	}
	
	
	public void showReglage() {
		this.cartes.show(panContents, "REGLAGE");
		repaint();
	}
	
	public void showIndexer() {
		this.cartes.show(panContents, "INDEXER");
		repaint();
	}
	
	public void showConfig() {
		this.cartes.show(panContents, "CONFIG");
		repaint();
	}
	
}
