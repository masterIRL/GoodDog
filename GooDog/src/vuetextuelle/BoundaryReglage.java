package vuetextuelle;


import control.ControlModeGestion;

import control.ControlVerifierIdentification;

public class BoundaryReglage {

    private ControlVerifierIdentification controller;

    public BoundaryReglage(ControlVerifierIdentification controller) {
        this.controller = controller;
    }


    public void reglage(){
        if(controller.verifierIdentification()){
            int choix =0;
            Clavier clavier = new Clavier();
            System.out.println("1. Mode Gestion \n" + "2. ConfigTexte\n" + "3. Config Son\n" + "4. Config Image\n");

            while(choix == 0 || choix >= 5 ){
                System.out.println("Veuillez entrez 1,2,3 ou 4");
                choix = clavier.entrerClavierInt();
            }

            switch (choix){
                case 1 :
                    new BoundaryModeGestion(new ControlModeGestion()).gestionMode();
                    break;
                case 2 :
                    new BoundaryConfigTexte().configurerSon();
                    break;
                case 3 :
                    new BoundaryConfigSon().configurerSon();
                    break;
                case 4 :
                    new BoundaryConfigImage().configurerImage();
                    break;
            }
        }
    }
}
