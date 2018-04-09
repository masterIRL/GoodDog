#include "file_image.h"

//fonction qui permet d'initialiser la structure correspondant au descripteur
void INIT_IMAGE(Descripteur_Img* e){
	e->compteur=0;
	e->precision=0;
	INIT_FILE_INT(&(e->File));
}

//fonction qui permet d'afficher la structure correspondant a un descripteur
void AFFICHE_IMAGE(Descripteur_Img e){
	printf("ID %d n= %d\n", e.compteur,e.precision);
	AFFICHE_FILE_INT(e.File);
	printf("\n");
}

//fonction qui permet d'affecter un Descripteur_Img
void AFFECT_IMAGE(Descripteur_Img *e, Descripteur_Img e2){
	e->compteur=e2.compteur;
	e->precision=e2.precision;
	INIT_FILE_INT(&(e->File));
	while(!FILE_INT_EST_VIDE(e2.File)){
		ENFILER_INT( &(e->File), DEFILER_INT(&(e2.File)) );
	}
}





//fonction qui permet d'initialiser la file_image
void INIT_FILE_IMAGE(file_image *f){
	f->tete=NULL;
	f->queue=NULL;
	f->taille=0;
}

//fonction qui verifie si la file_image est vide ou pas
int FILE_IMAGE_EST_VIDE(file_image f){
	if (f.tete==NULL)
	{
		return 1;
	}
	else{
		return 0;
	}
}


//fonction qui permet d'ajouter un element a la file_Image
void ENFILER_IMAGE(file_image *f, Descripteur_Img val){
	cellule_image *courant = (cellule_image *)malloc(sizeof(cellule_image));
	if(courant != NULL && f != NULL){
		AFFECT_IMAGE(&(courant->e),val);
		if (f->tete == NULL)
		{
			f->tete = courant;
			f->queue = courant;
		}
		else{
			courant->suiv = NULL;
			f->queue->suiv = courant;
			f->queue = courant;
		}
		f->taille++;
	}
	else{
		printf("Erreur memoire enfiler_IMAGE\n");
	}
	
}


//fonction qui permet d'afficher la file_image
void AFFICHE_FILE_IMAGE(file_image f){

	cellule_image *courant = f.tete;
	if (courant == NULL)
	{
		printf("()\n");
	}
	else{
		while(courant != NULL)
		{
			AFFICHE_IMAGE(courant->e);
			courant = courant->suiv;
		}
	}
} 


//fonction qui permet d'ecrire un descripteur dans un fichier passé en parametre
void ECRIT_DESCRIPTEUR(Descripteur_Img e,FILE* ptr_chemin){
 
	

        fprintf(ptr_chemin,"ID %d n= %d", e.compteur,e.precision);
        fprintf(ptr_chemin,"\n");
	ECRIT_FILE_INT(e.File,ptr_chemin);
        fprintf(ptr_chemin,"\n");
	
	
}


//fonction qui permet d'ecrire toute la file dans un fichier passé en parametre
void ECRIT_FILE_DESCRIPTEUR(file_image f,FILE* ptr_chemin){

	cellule_image *courant = f.tete;
	if (courant == NULL)
	{
		printf("()\n");
	}
	else{
		while(courant != NULL)
		{
			ECRIT_DESCRIPTEUR(courant->e,ptr_chemin);
			courant = courant->suiv;
		}
	}
} 

