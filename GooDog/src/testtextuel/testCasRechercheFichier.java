package testtextuel;

import control.ControlRecherche;
import vuetextuelle.BoundaryRechercheFichier;

public class testCasRechercheFichier {

	public static void main(String[] args) {

		ControlRecherche control = new ControlRecherche();
		BoundaryRechercheFichier boundaryRechercherFichier = new BoundaryRechercheFichier(control);
		boundaryRechercherFichier.rechercheFichier();
		
		
		
		//resulat : 
		
		/* 
		   1 Rechercher un fichier Texte
		   2 Rechercher un fichier Son
		   3 Rechercher un fichier Image
		   
		   4
		   
		   Veuillez rentrer 1,2 ou 3
		   
		   1 Rechercher un fichier Texte
		   2 Rechercher un fichier Son
		   3 Rechercher un fichier Image
		   
		   1
		   
		   Rentrez le nom du fichier
		   champions_league.xml
		   
		   Rentrez le seuil (en pourcentage)
		   
		   200
		   
		   Le seuil doit etre en pourcentage et doit etre compris entre 0 et 100
		    
		   Rentrez le seuil (en pourcentage)
		   
		   -1
		   
	 	  Le seuil doit etre en pourcentage et doit etre compris entre 0 et 100
	 	  
	 	  Rentrez le seuil (en pourcentage)
	 	  
	 	  10
	 	  
	 	  Resulat de la requette: 'champions_league.xml'		similaire à 10% :
	 	  1 : chamions_league.xml
	 	  2 : regles_du_football.xml
	 	  3 : transfert_de_Neymar.xml
	 	  4 : europa_league.xml
		*/
		
	}

}
