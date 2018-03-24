package vuetextuelle;

import java.util.List;

import control.ControlRecherche;
import model.Couleur;

public class BoundaryRechercheCouleur {
	
	private ControlRecherche controlRecherche;
	
	public String rechercheCouleur() {
		int choix = 0;
		Clavier clavier = new Clavier();
		while(choix<1 || choix>5) {
			System.out.println("Choisissez une couleur parmis la liste" + Couleur.values());
			choix = clavier.entrerClavierInt();	
			if(choix<1 || choix>5) {
				System.out.println("Veuillez entrer 1, 2, 3, 4 ou 5");
			}
		}
		
		int pourcentage = -1;
		while(pourcentage < 0 || pourcentage > 100) {
			System.out.println("Entrez le pourcentage:");
			pourcentage = clavier.entrerClavierInt();
			if(pourcentage < 0 || pourcentage > 100) {
				System.out.println("Pourcentage compris entre 0 et 100");
			}
		}
		
		String resultat = new String();
		switch (choix) {
		case 1:
			List<String> listeBlanc = controlRecherche.rechercheCouleur(Couleur.BLANC,pourcentage);
			int i = 1;
			for (String string : listeBlanc) {
				resultat += i + " : " + string;
				i++;
			}
			break;
			
		case 2:
			List<String> listeNoir = controlRecherche.rechercheCouleur(Couleur.NOIR,pourcentage);
			i = 1;
			for (String string : listeNoir) {
				resultat += i + " : " + string;
				i++;
			}
			break;
			
		case 3:
			List<String> listeRouge = controlRecherche.rechercheCouleur(Couleur.ROUGE,pourcentage);
			i = 1;
			for (String string : listeRouge) {
				resultat += i + " : " + string;
				i++;
			}
			break;
			
		case 4:
			List<String> listeVert = controlRecherche.rechercheCouleur(Couleur.VERT,pourcentage);
			i = 1;
			for (String string : listeVert) {
				resultat += i + " : " + string;
				i++;
			}
			break;
			
		case 5:
			List<String> listeBleu = controlRecherche.rechercheCouleur(Couleur.BLEU,pourcentage);
			i = 1;
			for (String string : listeBleu) {
				resultat += i + " : " + string;
				i++;
			}
			break;
			
		default:
			System.out.println("Type de recherche fichier non reconnu");
			break;
		}
		return resultat;
	}
}
