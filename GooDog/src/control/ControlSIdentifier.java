package control;

import model.Admin;

public class ControlSIdentifier {

	private Admin admin = Admin.getInstance();
	
	public ControlSIdentifier() {
	}

	public void sIdentifier(String login, String mdp) {
		// TODO Auto-generated method stub
		admin.connexion(login, mdp);
	}
	
	public String visualiserAdmin() {
    	return admin.toString();
    }

}
