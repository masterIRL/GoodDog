package autre;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageJLabel extends JLabel{

	private static final long serialVersionUID = 1L;

	public ImageJLabel(String chemin, String description) {
		super();
		BufferedImage image=null;
		try {
			image = ImageIO.read(new File(chemin));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		this.setIcon(new ImageIcon(image));
		this.setToolTipText(description);
	}
	public ImageJLabel(String chemin) {
		super();
		BufferedImage image=null;
		try {
			image = ImageIO.read(new File(chemin));
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		this.setIcon(new ImageIcon(image));
	}

}
