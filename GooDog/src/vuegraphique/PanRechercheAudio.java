package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class PanRechercheAudio extends JPanel{

	
	
	private static final long serialVersionUID = 1L;
	private Box boxMiseEnPageAudio=Box.createVerticalBox();
	private Box boxNbOcurences=Box.createHorizontalBox();
	private Box boxParcourir=Box.createHorizontalBox();
	private Box boxBareDeRecherche=Box.createHorizontalBox();
	private TextArea barederecherche=new TextArea();
	private JSpinner spinnerOcurences=new JSpinner();
	private JButton buttonParcourir =new JButton();
	private JButton buttonRecherche =new JButton();
	
	public void initialisation() {
		this.setBackground(Color.WHITE);
		barederecherche.setMaximumSize(new Dimension(650,40));
		buttonRecherche.setText("Recherche");
	
		boxBareDeRecherche.add(barederecherche);
		boxBareDeRecherche.add(buttonRecherche);
		
		buttonParcourir.setText("Parcourir");
		
		
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageAudio.add(boxBareDeRecherche);
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,30)));
		this.add(boxMiseEnPageAudio);
		
	}
	
	
	
	
	
	
	
}
