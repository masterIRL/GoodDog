#ifndef FILE_SON_H
#define FILE_SON_H

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "file_chaine.h"

typedef struct DESCRIPTEUR_SON{
    file_chaine File;
    int compteur;
    int taille_descripteur;
} Descripteur_Son;

void INIT_SON(Descripteur_Son* e);
void AFFICHE_SON(Descripteur_Son e);
void AFFECT_SON(Descripteur_Son *e, Descripteur_Son e2);

typedef struct CELLULE_SON cellule_son;
struct CELLULE_SON{
	Descripteur_Son e;
	cellule_son *suiv;
};

typedef struct FILE_SON file_son;
struct FILE_SON{
	int taille;
	cellule_son *tete;
	cellule_son *queue;
};


void INIT_FILE_SON(file_son *f);
int FILE_SON_EST_VIDE(file_son f);
void ENFILER_SON(file_son *f, Descripteur_Son val);
Descripteur_Son DEFILER_SON(file_son *f);
void AFFICHE_FILE_SON(file_son f);

#endif
