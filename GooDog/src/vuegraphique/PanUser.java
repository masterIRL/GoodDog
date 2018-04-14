package vuegraphique;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import autre.ImageJLabel;

public class PanUser extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel panTop = new JPanel();
	private JPanel panCenter = new JPanel();
	
	private ImageJLabel labelConnect = new ImageJLabel("RESSOURCE/IMAGE/LogoAdmin.png");
	private ImageJLabel labelReglage = new ImageJLabel("RESSOURCE/IMAGE/IconeReglage.png");
	
	
	public PanUser() {
	}


	public void initialisation() {
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		this.panTop.setLayout(new BorderLayout());
		this.panTop.add(labelConnect,BorderLayout.WEST);
		this.panTop.add(labelReglage,BorderLayout.EAST);
		this.add(panTop,BorderLayout.NORTH);
		
		JLabel texte = new JLabel("module de Recherche");
		this.panCenter.add(texte);
		this.add(panCenter,BorderLayout.CENTER);
		
		
	}

}
