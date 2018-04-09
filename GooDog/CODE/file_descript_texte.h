//======================================================================//
// Indexation texte
//======================================================================//
// UPSSITECH SRI 2016-2017
// Auteur: Moulas Arnaud
// Date de création: 14/01/17
//======================================================================//
// Fichier C: file_descripteur_texte.c / Fichier H: file_descripteur_texte.h
//======================================================================//
//Bibliotheque :
// Permet de créer une file de descripteurs textes
//======================================================================//

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <assert.h>

#ifndef DESCRIPTEUR_TEXTE_H
#define DESCRIPTEUR_TEXTE_H
#include "descripteur_texte.h"
#endif

////////////////////////////////////////////////////////////////////////////////////
//////////////////////TYPE//////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

typedef Descripteur_texte element_texte;

typedef struct cellule_texte_t
{
element_texte  info;
struct   cellule_texte_t *    suiv;
}cellule_texte ;

typedef struct celluleFile_texte_t
{
struct cellule_texte_t *  tete ;
struct cellule_texte_t *  queue ;
int nb_element;
}celluleFile_texte;

////////////////////////////////////////////////////////////////////////////////////
//////////////////////FILE//////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

celluleFile_texte init_file_texte ( );

int file_est_vide_texte (celluleFile_texte f);

// ATTENTION ! fileAux == NULL
void enfilerEnTete_texte (celluleFile_texte * f, element_texte x);

// ATTENTION ! fileAux == NULL
void enfilerEnQueue_texte (celluleFile_texte * f, element_texte x);

// ATTENTION ! pile vide
void defilerEnQueue_texte (celluleFile_texte * f,  element_texte * x);


