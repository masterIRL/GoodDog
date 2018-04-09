#include "pile_carac.h"

void AFFICHE_CARAC(CARAC e){
	printf("carac: %c\n",e);
}

void SAISIR_CARAC(CARAC *e){
	scanf("%c",e);
}

void AFFECT_CARAC(CARAC *e, CARAC e2){
	*e=e2;
}

void AFFECT_CARAC2(CARAC *e, char val){
	*e=val;
}

int COMPARE_CARAC(CARAC e, CARAC e2){
	if(e<e2){
		return -1;
	}
	
	if(e==e2){
		return 0;
	}
	
	if(e>e2){
		return 1;
	}
}



void INIT_PILE_CARAC(pile_carac *p){
    	p->tete=NULL;
    	p->taille=0;
}

int PILE_CARAC_EST_VIDE(pile_carac p){
	if (p.tete==NULL)
	{
		return 1;
	}
	else{
		return 0;
	}
}


void EMPILE_CARAC(pile_carac *p, CARAC val){
	cellule_carac *courant = (cellule_carac *)malloc(sizeof(cellule_carac));
	if(courant != NULL && p != NULL){
		courant->e=val;
		courant->suiv = p->tete;
		p->tete = courant;
		p->taille++;
	}
	else{
		printf("Erreur allocation empile_carac\n");
	}
	
}

CARAC DEPILE_CARAC(pile_carac *p){
	CARAC val;
	if (p != NULL)
	{
		if (PILE_CARAC_EST_VIDE(*p))
		{
			printf("Impossible de depile_carac, la pile_carac est vide\n");
		}
		else
		{
			cellule_carac *courant = p->tete;
			AFFECT_CARAC(&val,courant->e);
			p->tete = courant->suiv;
			p->taille--;
			free(courant);
		}
	}
	return val;
}

void AFFICHE_PILE_CARAC(pile_carac p){

	cellule_carac *courant = p.tete;
	if (courant == NULL)
	{
		printf("()\n");
	}
	else{
		while(courant != NULL)
		{
			AFFICHE_CARAC(courant->e);
			courant = courant->suiv;
		}
	}
} 