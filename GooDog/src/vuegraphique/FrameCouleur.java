package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import control.ControlRecherche;
import model.Couleur;

public class FrameCouleur  extends JFrame{

	private static final long serialVersionUID = -177116217887565541L;
	private ControlRecherche controlRecherche;
	private PanUser panUser;
	private PanAdmin panAdmin;
	private JPanel panelGeneral = new JPanel();
	private boolean admin = false;

	//Font

	// boxs
	private Box boxMiseEnPageCouleur = Box.createVerticalBox();
	private Box boxRecherche = Box.createHorizontalBox();
	private Box boxErreur = Box.createHorizontalBox();

	//private JComboBox<Integer> comboBoxSeuil = new JComboBox<>();
	private JComboBox<String> comboBoxCouleur = new JComboBox<>();
	private JSlider comboBoxSeuil = new JSlider();

	private int choixSeuil = 0;
	private Couleur choixCouleur = null;
	private List<Integer> listSeuil = new ArrayList<>();
	private final List<String>  listCouleurs = new ArrayList<>(Arrays.asList("NOIR", "BLANC", "ROUGE", "VERT", "BLEU"));

	//Jbouton
	private JButton lancerRecherche = new JButton();

	//Les constructeur
	public FrameCouleur(PanUser panUser, ControlRecherche controlRecherche) {
		super();
		this.panUser = panUser;
		this.controlRecherche = controlRecherche;

		this.setTitle("Recherche Couleur");
		this.setSize(new Dimension(900,200));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(new Dimension(920,700));

		this.initialisation();
		this.getContentPane().add(panelGeneral);
		this.setVisible(true);
	}

	public FrameCouleur(PanAdmin panAdmin, ControlRecherche controlRecherche) {
		super();
		this.panAdmin = panAdmin;
		this.controlRecherche = controlRecherche;
		this.admin = true;

		this.setTitle("Recherche Couleur");
		this.setSize(new Dimension(900,200));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(new Dimension(920,700));

		this.initialisation();
		this.getContentPane().add(panelGeneral);
		this.setVisible(true);
	}

	//Methode privee
	private void initialisation() {
		this.panelGeneral.setBackground(new Color(128,102,83));
		int espaceEntreElement = 15;

		JLabel texteSeuil = new JLabel("Pourcentage:"); //ajout de la partie s�lection seuil
		texteSeuil.setForeground(Color.WHITE);
		boxRecherche.add(texteSeuil);
		boxRecherche.add(Box.createRigidArea(new Dimension(5,0)));
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
		
		boxRecherche.add(comboBoxSeuil);
		boxRecherche.add(Box.createRigidArea(new Dimension(espaceEntreElement,0)));

		JLabel texteCouleur = new JLabel("Couleur:"); //ajout de la partie selection couleur
		texteCouleur.setForeground(Color.WHITE);
		boxRecherche.add(texteCouleur);
		boxRecherche.add(Box.createRigidArea(new Dimension(5,0)));
		comboBoxCouleur.setMaximumSize(new Dimension(200,30));
	
	
		comboBoxCouleur.addItem("");
		for (String string : listCouleurs) {
			comboBoxCouleur.addItem(string);
		}
		boxRecherche.add(comboBoxCouleur);
		boxRecherche.add(Box.createRigidArea(new Dimension(20,0)));
		
		lancerRecherche.setMaximumSize(new Dimension(110,30));
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
				//Recupere la couleur dans la box
				switch((String)comboBoxCouleur.getSelectedItem()) {
				case "NOIR":
					choixCouleur = Couleur.NOIR;
					break;
				case "BLANC":
					choixCouleur = Couleur.BLANC;
					break;
				case "ROUGE":
					choixCouleur = Couleur.ROUGE;
					break;
				case "VERT":
					choixCouleur = Couleur.VERT;
					break;
				case "BLEU":
					choixCouleur = Couleur.BLEU;
					break;
				default:
					choixCouleur = null;
					break;
				}
				//Recupere la valeur du seuil dans sa box
				//choixSeuil = comboBoxSeuil.getSelectedIndex();
				choixSeuil=comboBoxSeuil.getValue();
				System.out.println(choixSeuil); // v�rifier la valeur
				//lance la recherche
				rechercheCouleur();
			}
		});
		boxRecherche.add(lancerRecherche);
		
		////////////////////////////////////////////////////////////////////////////////
		///////////////              Ajout au Pan Principal           //////////////////
		////////////////////////////////////////////////////////////////////////////////
		boxMiseEnPageCouleur.add(Box.createRigidArea(new Dimension(0,10)));	
		boxMiseEnPageCouleur.add(getError("Choisissez une couleur")); //ajout du label d'erreur 
		boxMiseEnPageCouleur.add(Box.createRigidArea(new Dimension(0,10)));
		boxMiseEnPageCouleur.add(boxRecherche);
		
		panelGeneral.add(boxMiseEnPageCouleur);
	}

	private Box getError(String s) { //recupere un bouton d'erreur
		JLabel errorLabel = new JLabel(s);
		errorLabel.setForeground(Color.red);
		boxErreur.add(errorLabel);
		boxErreur.setVisible(false);
		return boxErreur;
	}

	
	public void rechercheCouleur() {
		if(choixCouleur != null)
		{
			if(!admin) {
				panUser.initBoxMiseEnPageResultat("R�sulats de votre recherche couleur");
				panUser.resultatImages(controlRecherche.rechercheCouleur(choixCouleur,choixSeuil));
			} 
			else {
				panAdmin.initBoxMiseEnPageResultat("R�sulats de votre recherche couleur");
				panAdmin.resultatImages(controlRecherche.rechercheCouleur(choixCouleur,choixSeuil));
			}
			dispose(); //ferme la fenetre
		}
		else {
			System.out.println("Choisissez une couleur"); //non valide la recherche
			boxErreur.setVisible(true);
		}

	}

}