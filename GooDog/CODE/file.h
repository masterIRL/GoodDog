//======================================================================//
// Indexation texte
//======================================================================//
//Bibliotheque :
// Permet de créer une file de chaine de char.
//======================================================================//
#ifndef FILE_H
#define FILE_H
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <assert.h>

////////////////////////////////////////////////////////////////////////////////////
//////////////////////TYPE//////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

typedef char element;
typedef struct cellule_t
{
element  info;
struct   cellule_t *    suiv;
}cellule ;

typedef struct celluleFile_t
{
struct cellule_t *  tete ;
struct cellule_t *  queue ;
int nb_element;

}celluleFile;

////////////////////////////////////////////////////////////////////////////////////
//////////////////////FILE//////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

celluleFile init_file ( );

int file_est_vide (celluleFile f);

void enfilerEnTete (celluleFile * f, element x);

void enfilerEnQueue (celluleFile * f, element x);

void defilerEnQueue (celluleFile * f,  element * x);

void afficherFile(celluleFile file);

#endif

