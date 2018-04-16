package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JToolTip;

public class PanRechercheAudio extends JPanel{

	
	
	private static final long serialVersionUID = 1L;
	private Box boxMiseEnPageAudio=Box.createVerticalBox();
	private Box boxNbOccurrences=Box.createHorizontalBox();
	private Box boxParcourir=Box.createHorizontalBox();
	private Box boxBareDeRecherche=Box.createHorizontalBox();
	private TextArea barederecherche=new TextArea("text", 3 , 40 , TextArea.SCROLLBARS_NONE);
	private JSpinner spinnerOccurrences=new JSpinner();
	private JButton buttonParcourir =new JButton();
	private JButton buttonRecherche =new JButton();
	
	
	public void initialisation() {
		this.setBackground(Color.WHITE);
		barederecherche.setMaximumSize(new Dimension(650,30));
		barederecherche.setBackground(Color.WHITE);
		JLabel texteEspace = new JLabel("   ");
		buttonRecherche.setText("Recherche");
	
		boxBareDeRecherche.add(barederecherche);
		boxBareDeRecherche.add(texteEspace);
		boxBareDeRecherche.add(buttonRecherche);
		
		buttonParcourir.setText("Parcourir");
		boxParcourir.add(buttonParcourir);
		
		
		JLabel texteNbOccurrences = new JLabel("Nombre d'occurrences :   ");
		spinnerOccurrences.setMaximumSize(new Dimension(30,30));
		boxNbOccurrences.add(texteNbOccurrences);
		boxNbOccurrences.add(spinnerOccurrences);
		
		
		
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageAudio.add(boxBareDeRecherche);
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageAudio.add(boxParcourir);
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageAudio.add(boxNbOccurrences);
		this.add(boxMiseEnPageAudio);
		
	}
	
	
	
	
	
	
	
}
