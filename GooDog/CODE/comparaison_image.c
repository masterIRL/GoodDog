#include "comparaison_image.h"

/* 
abs_Soustraction(int n1, int n2)
entree: int n1 -> un entier quelconque 
		int n2 -> un entier quelconque
sorti: int
fonction : calcule la valeur absolue de n1-n2
*/
int abs_Soustraction(int n1, int n2){ 
	if (n1>=n2)
	{
		return n1-n2;
	}

	else{
		return n2-n1;
	}
}


//Fonction pour récupérer le nombre de mot dans un fichier
int get_nb_mot_fichier(char* fichier){
	char commande[200];
	char char_nb_mot[100];
	FILE *ptr_fichier;
	strcpy(commande,"wc -w ");
	strcat(commande, fichier);
	strcat(commande," >");
	strcat(commande, " nb_mot_fichier");
	system(commande);

	ptr_fichier=fopen("nb_mot_fichier","r");
	if(ptr_fichier==NULL){
		return -1;
	}
	else
	{
		fscanf(ptr_fichier,"%s",char_nb_mot);
		fclose(ptr_fichier);
	}
	system("rm nb_mot_fichier");
	return atoi(char_nb_mot);
}



//Fonction qui compare deux files int et recupere la valeur de la comparaison
int comparaison_file_int(file_int* f_source, file_int* f_compare){
	int source;
	int compare;
	int stack_comp=0;
	int stack_source=0;
	int resultat=0;
	float final;
	int taille_min;

	if (f_source->taille >= f_compare->taille)
	{
		taille_min=f_compare->taille;
	}

	else{
		taille_min=f_source->taille;
	}

	for (int i = 0; i < taille_min; i++)
	{
		source=DEFILER_INT(f_source);
		//printf("source:%d\n", source);
		compare=DEFILER_INT(f_compare);
		//printf("compare:%d\n", compare);
		stack_source+=source;
		stack_comp+=compare;
		resultat+=abs_Soustraction(source,compare); //incremente le resultat en fonction de la comparaison de chaque element des deux piles
	}

	final = ((float)resultat / (stack_comp+stack_source))*100;
	//printf("resultat: %d\n stack_comp: %d\nstack_source: %d\n\nfinal: %f\n",resultat,stack_comp,stack_source,final);

	return final;
}





//Le fichier doit etre ouvert au prealable pour pouvoir lire dedans en continu grace a un boucle
Descripteur_Img lecture_Descripteur_Img(FILE * fichier_descripteur){
	Descripteur_Img rslt_Lecture_Img;
	INIT_IMAGE(&rslt_Lecture_Img);

	char valeur_img;
	int nb_motID ,valeur;
	
	//On lit et recupere les valeurs de la premiere ligne
	fscanf(fichier_descripteur,"%*s %d %*s %d", &(rslt_Lecture_Img.compteur), &(rslt_Lecture_Img.precision) );
	//On lit la chaine de caractere de la deuxieme ligne du fichier en ecrivant dans un fichier temp
	fscanf(fichier_descripteur,"%*c");
	FILE * ptr_temp=fopen("temp_lecture","w");
	if(ptr_temp!=NULL){
		while(valeur_img !='\n' && !feof(fichier_descripteur)){
			fscanf(fichier_descripteur,"%c",&valeur_img);
			fprintf(ptr_temp, "%c", valeur_img);
		}
	}		
	fclose(ptr_temp);

	//on recupere les valeurs de la seconde ligne
	nb_motID = get_nb_mot_fichier("temp_lecture");
	ptr_temp=fopen("temp_lecture","r");
	for (int i = 0; i < nb_motID; i++)
	{
		fscanf(ptr_temp,"%d",&valeur);
		ENFILER_INT(&(rslt_Lecture_Img.File), valeur);
	}
	fclose(ptr_temp);
	system("rm temp_lecture");
	return rslt_Lecture_Img;
}





/*
get_nom_path_chemin(char * path_complet,char* nom,char* path)
entree: char * path_complet -> une chaine de caractere contenant le chemin exacte du fichier
		char * nom -> chaine de caractere qui permettra de stocker le nom
		char * path -> chaine de caractere qui permettra de stocker le chemin sans le nom
sortie: rien
fonction: fonction permettant d'extraire le path et le nom séparé, et ce d'un fichier à partir de son chemin complet
*/
void get_nom_path_chemin(char * path_complet,char* nom,char* path){
	pile_carac filtre; //pile stockant la totalité de la chaine pour se faire filtré et récupérer le nom et le path du fichier a l'envers
	pile_carac reverse_path; //pile stockant uniquement le path sans le nom à l'envers afin de le remettre à l'endroit
	pile_carac reverse_nom; //pile stockant uniquement le nom à l'envers afin de le remettre à l'endroit
	INIT_PILE_CARAC(&filtre);
	INIT_PILE_CARAC(&reverse_path);
	INIT_PILE_CARAC(&reverse_nom);
	char c;
	//char path_chemin[150];
	char name[100];

	//On rempli la pile de caractere avec tout le chemin
	for (int i = 0; i < strlen(path_complet); i++)
	{
		EMPILE_CARAC(&filtre,path_complet[i]);
	}

	//on filtre la pile c jusqu'au premier '/' pour recuperer le nom à l'envers
	c=DEPILE_CARAC(&filtre);
	while( c!='/' && !PILE_CARAC_EST_VIDE(filtre)){
		EMPILE_CARAC(&reverse_nom,c);
		c=DEPILE_CARAC(&filtre);
	}

	// on recupere le reste de la pile pour constituer le path à l'envers
	if (c == '/')
	{
		while(!PILE_CARAC_EST_VIDE(filtre)){
			EMPILE_CARAC(&reverse_path,c);
			c=DEPILE_CARAC(&filtre);
		}
		EMPILE_CARAC(&reverse_path,c);
	}

	//On recupere le nom dans un tableau dans un bon ordre
	int i=0;
	while(!PILE_CARAC_EST_VIDE(reverse_nom)){
		name[i]= DEPILE_CARAC(&reverse_nom);
		i++;
	}

	//On recupere le path dans un tableau dans un bon ordre
	i=0;
	char* path_chemin = (char*)malloc(sizeof(char) * reverse_path.taille);
	while(!PILE_CARAC_EST_VIDE(reverse_path)){
		path_chemin[i] = DEPILE_CARAC(&reverse_path);
		i++;
	}

	strcpy(nom,name);
	strcpy(path,path_chemin);
}


/*
int index_requete_image(char* path_complet_img)
entree: char* path_complet_img -> chaine de caractère contenant le chemin complet du fichier a indexer pour la comparaison
sortie: int -> renvoie un bouleen
fonction: FONCTION QUI VA INDEXER DANS UN FICHIER LA REQUETE UTILISATEUR le fichier passe en parametre sera indexer et ecrit dans un fichier :"temp_descripteur_img"
*/
int index_requete_image(char* path_complet_img){

	char nom[100];
	char path[150];
	get_nom_path_chemin(path_complet_img,nom,path);
	Descripteur_Img descripteur_fichier;
	INIT_IMAGE(&descripteur_fichier);
	descripteur_fichier = creer_descripteur(path,nom,1); //creation du descripteur de la requete utilisateur

	//ecriture de la file des descripteurs dans le fichier base_descripteur_image
	if (descripteur_fichier.compteur ==0)
	{
		return 0;
	}
	else{

		FILE * ptr_fic_desc = fopen("temp_descripteur_img" ,"w");
		if (ptr_fic_desc != NULL)
		{
			ECRIT_DESCRIPTEUR(descripteur_fichier,ptr_fic_desc);
			fclose(ptr_fic_desc); 
		}
		else{
			return 0;
		}

		return 1;
	}

}





//renvoie la valeur de comparaison entre un descripteur du fichier et la requete user

arbre comparaison_image(){

	char ident[50];
	int somme=0;
	int nb1, nb2;

	int resultat_comparaison;

	arbre arbre_resultat;
	INIT_ARBRE(&arbre_resultat);

	Descripteur_Img descripteur_requete;
	Descripteur_Img descripteur_base;
	INIT_IMAGE(&descripteur_requete);
	INIT_IMAGE(&descripteur_base);

	FILE* fichier_requete;
	FILE* fichier_descripteur;


	fichier_descripteur=fopen("../DESCRIPTEURS/base_descripteur_image","r"); //ouvre le fichier contenant les descripteurs images
	if (fichier_descripteur!=NULL){
		//on recupere les descripteur du fichier descripteur_base puis on les compare a la requete
		AFFECT_IMAGE(&descripteur_base,lecture_Descripteur_Img(fichier_descripteur));//Met dans le descripteur la lecture du fichier descripteur image

		//utilisation d'une boucle pour faire la comparaison necessaire tant que le fichier descripteur n'est pas arrivé à sa fin
		while( feof(fichier_descripteur)==0 ){

			//utilisation de lecture pour récuperer dabord la requete utilisateur pour faire la comparaison
			fichier_requete=fopen("temp_descripteur_img","r"); // ouvre le fichier contenant l'indexation de la requete utilisateur
			if(fichier_requete!=NULL){
				AFFECT_IMAGE(&descripteur_requete,lecture_Descripteur_Img(fichier_requete)); //Met dans le descripteur la lecteur du fichier de requete
				fclose(fichier_requete);
			}

			//comparer les files int pour récupérer une valeur (dont on calculera un pourcentage?)
			//Si le pourcentage est assez haut (ou juste la valeur) on stocke la valeur des ID dans un arbre
			resultat_comparaison = comparaison_file_int(&(descripteur_requete.File), &(descripteur_base.File)); //ERREURresultat a 0 systematiquement ERREUR
			if (resultat_comparaison <=20) //Condition de mise de la valeur dans un arbre, valeur arbitraire changeable
			{
				addArbre(&arbre_resultat,resultat_comparaison,descripteur_base.compteur);
			}

			//on recupere les descripteur du fichier descripteur_base puis on les compare a la requete
			AFFECT_IMAGE(&descripteur_base,lecture_Descripteur_Img(fichier_descripteur));//Met dans le descripteur la lecture du fichier descripteur image
		}

		fclose(fichier_descripteur);
		system("rm temp_descripteur_img");
	}
	//AFFICHE_ARBRE(arbre_resultat);
	return(arbre_resultat);
}



// FONCTION QUI UTILISE LES IDENTIFIANTS DE L'ARBRE POUR RECUPERER LES NOMS ET FAIT L'AFFICHAGE FINAL
void result_compare_image(char* path_complet_img){
	int ID, ID2;
	int valeur;
	char nom_ficher[100];
	int reussi = index_requete_image(path_complet_img);
	if (reussi)
	{
		arbre arbre_compare_img;
		INIT_ARBRE(&arbre_compare_img);
		arbre_compare_img = comparaison_image();
		printf("Resultat -> ");
		if (ARBRE_VIDE(arbre_compare_img))
		{
			printf("Pas de resultat.\n");
		//return 0;
		}
		else{
			while (!ARBRE_VIDE(arbre_compare_img))
			{
				removeMin(&arbre_compare_img,&valeur,&ID);
				FILE * liste_base_image = fopen("../DESCRIPTEURS/liste_base_image","r");
				if (liste_base_image!=NULL)
				{
					do{
						fscanf(liste_base_image,"%*s %d %*s %s",&ID2,nom_ficher);
					}while(ID2!=ID);
					fclose(liste_base_image);

				}

				printf("ID %1d : %s |",ID,nom_ficher);
		/*FILE * temp_resultat = fopen("../DESCRIPTEURS/resultat_img","a");
		if (temp_resultat!=NULL)
		{
			fprintf(temp_resultat, "ID %3d : %s",ID,nom_ficher);
			fclose(temp_resultat);
		}*/
			}
			printf("\n");
		//return 1;
		}
	}


	else{
		printf("Votre fichier n'existe pas\n");
	}

	printf("\n\n");

}