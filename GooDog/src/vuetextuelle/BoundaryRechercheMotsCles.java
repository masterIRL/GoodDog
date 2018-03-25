package vuetextuelle;

import control.ControlRecherche;

public class BoundaryRechercheMotsCles {
	
	private ControlRecherche controlRechercheMotCle;
	
	public BoundaryRechercheMotsCles(ControlRecherche controlRechercheMotCle) {
		
	}
	
	public void rechercheMotCle() {
		
		Clavier clavier = new Clavier();
		
		boolean motCleOk;
		String mot;
		do {
			System.out.println("Entrez un mot clé: ");
			mot = clavier.entrerClavierString();
			
			motCleOk = controlRechercheMotCle.verifierMotCle(mot);
			
			if(!motCleOk) {
				System.out.println("Votre mot cle n'est pas correcte !");
			}
		}while(!motCleOk);
		
		int occurrenceMotCle;
		do {
			System.out.println("Veuillez entrer le nombre d'occurence de votre requete: ");
			occurrenceMotCle = clavier.entrerClavierInt();
			
			if(occurrenceMotCle<0) {
				System.out.println("Le nombre d'occurrence ne doit pas etre negatif !");
			} 
		}while(occurrenceMotCle<0);

		for (String resultat : controlRechercheMotCle.rechercheMotCle(mot,occurrenceMotCle)) {

			System.out.println(resultat);
		}

	}
}
