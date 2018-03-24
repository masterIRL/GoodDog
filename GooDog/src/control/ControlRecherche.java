package control;

import model.Comparaison;
import model.Couleur;
import model.TypeFichier;

public class ControlRecherche {

	private Comparaison comparaison;
	
	public String rechercheFichier(TypeFichier fichier, String nom, int seuil) {
		// TODO Auto-generated method stub
		switch (fichier) {
		case TEXTE:
			String listeTexte = comparaison.comparaisonTexte(nom,seuil);
			return listeTexte;
			
		case SON:
			String listeSon = comparaison.comparaisonSon(nom,seuil);
			return listeSon;
			
		case IMAGE:
			String listeImage = comparaison.comparaisonImage(nom,seuil);
			return listeImage;
		}
		return null;
	}

	public String rechercheCouleur(Couleur couleur, int pourcentage) {
		// TODO Auto-generated method stub
		switch (couleur) {
		case BLANC:
			String listeBlanc = comparaison.comparaisonCouleur(63,pourcentage);
			return listeBlanc;
			
		case NOIR:
			String listeNoir = comparaison.comparaisonCouleur(0,pourcentage);
			return listeNoir;
			
		case ROUGE:
			String listeRouge = comparaison.comparaisonCouleur(48,pourcentage);
			return listeRouge;
			
		case VERT:
			String listeVert = comparaison.comparaisonCouleur(12,pourcentage);
			return listeVert;
			
		case BLEU:
			String listeBleu = comparaison.comparaisonCouleur(3,pourcentage);
			return listeBleu;
		}
		return null;
	}

}
