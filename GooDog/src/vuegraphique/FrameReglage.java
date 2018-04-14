package vuegraphique;

import javax.swing.JFrame;

public class FrameReglage extends JFrame {

	private static final long serialVersionUID = 1L;

	public FrameReglage() {
		this.setTitle("Réglage");  //Définit un titre
		this.setSize(800, 500); //Définit sa taille 
		this.setLocationRelativeTo(null); //Positionne au centre la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus lorsqu'on clique sur la croix rouge
		
	}
}
