package vuetextuelle;

import java.util.List;

import control.ControlRecherche;
import model.TypeFichier;

public class BoundaryRechercheFichier {

	private ControlRecherche controlRecherche;
	
	public BoundaryRechercheFichier(ControlRecherche controlRecherche) {
		this.controlRecherche = controlRecherche;
	}

	public String rechercheFichier() {
		int choix = 0;
		Clavier clavier = new Clavier();
		while(!(choix == 1 || choix == 2 || choix == 3)) {
			System.out.println("1.recherche fichier texte\n" + "2.recherche fichier son\n" + "3.recherche fichier image");
			choix = clavier.entrerClavierInt();	
			if(!(choix==1 || choix==2 || choix==3)) {
				System.out.println("Veuillez entrer 1, 2 ou 3");
			}
		}
		
		System.out.println("Veuillez entrer le nom ou le chemin du fichier");
		String nom = clavier.entrerClavierString();
		
		int seuil = -1;
		while(seuil < 0 || seuil > 100) {
			System.out.println("Veuillez donner le seuil de similarité (en %):");
			seuil = clavier.entrerClavierInt();
			if(seuil < 0 || seuil > 100) {
				System.out.println("Seuil compris entre 0 et 100 (en %)");
			}
		}
		
		System.out.println("Resulat de la requette fichier : " + nom + " similaire à " + seuil + "%");

		String resultat = new String();
		switch (choix) {
		case 1:
			List<String> listeTexte = controlRecherche.rechercheFichier(TypeFichier.TEXTE,nom,seuil);
			if(listeTexte != null) {
				int i = 1;
				for (String string : listeTexte) {
					resultat += i + " : " + string;
					i++;
				}
			}
			else
				System.out.println("Aucun résultat");
			break;
			
		case 2:
			List<String> listeSon = controlRecherche.rechercheFichier(TypeFichier.SON,nom,seuil);
			if(listeSon != null) {
				int i = 1;
				for (String string : listeSon) {
					resultat += i + " : " + string;
					i++;
				}
			}
			else
				System.out.println("Aucun résultat");
			
			break;
			
		case 3:
			List<String> listeImage = controlRecherche.rechercheFichier(TypeFichier.IMAGE,nom,seuil);
			if(listeImage != null) {
				int i = 1;
				for (String string : listeImage) {
					resultat += i + " : " + string;
					i++;
				}
			}
			else
				System.out.println("Aucun résultat");
			
			break;
			
		default:
			System.out.println("Type de recherche fichier non reconnu");
			break;
		}
		return resultat;
	}
}
