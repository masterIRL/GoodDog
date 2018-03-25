package vuetextuelle;

import control.ControlModeGestion;

public class BoundaryModeGestion {

	ControlModeGestion controlModeGestion;

	public BoundaryModeGestion(ControlModeGestion controlModeGestion) {
		this.controlModeGestion = controlModeGestion;
	}
	
	public void gestionMode() {
		Clavier clavier = new Clavier();
		System.out.println("Vous �tes en mode " + controlModeGestion.getStatut());
		System.out.println("Choisissez votre mode:\n" + "1. Activer le mode Ouvert\n" + "2. D�sactivez le mode Ferm�");
		int choix = clavier.entrerClavierInt();
		switch (choix) {
		case 1:
			if(!controlModeGestion.isOuvert()) {
				controlModeGestion.activerModeOuvert();
				System.out.println("Vous �tes pass� en mode ouvert");
			}
			else
				System.out.println("Vous �tes d�j� en mode ouvert");
			break;
			
		case 2:
			if(!controlModeGestion.isOuvert()) {
				controlModeGestion.desactiverModeOuvert();;
				System.out.println("Vous �tes d�j� en mode ferm�");
			}
			else
				System.out.println("Vous �tes pass� en mode ferm�");
			break;
			
		default:
			System.out.println("Choix non reconnu");
			break;
		}
	}
}
