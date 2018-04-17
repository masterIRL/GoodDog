package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.TextArea;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JToolTip;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


import model.TypeFichier;

public class PanRechercheAudio extends JPanel{

	
	
	private static final long serialVersionUID = 1L;
	private Box boxMiseEnPageAudio=Box.createVerticalBox();
	private Box boxNbOccurrences=Box.createHorizontalBox();
	private Box boxParcourir=Box.createHorizontalBox();
	private Box boxBareDeRecherche=Box.createHorizontalBox();
	private JTextArea barederecherche=new JTextArea();
	private JSpinner spinnerOccurrences=new JSpinner(new SpinnerNumberModel(1, 1, 9, 1));
	private JButton buttonParcourir =new JButton();
	private JButton buttonRecherche =new JButton();
	private JFileChooser fc =new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); //cree un file chooser au home
	

	
	
	
	public void initialisation() throws Exception, IOException {
		this.setBackground(Color.WHITE);
		barederecherche.setMaximumSize(new Dimension(650,30));
		barederecherche.setMinimumSize(new Dimension(650,30));
		barederecherche.setBackground(Color.WHITE);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		barederecherche.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		barederecherche.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		 new  FileDrop( barederecherche, new FileDrop.Listener()
	      {   public void  filesDropped( java.io.File[] files )
	          {   
	              barederecherche.setText(files[0].getAbsolutePath());
	          
	          }   
	      });
		 
		JLabel texteEspace = new JLabel("   ");
		buttonRecherche.setText("Recherche");
		buttonRecherche.addActionListener(new ActionListener() { //click sur le bouton
			public void actionPerformed(ActionEvent e) {
				  
				}
			

		});
	
		boxBareDeRecherche.add(barederecherche);
		boxBareDeRecherche.add(texteEspace);
		boxBareDeRecherche.add(buttonRecherche);
		
		buttonParcourir.setText("Parcourir");
		boxParcourir.add(buttonParcourir);
		buttonParcourir.addActionListener(new ActionListener() { //interaction pour parcourir les fichier
			

			@Override
			public void actionPerformed(ActionEvent e) {
				javax.swing.filechooser.FileFilter filtreFichier = new FileNameExtensionFilter("Fichier lisible", "jpg", "xml", "wav"); //creation d'un filtre pour faciliter
				fc.addChoosableFileFilter(filtreFichier); // ajout du filtre
				int returnVal = fc.showOpenDialog(buttonParcourir); //lance le gestionaire de fichier en mode ouverture
				if (returnVal == JFileChooser.APPROVE_OPTION) { //un fichier a �t� s�lectionn�
					File file = fc.getSelectedFile();
					String nom = file.getName();
					barederecherche.setText(file.getAbsolutePath()); //r�cup�re le chemin absolu du fichier s�lectionn� et le stock
					
				} 
				else { //Aucun fichier de s�lectionner. Que faire?
				}
				
			}
		});
		
		
	
		
		
	     
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
