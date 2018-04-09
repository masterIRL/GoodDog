//======================================================================//
// Indexation texte
//======================================================================//
// UPSSITECH SRI 2016-2017
// Auteur: Moulas Arnaud
// Date de création: 14/01/17
//======================================================================//
// Fichier C: descripteur_texte.c / Fichier H: descripteur_texte.h
//======================================================================//
//Bibliotheque :
// - desripteur_texte.h : Contient toutes les fonctions utile a la création d'un descripteur_texte
// - file_char.h : Permet de créer une file de chaine de char.
// - file.h : Permet de créer une file de char.
//======================================================================//

#include "descripteur_texte.h"

////////////////////////////////////////////////////////////////////////////////////
//////////////////////DESCRIPTION///////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

/***************************************************************************
*void filtrage(celluleFile * file_filtre_ponctuation,FILE * ptr_file)
*Permet de stocker tout le texte character par character dans une file. On filtrera les balises et la ponctuation.
*retourne : rien
*param : 
*	- file_filtre_ponctuation : la file qui sera allégée de sa ponctuation
*	- ptr_file : fichier à filtrer
****************************************************************************/
void filtrage(celluleFile * file_filtre_ponctuation,FILE * ptr_file)
{
  	char c;
  	while(c!= EOF)
  	{
    		c=fgetc(ptr_file);
    		if (c== '<')
    		{
      			while(c!='\0')
      			{
        			c=fgetc(ptr_file);
        			if(c == '>')
        			{
          				c = '\0';
          				enfilerEnTete(file_filtre_ponctuation, c);
        			}
      			}
    		}
    		else if (c == ',' || c == ';' || c==':' || c=='!' || c=='?' || c == '-' || c== ' '|| c== '(' || c == ')' || c == (char)39 || c == '\n' || c == '\r' || c == '.' || c== '+' || c== '%' )
    		{
      			c = '\0';
      			enfilerEnTete(file_filtre_ponctuation, c);
    		}
    		else if((c>=65)  && (c <= 90))
      		{
        		c+=32;
        		enfilerEnTete(file_filtre_ponctuation, c);
      		}
      		else
      		{
        		enfilerEnTete(file_filtre_ponctuation, c);
      		}
  	}
	fclose(ptr_file);
}


/***************************************************************************
*void filtrage_taille_mot(celluleFile * file_texte, file_chaine * file_texte_FitreMot, int * nb_total_mot, int FiltreMot)
*Permet de reconstituer les mots et filtres ceux qui sont inférieur a la taille demandé.
*retourne : rien
*param : 
*	- file_texte : la file contenant tout les characters à la suite
*	- file_texte_FitreMot : la file qui contiendra les mots supérieur à la limite
*	- nb_total_mot : compte le nombre de mots du texte
*	- FiltreMot : filtre les mots du texte paramétré en configuration
****************************************************************************/
void filtrage_taille_mot(celluleFile * file_texte, file_chaine * file_texte_FitreMot, int * nb_total_mot, int FiltreMot)
{
  	int cpt_mot =0, taille_mot =0;
  	char c;
  	int cpt_tab = 0;
  	int cpt_cat =0;
  	int int_valeur_limite = file_texte->nb_element;
  	*nb_total_mot =0;

  	// initialisation du tableau qui contiendra les chaines de characters de chaque mot.
  	char **tableau_cat = (char**)malloc(int_valeur_limite * sizeof(char *));
  	if (tableau_cat == NULL)
  	printf("Erreur  => malloc tableau_cat \n");

	// initiatlisation de chaque cases du tableau.
  	for (cpt_mot = 0; cpt_mot < int_valeur_limite ; ++cpt_mot) 
	{
    		tableau_cat[cpt_mot] = (char *)malloc(31);
    		if (tableau_cat[cpt_mot] == NULL)
    		printf("Erreur  => malloc tableau_cat dans les cases numero : %d\n", cpt_mot);
 	}
  	for (int i = 0 ; i <= int_valeur_limite; i++)
  	{
    		defilerEnQueue(file_texte,&c);
		//  printf("%c",c);
    		if(c=='\0')
    		{
			//  concatenation[cpt_cat][cpt_tab]= c;
			tableau_cat[cpt_cat][cpt_tab]= '\0';
      			*nb_total_mot=(*nb_total_mot)+1;
			if(strlen(tableau_cat[cpt_cat])>= FiltreMot) // filtrage des mot superieur au filtre
      			{
        			ENFILER_CHAINE(file_texte_FitreMot, tableau_cat[cpt_cat]); // sauvegarde des mots dans la file
      			}
      			cpt_cat ++;
      			cpt_tab=0;
      			taille_mot = 0;
  		}
  		else
  		{
    			tableau_cat[cpt_cat][cpt_tab] = c; // assemblage des mots
    			taille_mot++;
    			cpt_tab++;
  		}
	}		
}


/***************************************************************************
*int nombre_occurence(file_chaine file_texte_FitreMot, information_mot * tableau_histogramme, int cpt )
*Permet de reconstituer les mots et filtres ceux qui sont inférieur a la taille demandé.
*retourne : le nombre de mots indexés
*param : 
*	- file_texte_FitreMot : la file qui contient les mots supérieur à la limite donnée
*	- tableau_histogramme : tableau contenant les mots retenus pour le descripteurs
*	- cpt : donne l'indice pour trouver le mot a comparer dans le tableau_histogramme
****************************************************************************/
int nombre_occurence(file_chaine file_texte_FitreMot, information_mot * tableau_histogramme, int cpt )
{
  	int cpt_nombre_mot_histo = 1;
  	file_chaine actuel;
  	actuel = file_texte_FitreMot;
  	while (actuel.tete != NULL) // On va parcourir la file jusqu'a trouvé le dernier élément qui aura pour adresse NULL
  	{
      		if(strcmp(actuel.tete->e, tableau_histogramme[cpt].mot )==0) // comparaison des mots
      		{
          		cpt_nombre_mot_histo ++;
      		}
    		actuel.tete = actuel.tete->suiv;
	}
	return(cpt_nombre_mot_histo);
}


/***************************************************************************
*information_mot* histogramme_texte(file_chaine * file_texte_FitreMot, int * nombre_resulat, int Filtre_occurence )
*Créer l'histogramme du fichier texte permettant de reformer son descripteur.
*retourne : un histogramme sous forme de tableau contenant des structures composés de mots et de leur nombre d'occurences
*param : 
*	- nombre_resulat : nombre de mot retenus et insérés dans le tableau histogramme
*	- file_texte_FitreMot :  contient les mots supérieur à la limite. Il faut les trier pour retenir les plus pertinents
*	- Filtre_occcurence : filtre permettant de ne retenir que les mots ayant une occurence suffisante. Ce paramètre est séléctionné par la configuration.
****************************************************************************/
information_mot* histogramme_texte(file_chaine * file_texte_FitreMot, int * nombre_resulat, int Filtre_occurence )
{
  	*nombre_resulat =0;
  	 int cpt_dernier_tab =0;
  	int cpt_nombre_mot_histo =0;
  	// Initialisation du tableau histogramme
    	information_mot *tableau_histogramme = (information_mot*)malloc(file_texte_FitreMot->taille * sizeof(information_mot));
    	if (tableau_histogramme == NULL)
	//Initialisation des cases du tableau de la taille de la file.
    	for (int cpt = 0; cpt < file_texte_FitreMot->taille ; cpt++)
    	{
      		tableau_histogramme[cpt].mot = (char *)malloc(31);
      		if (tableau_histogramme[cpt].mot == NULL)
      		printf("Erreur  => malloc tableau_hisot dans les mot : %d\n", cpt);
    	}
	// Recopie des mots pertinents dans le tableau
    	int nombre_mot = file_texte_FitreMot->taille;
    	for(int cpt_histo = 0; cpt_histo <  nombre_mot; cpt_histo++)
    	{
      		if(cpt_histo == 0)  // Pour le premier mot on le mets directement dans le tableau
      		{
        		tableau_histogramme[0].mot=DEFILER_CHAINE(file_texte_FitreMot);
        		cpt_nombre_mot_histo =nombre_occurence(*file_texte_FitreMot, tableau_histogramme, 0);
        		tableau_histogramme[0].occurence = cpt_nombre_mot_histo;

        		if(Filtre_occurence <= cpt_nombre_mot_histo) // mais si son nombre d'occurence est inférieur à la limite donné par l'utilisateur on n'incrémente pas le compteur. La case 0 du tableau sera donc écrasé par une nouvelle valeur.
        		{
          			*nombre_resulat = *nombre_resulat +1;
          			cpt_dernier_tab++;
        		}
      		}
      		else // si le ce n'est pas le premier du tableau il faudra tester sa présence dans le tableau pour savoir si il a déja été traité
      		{
        		int test_presence =0;
        		char * mot_comparer;
        		mot_comparer=DEFILER_CHAINE(file_texte_FitreMot);
        		for(int k = 0 ; k < cpt_dernier_tab; k++)
        		{
         			if(strcmp(tableau_histogramme[k].mot, mot_comparer)!=0)
        			{
          				test_presence = 0; //pas présent
        			}
        			else
        			{
          				test_presence =1; //déja présent
          				k = cpt_histo;
        			}
      			}
        		if(test_presence == 1)
        		{
          			//vide car on a détecter la présence du mot
        		}
        		else // on ajoute le mot à au tableua histogramme
        		{
          			tableau_histogramme[cpt_dernier_tab].mot = mot_comparer;
          			cpt_nombre_mot_histo = nombre_occurence(*file_texte_FitreMot, tableau_histogramme, cpt_dernier_tab);
          			tableau_histogramme[cpt_dernier_tab].occurence = cpt_nombre_mot_histo;
          			if(Filtre_occurence <= cpt_nombre_mot_histo) // si le nombre d'occurence est suffisant on incrémente l'indice du tableau pour passer a la case suivante
          			{
                			*nombre_resulat = *nombre_resulat +1;
                			cpt_dernier_tab++;
          			}
          			else // sinon on efface le mot précedent car sinon à la fin du cycle on aura un mot en trop en fin d'histogramme qui ne sera pas pertinent
          			{
            				tableau_histogramme[cpt_dernier_tab].mot = NULL;
          			}
        		}
      		}
    	}
    	return(tableau_histogramme);
}


/***************************************************************************
*Descripteur_texte DESCRIPTEUR_TEXTE(int ident,char* c_nom, int FiltreMot, int Filtre_occurence, char* Chemin_dossier )
*Fonction qui retourne le descripteur_texte avec l'attribution de valeur a chaque champ de la structure. Il s'agit de la fonction qui devra être appelée pour une indexation.
*retourne : une structue Descripteur_texte contenant toutes les informations nécessaire pour le descripteur_texte
*param : 
*	- indent : identifiant du documents
*	- c_nom : chaine de caractere du nom du document
*	- FiltreMot : filtre les mots du texte paramétré en configuration
*	- Filtre_occcurence : filtre permettant de ne retenir que les mots ayant une occurence suffisante. Ce paramètre est séléctionné par la configuration.
*	- Chemin_dossier : permet d'accéder à un dossier différent
****************************************************************************/
Descripteur_texte DESCRIPTEUR_TEXTE(int ident,char* c_nom, int FiltreMot, int Filtre_occurence, char* Chemin_dossier )
{
  	int nombre_resulat;
  	char nom_mot[60];
  	char chemin_global[140];
  	FILE *ptr_file;
  	celluleFile file_texte;
  	file_chaine file_texte_FitreMot;
  	information_mot* tableau_histogramme;
  	int nb_total_mot;
 	Descripteur_texte descripteur;

	strcpy(nom_mot, c_nom);
	strcpy(chemin_global,"");
	strcat(chemin_global,Chemin_dossier);
	strcat(chemin_global,nom_mot);

	ptr_file =fopen(chemin_global,"r"); // concatenation du chemin

	if (ptr_file == NULL)  
	{
		printf("erreur ouverture fichier");
		exit(EXIT_FAILURE);
	}

	file_texte =  init_file();
	INIT_FILE_CHAINE(&file_texte_FitreMot);
	filtrage(&file_texte, ptr_file);
	filtrage_taille_mot(&file_texte, &file_texte_FitreMot, &nb_total_mot, FiltreMot);
	tableau_histogramme = histogramme_texte(&file_texte_FitreMot, &nombre_resulat, Filtre_occurence);
        
        
	// Apres toutes les opérations de filtrage on rempli le descripteur.
	descripteur.int_identifiant =ident;
	descripteur.nb_mot_complet = nb_total_mot;
	descripteur.nb_mot = nombre_resulat;
	descripteur.tableau = tableau_histogramme;


	return(descripteur); // on retourne le descripteur final
}


