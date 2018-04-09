#ifndef COMPARAISON_IMAGE_H
#define COMPARAISON_IMAGE_H

#include "file_image.h" //struct de descripteur_img + file_int et file_image
#include "arbre.h" // arbre
#include "descripteur_image.h" //Permet de recuperer la fonction d'indexation
#include "pile_carac.h" //pile de caractere 



int abs_Soustraction(int n1, int n2);
int get_nb_mot_fichier(char* fichier);
int comparaison_file_int(file_int* f_source, file_int* f_compare);
Descripteur_Img lecture_Descripteur_Img(FILE * fichier_descripteur);
void get_nom_path_chemin(char * path_complet,char* nom,char* path);
int index_requete_image(char* path_complet_img);
arbre comparaison_image();
void result_compare_image(char* path_complet_img);


#endif