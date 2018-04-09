/*****************************************************************************/
/*   INTERFACE PROJET FILE ROUGE                                            */
/*   DEVELOPPE PAR : BISSELOU-NZENGUE Stezen                                */
/****************************************************************************/
#ifndef INTERFACE_H
#define INTERFACE_H

/*#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>*/
#include "descripteur_son.h"
#include "comparaison_image.h"
#include "indexation_texte.h"

/*****************************************************************************/
//**   DIFFERENTES STRUCTURES                                                */
//****************************************************************************/

struct Aide
{
    char mots[3000];//texte d'aide
    char commentaire[200];//les utilisateurs pourront laisser des commentaires 
    //int satisfaction;//contient les appreciations de l'utilisateur:annulé
    //int insatisfaction;//contient les appreciations de l'utilisateur :annulé
    //int nombreDecommentaires;:annulé
};

struct Aide FicherAide;

//structure d'un ficher de configuaration Texte
struct Fichier1
{
    float seuilModif;
    int nombreLettreModif;
    int nombreMotModif;
};
struct Fichier1 ficherconfigTexte;

//structure d'un ficher de configuaration Son
struct Ficher2
{
    int echantillonageParFenetre;
    int intervalFenetre;
};
struct Ficher2 ficherConfigSon;

//structure d'un ficher de configuaration Image
struct Ficher3
{
    int precision;//bit de quantification
};
struct Ficher3 ficherConfigImage;


/*************************debut fonctions liées à la robutesse du programme *****************************/

void ViderBuffer();
int lireChaine(char *chaine);
long lireLong();
int testeMotValide(char mot[100]);
/* fin */

/******************************debut fonctions liées aux services du moteur de recherche******************/
int UserLambda();
void test();
char Recherche(char mot[50]);
int mot_de_passe(long login2);
void ConfigTexte();
void configSon();
void configImage();
void configurer();
void indexer();
void fonctionAdmin();
void Admin(int operation);
/* fin */

/******************************debut fonctions liées aux services du moteur de recherche******************/
void fonctionnaliteSystem();
void satisfactionUtilisateur();
void aideAdmin();
/* fin */

#endif
