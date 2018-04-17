package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;



public class PanReglage extends JPanel {

	private static final long serialVersionUID = -7586081042841575443L;
	
	Box boxMiseEnPageReglage = Box.createVerticalBox();
	JButton boutonConfig = new JButton();
	JButton boutonIndexation = new JButton();
	JButton boutonMode = new JButton();



	
	 public PanReglage() {
		super();
		// TODO Auto-generated constructor stub
	}




	public void initialisation() {
		this.setBackground(Color.WHITE);
		
		boutonConfig.setText("CONFIGURATION DE L'INDEXATION");
		boutonConfig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		boutonIndexation.setText("INDEXER");
		boutonIndexation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		boutonMode.setText("Changer de mode");
		boutonMode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageReglage.add(boutonConfig);
		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageReglage.add(boutonIndexation);
		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,50)));
		boxMiseEnPageReglage.add(boutonMode);
		boxMiseEnPageReglage.add(Box.createRigidArea(new Dimension(0,50)));

		boxMiseEnPageReglage.setVisible(true);
		this.add(boxMiseEnPageReglage);

		
	}


}
