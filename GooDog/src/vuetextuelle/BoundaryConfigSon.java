package vuetextuelle;

import java.util.ArrayList;
import control.ControlConfig;

public class BoundaryConfigSon {
	
	ControlConfig control= new ControlConfig();
	
	public void configurerSon() {
		
		Fichier fichier= new Fichier();
		boolean nOK=false;
		Clavier clavier = new Clavier();
		int n;
		int m;
		ArrayList<Integer> configActuelle = new ArrayList<Integer>();
		
		configActuelle = fichier.lireInt("DESCRIPTEURS/config_son.txt");
		System.out.println("Configuration actuelle: ");
		System.out.println("Le nombre d'échantillons par fenêtre="+ String.valueOf(configActuelle.get(0)));
		System.out.println("Le nombre d'intervalle par fenêtre="+ String.valueOf(configActuelle.get(1)));
		
		do {
			System.out.println("Entrez le nombre d'échantillons par fenêtre");
			n = clavier.entrerClavierInt();
			nOK=control.verifEchantillon(n);
			if (!nOK) {
				System.out.println("Le nombre d'echantillons par fenetre n'est pas une puissance de 2!");
			}
		} while (!nOK);
		
		fichier.effacer("DESCRIPTEURS/config_son.txt");
		fichier.ecrire(String.valueOf(n),"DESCRIPTEURS/config_son.txt");
		
		nOK=false;
		do {
			System.out.println("Entrez le nombre d'intervalle par fenêtre");
			m = clavier.entrerClavierInt();
			nOK=control.verifInterval(m,n);
			if (!nOK) {
				System.out.println("Le nombre d'intervalles par fenetre doit etre inferieur au nombre d'echantillons par fenetre  ");
			}
		} while (!nOK);
		
		fichier.ecrire(String.valueOf(m),"DESCRIPTEURS/config_son.txt");
		// indexer(TypeFichier.SON);
	}
	
}
