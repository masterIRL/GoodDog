package control;

import java.util.ArrayList;
import java.util.List;

import model.Comparaison;
import model.Couleur;
import model.TypeFichier;

public class ControlRecherche {

	private Comparaison comparaison = new Comparaison();
	
	public ControlRecherche() {
	}

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
	
	public boolean verifierMotCle(String mot) {
		// TODO Auto-generated method stub
		if(mot.contains("&") || mot.contains("{") || mot.contains("}")
				|| mot.contains("*") || mot.contains("[") || mot.contains("]")
				|| mot.contains("@") || mot.contains("_") || mot.contains("/")
				|| mot.contains("-") || mot.contains("?") || mot.contains("!")
				|| mot.contains("§") || mot.contains("#") || mot.contains("=")) 
		{
			return false;
		}
		else
			return true;
		
	}

	public List<String> rechercheMotCle(String mot, int occurrenceMotCle) {
		List<String> listMotCle = new ArrayList<>();
		//TODO appeler la fonction comparaison.comparaisonMotCle qui va devoir renvoyer un map.
		// ce map aura donc le mot et son occurence. Pour chaque mot il faut comparer son occu avec
		// celui présent en parametre de CETTE fonction (occurrenceMotCle) et ceux sup ou egale
		//tu stocke le mot dnas le "listMotCle"
		return listMotCle;
	}

}
