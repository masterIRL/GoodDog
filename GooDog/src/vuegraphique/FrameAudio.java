package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
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
	private Box boxRecherche=Box.createHorizontalBox();
	private Box boxErreur = Box.createHorizontalBox();

	private JTextArea barreRecherche = new JTextArea();

	private JSpinner spinnerOccurrences=new JSpinner(new SpinnerNumberModel(1, 1, 9, 1));

	private JButton buttonParcourir =new JButton();
	private JButton buttonRecherche =new JButton();

	private JFileChooser fc =new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); //cree un file chooser au home

	private int occurenceAudio = 0;
	private String nom;

	public FrameAudio(PanUser panUser, ControlRecherche controlRecherche) {
		super();
		this.panUser = panUser;
		this.controlRecherche = controlRecherche;

		this.setTitle("Recherche Audio");
		this.setSize(new Dimension(900,200));
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
		this.setSize(new Dimension(900,200));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//      this.setPreferredSize(new Dimension(920,700));

		this.initialisation();
		this.getContentPane().add(panelGeneral);
		this.setVisible(true);
	}

	private void initialisation() {
		this.setBackground(new Color(102, 51, 81));
		this.panelGeneral.setBackground(new Color(193, 94, 28));

		////////////////////////////////////////////////////////////////////////////////
		///////////////              Nombre d'occurrences             //////////////////
		////////////////////////////////////////////////////////////////////////////////
		JLabel texteNbOccurrences = new JLabel("Occurrences:");
		texteNbOccurrences.setForeground(Color.WHITE);

		spinnerOccurrences.setPreferredSize(new Dimension(50,30));
		spinnerOccurrences.setEditor(new JSpinner.DefaultEditor(spinnerOccurrences));


		boxNbOccurrences.add(texteNbOccurrences);
		boxNbOccurrences.add(Box.createRigidArea(new Dimension(5,0)));
		boxNbOccurrences.add(spinnerOccurrences);
		boxParcourir.add(boxNbOccurrences);
		boxParcourir.add(Box.createRigidArea(new Dimension(30,0)));

		////////////////////////////////////////////////////////////////////////////////
		///////////////               Barre de Recherche               //////////////////
		////////////////////////////////////////////////////////////////////////////////
		JLabel texteAudio = new JLabel("Audio:"); //ajout de la barre de recherche
		texteAudio.setForeground(Color.WHITE);
		boxParcourir.add(texteAudio);
		boxParcourir.add(Box.createRigidArea(new Dimension(5,0)));
		
		barreRecherche.setPreferredSize(new Dimension(500,30));
		barreRecherche.setFont(new Font("Poppins-Black", Font.PLAIN,15));
		boxParcourir.add(barreRecherche);
		boxParcourir.add(Box.createRigidArea(new Dimension(5,0)));
		

		///////////////                 Drag and Drop                /////////////////
		new  FileDrop( barreRecherche, new FileDrop.Listener()
		{   public void  filesDropped( java.io.File[] files )
		{   
			barreRecherche.setText(files[0].getAbsolutePath());
		}   
		});



		////////////////////////////////////////////////////////////////////////////////
		///////////////               Bouton Parcourir                //////////////////
		////////////////////////////////////////////////////////////////////////////////
		buttonParcourir.setText("Parcourir");
		buttonParcourir.setBackground(Color.WHITE);
		buttonParcourir.setForeground(Color.BLACK); 
		buttonParcourir.setFocusPainted(false);
		buttonParcourir.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonParcourir.setPreferredSize(new Dimension(110,30));
		buttonParcourir.setMaximumSize(new Dimension(110,30));
		buttonParcourir.setMinimumSize(new Dimension(110,30));

		buttonParcourir.addActionListener(new ActionListener() { //interaction pour parcourir les fichier
			@Override
			public void actionPerformed(ActionEvent e) {
				javax.swing.filechooser.FileFilter filtreFichier = new FileNameExtensionFilter("Fichier lisible", "wav"); //creation d'un filtre pour faciliter
				fc.addChoosableFileFilter(filtreFichier); // ajout du filtre
				int returnVal = fc.showOpenDialog(buttonParcourir); //lance le gestionaire de fichier en mode ouverture
				if (returnVal == JFileChooser.APPROVE_OPTION) { //un fichier a ï¿½tï¿½ sï¿½lectionnï¿½
					File file = fc.getSelectedFile();
					nom = file.getName();
					barreRecherche.setText(file.getAbsolutePath()); //rï¿½cupï¿½re le chemin absolu du fichier sï¿½lectionnï¿½ et le stock

				}
				else { //Aucun fichier de sï¿½lectionner. Que faire?
				}
			}
		});
		boxParcourir.add(buttonParcourir);


		/////////////                  Bouton Recherche              ////////////////
		buttonRecherche.setText("Recherche");
		buttonRecherche.setBackground(Color.WHITE);
		buttonRecherche.setForeground(Color.BLACK); 
		buttonRecherche.setFocusPainted(false);
		buttonRecherche.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonRecherche.setPreferredSize(new Dimension(110,30));
		buttonRecherche.setMaximumSize(new Dimension(110,30));
		buttonRecherche.setMinimumSize(new Dimension(110,30));
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
						boxErreur.setVisible(true);
					}
				}
				else {
					System.out.println("Choisissez un fichier"); //Le faire apparaitre à l'écran
					boxErreur.setVisible(true);
				}
			}
		});

		//		boxRecherche.add(barreRecherche);
		boxRecherche.add(buttonRecherche);



		////////////////////////////////////////////////////////////////////////////////
		///////////////              Ajout au Pan Principal           //////////////////
		////////////////////////////////////////////////////////////////////////////////
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,10)));
		boxMiseEnPageAudio.add(getError("Choisissez un fichier audio valide (wav)")); //ajout du label d'erreur 
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,10)));		
		boxMiseEnPageAudio.add(boxParcourir);
		boxMiseEnPageAudio.add(Box.createRigidArea(new Dimension(0,15)));
		boxMiseEnPageAudio.add(boxRecherche);

		this.panelGeneral.add(boxMiseEnPageAudio);
	}
	
	private Box getError(String s) { //recupere un bouton d'erreur
		JLabel errorLabel = new JLabel(s);
		errorLabel.setForeground(Color.red);
		boxErreur.add(errorLabel);
		boxErreur.setVisible(false);
		return boxErreur;
	}

	public void rechercheAudio() {
		if(!admin) {
			panUser.initBoxMiseEnPageResultat("Résulats de votre recherche par audio");
			panUser.resultatSons(controlRecherche.rechercheAudio(nom,occurenceAudio)); //remplacer nom par barreRecherche.getText()
		}
		else {
			panAdmin.initBoxMiseEnPageResultat("Résulats de votre recherche par audio");
			panAdmin.resultatSons(controlRecherche.rechercheAudio(nom,occurenceAudio)); 
		}
		dispose();
	}

}
