package vuetextuelle;

import java.util.ArrayList;
import control.ControlConfig;

public class BoundaryConfigImage {
	
	ControlConfig control = new ControlConfig();
	
	public void configurerImage() {
		
		Fichier fichier = new Fichier();
		boolean nOK=false;
		Clavier clavier = new Clavier();
		int n;
		ArrayList<Integer> configActuelle = new ArrayList<Integer>();
		
		configActuelle = fichier.lireInt("../DESCRIPTEURS/ImageConfig");
		System.out.println("Configuration actuelle: ");
		System.out.println("Le nombre de bits de quantification = "+ String.valueOf(configActuelle.get(0)));
		
		do {
			System.out.println("Entrez le nombre de bits de quantification");
			n = clavier.entrerClavierInt();
			nOK = control.verifQuantification(n);
			if (!nOK) {
				System.out.println("Le nombre doit être compris entre 1 et 5 :");
			}
		} while (!nOK);
		
		fichier.effacer("../DESCRIPTEURS/ImageConfig");
		fichier.ecrire(String.valueOf(n),"../DESCRIPTEURS/ImageConfig");
		// indexer(TypeFichier.IMAGE);
	}
	
}
