package control;

import model.modeOuvertThread;

public class ControlModeGestion {

	private boolean ouvert = false;
	private String statut = "Fermé";
	private modeOuvertThread threadImageNB = new modeOuvertThread("DATA/IMAGE/NB");
	private modeOuvertThread threadImageRGB = new modeOuvertThread("DATA/IMAGE/RGB");
	private modeOuvertThread threadSon = new modeOuvertThread("DATA/SON");
	private modeOuvertThread threadTexte = new modeOuvertThread("DATA/TEXTE");
	
	public ControlModeGestion() {
	}
	
	public boolean isOuvert() {
		return ouvert;
	}
	
	public void activerModeOuvert() {
		this.ouvert = true;
		this.setStatut("Ouvert");
		this.threadImageNB.start();
		this.threadImageRGB.start();
		this.threadSon.start();
		this.threadTexte.start();
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
