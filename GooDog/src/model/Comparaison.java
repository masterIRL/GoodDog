package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comparaison {

	public List<String> comparaisonTexte(String nom, int seuil) {
		// TODO Auto-generated method stub
		
		//Simulation resultat
		List<String> listTexte = new ArrayList<>();
		listTexte.add("05-Edition___les_mots_et.xml");
		listTexte.add("05-Le_Colombien_Juan_Pablo_Montoya.xml");
		listTexte.add("15-Capturer_et_emprisonner_le_CO.xml");
		listTexte.add("27-Le_Stade_de_France_s_ouvre.xml");
		return listTexte;
	}

	public List<String> comparaisonSon(String nom, int seuil) {
		// TODO Auto-generated method stub
		
		//Simulation resultat
		List<String> listSon = new ArrayList<>();
		listSon.add("corpus_fi.wav");
		listSon.add("jingle_fi.wav");
		return listSon;
	}

	public List<String> comparaisonImage(String nom, int seuil) {
		// TODO Auto-generated method stub
		
		//Simulation resultat
		List<String> listImage = new ArrayList<>();
		listImage.add("10.jpg");
		listImage.add("20.jpg");
		listImage.add("30.jpg");
		listImage.add("40.jpg");
		return listImage;
	}

	public List<String> comparaisonCouleur(int i, int pourcentage) {
		// TODO Auto-generated method stub
		
		//simulation
		switch(i) {
		case 63:
			List<String> imageBlanc = new ArrayList<>();
			imageBlanc.add("18.jpg");//32, 35, vert
			imageBlanc.add("26.jpg");//14, 16,17,38 rouge
			imageBlanc.add("27.jpg");//13,22 bleu
			imageBlanc.add("47.jpg");
			return imageBlanc;
			
		case 48:
			List<String> imageRouge = new ArrayList<>();
			imageRouge.add("14.jpg");
			imageRouge.add("16.jpg");//13,22 bleu
			imageRouge.add("17.jpg");//14, 16,17,38 rouge
			imageRouge.add("38.jpg");//32, 35, vert
			return imageRouge;
			
		case 12:
			List<String> imageVert = new ArrayList<>();
			imageVert.add("32.jpg");
			imageVert.add("33.jpg");//13,22 bleu
			imageVert.add("34.jpg");//14, 16,17,38 rouge
			imageVert.add("35.jpg");//32, 35, vert
			return imageVert;
			
		case 3:
			List<String> imageBleu = new ArrayList<>();
			imageBleu.add("13.jpg");
			imageBleu.add("20.jpg");//14, 16,17,38 rouge
			imageBleu.add("21.jpg");//32, 35, vert
			imageBleu.add("46.jpg");//13,22 bleu
			return imageBleu;
			
		case 0:
			List<String> imagesNoire = new ArrayList<>();
			imagesNoire.add("04.jpg");
			imagesNoire.add("12.jpg");//13,22,49 bleu
			imagesNoire.add("08.jpg");//14, 16,17,38 rouge
			imagesNoire.add("11.jpg");//32, 35, vert
			return imagesNoire;
		}
		return null;
	}

	public Map<String,Integer> comparaisonMotCle(String mot) {
		
		// TODO Auto-generated method stub
		Map<String,Integer> listMotCle= new HashMap<>();

		listMotCle.put("Damso",11);
		listMotCle.put("monsterHunter",10);
		listMotCle.put("OrangeBud",9);
		listMotCle.put("TheWeeknd",8);

		return listMotCle;
	}
	
	public List<String> comparaisonAudio(String nom, int occurence){
		return null;
	}

}
