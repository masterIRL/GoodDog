package vuetextuelle;

import control.ControlRecherche;
import model.TypeFichier;

public class BoundaryRechercheFichier {

	private ControlRecherche controlRecherche;
	
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
		
		String resultat = new String();
		switch (choix) {
		case 1:
			String listeTexte = controlRecherche.rechercheFichier(TypeFichier.TEXTE,nom,seuil);
			resultat = listeTexte;
			break;
			
		case 2:
			String listeSon = controlRecherche.rechercheFichier(TypeFichier.SON,nom,seuil);
			resultat = listeSon;
			break;
			
		case 3:
			String listeImage = controlRecherche.rechercheFichier(TypeFichier.IMAGE,nom,seuil);
			resultat = listeImage;
			break;
			
		default:
			System.out.println("Type de recherche fichier non reconnu");
			break;
		}
		return resultat;
	}
}
