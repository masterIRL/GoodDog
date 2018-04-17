package vuegraphique;


import java.awt.Color;
import java.awt.Dimension;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import control.ControlRecherche;
import model.TypeFichier;

public class FrameFichier  extends JFrame{

	private static final long serialVersionUID = -177116217887565541L;
	private ControlRecherche controlRecherche;
	private PanUser panUser;
	private PanAdmin panAdmin;
	private JPanel panelGeneral = new JPanel();
	private boolean admin = false;

	//Font

	// boxs
	private Box boxMiseEnPage = Box.createHorizontalBox();
	private JComboBox<Integer> comboBoxSeuil = new JComboBox<>();
	
	//TexteArea
//	private JTextField texteChemin = new JTextField ();
	private JFileChooser fc =new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); //cree un file chooser au home
	private TextArea texteChemin = new TextArea();
	private String nom;
	private TypeFichier typeFichier;
	
	private int choixSeuil = 0;
	private List<Integer> listSeuil = new ArrayList<>();
	
	//Jbouton
	private JButton parcourir = new JButton();
	private JButton lancerRecherche = new JButton();
	
	//Les constructeur
		public FrameFichier(PanUser panUser, ControlRecherche controlRecherche) {
			super();
			this.panUser = panUser;
			this.controlRecherche = controlRecherche;
			
			this.setTitle("Recherche Fichier");
			this.setSize(new Dimension(900,300));
	        this.setLocationRelativeTo(null);
	        this.setResizable(true);
	        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//	        this.setPreferredSize(new Dimension(920,700));
			
	        this.initialisation();
			this.getContentPane().add(panelGeneral);
			this.setVisible(true);
		}
		
		public FrameFichier(PanAdmin panAdmin, ControlRecherche controlRecherche) {
			super();
			this.panAdmin = panAdmin;
			this.controlRecherche = controlRecherche;
			this.admin = true;
			
			this.setTitle("Recherche Fichier");
			this.setSize(new Dimension(900,300));
	        this.setLocationRelativeTo(null);
	        this.setResizable(true);
	        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//	        this.setPreferredSize(new Dimension(920,700));
			
	        this.initialisation();
			this.getContentPane().add(panelGeneral);
			this.setVisible(true);
		}
	
	private void initialisation() {
		this.panelGeneral.setBackground(Color.WHITE);
		int espaceEntreElement = 50;
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(0,70)));
		
		JLabel texteSeuil = new JLabel("seuil:"); //ajout de la partie seuil
		boxMiseEnPage.add(texteSeuil);
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(5,0)));
		for(int i=0;i<101;i++){
			listSeuil.add(i);
		}
		for (Integer integer : listSeuil) {
			comboBoxSeuil.addItem(integer);
		}
		boxMiseEnPage.add(comboBoxSeuil);
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(10,0)));
		
		this.texteChemin.setMaximumSize(new Dimension(150,30)); //ajout de la partie du texte du chemin et son bouton pour parcourir
		boxMiseEnPage.add(texteChemin);
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(5,0)));
		this.parcourir.setText("...");
		this.parcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileFilter filtreFichier = new FileNameExtensionFilter("Fichier lisible", "jpg", "xml", "wav");
				fc.addChoosableFileFilter(filtreFichier);
				int returnVal = fc.showOpenDialog(parcourir);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					nom = file.getName();
					texteChemin.setText(file.getAbsolutePath());
				} 
				else { //Que faire?
				}
			}
		});
		boxMiseEnPage.add(parcourir);
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(espaceEntreElement,0)));
		
		lancerRecherche.setText("OK"); //ajout du bouton recherche et son interaction 
		lancerRecherche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//récupère le type de fichier
				if(texteChemin.getText().length() >= 3) {
					String extension = texteChemin.getText().substring(texteChemin.getText().length()-3);
					if(extension.equals("xml")) {
						typeFichier = TypeFichier.TEXTE;
					}
					if(extension.equals("jpg")) {
						typeFichier = TypeFichier.IMAGE;
					}
					if(extension.equals("wav")){
						typeFichier = TypeFichier.SON;
					}
					if(!extension.equals("xml") && !extension.equals("jpg") && !extension.equals("wav")) {
						typeFichier = null;
					}
					System.out.println(extension + " , " + typeFichier);
					//Recupere la valeur du seuil dans sa box
					choixSeuil = comboBoxSeuil.getSelectedIndex();
					System.out.println(choixSeuil); // vérifier la valeur

					//lance la recherche
					rechercheFichier();
				}
				else {
					System.out.println("Choisissez un fichier"); //Le faire apparaitre à l'écran
				}
			}
		});
		boxMiseEnPage.add(lancerRecherche);
		
		panelGeneral.add(boxMiseEnPage);
	}
	
	public void rechercheFichier() {
		if(typeFichier != null)
		{
			if(!admin) {
				panUser.initBoxMiseEnPageResultat("Recherche par Fichier");
				switch(typeFichier) {
				case TEXTE:
					panUser.resultatsTextes(controlRecherche.rechercheFichier(typeFichier, texteChemin.getText(), choixSeuil));
					break;
				case IMAGE:
					panUser.resultatImages(controlRecherche.rechercheFichier(typeFichier, texteChemin.getText(), choixSeuil));
					break;
				case SON:
					panUser.resultatSons(controlRecherche.rechercheFichier(typeFichier, texteChemin.getText(), choixSeuil));
					break;
				}
			} 
			else {
				panAdmin.initBoxMiseEnPageResultat("Recherche par Fichier");
				switch(typeFichier) {
				case TEXTE:
					panAdmin.resultatsTextes(controlRecherche.rechercheFichier(typeFichier, texteChemin.getText(), choixSeuil));
					break;
				case IMAGE:
					panAdmin.resultatImages(controlRecherche.rechercheFichier(typeFichier, texteChemin.getText(), choixSeuil));
					break;
				case SON:
					panAdmin.resultatSons(controlRecherche.rechercheFichier(typeFichier, texteChemin.getText(), choixSeuil));
					break;
				}
			}
			dispose();
		}
		else {
			System.out.println("Choisissez un fichier valide"); // Le faire apparaitre a l'écran
		}
		
	}
}
