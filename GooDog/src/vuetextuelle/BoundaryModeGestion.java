package vuetextuelle;

import control.ControlModeGestion;

public class BoundaryModeGestion {

	ControlModeGestion controlModeGestion;

	public BoundaryModeGestion(ControlModeGestion controlModeGestion) {
		this.controlModeGestion = controlModeGestion;
	}
	
	public void gestionMode() {
		Clavier clavier = new Clavier();
		System.out.println("Vous êtes en mode " + controlModeGestion.getStatut());
		System.out.println("Choisissez votre mode:\n" + "1. Activer le mode Ouvert\n" + "2. Désactivez le mode Fermé");
		int choix = clavier.entrerClavierInt();
		switch (choix) {
		case 1:
			if(!controlModeGestion.isOuvert()) {
				controlModeGestion.activerModeOuvert();
				System.out.println("Vous êtes passé en mode ouvert");
			}
			else
				System.out.println("Vous êtes déjà en mode ouvert");
			break;
			
		case 2:
			if(!controlModeGestion.isOuvert()) {
				controlModeGestion.desactiverModeOuvert();;
				System.out.println("Vous êtes déjà en mode fermé");
			}
			else
				System.out.println("Vous êtes passé en mode fermé");
			break;
			
		default:
			System.out.println("Choix non reconnu");
			break;
		}
	}
}
