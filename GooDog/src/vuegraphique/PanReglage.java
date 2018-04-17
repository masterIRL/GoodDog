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



	
	 public void initialisation() {
		this.setBackground(Color.RED);
		boutonConfig.setText("CONFIGURATION DE L'INDEXATION");
		boutonConfig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		boutonIndexation.setText("INDEXER");
		boutonConfig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		boutonIndexation.setText("Changer de mode");
		boutonConfig.addActionListener(new ActionListener() {
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

		
	}


}
