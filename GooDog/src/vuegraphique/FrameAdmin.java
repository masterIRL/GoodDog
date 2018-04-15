package vuegraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameAdmin extends JFrame{

	public JPanel panContents=new JPanel();
	public JPanel panAccueil = new JPanel();
	private PanIndexer panIndexer=new PanIndexer();
	private JButton indexation=new JButton();
	public CardLayout cartes=new CardLayout();
	private Box boxIndexation=Box.createHorizontalBox();
	
	public FrameAdmin() throws IOException {
		this.setTitle("mode Admin");
		this.setSize(400, 400);
		this.panIndexer.initialisation();
		
		
		
		this.panContents.setLayout(cartes);
		
		this.panContents.add(panIndexer, "INDEXER");
		
		this.initialisationAcceuil();
		this.getContentPane().add(panContents);
		
		
		this .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	private void initialisationAcceuil(){

	      this.panAccueil.setBackground(Color.ORANGE);

	      JLabel texteAccueil = new JLabel("Bienvenu à Goodog");

	      texteAccueil.setFont(new Font("Calibri", Font.BOLD, 24));

	      this.panAccueil.add(texteAccueil);
	      
	      this.indexation.setText("INDEXATION");
	      indexation.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			
	    				cartes.show(panContents, "INDEXER");
	    			
	    		}
	    	});
	      
	      this.panAccueil.add(indexation);
	      
	      
	      
	      
	      this.panContents.add(panAccueil, "ECRAN_ACCUEIL");
	      cartes.show(panContents, "ECRAN_ACCUEIL");
	      
	     
	      this.panAccueil.setVisible(true);

	}

	private static final long serialVersionUID = 1L;

}
