#ifndef DESCRIPTEUR_IMAGE_H
#define DESCRIPTEUR_IMAGE_H


#include"file_int.h"
#include "file_image.h"

#define max_d 3      //dimension maximale
#define max_lh 500   //nombre maximale de ligne et de colone
#define max_hist 33000     //taille maximale de l'histograme

///////////////////////////////////////////////////////////////////////////////////////////////////////////
//Fonction qui permet d'indexer tout les images existent dans la base de donnés          
//elle crée 3 fichier(list_base_image,base_descripteur_image,Imageconfig) ou les modifie
//base_descripteur_image:contient tous les descripteurs des fichiers indexé
//list_base_image:contient les noms des fichier qui ont été indexé
//ImageConfig:contient le nombre de bits de quantification
///////////////////////////////////////////////////////////////////////////////////////////////////////////////




void Lire_Image_fic(int d,int h,int l,int Image[max_d][max_lh][max_lh], FILE* fichier);
//fonction qui lit les pixels d'une image a partir d'un fichier passer en parametre et les stocke dans la matrice "Image[max_d][max_lh][max_lh]"
//Entrée:
//d:dimension de l'image(1 pour image NB et 3 pour image RGB)
//h:hauteur de l'image
//l:longueur de l'image
//Image[max_d][max_lh][max_lh]:matrice de stockage des pixels
//fichier:fichier .txt contenant les pixels de l'image


int exposant(int x,int y);
//fonction qui calcule l'exposant d'un nombre
//Entrée:x et y
//Sortie:x exposant y


void Entier_Binaire(int E,int tbin[8]);
//fonction qui transforme un nombre entier en un binaire sur 8 bits et stocke le resultat dans le tableau "tbin[8]"
//Entrée:
//E:l'entier a transformer
//tbin[8]:tableau de stockage de la valeur binaire


int Binaire_Entier(int tmax,int tbin[max_lh]);
//fonction qui transforme un binaire en un nombre entier
//Entrée:
//tbin[max_lh]:tableau representant la valeur binaire
//tmax:taille du tableau
//Sortie:
//l'entier correspondant au binaire du tableau


int prem_index_image();
//fonction qui determine si une premiere indexation a ete faite ou pas en regardant si le fichier base_descripteur_image a été creer ou pas
//Retourne 0 s'il ya eu une premiere indexation et 1 sinon


int fichier_appartient_pas_liste_image(char* nom_fic);
//fonction qui verifie si le fichier passé en parametre a été indexé ou pas dans en recherchent le fichier dans la list_base_image


void Quantification_Image(int d,int h,int l,int n,int Image[max_d][max_lh][max_lh],int histogram[max_hist]);
//fonction qui prend en parametre la matrice Image,realise la quantification et renvoie l'histogramme des pixels
//Entrée:
//d:dimension de l'image(1 pour image NB et 3 pour image RGB)
//h:hauteur de l'image
//l:longueur de l'image
//n:nb de bits de quantification
//Image[max_d][max_lh][max_lh]:matrice de stockage des pixels
//histogram[max_hist]:histogramme des pixels aprés quantification


Descripteur_Img creer_descripteur(char* path_rep_img,char* nom_fic,int compteur_ID);
//fonction qui creer un descripteur pour un seul fichier
//Entrée:
//path_rep_img:chemin du repertoir contenant les images
//nom_fic:nom du fichier a indexer
//compteur_ID:correspond a l'identifiant du fichier a indexer
//Sortie:
//renvoi une structure de type Descripteur_Img contenant l'identifiant du fichier,le nombre de bit de quantification et l'histogramme correspondant

void indexation_image(char* mode);
//fonction generale,permet de faire l'indexation de tout les fichier image


void Index_Image();

#endif
