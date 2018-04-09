#ifndef FILE_CHAINE_H
#define FILE_CHAINE_H

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef char* CHAINE;

CHAINE AFFECT_CHAINE(CHAINE e2);
CHAINE AFFECT_CHAINE2(char *val);
int COMPARE_CHAINE(CHAINE e, CHAINE e2);
void AFFICHE_CHAINE(CHAINE e);

typedef struct CELLULE_CHAINE cellule_chaine;
struct CELLULE_CHAINE{
	CHAINE e;
	cellule_chaine *suiv;
};

typedef struct FILE_CHAINE file_chaine;
struct FILE_CHAINE{
	int taille;
	cellule_chaine *tete;
	cellule_chaine *queue;
};


void INIT_FILE_CHAINE(file_chaine *f);
int FILE_CHAINE_EST_VIDE(file_chaine f);
void ENFILER_CHAINE(file_chaine *f, CHAINE val);
CHAINE DEFILER_CHAINE(file_chaine *f);
void AFFICHE_FILE_CHAINE(file_chaine f);

#endif

