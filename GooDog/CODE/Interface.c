/*****************************************************************************/
/*   INTERFACE PROJET FIL ROUGE                                            */
/*   DEVELOPPE PAR : BISSELOU-NZENGUE Stezen                                */
/****************************************************************************/

#include "interface.h"


/*****************************************************************************/
/*   FONCTION LIEES A LA ROBUTESSE DU PROGRAMME                              */
//****************************************************************************/


/* la fonction ViderBuffer permettant de vider le buffer.
/ cette fonction sera appelée par la foction lireChaine dans deux cas :
/ 1-si la chaine est trop longue(on le sait parceque qu'on doit pas trouver le caracter \n
/		dans la chaine copiée);
/ 2-s'il y a eu une erreure (peu importe laquelle), il faut vider là aussi le buffer pour 
/		qu'il n'y ait plus rien;*/

void ViderBuffer()
{
    int c=0;
    while(c!='\n' && c!=EOF)
    {
        c=getchar();
    }
}

/* la fonction lireChaine permet de controler la chaine que l'utilisateur rentre au clavier
/  elle va appeler fgets et si tout se s'est bien passé, 
/  elle va chercher le carcacter \n à l'aide la fonction strchr. 
/  si une entrée est trouvé, elle est remplacée par un \0 (fin de chaine)
/  pour eviter de conserver une "entrée" */  

int lireChaine(char *chaine)
{
   const int longueur = 100;
    char *positionEntrer = NULL;
		
// Vous noterez que je me permet d'appeler la fonction fgets directement dans un if, 
// Cela m'evite d'avoir à recuperer la valeur de fgets dans un pointeur juste pour 
//tester si elle est NULL ou non

				//on lit au clavier
    if(fgets(chaine, longueur, stdin)!=NULL)//pas d'erreur de saisi???
    {
        positionEntrer=strchr(chaine,'\n'); //on recherche l'"entrer"

        if(positionEntrer!=NULL)//si on a trouvé le retour à la ligne
        {
            *positionEntrer='\0';//on remplace par '\0'
        }
        else
        {
            ViderBuffer();
        }
        return 1;//renvoie 1 si la fonction s'est bien derouléé sans erreur
    }
    else
    {
        ViderBuffer();
        return 0;//renvoie 0 s'il y a eu une erreur
    }
}


/* la fonction lireLong() va appeler notre fonction lireChaine 
/  ensuite, grace à la fonction strtol, on coverti la chaine en long
/  le prototype de la fonction strtol est : 
/			long strtol( const char *start, char **end, int base);
/ 
/	 La foction lireLong() est un scanf utrat-Robuste et très puissant. Il faut d'abord declarer une variable de type long et initialiser à 0
/  cette fonction est faite de telle sorte qu'un float est converti en entier, ce qui est très utile dans certaines parties du programme,
/  par exemple pour les differentes configurations qui nessecites des entiers(nombre de bit de quantification) 
/
/  IMPORTANT : quand au pointeur de pointeur end , la fonction s'ensert pour renvoyer la position du 1er caractere qu'elle a lu
/  et qui n'etait pas un nombre. On ne s'en sert pas, on l'envoie donc NULL pour lui faire comprendre qu'on ne s'en sert pas.*/

long lireLong()
{
   char nombreTexte[100]={0};
   if(lireChaine(nombreTexte))
   {	
			/*la fonction lit la chaine de caractere que vous lui envoyez (start) et essaie de convertir en long 
			/en utilisant la base indiquée(la base 10 dans notre cas, de 0 à 9).elle return un nombre si elle a reussi à lire.*/	
			
       return strtol(nombreTexte, NULL, 10);
   }
   else
   {
       return 0;
   }
}

/* la fonction testMotValide valide prend en entré un mot/chemin saisi aux clavier
/  renvoie 1 si le mot/chemin est valide.
/  Mot invalide:moins de 3 caractères de l'alphabet ou bien un caracter non alhptabeiuqe.
/	 Chemin invade: mot correct se terminant par /
 */		


int testeMotValide(char mot[250])
{
     int i,j;
     j=0;

    if(lireChaine(mot)) //permet aussi de saisir un nombre au clavier
    {

         for(i=0;mot[i];i++)
            {
                if((mot[i]>='A')&& (mot[i]<='Z')||(mot[i]>='a')&& (mot[i]<='z') || (mot[i]=='/') || (mot[i]=='.') || ((mot[i]>='0') && (mot[i]<='9')))//verifie la caracteres d'un mot
                    {
                        mot[i]=mot[i];
                        j++;
                    }
		

                else
                   {
                       system("clear");
                       printf("\n Mot invalide !!\n\n");
		 printf("\n Entrez un mot/chemin pour votre recherche ! \n\n");
                       testeMotValide(mot);
                   }
            }

            if(j<3)//convention : un mot doit contenir aumoins 3 lettres
            {
                 system("clear");
                 printf("\n Mot Tres court saisissez au moins trois (3) caracters !!\n\n");
		 printf("\n Entrez un mot/chemin pour votre recherche ! \n\n");
                 testeMotValide(mot);

            }else if((3<=j) && (mot[j-1]=='/'))//convention : un ne doit pas terminer par /
            {
                 system("clear");
                 printf(" \n Chemin invalide\n\n Le caracter ( %c ) ne peut etre en fin de mot\n\n",mot[j-1]);
		 printf("\n Entrez un mot/chemin pour votre recherche ! \n\n");
                 testeMotValide(mot);
            }

        }
        else
        {
            system("clear");
            printf("\n Mot invalide !!\n Vous avez rentre des mauvais caracters !!\n\n");
            testeMotValide(mot);
        }

return 1;
}


/*fonction se renseignant sur la satisfaction de l'utilisateur
/elle est appelée à chaque fois que l'utilisateur decide de quitter une foctionnalité
/à chaque fois qu'un utilisateur n'est pas satisfait, on lui propose de rentrer un cimmentaire
/cela permetrait à l'administrateur(le seul qui à acce au commentaires) de pouvoir configurer selon les commentaires 
/et de repondre ainsi aux satisfactions de tous*/

void satisfactionUtilisateur()
{
    FILE *F;//cette declaration permet de "creer un canal vers un ficher"
	long k=0;//je vais utiliser la fonction lireLong pour saisir aux clavier toutes ces variables servant à entrer les choix des utilisateur
	long j=0;
	long i=0;
 
  char commentaire[200];
    system("clear");
     printf(" \nEtes-Vous satisfait?\n\n 1 Pour oui\n 2 Pour non\n\n");

    j=lireLong();//permet de saisir au clavier: equivalent à scanf et gets, son rol est decritci-dessu.
     switch(j)
     {
     case 1:
            system("clear"); //si on est satisfait on sort
            break;
     case 2:
            system("clear");
     //si l'utilisateur n'est pas satisfait on lui propose de rentrer un rentre un commentaire
            printf(" Entrez : \n\n 1 Si vous avez un commentaire particulier a faire\n Remarque : n'importe quelle caractere permet de confirmer la sortie : \n\n");
		k=lireLong();
		if(k==1)
			{
				printf(" Entrez Votre commentaire\n\n");
		                lireChaine(FicherAide.commentaire);
		                fflush(stdin);
		                F=fopen("appreciation.txt","a");
		                fprintf(F, "\n %s ",FicherAide.commentaire);
		                fclose(F);
		                system("clear");
                   	}
            system("clear");
            break;
     default :
        system("clear");
        printf(" Entrez la bonne valeur SVP !\n\n");
        satisfactionUtilisateur();
        break;
}
}

/*permet de chercher un mot: l'utilisateur ne peut entrer que 50 caracteres aux maximun:c'est largement suffisant. 
/donc prend en entré un mot saisi au clavier et renvoi un ensemble de resultats correspondant à la recherche.
/On rappel que l'on peut faire la recherche soit d'un texte, une image ou bien un son 
/apres l'affichage de chaque resultat, le menu recherche reapparait : c'est la recursivité*/
char Recherche(char mot[250])
{
    long choix=0;
    printf(" Quelle recherche voulez-vous faire? \n\n 1 Pour le Texte\n 2 Pour L'Image\n 3 Pour le Son\n 4 Pour Sortir\n\n");
    choix=lireLong();
    switch(choix)
    {
    case 1:
        system("clear");
        printf("\n Entrez un mot/chemin pour votre recherche ! \n\n");
        if(testeMotValide(mot))
        {
            system("clear");

            printf(" Resultat de la requete : %s \n\n",mot);
        }
        Recherche(mot);
        break;
    case 2:
        system("clear");
        printf("\n Entrez un mot/chemin pour votre recherche ! \n\n");
        if(testeMotValide(mot))
        {
            system("clear");

            printf("Requête image: ' %s\n ' ",mot);
            result_compare_image(mot);
        }
        Recherche(mot);
        break;
    case 3:
        system("clear");
        printf("\n Entrez un mot/chemin pour votre recherche ! \n\n");
        if(testeMotValide(mot))
        {
            system("clear");
            printf(" Resultat de la requete : %s \n\n",mot);
        }
        Recherche(mot);
        break;
    case 4:
        system("clear");
        break;
    default :
        system("clear");
        Recherche(mot);
}
}

/*******************************************************************/
//*         DEBUT FONCTION SPECIFIQUES ADMIN                      */
/******************************************************************/

/* Cette fonction permet de saisir au clavier un mot de passe pour passer en mode Admin */
int mot_de_passe(long login2){
    long login1=123456;
		login2=0;
    int i=3;
    system("clear");
do{

printf("\n Entrez le mot de passe pour passer en mode Admin: \n");
login2=lireLong();
if(login1==login2){
    system("clear");
    printf("\n Mot de passe correct ");
    return 1;
}
else
{
    system("clear");
    i--;
    printf(" Mot de passe incorect, il vous reste %d tantative(s)\n",i);
}
}while(login1!=login2 && i<=3 && 1<=i);
return -1;
}

/*cette fonction permet de presenter l'aide à l'administrateur pour mieux connaitre le role et les tâches d'un administrateur
/en fonction du choix de l'utilisateur, on peut soit, choisir de lire en anglais ou en francais*/
void aideAdmin()
{
  FILE *F;
  FILE *F2;
  long opperation=0;
  long i=0;
printf(" Entrez la langue \n\n 1 Pour Lire en Anglais \n 2 Pour Lire En Francais\n 3 Pour quitter l'Aide\n\n");
i = lireLong();

switch(i)
{
case 1:
         system("clear");
        F=fopen("aideAdminAn.txt","r");
        do
        {
            fscanf(F,"\n%s\t",FicherAide.mots);
            fflush(stdin);
            printf(" %s",FicherAide.mots);
        }while(!feof(F));
        fclose(F);
        aideAdmin();
        break;
case 2:
         system("clear");
         F2=fopen("aideAdminFr.txt","r");//j'ouvre en mode lecture mon fichier contenant l'aide....
        do
        {
            fscanf(F2," %s \t",FicherAide.mots);
            fflush(stdin);
            printf(" %s",FicherAide.mots);
        }while(!feof(F2));
        fclose(F2);//...je le ferme
        aideAdmin();
        break;
case 3:
          system("clear");
          satisfactionUtilisateur();	
break;
default :
	system("clear");
	printf(" Rentrez une des valeur indiquee\n\n");
	aideAdmin();
	break;
}
}

//identique à la fonction aideAdmin, sauf qu'ici, cette aide est accessible à tous les utilisateurs tjrs en anglais ou en fransais
void fonctionnaliteSystem()
{
  FILE *F;
  FILE *F2;
	long i=0;
printf(" Entrez la langue \n\n 1 Pour Lire en Anglais \n 2 Pour Lire En Francais\n 3 Pour quitter l'Aide\n\n");
i = lireLong();
switch(i)
{
case 1:
         system("clear");
        F=fopen("moteurDeRechercheAnglais.txt","r");//j'ouvre en lecture mon fichier contenant la description duy moteur de recherchr....
        do
        {
            fscanf(F," %s \t",FicherAide.mots);
            fflush(stdin);
            printf(" %s",FicherAide.mots);
        }while(!feof(F));
        fclose(F);//....je le ferme
        aideAdmin();
        break;
case 2:
         system("clear");
         F2=fopen("moteurDeRechercheFrancais.txt","r");
        do
        {
            fscanf(F2," %s \t",FicherAide.mots);
            fflush(stdin);
            printf(" %s",FicherAide.mots);
        }while(!feof(F2));
        fclose(F2);
       fonctionnaliteSystem();
        break;
case 3:
         system("clear");
         satisfactionUtilisateur();
         break;
default :
    system("clear");
    fonctionnaliteSystem();
    break;

}
}

/*********fonction permettant de configurer l'indexation d'un texte Texte**********
/lors de cette configuration, on peut changer:le nombre d'occurence, le nombre de mot et le nombre de lettre.*/
void ConfigTexte()
{
    char K;//rien de particulier, ces deux char me permettront de montrer qqu'on peut aussi securiser l'entré au clavier avec un scanf("%c",&k) par exemple
    FILE * F;
    FILE *F2;
    int i;
   
        F=fopen("configTexte.txt","r");//j'ouvre en mode lecture mon fichier contenant le fichier de configuration texte....
        fscanf(F, " %f %d %d",&ficherconfigTexte.seuilModif,&ficherconfigTexte.nombreMotModif,&ficherconfigTexte.nombreLettreModif);
        printf(" \n\n Valeur de Configuration :\n\n");
	printf(" Valeur du seuil            :\t%.2f \n",ficherconfigTexte.seuilModif);
        printf(" Valeur du nombre de mots   :\t%d \n",ficherconfigTexte.nombreMotModif);
        printf(" Valeur du nombre de lettre :\t%d \n",ficherconfigTexte.nombreLettreModif);
        fclose(F);
        printf(" \n\n  Entrez :\n\n 1 pour modifier \n 2 pour revenir au menu de configuration\n\n ");
     scanf("%c",&K);//on pouvai aussi convertir en un entier(je le ferai ci-dessous(ref1))
     fflush(stdin);
   if(K=='1')
	{
                system("clear");
                F=fopen("configTexte.txt","w+");
                printf("\n Rentrez la nouvelle valeur du seuil            : ");
                scanf("%f",&ficherconfigTexte.seuilModif);
                //fflush(stdin);
                printf("\n Rentrez la nouvelle valeur du nombre de lettre : ");
                scanf("%d",&ficherconfigTexte.nombreLettreModif);
                // fflush(stdin);
                printf("\n Rentrez la nouvelle valeur du nombre de mot    : ");
                scanf("%d",&ficherconfigTexte.nombreMotModif);
                //fflush(stdin);
              fprintf(F,"%f\n%d\n%d \n",ficherconfigTexte.seuilModif,ficherconfigTexte.nombreMotModif,ficherconfigTexte.nombreLettreModif);
              fclose(F);
	      system("clear");
	      printf("\n\n Configuration Reussie !!!\n\n");
	       ConfigTexte();
		
           }
     else if(K=='2')
	{
             system("clear");
             //fonctionAdmin();
         }
    else
	{
             system("clear");
             printf(" \nRentrez l'une des valeures indiquee SVP\n\n");
             ConfigTexte();
         }

}


/******configurer l'indexationle du son.......*
/lors de la congiguration, l'Admin peut changer soit: le nombre d'echantillons par fenêtre ou bien l'intervalle par fenetre.
//
//Attention: l'echantillon doit etre une puissance de 2 et l'intervalle doit toujours etre inferieur à l'echantillon*/
void configSon()
{
    FILE * F=NULL;
    char c;
    long j=0;
    //Affichage d'un fichier : Faire des fscanf(F,"%s",ligne) tant que tu es pas a la fin du fichier, puis printf("%s",ligne)
        F=fopen("../DESCRIPTEURS/config_son.txt","r");
        fscanf(F, " %d %d",&ficherConfigSon.echantillonageParFenetre,&ficherConfigSon.intervalFenetre);
        printf(" \n\n Valeur de Configuration :\n\n");
        printf(" Nombre d'ecchantillonage par fenetre :\t%d \n",ficherConfigSon.echantillonageParFenetre);
        printf(" Valeur de l'interval par fenetre     :\t%d \n",ficherConfigSon.intervalFenetre);
	fclose(F);
        printf(" \n\n Entrez :\n\n 1 pour modifier \n 2 pour revenir au menu de configuration\n\n ");
        j=lireLong();
if(j==1)
    	 {
	   F=fopen("../DESCRIPTEURS/config_son.txt","w+");//ouvre le ficher en ecriture pour modifierle fichier de configuration du son
	system("clear");


        printf("\n Entrez le nouveau nombre d'echantillons par fenetre : ");
        scanf("%d",&ficherConfigSon.echantillonageParFenetre);
        while(ceil(log(ficherConfigSon.echantillonageParFenetre)/log(2))!= (log(ficherConfigSon.echantillonageParFenetre)/log(2))){//le nombre de bit de quantifiquation doit etre une puissance de 2{
            printf(" \n Le nombre d'echantillons par fenetre %d n'est pas une puissance de 2!",ficherConfigSon.echantillonageParFenetre);
            printf("\n Rentrez de nouveau le nombre d'echantillons par fenetre : ");  
            scanf("%d",&ficherConfigSon.echantillonageParFenetre);
        }
        
        
        printf("\n Rentrez de nouveau le nombre d'invervalles par fenetre : ");  
        scanf("%d",&ficherConfigSon.intervalFenetre);
        while(ficherConfigSon.echantillonageParFenetre<ficherConfigSon.intervalFenetre){
            printf("\n Le nombre d'intervalles par fenetre doit etre inferieur à %d !",ficherConfigSon.intervalFenetre);
            printf("\n Rentrez de nouveau le nombre d'invervalles par fenetre : ");        
            scanf("%d",&ficherConfigSon.intervalFenetre);
    }
        
                fprintf(F,"%d\n%d\n",ficherConfigSon.echantillonageParFenetre,ficherConfigSon.intervalFenetre);
	        fclose(F);
		system("clear");
	        printf("\n\n Configuration Reussie !!!\n\n");
		configSon();
          }
    else if(j==2)
	{
         system("clear");
         //on sort
        }
     else
	{
        system("clear");
        printf(" \n Rentrez l'une des valeures indiquee SVP\n\n");
        configSon();
        }
}

/******fonction permettant de configurer l'indexation de l'image.......*
/lors de la configuration, on ne peut changer que le nombre de bit de quantification
//
//Attention: le nombre de bit de quantification doit etre un entier compris entre 0 et 5*/
void configImage()
{
    FILE * F=NULL;
    FILE * F2=NULL;
    long j=0;
    long l=0;
    long choix=0;
   // char c,c1;
        F=fopen("../DESCRIPTEURS/ImageConfig","r");
        fscanf(F, " %d ",&ficherConfigImage.precision);
        system("clear");
        printf(" \n\n Valeur de Configuration :\n\n");
        printf(" Nombre de bits de quantification :\t%d \n",ficherConfigImage.precision);
				fclose(F);
        printf(" \n\n Entrez :\n\n 1 pour modifier \n 2 pour revenir au menu de configuration\n\n ");
	choix=lireLong();
     switch(choix)
	{
    	 case 1: 
		
	system("clear");
	F=fopen("../DESCRIPTEURS/ImageConfig","w+");//ouverture en mode ecriture

	printf("\n Entrez le nouveau nombre de bit de quantification : entrez les entiers compris entre 2 et 5 : ");
	l=lireLong();
	while(l<2 || l>5)//le nombre de bit de quantifiquation doit etre une puissance de 2
	{
	system("clear");
	printf("\n Mauvaise valeur !!! \n\n");
	printf("\n Entrez le nouveau nombre de bit de quantification : entrez les entiers compris entre 1 et 5 : ");
	l=lireLong();
	}
				ficherConfigImage.precision=l;
				fprintf(F,"%d\n",ficherConfigImage.precision);//saisie du nouveau nombre de bit de quantification
        fclose(F);
        system("clear");
        printf("\n\n Configuration Reussie !!!\n\n");
			  configImage();
	break;
  
    case 2:
          system("clear");
         //on sort
        break;
     default :
         system("clear");
         printf(" \n Rentrez l'une des valeures indiquee SVP\n\n");
         configImage();
       break;
}
}


//permet de configurer les fichiers texte, son ou image selon le choix le l'administrateur 
void configurer()
    {
        char k;
        char *chemin;
		long i=0;
        printf(" Entrez : \t\t\t\t\t\t\t****Configer****\n\n 1 Pour la configuration du Texte\n 2 Pour la configuration de l'Image\n 3 Pour la configuration du Son\n 4 Revenir au menu Admin\n\n");
      i=lireLong();
	/*scanf("%c",&k);
	fflush(stdout);
    fflush(stdin);
	i=k-'0';//ref1*/

  
if(i==1)
	{
            system("clear");
	    printf("\t\t\t\t\t\t\t\t****ADMIN*****\n\n");
	    printf("\t\t\t \t\t\t\t*Config Texte*\n\n");
            ConfigTexte();
            configurer();
	}
else if(i==2)
	{
	    system("clear");
            printf("\t\t \t\t\t\t****ADMIN*****\n\n");
	    printf("\t\t \t\t\t\t*Config Image*\n\n");
            configImage();
	    system("clear");
	    printf(" Configuration ressie avec succes\n");
            configurer();
	}
else if(i==3)
	{
            system("clear");
            printf("\t\t\t\t\t\t****ADMIN*****\n\n");
	    printf("\t\t\t\t\t\t*Config Son*\n\n");
            configSon();
	    system("clear");
	    printf(" Configuration ressie avec succes\n");
            configurer();
	}
else if(i==4)
	{
            system("clear");
            fonctionAdmin();
	}
else
	{
            system("clear");
            printf(" \n Rentrez l'une des valeures indiquee SVP\t\t\t****ADMIN****\n\n");
            configurer();
	}
 }

//permet d'indexer une base de donné texte, image ou son selon le choix rentré par l'administrateur
void indexer()
    {
        long i=0;//choix
        char mot[50];//mot qui sera rentré par l'utilisateur
				char *chemin;

       	printf(" Entrez : \n\n 1 Pour l'indexation du Texte\n 2 Pour l'indexation de Image\n 3 Pour l'indexation Son\n 4 Pour quitter\n\n");
        i=lireLong();
        switch(i)
            {
        case 1:

                        system("clear");
                        printf("\t\t\t\t****ADMIN****\n");
                        printf("\n                 \t\t\t\t*Indexer Texte*\n\n");
			printf(" Indexation en cours.......\n\n");
                        indexation_texte("../DATA/TEXTE/");
                        //if(indexation_texte(chemin)==1){
                        system("clear");
                        printf(" \n  L'indexation du texte a reussie avec succes \n\n");
			/*}else printf(" Une erreur est survenue lors de l'indexation\n\n");*/
                        indexer();
                        break;
        case 2:

                        system("clear");
                        printf(" \t\t\t\t****ADMIN****\n");
                        printf("\n                 \t\t\t\t*Indexer Image*\n\n");
			printf(" Indexation en cours.......\n\n");
                        Index_Image();
                        system("clear");
                        printf(" \n  L'indexation de l'image a reusie avec succes \n\n");
                        indexer();
                        break;
        case 3:
                        system("clear");
                        printf(" \t\t\t\t****ADMIN****\n");
                        printf("\n                 \t\t\t\t*Indexer Son*\n\n");
			printf(" Indexation en cours.......\n\n");
                        if(indexation_son("../DATA/SON/")==1){
                        system("clear");
                        printf(" \n  L'indexation du son a reusie avec succes \n\n");
			}else printf(" Une erreur est survenue lors de l'indexation !!!!!!!\n\n");
                        indexer();
                        break;
        case 4 :
								    system("clear");
								    break;
		   default:
                    system("clear");
                    printf("\n\n \t\t\t\t****ADMIN****\n\n");
                    indexer();
                    break;

                }
}
void ficher()//non util permet de créer mes fichiers config pour tester ma partie
{
    FILE *F4;
    F4=fopen("configImage.txt","w+");
    scanf("%d",&ficherConfigImage.precision);
    fprintf(F4, " %d ",ficherConfigImage.precision);
   fclose(F4);
}

/* fonctionAdmin est la fonction qui regroupe l'ensemble des fonctions utilisé par l'administrateur.
/ Dans la fonction Admin ci-dessous, une fois le mots de passe correct, fonctionAdmin sera appelée*/
void fonctionAdmin()
{
    FILE *F;
    FILE *F2;
    char mot[50];
    long opperation=0;
printf("\t\t\t\t****ADMIN****\n\n Entrez : \n\n 1 Pour l'indexation\n 2 Pour la recherche\n 3 Pour configurer\n\n 4 Pour consulter les appreciations des utilisateurs\n 5 Pour revenir au Menu Principal\n 0 Pour l'Aide\n\n");
opperation=lireLong();
switch(opperation)
{
case 1 :
    system("clear");
    printf("\n Vous avez choisi l'indexation ! \t\t\t\t****ADMIN****\n\n");
    indexer();
    fonctionAdmin();
    break;
case 2 :
    system("clear");
    printf("\n Vous avez choisi la recherche !\t\t\t\t****ADMIN****\n\n");
    Recherche(mot);
    fonctionAdmin();
    break;
case 3 :
    system("clear");
    printf("\n Vous avez choisi la configuration ! \t\t\t\t****ADMIN****\n\n");
    configurer();
    fonctionAdmin();
    break;
case 4:
        system("clear");
        F=fopen("appreciation.txt","a");
        printf(" \n\t\t\nINFORMATIONS UTILISATEURS\t\t\t****ADMIN****\n\n\n");
        F=fopen("appreciation.txt","r");
        printf(" Debut commentaires :***************************************** \n\n\n\n");
        do
        {
            fscanf(F," \n %s\n ",FicherAide.commentaire);
            fflush(stdin);
            /*printf(" %d ",FicherAide.insatisfaction); jai nannulé
            printf(" %d ",FicherAide.satisfaction);*/// j'ai annulé
            printf(" %s ",FicherAide.commentaire);
        }while(!feof(F));
        fclose(F);
         printf(" \n\n\n\n Fin de(s) commentaire(s).************************************ \n\n\n");
         fonctionAdmin();
        break;
case 5 :
    system("clear");
        break;
case 0:
        system("clear");
        aideAdmin();
        fonctionAdmin();
        break;
default :
        system("clear");
        printf(" \nRentrez l'une des valeur indiquee SVP\n\n");
        fonctionAdmin();
        break;
}
}

/* fonction Admin permet de passer en mode Admin et de beneficier de toutes les fonctionalitée qui lui sont dûes.
/  pour cela, il faudra d'abord rentrer un mode passe correct.
/  si vous saisisez 3 fois un mauvais mot de passe, vous ne pourriez plus continuer.
/  on vous propose soit de consulter l'aide ou bien de revenir au menu principal */
void Admin(int operation)
{
    void sousfonctionAdmin()
         {
          int l;
	  char c;
          system("clear");
          printf(" Vous n'avez plus le droit de continuer\n\n Entrez :\n\n 1 pour plus d'informations\n 2 Pour revenir au menu principal\n\n");
          scanf("%c",&c);
	   l=c-'0';
          if(l==1)
            {
             system("clear");
             aideAdmin();
            }
        else if(l==2)
        {
            system("clear");
        }else
        {
            sousfonctionAdmin();
        }
    }
    int i;
    if(mot_de_passe(operation)==1)
    {
        fonctionAdmin();
    }
    else
    {
        printf(" \n!!! Vous n'avez plus le droit de continuer !!!\n\n Entrez :\n\n 1 pour plus d'information\n 2 Pour revenir au menu principal \n\n");
        scanf("%d",&i);
        switch(i)
        {
        case 1:
            system("clear");
            aideAdmin();
            break;
        case 2:
            system("clear");
            break;
        default :
        system("clear");
         sousfonctionAdmin();
         break;

        }
    }

}

/************** FIN FONCTION SPECIFIQUES ADMIN     *************/

/******Fonction utilisateur****
/elle permet d'effectuer une recherche soit d'un texte, d'une image ou d'un mot, selon le choix de l'utilisateur*/

int UserLambda()
{
    char mot[50];
    long i;
    printf("\n Vous etes en mode utilisateur lambda\t\t\t**********USER**********\n\n");
    printf(" Entrez \n\n 1 Pour la Recherche\n 2 Pour revenir au menu principal\n\n");
    i=lireLong();
    if(i==1)
        {
            system("clear");
            Recherche(mot);
        }else if(i==2)
        {
            system("clear");
        }else
        {
            system("clear");
            printf("entrez 1 ou 2 SVP\n\n");
            UserLambda();
        }
}
/*****fonction de test *************
/permet de executer mon programme. cette fonction regroupe toutes les fonctionalitées du moteur de recherche. 
/Vous pouvez passer en mode Admin ou bien utilisateur lambda et effectuer differentes tâches selon votre menu
/ vous pouvez aussi consulter le fonctionnement du moteur de cherche*/ 
void test()
{
long opperation;
char mot[50];
char *configTexte;

   char motCle[50];
   int rep;
   long choix,choix2;
   int login;
   int mode,mode2;
       printf("******************************************\n");
       printf("***********      GOODOG        ***********\n");
       printf("***********  MENU PRINCIPAL    ***********\n");
       printf("******************************************\n\n");
       printf(" 1 Mode administrateur\n");
       printf(" 2 Mode utilisateur\n");
       printf(" 3 Fonctionement du moteur de recherche.\n");
       printf(" 4 Quitter\n\n");
       do
       {
          printf("\n Entrez votre choix :\t ");
          choix =lireLong();
        }while(choix!=1 && choix!=2 && choix!=3 && choix!=4);
       switch(choix)
       {
       case 1:
           system("clear");
            Admin(login);
            test();
            break;
        case 2 :
                system("clear");
               UserLambda();
                test();
                break;
        case 3:
            system("clear");
           fonctionnaliteSystem();
            test();
            break;

        case 4 :
                system("clear");
 printf(" Entrez : \n\n 1 Pour annuler votre sortie \n Remarque : n'importe quelle caractere permet de confirmer la sortie : \n\n");
                choix2=lireLong();
                if(choix2==1)
                {
                    system("clear");
                    test();
                }   
                 satisfactionUtilisateur();
               	
	    printf(" |****************************************************************|\n");
	    printf(" |*****                        GOODOG                         ****|\n");
	    printf(" |*****    Merci d'avoir choisi notre moteur de recherche     ****|\n");
	    printf(" |*****      Entrez ./interface.out pour le reutil       ****|\n");
	    printf(" |****************************************************************|\n");

            break;
        default :
            system("clear");
            printf(" \n Choix invalide : Rentrez l'une des valeur indiquee SVP\n\n");
            test();
            break;
}
}


