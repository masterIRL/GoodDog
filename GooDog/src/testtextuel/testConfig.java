package testtextuel;

import vuetextuelle.BoundaryConfigImage;
import vuetextuelle.BoundaryConfigSon;
import vuetextuelle.BoundaryConfigTexte;

public class testConfig {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("Image: ");
		BoundaryConfigImage boundaryConfigImage = new BoundaryConfigImage();
		boundaryConfigImage.configurerImage();
		System.out.println();
		System.out.println("Son: ");
		BoundaryConfigSon boundaryConfigSon = new BoundaryConfigSon();
		boundaryConfigSon.configurerSon();
		System.out.println();
		System.out.println("Texte: ");
		BoundaryConfigTexte boundaryConfigTexte = new BoundaryConfigTexte();
		boundaryConfigTexte.configurerTexte();
	}
}
