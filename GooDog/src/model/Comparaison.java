package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vuetextuelle.Fichier;

public class Comparaison {

	public List<String> comparaisonTexte(String nom, int seuil) {
		// TODO Auto-generated method stub
		
		//Simulation resultat
		List<String> listTexte = new ArrayList<>();
		listTexte.add("15-Capturer_et_emprisonner_le_CO2,.xml");
		listTexte.add("15-Capturer_et_emprisonner_le_CO.xml");
		
		List<String> listTexte2 = new ArrayList<>();
		listTexte2.add("03-Mimer_un_signal_nerveux_pour.xml");
		listTexte2.add("05-Edition___les_mots_et.xml");
		listTexte2.add("05-Le_Colombien_Juan_Pablo_Montoya.xml");
		listTexte2.add("05-Photographie___Philip_Blenkinsop_a.xml");
		listTexte2.add("05-Rock___l_Illinois_magique_de.xml");
		listTexte2.add("06-US_Open___Mauresmo_et.xml");
		listTexte2.add("08-Carlos_do_Carmo____Le.xml");
		listTexte2.add("08-La_mission_Deep_Impact_permet.xml");
		listTexte2.add("09-Miracle___le_cricket_est.xml");
		listTexte2.add("10-Le_cyclone_Katrina_complique_le.xml");
		listTexte2.add("12-Agassi_plie_face_au_meilleur.xml");
		listTexte2.add("12-Jean-Marie_Sevestre,_libraire_et_PDG.xml");
		listTexte2.add("12-Musique_classique___un__Oberon_.xml");
		listTexte2.add("12-Musiques_du_monde___les.xml");
		listTexte2.add("13-Ligue_des_champions____Si.xml");
		listTexte2.add("14-Grippe_aviaire___l_OMS_exhorte.xml");
		listTexte2.add("15-Capturer_et_emprisonner_le_CO2,.xml");
		listTexte2.add("15-Capturer_et_emprisonner_le_CO.xml");
		listTexte2.add("15-La_mort_de_Robert_Wise,.xml");
		listTexte2.add("15-Lille_s_incline_dans_les.xml");
		listTexte2.add("15-_Si_on_veut_aller_trop.xml");
		listTexte2.add("15-Un_quasar_solitaire_bouleverse_les.xml");
		listTexte2.add("16-Une_sonde_japonaise_va_tenter.xml");
		listTexte2.add("18-Ligue_1___Lyon_a.xml");
		listTexte2.add("22-Danse___quarante_jeunes_de.xml");
		listTexte2.add("22-Des_laboureurs,_des_OGM..._et.xml");
		listTexte2.add("22-Grippe_aviaire___la_course.xml");
		listTexte2.add("22-Les_clubs_de_football_anglais.xml");
		listTexte2.add("23-Les_Bleus,_tombeurs_de_la.xml");
		listTexte2.add("26-Lyon_prend_ses_aises_en.xml");
		listTexte2.add("27-A_Lens,_le_Louvre_sera.xml");
		listTexte2.add("27-Le_Stade_de_France_s_ouvre.xml");
		listTexte2.add("28-A_Hossegor,_Kelly_Slater_peut.xml");
		listTexte2.add("28-Danse___Robyn_Orlin_et.xml");
		listTexte2.add("29-Ligue_des_champions___Lyon.xml");
		
		List<String> listTexte3 = new ArrayList<>();		
		
		if((nom.equals("15-Capturer_et_emprisonner_le_CO2,.xml") || nom.equals("15-Capturer_et_emprisonner_le_CO.xml")) && seuil > 40) {
			return listTexte;
		}
		if(seuil < 10) {
			return listTexte2;
		}
		else {
			return listTexte3;
		}
	}

	public List<String> comparaisonSon(String nom, int seuil) {
		// TODO Auto-generated method stub
		
		//Simulation resultat
		List<String> listSon = new ArrayList<>();
		listSon.add("corpus_fi.wav");
		listSon.add("jingle_fi.wav");
		
		List<String> listSon2 = new ArrayList<>();
		listSon2.add("corpus_fi.wav");
		
		List<String> listSon3 = new ArrayList<>();
		
		if(nom.equals("corpus_fi.wav") && seuil>30) {
			return listSon2;
		}
		if(seuil<=10) {
			return listSon;
		}
		else {
			return listSon3;
		}
	}

	public List<String> comparaisonImage(String nom, int seuil) {
		// TODO Auto-generated method stub
		
		//Simulation resultat
		List<String> listImage = new ArrayList<>();
		for(int i=0;i<10;i++) {
			listImage.add("0"+String.valueOf(i));
		}
		for(int i=10;i<64;i++) {
			listImage.add(String.valueOf(i));
		}
		
		List<String> listImage2 = new ArrayList<>();
		
		if(seuil < 5) {
			return listImage;
		}
		else {
			return listImage2;
		}
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
			imageRouge.add("17.jpg");//13,22 bleu
			imageRouge.add("16.jpg");//14, 16,17,38 rouge
			imageRouge.add("13.jpg");//32, 35, vert
			imageRouge.add("27.jpg");
			imageRouge.add("44.jpg");
			imageRouge.add("47.jpg");
			
			return imageRouge; // image rouge a 10%
			
		case 12:
			List<String> imageVert = new ArrayList<>();
			imageVert.add("32.jpg");
			imageVert.add("33.jpg");//13,22 bleu
			imageVert.add("34.jpg");//14, 16,17,38 rouge
			imageVert.add("35.jpg");//32, 35, vert
			return imageVert;
			
		case 3:
			List<String> imageBleu = new ArrayList<>();
			List<String> imageBleu2 = new ArrayList<>();
			imageBleu.add("34.jpg");
			imageBleu.add("35.jpg");

			if(pourcentage > 20) {
				return imageBleu;
			}
			else
				return imageBleu2;
			
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
		listMotCle.put("22-Les_clubs_de_football_anglais.xml",12);

		Map<String,Integer> listMotCle2= new HashMap<>();

		Map<String,Integer> listMotCle3= new HashMap<>();
		listMotCle3.put("16-Une_sonde_japonaise_va_tenter.xml",11);
		listMotCle3.put("22-Les_clubs_de_football_anglais.xml",9);
		listMotCle3.put("12-Agassi_plie_face_au_meilleur.xml",8);
		listMotCle3.put("05-Edition___les_mots_et.xml",7);
		listMotCle3.put("05-Rock___l_Illinois_magique_de.xml",7);
		listMotCle3.put("05-Le_Colombien_Juan_Pablo_Montoya.xml",6);
		listMotCle3.put("15-Capturer_et_emprisonner_le_CO2,.xml",6);
		listMotCle3.put("15-Capturer_et_emprisonner_le_CO.xml",6);
		
		/*Map<String,Integer> listMotCle4= new HashMap<>();
		listMotCle4.put("16-Une_sonde_japonaise_va_tenter.xml",11);
		listMotCle4.put("22-Les_clubs_de_football_anglais.xml",9);
		listMotCle4.put("12-Agassi_plie_face_au_meilleur.xml",8);*/
		
		Map<String,Integer> listMotCle5= new HashMap<>();
		listMotCle5.put("22-Les_clubs_de_football_anglais.xml",12);
		listMotCle5.put("13-Ligue_des_champions____Si.xml",5);
		listMotCle5.put("27-Le_Stade_de_France_s_ouvre.xml",5);

		ArrayList<Integer> configActuelle = new ArrayList<Integer>();
		configActuelle = new Fichier().lireInt("DESCRIPTEURS/configTexte.txt");
		if(mot.equals("football") && configActuelle.get(1)==6) {
			return listMotCle;
		}
		if(mot.equals("plus") && configActuelle.get(1)==6) {
			return listMotCle3;
		}
		/*if(mot=="plus" && occurence == 8) {
			return listMotCle4;
		}*/
		if(mot.equals("football") && configActuelle.get(1)==4) {
			return listMotCle5;
		}
		else {
			return listMotCle2;
		}
	}
	
	public List<String> comparaisonAudio(String nom, int occurence){
		
		List<String> listSon = new ArrayList<>();
		listSon.add("corpus_fi.wav");
		listSon.add("jingle_fi.wav");
		
		List<String> listSon2 = new ArrayList<>();
		listSon.add("corpus_fi.wav");
		
		List<String> listSon3 = new ArrayList<>();
		
		if(nom.equals("jingle_fi.wav") && occurence == 1) {
			return listSon;
		}
		if(nom.equals("corpus_fi.wav") && occurence == 1) {
			return listSon2;
		}
		else {
			return listSon3;
		}
	}

}
