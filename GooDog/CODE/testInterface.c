#include "interface.h"

int main(){
	system("clear");
	printf("Indexation en cours, veuillez patienter  . . . . . . . . .\n");
	Index_Image();
	indexation_son("../DATA/SON/");
        indexation_texte("../DATA/TEXTE/");
	system("clear");
	test();
	return 0;
}