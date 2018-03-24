package control;

import java.util.List;

import model.Comparaison;
import model.Couleur;
import model.TypeFichier;

public class ControlRecherche {

	private Comparaison comparaison;
	
	public List<String> rechercheFichier(TypeFichier fichier, String nom, int seuil) {
		// TODO Auto-generated method stub
		switch (fichier) {
		case TEXTE:
			List<String> listeTexte = comparaison.comparaisonTexte(nom,seuil);
			return listeTexte;
			
		case SON:
			List<String> listeSon = comparaison.comparaisonSon(nom,seuil);
			return listeSon;
			
		case IMAGE:
			List<String> listeImage = comparaison.comparaisonImage(nom,seuil);
			return listeImage;
		}
		return null;
	}

	public List<String> rechercheCouleur(Couleur couleur, int pourcentage) {
		// TODO Auto-generated method stub
		switch (couleur) {
		case BLANC:
			List<String> listeBlanc = comparaison.comparaisonCouleur(63,pourcentage);
			return listeBlanc;
			
		case NOIR:
			List<String> listeNoir = comparaison.comparaisonCouleur(0,pourcentage);
			return listeNoir;
			
		case ROUGE:
			List<String> listeRouge = comparaison.comparaisonCouleur(48,pourcentage);
			return listeRouge;
			
		case VERT:
			List<String> listeVert = comparaison.comparaisonCouleur(12,pourcentage);
			return listeVert;
			
		case BLEU:
			List<String> listeBleu = comparaison.comparaisonCouleur(3,pourcentage);
			return listeBleu;
		}
		return null;
	}

}
