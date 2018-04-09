#ifndef PILE_CARAC_H
#define PILE_CARAC_H

#include<stdio.h>
#include<stdlib.h>

typedef char CARAC;

void AFFICHE_CARAC(CARAC e);
void SAISIR_CARAC(CARAC *e);
void AFFECT_CARAC(CARAC *e, CARAC e2);
void AFFECT_CARAC2(CARAC *e, char val);
int COMPARE_CARAC(CARAC e, CARAC e2);

typedef struct CELLULE_CARAC cellule_carac;
struct CELLULE_CARAC{
	CARAC e;
	cellule_carac *suiv;
};

typedef struct PILE_CARAC pile_carac;
struct PILE_CARAC{
	int taille;
	cellule_carac *tete;
};

void INIT_PILE_CARAC(pile_carac *p);
int PILE_CARAC_EST_VIDE(pile_carac p);
void EMPILE_CARAC(pile_carac *p, CARAC val);
CARAC DEPILE_CARAC(pile_carac *p);
void AFFICHE_PILE_CARAC(pile_carac p);

#endif