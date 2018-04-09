#ifndef DESCRIPTEUR_SON_H
#define DESCRIPTEUR_SON_H

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "file_son.h"
#include"file_chaine.h"

int nb_ligne_fichier(char* chemin_fichier);
int prem_index_son();
int modif_config_son();
int fichier_appartient_pas_liste_son(char *nom_fichier);
Descripteur_Son indexation_fichier_son(char* chemin_fichier, char* name_fic,int identifiant,int n, int m);
int indexation_son (char*chemin);

#endif

