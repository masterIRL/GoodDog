//======================================================================//
// Indexation texte
//======================================================================//
//Bibliotheque :
// - file.h : Permet de créer une file de chaine de char.
//======================================================================//

#include "file.h"

////////////////////////////////////////////////////////////////////////////////////
//////////////////////FILE//////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

/***************************************************************************
*celluleFile init_file ( )
*initialise la file
*retourne : la file initialisée
*param : rien
****************************************************************************/
celluleFile init_file ( )
{
	celluleFile f ;
	f.tete = NULL ;
	f.queue = NULL ;
	f.nb_element = 0;
	return f ;
}


/***************************************************************************
*int file_est_vide (celluleFile f)
*test si la file est vide
*retourne : le booléen symbolisant si la file est vide
*param :
*	- f : la file à tester
****************************************************************************/
int file_est_vide (celluleFile f)
{
  	return (f.tete == NULL); // on regarde si il y a une adresse
}


/***************************************************************************
*void enfilerEnQueue (celluleFile * f, element x)
*enfile un char en queue de file
*retourne : rien
*param :
*	- f : la file à enfiler
*	- x : élement à enfiler
****************************************************************************/
void enfilerEnQueue (celluleFile * f, element x)
{
	cellule* fileAux ;
	fileAux = (struct cellule_t *)malloc(sizeof(struct cellule_t));
	if (fileAux == NULL)
	printf("Erreur  => pas de rajout ");
	else
	{
		fileAux->info = x ;
		fileAux->suiv = NULL ;
		if (file_est_vide(*f))
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
*void enfilerEnTete (celluleFile * f, element x)
*enfile un char en tete de file
*retourne : rien
*param :
*	- f : la file à enfiler
*	- x : élement à enfiler
****************************************************************************/
void enfilerEnTete (celluleFile * f, element x)
{
	struct cellule_t * fileAux ;
	fileAux = (cellule *)malloc(sizeof(struct cellule_t));
	if (fileAux == NULL)
	printf("Erreur : file pleine => pas de rajout ");
	else
	{
		fileAux->info = x ;
		fileAux->suiv = f->tete ;
		if (file_est_vide(*f))
		{
			f->queue = fileAux ;
			f->nb_element =0;
		}
		f->tete = fileAux ;
		f->nb_element = (f->nb_element)+1;
	}
}


/***************************************************************************
*void defilerEnQueue (celluleFile * f,  element * x)
*depile un element de la file
*retourne : rien
*param :
*	- f : la file à defiler
*	- x : élement defilé
****************************************************************************/
void defilerEnQueue (celluleFile * f,  element * x)
{
	cellule * fileAux;
	cellule * fprec;
	//*result = 0 ;
	if (file_est_vide(*f))
	{
		// on ne fait rien
	}
	else
	{
		fileAux = f->tete ;
		fprec = NULL ;
		while (fileAux != f->queue)
		{
			fprec = fileAux ;
			fileAux = fileAux->suiv ;
		}
    	  	/* fileAux pointe sur la derniere cellule de la file*/
     		/* fprec pointe sur l’avant-derniere cellule de la file si elle existe */
		*x = fileAux->info ;
		f->queue = fprec; // on met a jour la derniere adresse dans f->queue
		if (fprec != NULL) fprec->suiv = NULL ;
		else f->tete = NULL ;
		f->nb_element = (f->nb_element)-1;
		free(fileAux);
		if (file_est_vide(*f))
		{
			f->queue = f->tete ;
			f->nb_element = 0;
		}
	}
}


/***************************************************************************
*void affichefile (celluleFile * file)
*affiche la file
*retourne : rien
*param :
*	- file : la file à afficher
****************************************************************************/
void afficherFile(celluleFile file)
{
	if (file.tete == NULL)       // si la file est vide on sort
	{
		printf("file vide\n" );
	}
	celluleFile actuel;
	actuel = file;
	while (actuel.tete != NULL) // On va parcourir la file jusqu'a trouvé le dernier élément qui aura pour adresse NULL
	{
		printf("%c", actuel.tete->info);
		actuel.tete = actuel.tete->suiv;
	}
	//printf("\n");
}


