package control;

import java.io.IOException;

import model.modeOuvert;

public class ControlModeGestion {

	private boolean ouvert = false;
	private String statut = "Fermé";
	private modeOuvert threadImageNB = new modeOuvert("../DATA/IMAGE/NB");
	private modeOuvert threadImageRGB = new modeOuvert("../DATA/IMAGE/RGB");
	private modeOuvert threadSon = new modeOuvert("../DATA/SON");
	private modeOuvert threadTexte = new modeOuvert("../DATA/TEXTE");
	
	public ControlModeGestion() {
	}
	
	public boolean isOuvert() {
		return ouvert;
	}
	
	public void activerModeOuvert() {
		this.ouvert = true;
		this.setStatut("Ouvert");
		try {
			this.threadImageNB.process();
			this.threadImageRGB.process();
			this.threadSon.process();
			this.threadTexte.process();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void desactiverModeOuvert() {
		this.ouvert = false;
		this.setStatut("Fermé");
		this.threadImageNB.arret(); // et interrupted le thread
		this.threadImageRGB.arret();
		this.threadSon.arret();
		this.threadTexte.arret();
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

}
