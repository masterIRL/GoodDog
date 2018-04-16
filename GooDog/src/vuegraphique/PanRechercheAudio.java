package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JToolTip;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class PanRechercheAudio extends JPanel{

	
	
	private static final long serialVersionUID = 1L;
	private Box boxMiseEnPageAudio=Box.createVerticalBox();
	private Box boxNbOccurrences=Box.createHorizontalBox();
	private Box boxParcourir=Box.createHorizontalBox();
	private Box boxBareDeRecherche=Box.createHorizontalBox();
	//private TextArea barederecherche=new TextArea("text", 3 , 40 , TextArea.SCROLLBARS_NONE);
	private JTextArea barederecherche=new JTextArea();
	private JSpinner spinnerOccurrences=new JSpinner(new SpinnerNumberModel(1, 1, 9, 1));
	private JButton buttonParcourir =new JButton();
	private JButton buttonRecherche =new JButton();
	
	
	public void initialisation() {
		this.setBackground(Color.WHITE);
		barederecherche.setMaximumSize(new Dimension(650,30));
		barederecherche.setMinimumSize(new Dimension(650,30));
		barederecherche.setBackground(Color.WHITE);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		barederecherche.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		barederecherche.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		JLabel texteEspace = new JLabel("   ");
		buttonRecherche.setText("Recherche");
	
		boxBareDeRecherche.add(barederecherche);
		boxBareDeRecherche.add(texteEspace);
		boxBareDeRecherche.add(buttonRecherche);
		
		buttonParcourir.setText("Parcourir");
		boxParcourir.add(buttonParcourir);
		
		
		JLabel texteNbOccurrences = new JLabel("Nombre d'occurrences :   ");
		spinnerOccurrences.setMaximumSize(new Dimension(30,30));
		spinnerOccurrences.setEditor(new JSpinner.DefaultEditor(spinnerOccurrences));
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
