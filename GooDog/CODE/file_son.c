#include "file_son.h"


void INIT_SON(Descripteur_Son* e){
	e->compteur=0;
        e->taille_descripteur=0;
	INIT_FILE_CHAINE(&(e->File));
}

void AFFICHE_SON(Descripteur_Son e){
	printf("ID %d \n", e.compteur);
	AFFICHE_FILE_CHAINE(e.File);
	printf("\n");
}


void AFFECT_SON(Descripteur_Son *e, Descripteur_Son e2){
	CHAINE x;
	e->compteur=e2.compteur;
        e->taille_descripteur = e2.taille_descripteur;
	INIT_FILE_CHAINE(&(e->File));
	while(!FILE_CHAINE_EST_VIDE(e2.File)){
		x = DEFILER_CHAINE(&(e2.File));
		ENFILER_CHAINE(&(e->File), x);
	}
}



void INIT_FILE_SON(file_son *f){
	f->tete=NULL;
	f->queue=NULL;
	f->taille=0;
}

int FILE_SON_EST_VIDE(file_son f){
	if (f.tete==NULL)
	{
		return 1;
	}
	else{
		return 0;
	}
}


void ENFILER_SON(file_son *f, Descripteur_Son val){
	cellule_son *courant = (cellule_son *)malloc(sizeof(cellule_son));
	if(courant != NULL && f != NULL){
		AFFECT_SON(&(courant->e),val);
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
		printf("Erreur memoire enfiler_son\n");
	}
	
}

Descripteur_Son DEFILER_SON(file_son *f){
	Descripteur_Son val;
	val.compteur=0;
        val.taille_descripteur=0;
	INIT_FILE_CHAINE(&(val.File));
	if (f != NULL)
	{
		if (FILE_SON_EST_VIDE(*f))
		{
			printf("Impossible de defiler, la file est vide\n");
		}
		else
		{
			cellule_son *courant = f->tete;
			AFFECT_SON(&val,courant->e);
			f->tete = courant->suiv;
			f->taille--;
			free(courant);
		}
	}
	return val;
}


void AFFICHE_FILE_SON(file_son f){
	cellule_son *courant = f.tete;
	if (courant == NULL)
	{
		printf("()\n");
	}
	else{
		while(courant != NULL)
		{
			AFFICHE_SON(courant->e);
			courant = courant->suiv;
		}
	}
}
