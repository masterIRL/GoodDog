package model;

import java.util.ArrayList;
import java.util.List;

public class Comparaison {

	public List<String> comparaisonTexte(String nom, int seuil) {
		// TODO Auto-generated method stub
		
		//Simulation resultat
		List<String> listTexte = new ArrayList<>();
		listTexte.add("chamions_league.xml");
		listTexte.add("regles_du_football.xml");
		listTexte.add("transfert_de_Neymar.xml");
		listTexte.add("europa_league.xml");
		return listTexte;
	}

	public List<String> comparaisonSon(String nom, int seuil) {
		// TODO Auto-generated method stub
		
		//Simulation resultat
		List<String> listSon = new ArrayList<>();
		listSon.add("zouk.wav");
		listSon.add("sonerie1.wav");
		listSon.add("sonnerie2 .wav");
		listSon.add("radio_ups .wav");
		return listSon;
	}

	public List<String> comparaisonImage(String nom, int seuil) {
		// TODO Auto-generated method stub
		
		//Simulation resultat
		List<String> listImage = new ArrayList<>();
		listImage.add("1asri.png");
		listImage.add("PGE.png");
		listImage.add("YOUPSSITECH.png");
		listImage.add("ups.png");
		return listImage;
	}

	public List<String> comparaisonCouleur(int i, int pourcentage) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> comparaisonMotCle(String mot) {
		// TODO Auto-generated method stub
		return null;
	}

}
