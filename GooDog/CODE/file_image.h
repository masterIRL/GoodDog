#ifndef FILE_IMAGE_H
#define FILE_IMAGE_H

#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#include<string.h>

#include"file_int.h"

///////////////////////////////////////////////////////////////////////////////////////////////
//la file_image est une file composé d'elements du type Descripteur_Img
//chaque element est une structure composé d'une file_int representant l'histogramme
//d'un compteur representant l'identifiant du descripteur
//de la precision representant le nombre de bits de quantification 
///////////////////////////////////////////////////////////////////////////////////////////////


typedef struct DESCRIPTEUR_IMAGE Descripteur_Img;
struct DESCRIPTEUR_IMAGE{
	int compteur;
	int precision;
	file_int File; 
};



void INIT_IMAGE(Descripteur_Img* e);
//fonction qui permet d'initialiser la structure correspondant au descripteur

void AFFICHE_IMAGE(Descripteur_Img e);
//fonction qui permet d'afficher la structure correspondant a un descripteur

void AFFECT_IMAGE(Descripteur_Img *e, Descripteur_Img e2);
//fonction qui permet d'affecter un Descripteur_Img


typedef struct CELLULE_IMAGE cellule_image;
struct CELLULE_IMAGE{
	Descripteur_Img e;
	cellule_image *suiv;
};

typedef struct FILE_IMAGE file_image;
struct FILE_IMAGE{
	int taille;
	cellule_image *tete;
	cellule_image *queue;
};


void INIT_FILE_IMAGE(file_image *f);
//fonction qui permet d'initialiser la file_image

int FILE_IMAGE_EST_VIDE(file_image f);
//fonction qui verifie si la file_image est vide ou pas

void ENFILER_IMAGE(file_image *f, Descripteur_Img val);
//fonction qui permet d'ajouter un element a la file_Image

void AFFICHE_FILE_IMAGE(file_image f);
//fonction qui permet d'afficher la file_image

void ECRIT_DESCRIPTEUR(Descripteur_Img e,FILE* ptr_chemin);
//fonction qui permet d'ecrire un descripteur dans un fichier passé en parametre

void ECRIT_FILE_DESCRIPTEUR(file_image f,FILE* ptr_chemin);
//fonction qui permet d'ecrire toute la file dans un fichier passé en parametre

#endif
