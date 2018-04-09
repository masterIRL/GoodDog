#include"descripteur_image.h"
#include"file_int.h"
#include"file_image.h"



#define max_d 3      //dimension maximale de l'image
#define max_lh 500   //nombre maximale de ligne et de colone  de l'image
#define max_hist 33000     //taille maximale de l'histograme





//fonction qui lit les pixels d'une image a partir d'un fichier passer en parametre et les stocke dans la matrice "Image[max_d][max_lh][max_lh]"
//Entrée:
//d:dimension de l'image(1 pour image NB et 3 pour image RGB)
//h:hauteur de l'image
//l:longueur de l'image
//Image[max_d][max_lh][max_lh]:matrice de stockage des pixels
//fichier:fichier .txt contenant les pixels de l'image
void Lire_Image_fic(int d,int h,int l,int Image[max_d][max_lh][max_lh], FILE* fichier)   {
  int x;
  for(int i=0;i<d;i++)     
  {  
   for(int j=0;j<h;j++)
   {
     for(int k=0;k<l;k++)
     {
       fscanf(fichier,"%d",&x);
       Image[i][j][k]=x;  
     }
   }
 }
}


//fonction qui calcule l'exposant d'un nombre
//Entrée:x et y
//Sortie:x exposant y
int exposant(int x,int y)
{
  int ans=x;

  if(y==0)
   return 1;
 else
   for(int i=0;i<y-1;i++)
   {
     ans=ans*x;
   }
   return ans;
 }

//fonction qui transforme un nombre entier en un binaire sur 8 bits et stocke le resultat dans le tableau "tbin[8]"
//Entrée:
//E:l'entier a transformer
//tbin[8]:tableau de stockage de la valeur binaire
 void Entier_Binaire(int E,int tbin[8])
 {
  int ans=E;
  for(int i=7;i>=0;i--)
  {
   tbin[i]=ans%2;
   ans=ans/2;
 }
}

//fonction qui transforme un binaire en un nombre entier
//Entrée:
//tbin[max_lh]:tableau representant la valeur binaire
//tmax:taille du tableau
//Sortie:
//l'entier correspondant au binaire du tableau
int Binaire_Entier(int tmax,int tbin[max_lh])
{
  int s=0;
  int e=0;
  for(int i=tmax-1;i>=0;i--)
  { 
    s=s+(tbin[i]*exposant(2,e));
    e=e+1;
  } 
  return s;
}



//fonction qui determine si une premiere indexation a ete faite ou pas en regardant si le fichier base_descripteur_image a été creer ou pas
//Retourne 0 s'il ya eu une premiere indexation et 1 sinon
int prem_index_image()
{
  FILE * ptr_fic=NULL;
  ptr_fic = fopen("../DESCRIPTEURS/base_descripteur_image","r");

  if(ptr_fic==NULL){
    return 1;
  } else { 
    fclose(ptr_fic);
    return 0;
  }
}




//fonction qui verifie si le fichier passé en parametre a été indexé ou pas dans en recherchent le fichier dans la list_base_image
int fichier_appartient_pas_liste_image(char* nom_fic){

  char commande[400];
  strcpy(commande,"grep -F ");
  strcat(commande,nom_fic);
  strcat(commande," ");
  strcat(commande,"../DESCRIPTEURS/liste_base_image");
  strcat(commande," > tmp_liste3");
  system(commande);
  FILE * ptr_tmp_liste3=fopen("tmp_liste3", "r");
  if (feof(ptr_tmp_liste3))
  {
    return 1;
  } 
  else 
  {
    return 0;
  }
  fclose(ptr_tmp_liste3);
}


//fonction qui prend en parametre la matrice Image,realise la quantification et renvoie l'histogramme des pixels
//Entrée:
//d:dimension de l'image(1 pour image NB et 3 pour image RGB)
//h:hauteur de l'image
//l:longueur de l'image
//n:nb de bits de quantification
//Image[max_d][max_lh][max_lh]:matrice de stockage des pixels
//histogram[max_hist]:histogramme des pixels aprés quantification
void Quantification_Image(int d,int h,int l,int n,int Image[max_d][max_lh][max_lh],int histogram[max_hist])
{
  int tbin[8];   //tableau de representation binaire a 8 bits
  int tfort[n*d]; //tableau pour representer les n bits fort de chaque couleur
  int e;          //compteur

//Initialisation de l'histogramme 
  for(int i=0;i<exposant(2,d*n);i++)
  {
    histogram[i]=0;
  }


//remplissage de l'histogramme
  for(int j=0;j<h;j++)
  {  

   for(int k=0;k<l;k++)
   {
     e=0;
     for(int i=0;i<d;i++)
     {
      Entier_Binaire(Image[i][j][k],tbin);

      for(int m=0;m<n;m++)
      {
        tfort[e]=tbin[m];
        e=e+1;    
      }      
    }

    histogram[Binaire_Entier(n*d,tfort)]=  histogram[Binaire_Entier(n*d,tfort)]   +  1;
  }
}
}





//fonction qui creer un descripteur pour un seul fichier
//Entrée:
//path_rep_img:chemin du repertoir contenant les images
//nom_fic:nom du fichier a indexer
//compteur_ID:correspond a l'identifiant du fichier a indexer
//Sortie:
//renvoi une structure de type Descripteur_Img contenant l'identifiant du fichier,le nombre de bit de quantification et l'histogramme correspondant
Descripteur_Img creer_descripteur(char* path_rep_img,char* nom_fic,int compteur_ID)
{
  Descripteur_Img Descripteur;
  INIT_IMAGE(&Descripteur);
  
  FILE * ptr_fichier=NULL;
  FILE * ptr_fic_config=NULL;
  int d,h,l;   //taille de l'image
  int n;     //degre de quantification
  int Image[max_d][max_lh][max_lh];  //image a traiter
  int histogram[max_hist];    //histograme des pixels apres quantification


  ptr_fic_config= fopen("../DESCRIPTEURS/ImageConfig","r");
  if(ptr_fic_config == NULL){
    printf("impossible d'ouvrir le fichier config\n");
  }
  else{
    fscanf(ptr_fic_config,"%d",&n);
    fclose(ptr_fic_config);
  }

  //lire une Image d'aprés son format .txt
  char* path = malloc(sizeof(char) * (strlen(path_rep_img) + strlen(nom_fic)+1));
  strcpy(path,path_rep_img);
  strcat(path,nom_fic);

  ptr_fichier = fopen(path,"r");

  if(ptr_fichier == NULL){
   printf("Impossible d'ouvrir le fichier a indexer\n");
 }
 else{
   fscanf(ptr_fichier,"%d%d%d",&l,&h,&d); 
   Lire_Image_fic(d,h,l,Image,ptr_fichier);
   fclose(ptr_fichier);

   //quantification de l'image lue
  Quantification_Image(d,h,l,n,Image,histogram);

  //initialisation de la File
  INIT_FILE_INT(&Descripteur.File);

  //remplissage de la file
  for(int i=0;i<exposant(2,d*n);i++)
  {
    ENFILER_INT(&Descripteur.File,histogram[i]);
  }

  Descripteur.compteur=compteur_ID;
  Descripteur.precision=n;
  }
  return Descripteur;
}




//fonction generale,permet de faire l'indexation de tout les fichier image
void indexation_image(char* mode)
{
  FILE* ptr_fic_config=NULL;
  FILE* ptr_tmp_liste_rgb=NULL;
  FILE* ptr_tmp_liste_nb=NULL;
  FILE* ptr_fic_listbase=NULL;
  FILE* ptr_fic_basedesc=NULL;
  FILE* ptr_fic_nb_ligne_rgb=NULL;
  FILE* ptr_fic_nb_ligne_nb=NULL;
  
  char nom_fic[15];                       //nom du fichier a traiter
  char commande[100];

  int nb_ligne_fic_rgb;  //nombre de fichier rgb dans la base de donnés
  int nb_ligne_fic_nb;   //nombre de fichier nb dans la base de donnés
  int compteur_ID;       //numero de l'identifiant

  file_image file_img;   //file des descripteurs
  Descripteur_Img Descripteur; //structure representant un descripteur


//Initialisation de la file des descripteurs
  INIT_FILE_IMAGE(&file_img);
  
//creation du fichier de configuration et initailiser le nombre de bits de quantification a 2
  ptr_fic_config = fopen("../DESCRIPTEURS/ImageConfig" ,"r");
  if(ptr_fic_config==NULL)
  {
   ptr_fic_config = fopen("../DESCRIPTEURS/ImageConfig" ,"w");
   fprintf(ptr_fic_config,"2");
   fclose(ptr_fic_config);
 }
 else
   fclose(ptr_fic_config);  


//sauvegarde les noms des fichiers .txt des images rgb et nb dans des fichiers temporaire
 system("ls ../DATA/IMAGE/RGB > tmp_liste1;grep .txt$ tmp_liste1 > tmp_liste_rgb");
 system("ls ../DATA/IMAGE/NB > tmp_liste2;grep .txt$ tmp_liste2 > tmp_liste_nb");
 system("rm tmp_liste1");
 system("rm tmp_liste2");


//recuperation de nombre de fichier .txt des images rgb      
 system("wc -l tmp_liste_rgb > nb_ligne_fic_rgb");
 ptr_fic_nb_ligne_rgb = fopen("nb_ligne_fic_rgb" ,"r");
 fscanf(ptr_fic_nb_ligne_rgb,"%d",&nb_ligne_fic_rgb);
 fclose(ptr_fic_nb_ligne_rgb);
 system("rm nb_ligne_fic_rgb");

//traitement de tous les images rgb    
 ptr_tmp_liste_rgb = fopen("tmp_liste_rgb","r");
 ptr_fic_listbase = fopen("../DESCRIPTEURS/liste_base_image" ,mode);

 for(int i=1;i<=nb_ligne_fic_rgb;i++ )
 {

  fscanf(ptr_tmp_liste_rgb,"%s",nom_fic);
  Descripteur=creer_descripteur("../DATA/IMAGE/RGB/",nom_fic,i);
  ENFILER_IMAGE(&file_img,Descripteur);             
  fprintf(ptr_fic_listbase,"ID %d : %s\n",i,nom_fic);
  compteur_ID=i+1;

}

fclose(ptr_tmp_liste_rgb);
fclose(ptr_fic_listbase);
system("rm tmp_liste_rgb");

//recuperation de nombre de fichier .txt des images nb       
system("wc -l tmp_liste_nb > nb_ligne_fic_nb");
ptr_fic_nb_ligne_nb = fopen("nb_ligne_fic_nb" ,"r");
fscanf(ptr_fic_nb_ligne_nb,"%d",&nb_ligne_fic_nb);
fclose(ptr_fic_nb_ligne_nb);
system("rm nb_ligne_fic_nb");


//traitement de tous les images rgb      
ptr_tmp_liste_nb = fopen("tmp_liste_nb","r");
ptr_fic_listbase = fopen("../DESCRIPTEURS/liste_base_image" ,"a");

for(int i=compteur_ID;i<nb_ligne_fic_nb+compteur_ID;i++ )
{

  fscanf(ptr_tmp_liste_nb,"%s",nom_fic);
  Descripteur=creer_descripteur("../DATA/IMAGE/NB/",nom_fic,i);
  ENFILER_IMAGE(&file_img,Descripteur);
  fprintf(ptr_fic_listbase,"ID %d : %s\n",i,nom_fic);

}

fclose(ptr_tmp_liste_nb);
fclose(ptr_fic_listbase);
system("rm tmp_liste_nb");


//ecriture de la file des descripteurs dans le fichier base_descripteur_image
ptr_fic_basedesc = fopen("../DESCRIPTEURS/base_descripteur_image" ,mode);
ECRIT_FILE_DESCRIPTEUR(file_img,ptr_fic_basedesc);
fclose(ptr_fic_basedesc); 


}




//
void Index_Image()
{

  //if(prem_index(chemin)==1)
    //{ 
  indexation_image("w");

    //}
  //else
   // {
      //indexation_image(chemin,"a");

   // }


}

