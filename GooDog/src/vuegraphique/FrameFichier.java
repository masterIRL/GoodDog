package vuegraphique;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import autre.FileDrop;
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
	private Box boxMiseEnPage = Box.createVerticalBox();
	private Box boxRecherche = Box.createHorizontalBox();
	private Box boxParcourir = Box.createHorizontalBox();
	private Box boxErreur = Box.createHorizontalBox();
	private JSlider comboBoxSeuil = new JSlider();

	//TexteArea
	private JFileChooser fc =new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); //cree un file chooser au home
	private JTextArea texteChemin = new JTextArea();
	private String nom;
	private TypeFichier typeFichier;

	private int choixSeuil = 0;

	//Jbouton
	private JButton parcourir = new JButton();
	private JButton lancerRecherche = new JButton();

	//Les constructeur
	public FrameFichier(PanUser panUser, ControlRecherche controlRecherche) {
		super();
		this.panUser = panUser;
		this.controlRecherche = controlRecherche;

		this.setTitle("Recherche Fichier");
		this.setSize(new Dimension(1200,200));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
		this.setSize(new Dimension(1200,200));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.initialisation();
		this.getContentPane().add(panelGeneral);
		this.setVisible(true);
	}

	private void initialisation() {
		this.panelGeneral.setBackground(new Color(128,102,83));

		////////////////////////////////////////////////////////////////////////////////
		///////////////              Box de Recherche                 //////////////////
		////////////////////////////////////////////////////////////////////////////////

		///////////////               Texte et box seuil              //////////////////
		JLabel texteSeuil = new JLabel("Seuil:"); //ajout de la partie seuil
		texteSeuil.setForeground(Color.WHITE);
		boxParcourir.add(texteSeuil);
		boxParcourir.add(Box.createRigidArea(new Dimension(5,0)));
		
		comboBoxSeuil.setMaximumSize(new Dimension(300,40));
		comboBoxSeuil.setMinimumSize(new Dimension(300,40));
		comboBoxSeuil.setPreferredSize(new Dimension(300,40));
		comboBoxSeuil.setBackground(new Color(128,102,83));
		comboBoxSeuil.setForeground(Color.WHITE);
		comboBoxSeuil.setMaximum(100);

		comboBoxSeuil.setMinimum(0);

		comboBoxSeuil.setValue(33);

		comboBoxSeuil.setPaintTicks(true);

		comboBoxSeuil.setPaintLabels(true);

		comboBoxSeuil.setMinorTickSpacing(10);

		comboBoxSeuil.setMajorTickSpacing(10);
		boxParcourir.add(comboBoxSeuil);
		boxParcourir.add(Box.createRigidArea(new Dimension(30,0)));
		
		
		///////////////               Barre de Recherche               //////////////////
		JLabel texteFichier = new JLabel("Fichier:"); //ajout de la barre de recherche
		texteFichier.setForeground(Color.WHITE);
		boxParcourir.add(texteFichier);
		boxParcourir.add(Box.createRigidArea(new Dimension(5,0)));

		this.texteChemin.setPreferredSize(new Dimension(500,30)); //ajout de la partie du texte du chemin et son bouton pour parcourir
		texteChemin.setFont(new Font("Poppins-Black", Font.PLAIN,15));
		boxParcourir.add(texteChemin);
		boxParcourir.add(Box.createRigidArea(new Dimension(5,0)));
		texteChemin.setPreferredSize(new Dimension(500,30));
		texteChemin.setMaximumSize(new Dimension(500,30));
		texteChemin.setMinimumSize(new Dimension(500,30));
		///////////////                 Drag and Drop                /////////////////
		new  FileDrop( texteChemin, new FileDrop.Listener()
		{   public void  filesDropped( java.io.File[] files )
		{   
			texteChemin.setText(files[0].getAbsolutePath());
		}   
		});
		
		
		///////////////               Bouton Parcourir                //////////////////
		this.parcourir.setText("Parcourir");
		parcourir.setBackground(Color.WHITE);
		parcourir.setForeground(Color.BLACK); 
		parcourir.setFocusPainted(false);
		parcourir.setFont(new Font("Tahoma", Font.BOLD, 12));
		parcourir.setPreferredSize(new Dimension(110,30));
		parcourir.setMaximumSize(new Dimension(110,30));
		parcourir.setMinimumSize(new Dimension(110,30));
		
		this.parcourir.addActionListener(new ActionListener() { //interaction pour parcourir les fichier
			public void actionPerformed(ActionEvent e) {
				FileFilter filtreFichier = new FileNameExtensionFilter("Fichier lisible", "jpg", "xml", "wav"); //creation d'un filtre pour faciliter
				fc.addChoosableFileFilter(filtreFichier); // ajout du filtre
				int returnVal = fc.showOpenDialog(parcourir); //lance le gestionaire de fichier en mode ouverture
				if (returnVal == JFileChooser.APPROVE_OPTION) { //un fichier a ï¿½tï¿½ sï¿½lectionnï¿½
					File file = fc.getSelectedFile();
					nom = file.getName();
					texteChemin.setText(file.getAbsolutePath()); //rï¿½cupï¿½re le chemin absolu du fichier sï¿½lectionnï¿½ et le stock
				} 
				else { //Aucun fichier de sï¿½lectionner. Que faire?
				}
			}
		});
		boxParcourir.add(parcourir);


		///////////////               Bouton Rechercher                //////////////////
		lancerRecherche.setText("Rechercher"); //ajout du bouton recherche et son interaction 
		lancerRecherche.setBackground(Color.WHITE);
		lancerRecherche.setForeground(Color.BLACK); 
		lancerRecherche.setFocusPainted(false);
		lancerRecherche.setFont(new Font("Tahoma", Font.BOLD, 12));
		lancerRecherche.setPreferredSize(new Dimension(110,30));
		lancerRecherche.setMaximumSize(new Dimension(110,30));
		lancerRecherche.setMinimumSize(new Dimension(110,30));
		
		lancerRecherche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//rï¿½cupï¿½re le type de fichier
				if(texteChemin.getText().length() >= 3) {
					String extension = texteChemin.getText().substring(texteChemin.getText().length()-3); //rï¿½cupï¿½re les 3 dernieres lettre
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
					choixSeuil = comboBoxSeuil.getValue();
					System.out.println(choixSeuil); // vï¿½rifier la valeur

					rechercheFichier();//lance la recherche
				}
				else {
					System.out.println("Choisissez un fichier"); //Le faire apparaitre ï¿½ l'ï¿½cran
					boxErreur.setVisible(true);
				}
			}
		});
		boxRecherche.add(lancerRecherche);

		////////////////////////////////////////////////////////////////////////////////
		///////////////              Ajout au Pan Principal           //////////////////
		////////////////////////////////////////////////////////////////////////////////
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(0,10)));	
		boxMiseEnPage.add(getError("Choisissez un fichier valide (xml,jpg ou wav)")); //ajout du label d'erreur 
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(0,10)));
		boxMiseEnPage.add(boxParcourir);
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(0,15)));
		boxMiseEnPage.add(boxRecherche);

		panelGeneral.add(boxMiseEnPage);
	}
	
	private Box getError(String s) { //recupere un bouton d'erreur
		JLabel errorLabel = new JLabel(s);
		errorLabel.setForeground(Color.red);
		boxErreur.add(errorLabel);
		boxErreur.setVisible(false);
		return boxErreur;
	}

	public void rechercheFichier() {
		if(typeFichier != null)
		{
			if(!admin) {
				panUser.initBoxMiseEnPageResultat("Résulats de votre recherche par fichier");
				switch(typeFichier) {
				case TEXTE:
					panUser.resultatsTextes(controlRecherche.rechercheFichier(typeFichier, nom, choixSeuil)); // remplacer par texteChemin.getText()
					break;
				case IMAGE:
					panUser.resultatImages(controlRecherche.rechercheFichier(typeFichier, nom, choixSeuil));
					break;
				case SON:
					panUser.resultatSons(controlRecherche.rechercheFichier(typeFichier, nom, choixSeuil));
					break;
				}
			} 
			else {
				panAdmin.initBoxMiseEnPageResultat("Résulats de votre recherche par fichier");
				switch(typeFichier) {
				case TEXTE:
					panAdmin.resultatsTextes(controlRecherche.rechercheFichier(typeFichier, nom, choixSeuil));
					break;
				case IMAGE:
					panAdmin.resultatImages(controlRecherche.rechercheFichier(typeFichier, nom, choixSeuil));
					break;
				case SON:
					panAdmin.resultatSons(controlRecherche.rechercheFichier(typeFichier, nom, choixSeuil));
					break;
				}
			}
			dispose(); //ferme la fenetre
		}
		else {
			System.out.println("Choisissez un fichier valide"); // Le faire apparaitre a l'ï¿½cran grace a un label etc
			boxErreur.setVisible(true);
		}

	}
}
