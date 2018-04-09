//======================================================================//
// Indexation texte
//======================================================================//

#include "indexation_texte.h"


int indexation_texte (char*chemin){

    celluleFile_texte file_base_descripteur= init_file_texte();
    
    char * path4 = malloc(sizeof(char)* (strlen(chemin)+strlen("ls > tmp_liste2;grep .xml$ tmp_liste2 >tmp_liste; wc -l tmp_liste>tmp_nb_traiter")));
    strcpy(path4,"ls ");
    strcat(path4,chemin);
    strcat(path4,"> tmp_liste2;grep .xml$ tmp_liste2 >tmp_liste; wc -l tmp_liste>tmp_nb_traiter");
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
    fichier_config=fopen("../DESCRIPTEURS/configTexte.txt","r");
    if (fichier_config==NULL){
        system("echo '3\n3' > ../DESCRIPTEURS/configTexte.txt");
        fichier_config=fopen("../DESCRIPTEURS/configTexte.txt","r");
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
    /*char mode[1]="a";
    int premiere_indexation=prem_index_son();
    if(premiere_indexation){
        strcpy(mode,"w");
    } else {
        if (modif_config_son()){
            premiere_indexation=1;
            strcpy(mode,"w");
        }
    }
    
  */  
    liste_base= fopen("../DESCRIPTEURS/liste_base_texte", "w");  
//     fclose(liste_base); 
    
    
//     int ID_descripteur=nb_ligne_fichier("../DESCRIPTEURS/liste_base_texte");
    int ID_descripteur=0;
    char nom_fichier[50]; //taille nom fichier max 50
    
    Descripteur_texte struct_decrip;
//     INIT_FILE_CHAINE(&(struct_decrip.File));
    
//     file_chaine file_liste_base_audio;
//     INIT_FILE_CHAINE(&file_liste_base_audio);
//     char ligne_liste_base[70]=""; 
    
    for (int i=0; i< nb_traiter;i++) {
        
        fscanf(liste_fichier,"%s",nom_fichier);

//        if (premiere_indexation || fichier_appartient_pas_liste_son(nom_fichier)){
            
            ID_descripteur=ID_descripteur+1;
            struct_decrip=DESCRIPTEUR_TEXTE(ID_descripteur,nom_fichier, n,m, chemin);
            enfilerEnTete_texte (&file_base_descripteur, struct_decrip);
            
//             sprintf(ligne_liste_base,"ID %d : %s\n",ID_descripteur,nom_fichier);
//             ENFILER_CHAINE(&file_liste_base_audio,ligne_liste_base);
//             memset(ligne_liste_base,0,sizeof(ligne_liste_base));
            
//             liste_base= fopen("../DESCRIPTEURS/liste_base_audio","a");  
            fprintf(liste_base,"ID%d : ",ID_descripteur);
            fprintf(liste_base,"%s\n",nom_fichier);

            
//             INIT_FILE_CHAINE(&(struct_decrip.File));
            
            
//        }
        memset(nom_fichier,0,sizeof(nom_fichier));
        
    }
    fclose(liste_base); 
    FILE* descripteur = NULL;
    descripteur = fopen("../DESCRIPTEURS/base_descripteur_texte", "w"); 
    int nombre_a_indexer_descripteur= file_base_descripteur.nb_element;
    Descripteur_texte descripteur_defiler;
    for (int i=0; i< nombre_a_indexer_descripteur;i++) { 
        

        defilerEnQueue_texte (&file_base_descripteur ,  &descripteur_defiler);
         
        fprintf(descripteur,"ID %d | n= %d m= %d\n",descripteur_defiler.int_identifiant, n,m);
        
        for(int i=0; i< descripteur_defiler.nb_mot;i++){
            fprintf(descripteur,"%s : %d  ",descripteur_defiler.tableau[i].mot,descripteur_defiler.tableau[i].occurence);
        }
        fprintf(descripteur,"\n");
    
    }
    
    fclose(liste_fichier);
    system("rm tmp_liste");
    fclose(descripteur);
    free(path4);
    return 1; 
}



// int main(){
//     indexation_texte("../DATA/TEXTE/");
// //     table_index("../DESCRIPTEURS/","../DESCRIPTEURS/");
// 
// }