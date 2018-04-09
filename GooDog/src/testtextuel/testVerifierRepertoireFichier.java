package testtextuel;

import java.io.File;

public class testVerifierRepertoireFichier {

	public static void main(String[] args) {
		File f = new File("DESCRIPTEURS/ImageConfig");
		if(f.exists() && !f.isDirectory())
		{
		 System.out.println("fichier existant");
		}
		else {
			System.out.println("erreur");
		}
	}
}
