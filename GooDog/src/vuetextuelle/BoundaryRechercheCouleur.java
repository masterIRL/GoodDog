package vuetextuelle;

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
			String listeBlanc = controlRecherche.rechercheCouleur(Couleur.BLANC,pourcentage);
			resultat = listeBlanc;
			break;
			
		case 2:
			String listeNoir = controlRecherche.rechercheCouleur(Couleur.NOIR,pourcentage);
			resultat = listeNoir;
			break;
			
		case 3:
			String listeRouge = controlRecherche.rechercheCouleur(Couleur.ROUGE,pourcentage);
			resultat = listeRouge;
			break;
			
		case 4:
			String listeVert = controlRecherche.rechercheCouleur(Couleur.VERT,pourcentage);
			resultat = listeVert;
			break;
			
		case 5:
			String listeBleu = controlRecherche.rechercheCouleur(Couleur.BLEU,pourcentage);
			resultat = listeBleu;
			break;
			
		default:
			System.out.println("Type de recherche fichier non reconnu");
			break;
		}
		return resultat;
	}
}
