package testtextuel;

import control.ControlSIdentifier;
import vuetextuelle.BoundarySIdentifier;

public class testCasSIdentifier {

	public static void main(String[] args) {
		// Mise en place de l'environnement
		
		// Initialisation controleur du cas & cas Inclus/etendu
		ControlSIdentifier controlSIdentifier = new ControlSIdentifier();
		// Initialisation vue du cas
		BoundarySIdentifier boundarySIdentifier = new BoundarySIdentifier(controlSIdentifier);
		// Lancement du cas
		boundarySIdentifier.identification();
		// Verification de la bonne realisation du cas
		System.out.println("VERIFICATION");
		System.out.println(controlSIdentifier.visualiserAdmin());
		
		
		// Resultat du test
		// Veuilliez entrer votre login
		// Admin
		// Veuillez entrer votre mot de passe
		// admin
		// VERIFICATION
		// login=Admin, mdp=admin, connecte=true
	}

}
