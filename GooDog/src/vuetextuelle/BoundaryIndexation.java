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
					System.out.println("Indexation image r�ussi");
				}
				else
					System.out.println("Indexation � �chou�");
				break;
				
			case 2:
				OK = controlIndexation.indexer(TypeFichier.SON);
				if(OK) {
					System.out.println("Indexation son r�ussi");
				}
				else
					System.out.println("Indexation � �chou�");
				break;
				
			case 3:
				OK = controlIndexation.indexer(TypeFichier.TEXTE);
				if(OK) {
					System.out.println("Indexation texte r�ussi");
				}
				else
					System.out.println("Indexation � �chou�");
				break;
				
			default:
				System.out.println("Type d'indexation non reconnue");
				break;
			}
		}
		
	}
	
}
