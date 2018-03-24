package model;

import java.util.ArrayList;
import java.util.List;

public class Comparaison {

	public List<String> comparaisonTexte(String nom, int seuil) {
		// TODO Auto-generated method stub
		
		//Simulation resultat
		List<String> listTexte = new ArrayList<>();
		listTexte.add("chamions league.xml");
		listTexte.add("regles du football.xml");
		listTexte.add("transfert de Neymar.xml");
		listTexte.add("europa league.xml");
		return listTexte;
	}

	public List<String> comparaisonSon(String nom, int seuil) {
		// TODO Auto-generated method stub
		
		//Simulation resultat
		List<String> listSon = new ArrayList<>();
		listSon.add("zouk.wav");
		listSon.add("sonerie 1.wav");
		listSon.add("sonnerie 2 .wav");
		listSon.add("radio ups .wav");
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

}
