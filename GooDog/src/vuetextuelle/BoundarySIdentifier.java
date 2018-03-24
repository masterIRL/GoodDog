package vuetextuelle;

import control.ControlSIdentifier;

public class BoundarySIdentifier {

	ControlSIdentifier controlSIdentifier;
	
	public BoundarySIdentifier(ControlSIdentifier controlSIdentifier) {
		this.controlSIdentifier = controlSIdentifier;
	}

	public void identification() {
		int i=0;
		boolean identifiantOk = false;
		Clavier clavier = new Clavier() ;
		
		while (!identifiantOk || i < 3) {
			System.out.println("Veuillez entrer votre login");
	        String login = clavier.entrerClavierString();
	
	        System.out.println("Veuillez entrer votre mot de passe");
	        String mdp = clavier.entrerClavierString();
	
	        identifiantOk = controlSIdentifier.sIdentifier(login,mdp);
	        if(identifiantOk)
	        	System.out.println("Identification correcte");
	        else
	        	System.out.println("Erreur de connection : Login ou mot de passe erroné !\n Il vous reste " + String.valueOf(3-i) + "tentatives");
	        i++;
		}
		
		if(i>=3) {
			System.out.println("Vous avez dépassé le nombre de tentatives");
		}
	}
}
