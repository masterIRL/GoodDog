package vuetextuelle;

import java.util.List;

import control.ControlRecherche;

public class BoundaryRechercheAudio {
	
	private ControlRecherche controlRecherche;

	public BoundaryRechercheAudio(ControlRecherche controlRecherche) {
		this.controlRecherche = controlRecherche;
	}
	
	public void rechercheAudio() {
		boolean cheminValide = false;
		String chemin = "";
		int occurenceAudio = -1;
		Clavier clavier = new Clavier();
		while(!cheminValide) {
			System.out.println("Entrez le chemin");
			chemin = clavier.entrerClavierString();
			cheminValide = controlRecherche.verifierChemin(chemin);
			if(!cheminValide) {
				System.out.println("Erreur de chemin: saisissez le bon chemin !");
			}
		}
		
		while(occurenceAudio < 0) {
			System.out.println("Entrez le nombre de fois que l'audio doit être présent");
			occurenceAudio = clavier.entrerClavierInt();
			if(occurenceAudio<0) {
				System.out.println("Vous ne pouvez pas entrer de nombre négatif");
			}
		}
		
		String resultat = new String();
		System.out.println("Resulat de la requette audio : " + chemin + "présent " + occurenceAudio + "fois");
		List<String> listeAudio = controlRecherche.rechercheAudio(chemin,occurenceAudio);
		if(listeAudio != null) {
			int i = 1;
			for (String string : listeAudio) {
				resultat += i + " : " + string;
				i++;
			}
			System.out.println(resultat);
		}
		else
			System.out.println("Aucun résultat");
	}
}
