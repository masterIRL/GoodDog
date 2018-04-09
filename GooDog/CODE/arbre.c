#include "arbre.h"

void INIT_ARBRE(arbre *a) {
	*a = NULL;
}

int ARBRE_VIDE(arbre a) {
	if (a==NULL){
		return 1;
	}
	return 0;
}

// passage d'un pointeur de pointeur pour gerer le cas ou l'arbre en parametre est vide...
void addArbre(arbre *a, int valeur, int ident) {
	if (ARBRE_VIDE(*a))
	{
		*a=(arbre)malloc(sizeof(feuille));
		(*a)->droite = NULL;
		(*a)->gauche = NULL;
		(*a)->racine = valeur;
		(*a)->id = ident;
	}
	else{
		if (valeur > (*a)->racine){

			addArbre(&(*a)->droite, valeur, ident);
		}
		else { // sinon la valeur a ajouter est inferieur donc aller a gauche

			addArbre(&(*a)->gauche,valeur,ident);
		}
	}
}

//Supprime la valeur minimale
// ptr_valeur: valeur de comparaison a récupérer de l'arbre
// ptr_id : la valeur du ID à récup
int removeMin(arbre *a, int *ptr_valeur, int *ptr_id) {
	int valeur;
	feuille *pere;
	feuille *temp;
	if((*a)->gauche==NULL){
		temp = *a;
		(*a)=(*a)->droite;
		*ptr_valeur=temp->racine;
		*ptr_id=temp->id;
	}else{
		while(temp->gauche!=NULL){
			pere=temp;
			temp=temp->gauche;
		}
		*ptr_valeur=temp->racine;
		*ptr_id=temp->id;
		if(temp->droite!=NULL){
			pere->gauche=temp->droite;
		}else{
			pere->gauche=NULL;
		}
	}
	valeur=temp->racine;
	free(temp);
	return valeur;
}

void STRING_ARBRE(arbre a) {
	//arbre tempArbre = a;
	if (!ARBRE_VIDE(a)) {
		STRING_ARBRE(a->gauche);
		if (a->gauche != NULL) {
			printf(", ");
		}
		printf("ID %d : ", a->id);
		printf("%d", a->racine);
		if (a->droite != NULL) {
			printf(",");
		}
		STRING_ARBRE(a->droite);
	}
}

void AFFICHE_ARBRE(arbre a){
	STRING_ARBRE(a);
	printf("\n");
}



