package vuegraphique;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameReglage extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panContents = new JPanel();
	//private JPanel panConfig;
	//private JPanel panIndexation;
	private PanReglage panReglage= new PanReglage();
	private CardLayout cartes = new CardLayout();


	public FrameReglage() {
        
		this.setTitle("R�glage");  //D�finit un titre
		this.setSize(800, 500); //D�finit sa taille 
		this.setLocationRelativeTo(null); //Positionne au centre la fenetre
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.panContents.setLayout(cartes); //ajoute � panContents le Layout de cartes
		this.panContents.add(panReglage,"REGLAGE");
		//this.panContents.add(panConfig);
		//this.panContents.add(panIndexation);
		this.panReglage.initialisation();
		this.panReglage.setVisible(true);
		this.getContentPane().add(panContents);
		this.cartes.show(panContents, "REGLAGE");
		this.setVisible(true);
		this.repaint();
		

		  
	}
	
	public void reglage(){
	      
	      
	}
}
