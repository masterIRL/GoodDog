//======================================================================//
// Indexation texte
//======================================================================//
//Bibliotheque :
// - file_descripteur_texte.h : Permet de créer une file de descripteurs textes
// - descripteur_texte.h : Déclare et opère sur les structures de type Descripteur_texte
//======================================================================//

#include "file_descript_texte.h"

////////////////////////////////////////////////////////////////////////////////////
//////////////////////FILE//////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

/***************************************************************************
*celluleFile_texte init_file_texte ( )
*initialise la file
*retourne : la file initialisée
*param : rien
****************************************************************************/
celluleFile_texte init_file_texte ( )
{
  	celluleFile_texte f ;
  	f.tete = NULL ;
  	f.queue = NULL ;
  	f.nb_element = 0;
  	return f ;
}


/***************************************************************************
*int file_est_vide_texte (celluleFile_texte f)
*test si la file est vide
*retourne : le booléen symbolisant si la file est vide
*param :
*	- f : la file à tester
****************************************************************************/
int file_est_vide_texte (celluleFile_texte f)
{
  	return (f.tete == NULL); // on regarde si il y a une adresse
}


/***************************************************************************
*void enfilerEnQueue_texte (celluleFile_texte * f, element_texte x)
*enfile un descripteur texte en queue de file
*retourne : rien
*param :
*	- f : la file à enfiler
*	- x : élement à enfiler
****************************************************************************/
void enfilerEnQueue_texte (celluleFile_texte * f, element_texte x)
{
  	cellule_texte* fileAux ;
	fileAux = (struct cellule_texte_t *)malloc(sizeof(struct cellule_texte_t));
  	if (fileAux == NULL)
  	printf("Erreur  => pas de rajout ");
  	else
  	{
   		fileAux->info = x ;
    		fileAux->suiv = NULL ;
    		if (file_est_vide_texte(*f))
    		{
      			f->queue = fileAux ;
      			f->tete = fileAux ;
      			f->nb_element = 1;
    		}
    		else
    		{
      			f->queue->suiv = fileAux ;
      			f->queue = fileAux ;
      			f->nb_element = (f->nb_element)+1;
    		}
  	}
}


/***************************************************************************
*void enfilerEnTete_texte (celluleFile_texte * f, element_texte x)
*enfile un descripteur texte en tete de file
*retourne : rien
*param :
*	- f : la file à enfiler
*	- x : élement à enfiler
****************************************************************************/
void enfilerEnTete_texte (celluleFile_texte * f, element_texte x)
{
  	struct cellule_texte_t * fileAux ;
	fileAux = (cellule_texte *)malloc(sizeof(struct cellule_texte_t));
  	if (fileAux == NULL)
  	printf("Erreur : file pleine => pas de rajout ");
  	else
  	{
    		fileAux->info = x ;
    		fileAux->suiv = f->tete ;
    	if (file_est_vide_texte(*f))
    	{
      		f->queue = fileAux ;
      		f->nb_element =0;
    	}
      	f->tete = fileAux ;
      	f->nb_element = (f->nb_element)+1;
    }
}


/***************************************************************************
*void defilerEnQueue_texte (celluleFile_texte * f,  element_texte * x)
*depile un element de la file
*retourne : rien
*param :
*	- f : la file à defiler
*	- x : élement defilé
****************************************************************************/
void defilerEnQueue_texte (celluleFile_texte * f,  element_texte * x)
{
    	cellule_texte * fileAux;
    	cellule_texte * fprec;
    	//*result = 0 ;
    	if (file_est_vide_texte(*f))
    	printf("Erreur : file vide => pas de suppression ") ;
    	else
    	{
      		fileAux = f->tete ;
      		fprec = NULL ;
      		while (fileAux != f->queue)
      		{
			fprec = fileAux ;
        		fileAux = fileAux->suiv ;
      		}
      		/* fileAux pointe sur la derniere cellule de la file */
      		/* fprec pointe sur l’avant-derniere cellule de la file si elle existe */
      		*x = fileAux->info ;
      		f->queue = fprec; // on met a jour la derniere adresse dans f->queue
      		if (fprec != NULL) fprec->suiv = NULL ;
      		else f->tete = NULL ;
      		f->nb_element = (f->nb_element)-1;
      		free(fileAux);
      		if (file_est_vide_texte(*f))
      		{
        		f->queue = f->tete ;
        		f->nb_element = 0;
      		}

	}
}


