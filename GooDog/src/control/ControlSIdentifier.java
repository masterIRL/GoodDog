package control;

import model.Admin;
import vue.EcranAcceuil;
import vue.EcranConnexionAdmin;

public class ControlSIdentifier {

	private static ControlSIdentifier instance;
	private Admin admin = Admin.getInstance();

	private EcranAcceuil ecranAcceuil;
	

	public ControlSIdentifier(){

	}

	public static ControlSIdentifier getInstance() {
		if(instance == null){
			instance = new ControlSIdentifier();
		}
		return instance;
	}

	public boolean sIdentifier(String login, String mdp) {
		// TODO Auto-generated method stub
		return admin.connexion(login, mdp);
	}
	
	public String visualiserAdmin() {
    	return admin.toString();
    }

    //Afiche l'ecran de connexion admin
	public void showEcranConnexionAdmin() {
		EcranConnexionAdmin connexionAdmin = new EcranConnexionAdmin();
	}

	//Affiche et instancie l'ecranc d'acceuil
	//Ca devrait etre dans un Controller "principal"
	public void setEcranAcceuil(){
		ecranAcceuil = new EcranAcceuil();
	}
	//Affiche l'ecran d'acceuil en mode 'admin'
	public void setEcranAcceuilAdmin() {
		ecranAcceuil.setAcceuilAdmin();
	}
}
