package vuetextuelle;

import control.ControlSIdentifier;

public class BoundarySIdentifier {

	ControlSIdentifier controlSIdentifier;
	
	public BoundarySIdentifier(ControlSIdentifier controlSIdentifier) {
		this.controlSIdentifier = controlSIdentifier;
	}

	public void identification() {
		Clavier clavier = new Clavier() ;
        System.out.println("Veuillez entrer votre login");
        String login = clavier.entrerClavierString();

        System.out.println("Veuillez entrer votre mot de passe");
        String mdp = clavier.entrerClavierString();

        controlSIdentifier.sIdentifier(login,mdp);
	}
}
