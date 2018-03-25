package vuetextuelle;

import java.util.ArrayList;
import control.ControlConfig;

public class BoundaryConfigTexte {
	
	ControlConfig control = new ControlConfig();
	
	public void configurerSon() {
		
		Fichier fichier= new Fichier();
		boolean nOK=false;
		Clavier clavier = new Clavier();
		int n,m,p;
		ArrayList<Integer> configActuelle = new ArrayList<Integer>();
		
		configActuelle = fichier.lireInt("../DESCRIPTEURS/configTexte.txt");
		System.out.println("Configuration actuelle: ");
		System.out.println("Valeur du seuil= "+ String.valueOf(configActuelle.get(0)));
		System.out.println("Valeur du nombre de mots= "+ String.valueOf(configActuelle.get(1)));
		System.out.println("Valeur du nombre de lettre= "+ String.valueOf(configActuelle.get(2)));
		
		do {
			System.out.println("Rentrez la nouvelle valeur du seuil:");
			n = clavier.entrerClavierInt();
			nOK = true; //test pour le seuil
		} while (!nOK);
		
		fichier.effacer("../DESCRIPTEURS/configTexte.txt");
		fichier.ecrire(String.valueOf(n),"../DESCRIPTEURS/configTexte.txt");
		
		nOK=false;
		do {
			System.out.println("Rentrez la nouvelle valeur du nombre de lettre :");
			m = clavier.entrerClavierInt();
			nOK = true; //test pour le nombre de lettre
		} while (!nOK);
		
		fichier.ecrire(String.valueOf(m),"../DESCRIPTEURS/configTexte.txt");
		
		do {
			System.out.println("Rentrez la nouvelle valeur du nombre de mot:");
			p = clavier.entrerClavierInt();
			nOK = true; //test pour le nombre de mot
		} while (!nOK);
		
		fichier.ecrire(String.valueOf(p),"../DESCRIPTEURS/configTexte.txt");
		// indexer(TypeFichier.TEXTE);
	}
	
}
