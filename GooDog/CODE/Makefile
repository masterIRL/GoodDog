all: interface.out

interface.out : testInterface.o Interface.o descripteur_son.o file_son.o file_chaine.o descripteur_image.o file_image.o file_int.o arbre.o comparaison_image.o pile_carac.o indexation_texte.o descripteur_texte.o file.o file_descript_texte.o
	gcc testInterface.o Interface.o descripteur_son.o file_son.o file_chaine.o descripteur_image.o file_image.o file_int.o arbre.o comparaison_image.o pile_carac.o indexation_texte.o descripteur_texte.o file.o file_descript_texte.o -o interface.out -lm



#interface et main
testInterface.o : interface.h file_son.h file_chaine.h descripteur_son.h testInterface.c
	gcc -c testInterface.c

Interface.o : interface.h file_son.h file_chaine.h descripteur_son.h Interface.c
	gcc -c Interface.c


#comparaisons
comparaison_image.o : pile_carac.h file_image.h file_int.h arbre.h descripteur_image.h comparaison_image.h
	gcc -c comparaison_image.c

	
	

indexation_texte.o : indexation_texte.h file_descript_texte.h file.h file_chaine.h indexation_texte.c 
	gcc -c indexation_texte.c
	
	
	
#descripteur
descripteur_texte.o : descripteur_texte.h file.h  file_chaine.h descripteur_texte.c 
	gcc -c descripteur_texte.c

descripteur_image.o : file_image.h file_int.h descripteur_image.h descripteur_image.c
	gcc -c descripteur_image.c

descripteur_son.o : file_son.h file_chaine.h descripteur_son.h descripteur_son.c
	gcc -c descripteur_son.c 


#arbre
arbre.o : arbre.h arbre.c
	gcc -c arbre.c


#file
file.o : file.h file.c
	gcc -c file.c

file_descript_texte.o: file_descript_texte.h descripteur_texte.h file.h file_chaine.h file_descript_texte.c
	gcc -c file_descript_texte.c

file_image.o : file_image.h file_int.h file_image.c
	gcc -c file_image.c
	
file_int.o : file_int.h file_int.c
	gcc -c file_int.c

file_son.o : file_son.h file_chaine.h file_son.c
	gcc -c file_son.c

file_chaine.o : file_chaine.h file_chaine.c
	gcc -c file_chaine.c 

#pile 
pile_carac.o : pile_carac.h pile_carac.c
	gcc -c pile_carac.c