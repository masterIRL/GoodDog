package vuegraphique;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import control.ControlRecherche;
import autre.FileDrop;

public class FrameAudio extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControlRecherche controlRecherche;
	private PanUser panUser;
	private PanAdmin panAdmin;
	private JPanel panelGeneral = new JPanel();
	private boolean admin = false;
	
	private Box boxMiseEnPageAudio=Box.createVerticalBox();
	private Box boxNbOccurrences=Box.createHorizontalBox();
	private Box boxParcourir=Box.createHorizontalBox();
	private Box boxBareDeRecherche=Box.createHorizontalBox();
	
	private JTextArea barreRecherche=new JTextArea();
	
	private JSpinner spinnerOccurrences=new JSpinner(new SpinnerNumberModel(1, 1, 9, 1));
	
	private JButton buttonParcourir =new JButton();
	private JButton buttonRecherche =new JButton();
	
	private JFileChooser fc =new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); //cree un file chooser au home
	
	private int occurenceAudio = 0;
	
	public FrameAudio(PanUser panUser, ControlRecherche controlRecherche) {
		super();
		this.panUser = panUser;
		this.controlRecherche = controlRecherche;
		
		this.setTitle("Recherche Audio");
		this.setSize(new Dimension(900,400));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//      this.setPreferredSize(new Dimension(920,700));
		
        this.initialisation();
		this.getContentPane().add(panelGeneral);
		this.setVisible(true);
	}
	
	public FrameAudio(PanAdmin panAdmin, ControlRecherche controlRecherche) {
		super();
		this.panAdmin = panAdmin;
		this.controlRecherche = controlRecherche;
		this.admin = true;
		
		this.setTitle("Recherche Audio");
		this.setSize(new Dimension(900,400));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//      this.setPreferredSize(new Dimension(920,700));
		
        this.initialisation();
		this.getContentPane().add(panelGeneral);
		this.setVisible(true);
	}
	
	private void initialisation() {
		this.setBackground(Color.WHITE);
		
		////////////////////////////////////////////////////////////////////////////////
		///////////////               Barre de Recherche               //////////////////
		////////////////////////////////////////////////////////////////////////////////
		barreRecherche.setMaximumSize(new Dimension(650,30));
		barreRecherche.setMinimumSize(new Dimension(650,30));
		barreRecherche.setBackground(Color.WHITE);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		barreRecherche.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		barreRecherche.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		
		///////////////                 Drag and Drop                /////////////////
		 new  FileDrop( barreRecherche, new FileDrop.Listener()
	      {   public void  filesDropped( java.io.File[] files )
	          {   
	              barreRecherche.setText(files[0].getAbsolutePath());
	          }   
	      });
		 
		/////////////                  Bouton Recherche              ////////////////
		JLabel texteEspace = new JLabel("   ");
		buttonRecherche.setText("Recherche");
		buttonRecherche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonRecherche.addActionListener(new ActionListener() { //click sur le bouton
			public void actionPerformed(ActionEvent e) {
				if(barreRecherche.getText().length() >= 3) {
					String extension = barreRecherche.getText().substring(barreRecherche.getText().length()-3); //récupère les 3 dernieres lettre
					if(extension.equals("wav")){
						//Recupere la valeur du seuil dans sa box
						occurenceAudio = (int)spinnerOccurrences.getValue();
						System.out.println(occurenceAudio); // vérifier la valeur

						rechercheAudio();//lance la recherche
					}
					else{
						System.out.println("Choisissez un fichier valide");
					}
				}
				else {
					System.out.println("Choisissez un fichier"); //Le faire apparaitre à l'écran
				}
			}
		});
	
		boxBareDeRecherche.add(barreRecherche);
		boxBareDeRecherche.add(texteEspace);
		boxBareDeRecherche.add(buttonRecherche);
		
		
        ////////////////////////////////////////////////////////////////////////////////
        ///////////////               Bouton Parcourir                //////////////////
        ////////////////////////////////////////////////////////////////////////////////
		buttonParcourir.setText("Parcourir");
		buttonParcourir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boxParcourir.add(buttonParcourir);
		 
		/////////////              Parcourir des Fichiers               /////////////////
		buttonParcourir.addActionListener(new ActionListener() { //interaction pour parcourir les fichier
			@Override
			public void actionPerformed(ActionEvent e) {
				javax.swing.filechooser.FileFilter filtreFichier = new FileNameExtensionFilter("Fichier lisible", "wav"); //creation d'un filtre pour faciliter
				fc.addChoosableFileFilter(filtreFichier); // ajout du filtre
				int returnVal = fc.showOpenDialog(buttonParcourir); //lance le gestionaire de fichier en mode ouverture
				if (returnVal == JFileChooser.APPROVE_OPTION) { //un fichier a ï¿½tï¿½ sï¿½lectionnï¿½
					File file = fc.getSelectedFile();
					//String nom = file.getName();
					barreRecherche.setText(file.getAbsolutePath()); //rï¿½cupï¿½re le chemin absolu du fichier sï¿½lectionnï¿½ et le stock
					
				}
				else { //Aucun fichier de sï¿½lectionner. Que faire?
				}
			}
		});
		
       ////////////////////////////////////////////////////////////////////////////////
       ///////////////              Nombre d'occurrences             //////////////////
       ////////////////////////////////////////////////////////////////////////////////
		JLabel texteNbOccurrences = new JLabel("Nombre d'occurrences :   ");
		spinnerOccurrences.setMaximumSize(new Dimension(30,30));
		spinnerOccurrences.setEditor(new JSpinner.DefaultEditor(spinnerOccurrences));
		
		
		boxNbOccurrences.add(texteNbOccurrences);
		boxNbOccurrences.add(spinnerOccurrences);
		
		
		////////////////////////////////////////////////////////////////////////////////
	    ///////////////              Ajout au Pan Principal           //////////////////
		////////////////////////////////////////////////////////////////////////////////
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageAudio.add(boxBareDeRecherche);
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageAudio.add(boxParcourir);
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,30)));
		boxMiseEnPageAudio.add(boxNbOccurrences);
		this.panelGeneral.add(boxMiseEnPageAudio);
		
	}
	
	public void rechercheAudio() {
		if(!admin) {
			panUser.initBoxMiseEnPageResultat("Résulats de votre recherche par audio");
			panUser.resultatSons(controlRecherche.rechercheAudio(barreRecherche.getText(),occurenceAudio)); 
		}
		else {
			panAdmin.initBoxMiseEnPageResultat("Résulats de votre recherche par audio");
			panAdmin.resultatSons(controlRecherche.rechercheAudio(barreRecherche.getText(),occurenceAudio)); 
		}
		dispose();
	}

}
