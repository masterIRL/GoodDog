package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
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
	private Box boxMiseEnPage = Box.createHorizontalBox();

	private JComboBox<Integer> comboBoxSeuil = new JComboBox<>();
	private JComboBox<String> comboBoxCouleur = new JComboBox<>();

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
		this.setSize(new Dimension(700,500));
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
		this.setSize(new Dimension(700,500));
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
		this.panelGeneral.setBackground(Color.WHITE);
		int espaceEntreElement = 15;
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(0,70)));

		JLabel texteSeuil = new JLabel("seuil:"); //ajout de la partie sélection seuil
		boxMiseEnPage.add(texteSeuil);
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(5,0)));
		for(int i=0;i<101;i++){
			listSeuil.add(i);
		}
		for (Integer integer : listSeuil) {
			comboBoxSeuil.addItem(integer);
		}
		boxMiseEnPage.add(comboBoxSeuil);
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(espaceEntreElement,0)));

		JLabel texteCouleur = new JLabel("Couleur:"); //ajout de la partie selection couleur
		boxMiseEnPage.add(texteCouleur);
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(5,0)));
		comboBoxCouleur.addItem("");
		for (String string : listCouleurs) {
			comboBoxCouleur.addItem(string);
		}
		boxMiseEnPage.add(comboBoxCouleur);
		boxMiseEnPage.add(Box.createRigidArea(new Dimension(20,0)));

		lancerRecherche.setText("OK"); //ajout du bouton recherche et son interaction 
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
				choixSeuil = comboBoxSeuil.getSelectedIndex();
				System.out.println(choixSeuil); // vérifier la valeur
				//lance la recherche
				rechercheCouleur();
			}
		});
		boxMiseEnPage.add(lancerRecherche);

		panelGeneral.add(boxMiseEnPage);

	}

	public void rechercheCouleur() {
		if(choixCouleur != null)
		{
			if(!admin) {
				panUser.initBoxMiseEnPageResultat("Résulats de votre recherche couleur");
				panUser.resultatImages(controlRecherche.rechercheCouleur(choixCouleur,choixSeuil));
			} 
			else {
				panAdmin.initBoxMiseEnPageResultat("Résulats de votre recherche couleur");
				panAdmin.resultatImages(controlRecherche.rechercheCouleur(choixCouleur,choixSeuil));
			}
			dispose(); //ferme la fenetre
		}
		else {
			System.out.println("Choisissez une couleur"); //non valide la recherche
		}

	}

}