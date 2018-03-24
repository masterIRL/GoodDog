package control;

import model.Admin;

public class ControlVerifierIdentification {
	
	private Admin admin = Admin.getInstance();

	public ControlVerifierIdentification() {
	}
	
	public boolean verifierIdentification() {
		return admin.isConnecte();
	}
	
}
