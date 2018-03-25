package vuetextuelle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichier {
	public void ecrire(String texte, String chemin) {
		try {
			File f = new File(chemin);
			f.createNewFile();
			FileWriter fw = new FileWriter(f, true);
			fw.write(texte+"\n");
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void effacer(String chemin) {
		try {
			File f = new File(chemin);
			f.createNewFile();
			FileWriter fw = new FileWriter(f, false);
			fw.write("");
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public ArrayList<Integer> lireInt(String chemin) {
		File f = null;
		Scanner scan = null;
		try{
		   f = new File(chemin);
		   scan = new Scanner(f);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

		ArrayList<Integer> x = new ArrayList<Integer>();
		//Assuming you know all data on the file are ints
		while(scan.hasNext())
		   x.add(scan.nextInt());
		return x;
	}
}
