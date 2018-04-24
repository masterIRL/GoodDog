package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameAide extends JFrame {

	private static final long serialVersionUID = 2932804857257376989L;
	private TextArea monTexte = new TextArea();
	private Box boxTexte = Box.createVerticalBox();
	
	
	
	
	public void aideAminFrancais() throws IOException {//pour l'admin
		String path = "CODE/aideAdminFr.txt";
		Path path1 = Paths.get(path);
		String ligne2 = "";
	List<String> texte = Files.readAllLines(path1,StandardCharsets.ISO_8859_1);
	for(String line : texte) {
		ligne2 +="\n"+line;
	}
	monTexte.setMaximumSize(new Dimension(1000, 1000));
	monTexte.setForeground(Color.gray);
	monTexte.setText(ligne2);
	JFrame frame = new JFrame(ligne2);
	boxTexte.add(monTexte);
	frame.setContentPane(boxTexte);
	frame.setTitle("Aide Admin");
	frame.setSize(400, 400);
	frame.setLocation(100, 100);
	frame.setVisible(true);
}
	
public void aideUserFrancais() throws IOException {//pour les user lambda
		String path = "CODE/aideFonctionnement du System.txt";
		Path path1 = Paths.get(path);
		String ligne2 = "";
	List<String> texte = Files.readAllLines(path1,StandardCharsets.ISO_8859_1);
	for(String line : texte) {
		ligne2 +="\n"+line;
	}
	monTexte.setMaximumSize(new Dimension(1000, 1000));
	monTexte.setForeground(Color.gray);
	monTexte.setText(ligne2);
	JFrame frame = new JFrame(ligne2);
	boxTexte.add(monTexte);
	frame.setContentPane(boxTexte);
	frame.setTitle("Fonctionnement de GooDog");
	frame.setSize(400, 400);
	frame.setLocation(100, 100);
	frame.setVisible(true);
}


/* pour l'aide admin, voici le code à mettre dans le listener: 
	PanAide aide = new PanAide(); // il sera mieu que tu declares cette variable plus haut;
	
	try {
		aide.aideAminFrancais();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
*/


/* pour l'aide generale, voici le code à mettre dans le listener: 	
	PanAide aide = new PanAide(); // il sera mieu que tu declares cette variable plus haut;
 
	/*try {
		aide.aideUserFrancais();
	} catch (IOException e) {
		e.printStackTrace();
	}*/


}
