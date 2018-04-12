package vuegraphique;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanIndexer extends JPanel{

	private JButton buttonIndexImage=new JButton();
	private JButton buttonIndexTexte=new JButton();
	private JButton buttonIndexSon=new JButton();
	private Box boxMiseEnPageIndexation=Box.createVerticalBox();
	private Box boxChoixIndexImage=Box.createHorizontalBox();
	private Box boxChoixIndexTexte=Box.createHorizontalBox();
	private Box boxChoixIndexSon=Box.createHorizontalBox();
	private JCheckBox checkboxImage=new JCheckBox();
	
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
	
    public void initialisation(){
    	
    	this.setBackground(Color.WHITE);
    	boxMiseEnPageIndexation.add(Box.createRigidArea(new Dimension(0,30)));
    	
    	//bouton indexation Image
    	buttonIndexImage.setBackground(Color.WHITE);
    	buttonIndexImage.setForeground(new Color(59, 89, 182));
    	buttonIndexImage.setFocusPainted(false);
    	buttonIndexImage.setFont(new Font("Tahoma", Font.BOLD, 12));
    	buttonIndexImage.setText("Indexation Image");
    	buttonIndexImage.setBorderPainted(false);
    	buttonIndexImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	buttonIndexImage.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			checkboxImage.setSelected(true);
    			
    			
    		}
    	});
    	
    	buttonIndexImage.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonIndexImage.setForeground(new Color(59, 89, 182));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonIndexImage.setForeground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
		});
    	

  
    	checkboxImage.setBackground(Color.WHITE);
    	checkboxImage.setEnabled(false);
    	
    	boxChoixIndexImage.add(buttonIndexImage);
    	boxChoixIndexImage.add(checkboxImage);
    	boxMiseEnPageIndexation.add(boxChoixIndexImage);
    	boxMiseEnPageIndexation.add(Box.createRigidArea(new Dimension(0,30)));
    	
    	//bouton indexation texte
    	buttonIndexTexte.setText("Indexation Texte");
    	buttonIndexTexte.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    		}
    	});
    	boxChoixIndexTexte.add(buttonIndexTexte);
    	boxMiseEnPageIndexation.add(boxChoixIndexTexte);
    	boxMiseEnPageIndexation.add(Box.createRigidArea(new Dimension(0,30)));
    	
    	//bouton indexation Son
    	buttonIndexSon.setText("Indexation Son");
    	buttonIndexSon.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    		}
    	});
    	boxChoixIndexSon.add(buttonIndexSon);
    	boxMiseEnPageIndexation.add(boxChoixIndexSon);
    	boxMiseEnPageIndexation.add(Box.createRigidArea(new Dimension(0,30)));
    	
    	this.add(boxMiseEnPageIndexation);
    	
    	
		
    }
	private static final long serialVersionUID = 1L;

}
