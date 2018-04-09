#include"file_chaine.h"


CHAINE AFFECT_CHAINE(CHAINE e2){
	CHAINE e;
	e = calloc(strlen(e2),2*sizeof(char));
	strcpy(e,e2);
	return e;
} 

CHAINE AFFECT_CHAINE2(char *val){
	CHAINE e;
	e = calloc(strlen(val),sizeof(char));
	strcpy(e,val);
	return e;
}

int COMPARE_CHAINE(CHAINE e, CHAINE e2){
	return strcmp(e,e2);
}

void AFFICHE_CHAINE(CHAINE e){
	printf("%s ", e);
}




void INIT_FILE_CHAINE(file_chaine *f){
	f->taille=0;
	f->tete=NULL;
	f->queue=NULL;
}

int FILE_CHAINE_EST_VIDE(file_chaine f){
	if (f.tete==NULL)
	{
		return 1;
	}
	else{
		return 0;
	}
}


void ENFILER_CHAINE(file_chaine *f, CHAINE val){
	cellule_chaine *courant = (cellule_chaine *)malloc(sizeof(cellule_chaine));
	if(courant != NULL && f != NULL){
		courant->e = AFFECT_CHAINE(val);
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
		printf("Erreur memoire enfiler_chaine\n");
	}
	
}

CHAINE DEFILER_CHAINE(file_chaine *f){
	CHAINE val;
	val=AFFECT_CHAINE2("");
	if (f != NULL)
	{
		if (FILE_CHAINE_EST_VIDE(*f))
		{
			printf("Impossible de defiler, la file est vide\n");
		}
		else
		{
			cellule_chaine *courant = f->tete;
			val=AFFECT_CHAINE(courant->e);
			f->tete = courant->suiv;
			f->taille--;
			free(courant);
		}
	}
	return val;
}


void AFFICHE_FILE_CHAINE(file_chaine f){

	cellule_chaine *courant = f.tete;
	if (courant == NULL)
	{
		printf("()\n");
	}
	else{
		while(courant != NULL)
		{
			AFFICHE_CHAINE(courant->e);
			courant = courant->suiv;
		}
	}
} 







