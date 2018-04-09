#ifndef ARBRE_H
#define ARBRE_H

#include <stdio.h>
#include <stdlib.h>

///////////////////////////////////////////////////////////////////////////////////////////////
//l'arbre est une structure composé de feuilles et permettant de trier des valeurs.
///////////////////////////////////////////////////////////////////////////////////////////////

typedef struct FEUILLE feuille;
struct FEUILLE
{
	int id;
	int racine;
	feuille* gauche;
	feuille* droite;
};

typedef feuille* arbre;


void INIT_ARBRE(arbre *a);
//Initialisation de l'arbre

int ARBRE_VIDE(arbre a);
//Renvoie un bouleen si l'arbre est vide

void addArbre(arbre *a, int valeur, int ident);
//Ajoute dans l'arbre une valeur et l'identifiant lié

int removeMin(arbre *a, int *ptr_valeur, int *ptr_id);
//Supprime la derniere valeur de l'arbre

void STRING_ARBRE(arbre a);
//Fait l'affichage de manière recursive

void AFFICHE_ARBRE(arbre a);
//amelioration de la "beauté" de l'affichage

#endif