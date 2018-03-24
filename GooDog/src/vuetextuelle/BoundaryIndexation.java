package vuetextuelle;

import control.ControlIndexation;
import model.TypeFichier;

public class BoundaryIndexation {
	
	ControlIndexation controlIndexation;
	
	public BoundaryIndexation(ControlIndexation controlIndexation) {
		this.controlIndexation = controlIndexation;
	}

	public void indexer() {
		int choix = 0;
		boolean adminConnecte = controlIndexation.verifierIdentification();
		if(adminConnecte) {
			
			Clavier clavier = new Clavier();
			while(!(choix == 1 || choix == 2 || choix == 3)) {
				System.out.println("Entrez:\n" + "1.indexer image\n" + "2.indexer son\n" + "3.indexer texte");
				choix = clavier.entrerClavierInt();	
				if(!(choix==1 || choix==2 || choix==3)) {
					System.out.println("Veuillez entrer 1, 2 ou 3");
				}
			}
			
			boolean OK = false;
			
			switch (choix) {
			case 1:
				OK = controlIndexation.indexer(TypeFichier.IMAGE);
				if(OK) {
					System.out.println("Indexation image réussi");
				}
				else
					System.out.println("Indexation à échoué");
				break;
				
			case 2:
				OK = controlIndexation.indexer(TypeFichier.SON);
				if(OK) {
					System.out.println("Indexation son réussi");
				}
				else
					System.out.println("Indexation à échoué");
				break;
				
			case 3:
				OK = controlIndexation.indexer(TypeFichier.TEXTE);
				if(OK) {
					System.out.println("Indexation texte réussi");
				}
				else
					System.out.println("Indexation à échoué");
				break;
				
			default:
				System.out.println("Type d'indexation non reconnue");
				break;
			}
		}
		
	}
	
}
