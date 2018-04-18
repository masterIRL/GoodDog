package testgraphique;

/* A Swing version of the Light switch GUI program  */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

@SuppressWarnings("serial")
class Lightbulb extends JComponent {
	private boolean isOn = false;
	@Override
	public void paintComponent(Graphics gc) {
		// display the lightbulb here
		if (isOn) {
			gc.setColor(Color.YELLOW);
		} else {
			gc.setColor(Color.BLACK);
		}
		gc.fillRect(0, 0, 100, 100);
	}
	
	public void flip() {
		isOn = !isOn;
		repaint();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100,100);
	}
	
}

class ButtonListener implements ActionListener {

	private Lightbulb bulb;
	public ButtonListener(Lightbulb b) {
		bulb = b;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		bulb.flip();
		
	}
	
}

class OnOffExample implements Runnable {
	public void run() {
		JFrame frame = new JFrame("On/Off Switch");

		// Create a panel to store the two components
		JPanel panel = new JPanel();	
		frame.add(panel);	

		JButton button = new JButton("On/Off");
		panel.add(button);

		Lightbulb bulb = new Lightbulb();
		panel.add(bulb); 
		
		bulb.flip();
		
		JButton button2 = new JButton("On/Off");
		panel.add(button2);

		Lightbulb bulb2 = new Lightbulb();
		panel.add(bulb2); 
		
		button2.addActionListener(new ButtonListener(bulb));
		button.addActionListener(new ButtonListener(bulb));
		button2.addActionListener(new ButtonListener(bulb2));
		button.addActionListener(new ButtonListener(bulb2));
		
		Timer t = new Timer(1000, new ButtonListener(bulb));
		t.start();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new OnOffExample()); 
	}
}



