package vuegraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import autre.ImageJLabel;
import control.ControlVerifierIdentification;

public class PanUser extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel panTop = new JPanel();
	private JPanel panCenter = new JPanel();
	
	private ImageJLabel labelConnect = new ImageJLabel("RESSOURCE/IMAGE/LogoAdmin.png");
	private ImageJLabel labelReglage = new ImageJLabel("RESSOURCE/IMAGE/IconeReglage.png");
	
	
	public PanUser() {
	}


	public void initialisation() {
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		this.panTop.setLayout(new BorderLayout());
		this.panTop.add(labelConnect,BorderLayout.WEST);
		this.panTop.add(labelReglage,BorderLayout.EAST);
		this.labelReglage.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			      new FrameReglage(new ControlVerifierIdentification()).reglage();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		this.add(panTop,BorderLayout.NORTH);
		
		JLabel texte = new JLabel("module de Recherche");
		this.panCenter.add(texte);
		this.add(panCenter,BorderLayout.CENTER);
		
		
	}

}
