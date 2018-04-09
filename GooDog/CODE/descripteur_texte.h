//======================================================================//
// Indexation texte
//======================================================================//
//Bibliotheque :
// Contient toutes les fonctions utile a la création d'un descripteur_texte
//======================================================================//

#ifndef DESCRIPTEUR_TXT_H
#define DESCRIPTEUR_TXT_H

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#include "file.h"
#include "file_chaine.h"

////////////////////////////////////////////////////////////////////////////////////
//////////////////////TYPE//////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

typedef struct information_mot_t
{
  char* mot;
  int occurence;
}information_mot;

typedef struct descripteur_texte_t
{
  int int_identifiant;
  information_mot* tableau;
  int nb_mot;
  int nb_mot_complet;
}Descripteur_texte;

////////////////////////////////////////////////////////////////////////////////////
//////////////////////DESCRIPTION///////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

// // // // // // // // // // // // // // //
//retourne la premiere valeur entiere d'un fichier
//le nom du fichier se met en parametre
// // // // // // // // // // // // // // //
void filtrage(celluleFile * file_filtre_ponctuation,FILE * ptr_file);

// // // // // // // // // // // // // // //
//Permet de reconstituer les mots et filtres ceux
//qui sont inférieur a la taille demandé
// // // // // // // // // // // // // // //
// ATTENTION ! tableau_cat == NULL et tableau_cat[cpt_mot] == NULL
void filtrage_taille_mot(celluleFile * file_texte, file_chaine * file_texte_FitreMot, int * nb_total_mot, int FiltreMot);

// // // // // // // // // // // // // // //
//Permet de reconstituer les mots et filtres
//ceux qui sont inférieur a la taille demandé
// // // // // // // // // // // // // // //
int nombre_occurence(file_chaine file_texte_FitreMot, information_mot * tableau_histogramme, int cpt );

// // // // // // // // // // // // // // //
//Créer l'histogramme du fichier texte permettant
//de reformer son descripteur
// // // // // // // // // // // // // // //
// ATTENTION ! tableau_histogramme[cpt].mot == NULL
information_mot* histogramme_texte(file_chaine * file_texte_FitreMot, int * nombre_resulat, int Filtre_occurence );

// // // // // // // // // // // // // // //
//Fonction qui retourne le descripteur_texte avec
//l'attribution de valeur a chaque champ de la structure
// // // // // // // // // // // // // // //
// ATTENTION ! ptr_file == NULL
Descripteur_texte DESCRIPTEUR_TEXTE(int ident,char* c_nom, int FiltreMot, int Filtre_occurence, char* Chemin_dossier );


#endif