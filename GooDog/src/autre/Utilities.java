package autre;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Utilities {

	//REDIMENTSIONNER UNE IMAGE
	public static BufferedImage scale(BufferedImage bImage, double factor) {
		int destWidth=(int) (bImage.getWidth() * factor);
		int destHeight=(int) (bImage.getHeight() * factor);
		//créer l'image de destination
		GraphicsConfiguration configuration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		BufferedImage bImageNew = configuration.createCompatibleImage(destWidth, destHeight);
		Graphics2D graphics = bImageNew.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		//dessiner l'image de destination
		graphics.drawImage(bImage, 0, 0, destWidth, destHeight, 0, 0, bImage.getWidth(), bImage.getHeight(), null);
		graphics.dispose();

		return bImageNew;
	}
	
	//Fonction qui permet de faire apparaitre les résultats alignés à gauche
	public String aligner (String mot) {
		int espaces= Math.abs(100 - mot.length());
		System.out.println(espaces);
		String retour = new String();
		//retour = "";
 		for (int i=0; i<espaces; i++) {
			retour = retour + "|";
		}
 		System.out.println(retour.length());
 		return retour;
	}
}

//JDialog
