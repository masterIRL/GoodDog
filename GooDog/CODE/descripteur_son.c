/*****************************************************************************/
/*   DESCRIPTEURS SON PROJET FIL ROUGE                                       */
/*   DEVELOPPE PAR : HILD-LE Charles                                         */
/*****************************************************************************/

#include "descripteur_son.h"


// n : nombre d'échantillons par fenêtre
// m : nombre d'intervalle dans chaque fenêtre



// Fonction permettant de determiner la taille d'un fichier
// Elle prend en entrée le chemin du fichier et rend le nombre de ligne
int nb_ligne_fichier(char* chemin_fichier)
{
	char commande[200];
	int retour;
        FILE *ptr_chemin_fichier;
	strcpy(commande, "wc -l ");
	strcat(commande, chemin_fichier);
	strcat(commande, " > nb_ligne_chemin_fichier");
	system(commande);
	ptr_chemin_fichier=fopen("nb_ligne_chemin_fichier","r");
	if(ptr_chemin_fichier==NULL){
		return -1;
	}
	else
	{
		fscanf(ptr_chemin_fichier,"%d",&retour);
		fclose(ptr_chemin_fichier);
	}
	system("rm nb_ligne_chemin_fichier");
	return retour;
}


// Vérifie si la première indexation du son a déjà eu lieu, 
// en regardant si le fichier base_descripteur_audio existe
//  rend 1 si c'est la première indexation, sinon retourne 0
int prem_index_son()
{
    FILE * ptr_fic=NULL;
    ptr_fic = fopen("../DESCRIPTEURS/base_descripteur_audio","r");
    
    if(ptr_fic==NULL){
        return 1;
    } else { 
        fclose(ptr_fic);
        return 0;
    }
}


// Vérifie si le fichier config du son a été modifié
// Cela compare le fichier config et le fichier base_descripteur_audio et vérfie les valeurs n et m
// Rend 1 si cela a été modifié, sinon 0
int modif_config_son(){
    
    int n,m,n1,m1;
    
    //Ouvre le fichier config et récupére n et m
    FILE * fichier_config=fopen("../DESCRIPTEURS/config_son.txt","r"); 
    fscanf(fichier_config,"%d",&n);
    fscanf(fichier_config,"%d",&m);
    fclose(fichier_config);
    
    //Ouvre le fichier base_descripteur_audio et récupére n et m
    FILE * liste_base = fopen("../DESCRIPTEURS/base_descripteur_audio","r");
    fscanf(liste_base,"%*s %*d %*s %*s %d %*s %d",&n1,&m1);
    fclose(liste_base);
    
    //Compare
    if (n==n1 && m==m1){
        return 0;
    } else {
        return 1;
    }
}

// Fonction vérifiant si un fichier son a déjà été indexé en en vérifiant dans le fichier liste_base_audio
int fichier_appartient_pas_liste_son(char *nom_fichier){
    
    FILE * liste_base=fopen("../DESCRIPTEURS/liste_base_audio", "r");
    
    // Commande permettant de vérifier si le nom du fichier et présent dans la liste_base_audio
    // si tmp_liste3 est vide alors le fichier n'est pas présent, 
    // sinon cela stocke la ligne correspondante dans le fichier temporaire 
    char commande[400];
    strcpy(commande,"grep -F ");
    strcat(commande,nom_fichier);
    strcat(commande," ");
    strcat(commande,"../DESCRIPTEURS/liste_base_audio");
    strcat(commande," > tmp_liste3");
    system(commande);
    
    FILE * ptr_tmp_liste3=fopen("tmp_liste3", "r");
    char lire;
    fscanf(ptr_tmp_liste3,"%c",&lire);
    if (feof(ptr_tmp_liste3)){
        fclose(ptr_tmp_liste3);
        system("rm tmp_liste3");
        return 1;
    } else {
        fclose(ptr_tmp_liste3);
        system("rm tmp_liste3");
        return 0;
    }
}


// Fonction permettant de créer le descripteur d'un fichier son 
// Prend en entrée le chemin du répertoire à indexer, le nom du fichier, l'identifiant, n et m
// Cela rend en sortie la structure contenant le compteur et une file de chaine qui correspond au descripteur son ligne par ligne
Descripteur_Son indexation_fichier_son(char* chemin_fichier, char* name_fic, int identifiant, int n, int m) { 
        
    FILE* nb_ligne_fichier=NULL;
    FILE* fichier = NULL;
    
    // Déclaration et initialisation de la structure du descripteur
    Descripteur_Son struct_decrip;
    INIT_FILE_CHAINE(&(struct_decrip.File));
    struct_decrip.compteur=0;    
    struct_decrip.taille_descripteur=0;
    
    // Concaténation du répertoire à indexer et du nom du fichier
    char * path = malloc(sizeof(char)* (strlen(chemin_fichier)+strlen(name_fic)) );
    strcpy(path,chemin_fichier);
    strcat(path,name_fic);
    
    
    fichier=fopen(path,"r"); //Ouvre le fichier son 
    
    double valeur; //variable qui contiendra chaque valeur lu dans le fichier
    
    // variables qui permettront d'avoir les intervalles pour l'histogramme dans chaque fenêtre
    // cela permettra de savoir dans quel colonne rajouter +1 pour chaque valeur du fichier
    double debut=-1.0;
    double intervalle=2.0/(double)m;
    double fin=debut+intervalle;

    // tab_fenetre permettra de contenir un histogramme
    int tab_fenetre[m];
    for (int a=0; a<m;a++){ //initialisation
        tab_fenetre[a]=0;
    }
    
    //compteur de boucle
    int k=0; 
    //chaque ligne du descripteur qui sera empiler à chaque fois dans la file de chaine
    char ligne[5000]=""; 
    //chaine de char temporaire qui permettra de transformer chaque int de tab_fenetre en chaine, cette chaine sera ensuite concaténé à ligne 
    char string_tmp[5]=""; 
       
    while ( !feof(fichier)  ){ //tant qu'on a pas fini de lire le fichier
        
        for (int i=0; i<n;i++){ //fenetre
            fread(&valeur, 8, 1,fichier); //
            for(int j=0; j<m;j++){
                if ( (debut<=valeur) && (valeur<=fin) ) { 
                    tab_fenetre[j]=tab_fenetre[j]+1;
                    break;
                }
                
                debut=-1.0+(double)j*intervalle;
                fin=(-1.0+intervalle)+(double)j*intervalle;
            }
            debut=-1.0;
            fin=debut+intervalle;            
        }
        
        
        for (int a=0;a<m;a++){
            sprintf(string_tmp,"%d ",tab_fenetre[a]);
            strcat(ligne,string_tmp);
            memset(string_tmp,0,sizeof(string_tmp));
            
        }
        
        for(int a=0;a<m;a++){
            tab_fenetre[a]=0;
        }

        ENFILER_CHAINE(&(struct_decrip.File),ligne);
        memset(ligne,0,sizeof(ligne));
        k++;      
        
    }
    struct_decrip.taille_descripteur=k;
    struct_decrip.compteur=identifiant;
    return struct_decrip;
}


int indexation_son (char*chemin){

    file_son file_base_descripteur;
    INIT_FILE_SON(&file_base_descripteur);
    
    
    char * path4 = malloc(sizeof(char)* (strlen(chemin)+strlen("ls > tmp_liste2;grep .bin$ tmp_liste2 >tmp_liste; wc -l tmp_liste>tmp_nb_traiter")));
    strcpy(path4,"ls ");
    strcat(path4,chemin);
    strcat(path4,"> tmp_liste2;grep .bin$ tmp_liste2 >tmp_liste; wc -l tmp_liste>tmp_nb_traiter");
    system(path4);
    system("rm tmp_liste2");
    
    FILE * taille= fopen("tmp_nb_traiter","r");
    int nb_traiter;
    fscanf(taille,"%d",&nb_traiter);
    fclose(taille);
    system("rm tmp_nb_traiter");

    FILE * liste_fichier=NULL;
    liste_fichier=fopen("tmp_liste","r");
    
    FILE* fichier_config=NULL;
    fichier_config=fopen("../DESCRIPTEURS/config_son.txt","r");
    if (fichier_config==NULL){
        system("echo '2048\n50' > ../DESCRIPTEURS/config_son.txt");
        fichier_config=fopen("../DESCRIPTEURS/config_son.txt","r");
        if (fichier_config==NULL){
            return 0;
        }
    } 
    int n;
    int m;
    fscanf(fichier_config,"%d",&n);
    fscanf(fichier_config,"%d",&m);
    fclose(fichier_config);
        
    
    FILE * liste_base=NULL;
    char mode[1]="a";
    int premiere_indexation=prem_index_son();
    if(premiere_indexation){
        strcpy(mode,"w");
    } else {
        if (modif_config_son()){
            premiere_indexation=1;
            strcpy(mode,"w");
        }
    }
    
    
    liste_base= fopen("../DESCRIPTEURS/liste_base_audio", mode);  
    fclose(liste_base); 
    
    
    int ID_descripteur=nb_ligne_fichier("../DESCRIPTEURS/liste_base_audio");
    
    char nom_fichier[50]; //taille nom fichier max 50
    
    Descripteur_Son struct_decrip;
    INIT_FILE_CHAINE(&(struct_decrip.File));
    
    file_chaine file_liste_base_audio;
    INIT_FILE_CHAINE(&file_liste_base_audio);
    char ligne_liste_base[70]=""; 
    for (int i=0; i< nb_traiter;i++) {
        
        fscanf(liste_fichier,"%s",nom_fichier);

        if (premiere_indexation || fichier_appartient_pas_liste_son(nom_fichier)){
            
            ID_descripteur=ID_descripteur+1;
            struct_decrip=indexation_fichier_son(chemin,nom_fichier,ID_descripteur,n,m);
            ENFILER_SON(&file_base_descripteur, struct_decrip); 
            
            sprintf(ligne_liste_base,"ID %d : %s\n",ID_descripteur,nom_fichier);
            ENFILER_CHAINE(&file_liste_base_audio,ligne_liste_base);
            memset(ligne_liste_base,0,sizeof(ligne_liste_base));
            /*liste_base= fopen("../DESCRIPTEURS/liste_base_audio","a");  
            fprintf(liste_base,"ID%d : ",ID_descripteur);
            fprintf(liste_base,"",nom_fichier);
            fclose(liste_base); 
            */
            INIT_FILE_CHAINE(&(struct_decrip.File));
            
            
        }
        memset(nom_fichier,0,sizeof(nom_fichier));
        
    }
    
    FILE* descripteur = NULL;
    liste_base= fopen("../DESCRIPTEURS/liste_base_audio", mode);  
    descripteur = fopen("../DESCRIPTEURS/base_descripteur_audio", mode); 
    int nombre_a_indexer_descripteur= file_base_descripteur.taille;
    Descripteur_Son descripteur_defiler;
    for (int i=0; i< nombre_a_indexer_descripteur;i++) { 
        
        descripteur_defiler=DEFILER_SON(&file_base_descripteur);
         
        fprintf(descripteur,"ID %d | n= %d m= %d nb_fenêtre= ",descripteur_defiler.compteur, n,m);
        fprintf(descripteur,"%d\n", (descripteur_defiler.taille_descripteur));
        
        while( !FILE_CHAINE_EST_VIDE(descripteur_defiler.File) ){
            fprintf(descripteur,"%s", DEFILER_CHAINE(&(descripteur_defiler.File)) ); 
            fprintf(descripteur,"\n");
            
        }
        fprintf(liste_base,"%s", DEFILER_CHAINE(&(file_liste_base_audio)));
    }
    
    fclose(liste_fichier);
    fclose(liste_base); 
    system("rm tmp_liste");
    fclose(descripteur);
    free(path4);
    return 1; 
}

/*
int main(){ 
    indexation_son("../DATA/SON/");

    return 0;
}*/



