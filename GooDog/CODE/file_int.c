#include"file_int.h"

//fonction qui affiche un entier
void AFFICHE_INT(INT e){
	printf("%d ",e);
}

//fonction qui saisie un entier
void SAISIR_INT(INT *e){
	scanf("%d",e);}


//fonction qui permet d'affecter un entier
void AFFECT_INT(INT *e, INT e2){
	*e=e2;
}

//fonction analogue
void AFFECT_INT2(INT *e, int val){
	*e=val;
}


//fonction qui initialise la file
void INIT_FILE_INT(file_int *f){
	f->tete=NULL;
	f->queue=NULL;
	f->taille = 0;
}

//fonction qui verifie si la pile est vide ou pas
int FILE_INT_EST_VIDE(file_int f){
	if (f.tete==NULL)
	{
		return 1;
	}
	else{
		return 0;
	}
}


//fonction qui permet d'ajouter un element a la file
void ENFILER_INT(file_int *f, INT val){
	cellule_int *courant = (cellule_int *)malloc(sizeof(cellule_int));
	if(courant != NULL && f != NULL){
		AFFECT_INT(&(courant->e),val);
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
		printf("Erreur memoire file\n");
	}
	
}

//fonction qui permet de supprimer un element de la file
INT DEFILER_INT(file_int *f){
	INT val;
	AFFECT_INT2(&val,0);
	if (f != NULL)
	{
		if (FILE_INT_EST_VIDE(*f))
		{
			printf("Impossible de defiler, la file est vide\n");
		}
		else
		{
			cellule_int *courant = f->tete;
			AFFECT_INT(&val,courant->e);
			f->tete = courant->suiv;
			f->taille--;
			free(courant);
		}
	}
	return val;
}


//fonction qui permet d'afficher la file
void AFFICHE_FILE_INT(file_int f){

	cellule_int *courant = f.tete;
	if (courant == NULL)
	{
		printf("()\n");
	}
	else{
		while(courant != NULL)
		{
			AFFICHE_INT(courant->e);
			courant = courant->suiv;
		}
	}
} 


//fonction qui permet d'ecrire un element de la file dans un fichier passé en parametre
void ECRIT_INT(INT e,FILE* ptr_chemin){
        
	fprintf(ptr_chemin,"%d ",e);
        
}


//fonction qui permet d'ecrire toute la file dans un fichier passé en parametre
void ECRIT_FILE_INT(file_int f,FILE* ptr_chemin){
	
	cellule_int *courant = f.tete;
	if (courant == NULL)
	{
		printf("()\n");
	}
	else{
		while(courant != NULL)
		{
			ECRIT_INT(courant->e,ptr_chemin);
                        
			courant = courant->suiv;
		}
	
	}
	
} 





