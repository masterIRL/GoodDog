#ifndef FILE_INT_H
#define FILE_INT_H

#include<stdio.h>
#include<stdlib.h>

/////////////////////////////////////////////////////////////////////////////////////////////////
//la file_int est une file d'entier
//elle represente un histogramme
/////////////////////////////////////////////////////////////////////////////////////////////////

typedef int INT;

void AFFICHE_INT(INT e);
//fonction qui affiche un entier

void SAISIR_INT(INT *e);
//fonction qui saisie un entier

void AFFECT_INT(INT *e, INT e2);
//fonction qui permet d'affecter un entier

void AFFECT_INT2(INT *e, int val);
//fonction analogue


typedef struct CELLULE_INT cellule_int;
struct CELLULE_INT{
	INT e;
	cellule_int *suiv;
};

typedef struct FILE_INT file_int;
struct FILE_INT{
	int taille;
	cellule_int *tete;
	cellule_int *queue;
};


void INIT_FILE_INT(file_int *f);
//fonction qui initialise la file

int FILE_INT_EST_VIDE(file_int f);
//fonction qui verifie si la pile est vide ou pas

void ENFILER_INT(file_int *f, INT val);
//fonction qui permet d'ajouter un element a la file

INT DEFILER_INT(file_int *f);
//fonction qui permet de supprimer un element de la file

void AFFICHE_FILE_INT(file_int f);
//fonction qui permet d'afficher la file

void ECRIT_INT(INT e,FILE* ptr_chemin);
//fonction qui permet d'ecrire un element de la file dans un fichier passé en parametre

void ECRIT_FILE_INT(file_int f,FILE* ptr_chemin);
//fonction qui permet d'ecrire toute la file dans un fichier passé en parametre


#endif
