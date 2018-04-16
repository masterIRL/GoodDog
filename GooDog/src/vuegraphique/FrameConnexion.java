package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ControlSIdentifier;

public class FrameConnexion extends JFrame{

	private static final long serialVersionUID = 1L;
	private ControlSIdentifier controlSIdentifier;
	
	private FramePrincipal framePrincipal;
	
	private Box boxMiseEnPageConnexion = Box.createVerticalBox();
	private Box boxErreur = Box.createHorizontalBox();
	private Box boxLogin = Box.createHorizontalBox();
	private Box boxTexteLogin = Box.createHorizontalBox();
	private Box boxMDP = Box.createHorizontalBox();
	private Box boxTexteMDP = Box.createHorizontalBox();
	private Box boxBouton = Box.createHorizontalBox();

	private TextArea textAreaLogin = new TextArea();
	private TextArea textAreaMDP = new TextArea();
	
	private JButton buttonLogin = new JButton();

    JPanel panel = new JPanel(new FlowLayout());
    
	public FrameConnexion(FramePrincipal framePrincipal, ControlSIdentifier controlSIdentifier) {
		this.framePrincipal = framePrincipal;
		this.controlSIdentifier = controlSIdentifier;
		
		this.setTitle("connexion admin");
        this.setSize(new Dimension(700,500));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(920,700));
        
        this.initBoxMiseEnPageConnexion();
        this.panel.add(boxMiseEnPageConnexion);
        
        this.getContentPane().add(panel);
        this.setVisible(true);
	}	
	
	private void initBoxMiseEnPageConnexion() {
		
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,40)));
		
		boxMiseEnPageConnexion.add(getError());
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,30)));
		
		JLabel texteLogin=new JLabel("Pseudo");
		boxTexteLogin.add(texteLogin);
		boxMiseEnPageConnexion.add(boxTexteLogin);
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,5)));
		
		textAreaLogin.setMaximumSize(new Dimension(150,30));
		boxLogin.add(textAreaLogin);
		boxMiseEnPageConnexion.add(boxLogin);
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,15)));
		
		JLabel texteMDP=new JLabel("Password");
		boxTexteMDP.add(texteMDP);
		boxMiseEnPageConnexion.add(boxTexteMDP);
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,5)));
		
		textAreaMDP.setMaximumSize(new Dimension(150,30));
		boxMDP.add(textAreaMDP);
		boxMiseEnPageConnexion.add(boxMDP);
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,30)));
		
		buttonLogin.setText("LOG IN");
		buttonLogin.setMaximumSize(new Dimension(150,30));
		buttonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				identification();
			}
		});
		boxBouton.add(buttonLogin);
		boxMiseEnPageConnexion.add(boxBouton);
	}

    private Box getError() {
    	JLabel errorLabel = new JLabel("Login ou mot de passe incorrect");
        errorLabel.setForeground(Color.red);
        boxErreur.add(errorLabel);
        boxErreur.setVisible(false);
        return boxErreur;
    }
    
    private void identification() {
		int i=0;
		boolean identifiantOk = false;
		if(!identifiantOk || i < 3) {
			String login = textAreaLogin.getText();
			String mdp = textAreaMDP.getText();
			identifiantOk = controlSIdentifier.sIdentifier(login,mdp);
	        if(identifiantOk) {	
	        	framePrincipal.showPanAdmin(); //lancement passage à l'écran admin
	        	dispose();
	        }
	        else {
	        	boxErreur.setVisible(true);
	        }
	        i++;
		}
		
		else {
			dispose();
		}
	}
}
