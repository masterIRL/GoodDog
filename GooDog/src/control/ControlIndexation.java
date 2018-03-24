package control;

import model.FabriqueDescripteurs;
import model.TypeFichier;

public class ControlIndexation {
	
	ControlVerifierAdmin controlVerifierAdmin;
	FabriqueDescripteurs fabriqueDescripteurs = new FabriqueDescripteurs();

	public boolean verifierIdentification() {
		return controlVerifierAdmin.verifierIdentification();
	}	

	public boolean indexer(TypeFichier fichier) {
		boolean OK = true;
		switch (fichier) {
		case IMAGE:
			fabriqueDescripteurs.indexerImage();
			//verifier le fichier descripteur image
			break;
			
		case SON:
			fabriqueDescripteurs.indexerSon();
			//verifier le fichier descripteur son
			break;
			
		case TEXTE:
			fabriqueDescripteurs.indexerTexte();
			//verifier le fichier descripteur texte
			break;
		}
		return OK;
	}
	
	
}
