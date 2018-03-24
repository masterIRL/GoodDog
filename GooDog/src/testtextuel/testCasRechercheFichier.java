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
		   football
		   
		   Rentrez le seuil (en pourcentage)
		   
		   200
		   
		   Le seuil doit etre en pourcentage et doit etre compris entre 0 et 100
		    
		   Rentrez le seuil (en pourcentage)
		   
		   -1
		   
	 	  Le seuil doit etre en pourcentage et doit etre compris entre 0 et 100
	 	  
	 	  Rentrez le seuil (en pourcentage)
	 	  
	 	  10
	 	  
	 	  Resulat de la requette : 

		  Liste des fichier Texte : football
		  chamions league.txt
		  regles du football.pdf
		  transfert de Neymar.docx
		  europa league.pdf
		  
		  seuil = 10
	
		*/
		
	}

}
