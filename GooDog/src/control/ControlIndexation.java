package control;

import model.Indexeur;
import model.TypeFichier;

public class ControlIndexation {
	
	ControlVerifierIdentification controlVerifierIdentification;
	Indexeur indexeur = new Indexeur();

	public ControlIndexation(ControlVerifierIdentification controlVerifierIdentification) {
		this.controlVerifierIdentification = controlVerifierIdentification;
	}

	public boolean verifierIdentification() {
		return controlVerifierIdentification.verifierIdentification();
	}	

	public boolean indexer(TypeFichier fichier) {
		boolean OK = false;
		switch (fichier) {
		case IMAGE:
			OK = indexeur.indexerImage();
			//verifier le fichier descripteur image
			break;
			
		case SON:
			OK = indexeur.indexerSon();
			//verifier le fichier descripteur son
			break;
			
		case TEXTE:
			OK = indexeur.indexerTexte();
			//verifier le fichier descripteur texte
			break;
		}
		return OK;
	}
	
	
}
