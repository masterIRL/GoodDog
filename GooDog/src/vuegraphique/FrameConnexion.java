package vuegraphique;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

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
	private JPasswordField fieldMDP = new JPasswordField();
	
	private JButton buttonLogin = new JButton();

    JPanel panel = new JPanel(new FlowLayout());
    
	public FrameConnexion(FramePrincipal framePrincipal, ControlSIdentifier controlSIdentifier) {
		this.framePrincipal = framePrincipal;
		this.controlSIdentifier = controlSIdentifier;
		
		this.setTitle("Connexion administrateur");
        this.setSize(new Dimension(400,300));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.initBoxMiseEnPageConnexion();
        this.panel.add(boxMiseEnPageConnexion);
        
        this.getContentPane().add(panel);
        this.setVisible(true);
	}	
	
	private void initBoxMiseEnPageConnexion() {
		panel.setBackground(new Color(128,102,83));
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,10)));
		
		boxMiseEnPageConnexion.add(getError()); //ajout du label d'erreur 
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,10)));
		
		JLabel texteLogin=new JLabel("IDENTIFIANT"); //texte du login
		texteLogin.setForeground(Color.WHITE);
		boxTexteLogin.add(texteLogin);
		boxMiseEnPageConnexion.add(boxTexteLogin);
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,5)));
		
		textAreaLogin.setMaximumSize(new Dimension(150,30)); //zone d'ecriture du login
		textAreaLogin.setFont(new Font("Poppins-Black", Font.PLAIN,20));
		textAreaLogin.addKeyListener(new KeyListener(){
		    @Override
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB ){
		        	e.consume();
		        	fieldMDP.requestFocusInWindow(); //passer a la bare de mdp
		        }
		    }

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		boxLogin.add(textAreaLogin);
		boxMiseEnPageConnexion.add(boxLogin);
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,15)));
		
		JLabel texteMDP=new JLabel("MOT DE PASSE"); //texte du mdp
		texteMDP.setForeground(Color.WHITE);
		boxTexteMDP.add(texteMDP);
		boxMiseEnPageConnexion.add(boxTexteMDP);
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,5)));
		
		fieldMDP.setMaximumSize(new Dimension(150,30)); //zone d'ecriture securisee pour le mdp
		boxMDP.add(fieldMDP);
		boxMiseEnPageConnexion.add(boxMDP);
		boxMiseEnPageConnexion.add(Box.createRigidArea(new Dimension(0,15)));
		
		buttonLogin.setText("SE CONNECTER"); //bouton de connexion
		
		buttonLogin.setBackground(Color.WHITE);
		buttonLogin.setForeground(Color.BLACK); 
		buttonLogin.setFocusPainted(false);
		buttonLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		//buttonLogin.setBorderPainted(false);
		buttonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		
		buttonLogin.setMaximumSize(new Dimension(150,30));
		buttonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				identification();
			}
		});
		
		//pour se connecter avec le bouton "entrer"
		fieldMDP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				identification();
			}
		});
		boxBouton.add(buttonLogin);
		boxMiseEnPageConnexion.add(boxBouton);
	}

    private Box getError() { //recupere un bouton d'erreur
    	JLabel errorLabel = new JLabel("Login ou mot de passe incorrect");
        errorLabel.setForeground(Color.red);
        boxErreur.add(errorLabel);
        boxErreur.setVisible(false);
        return boxErreur;
    }
    
    private void identification() { //La fonction pour se connecter
		int i=0;
		boolean identifiantOk = false;
		if(!identifiantOk || i < 3) {
			String login = textAreaLogin.getText();
			String mdp = new String(fieldMDP.getPassword());
			System.out.println(mdp);
			identifiantOk = controlSIdentifier.sIdentifier(login,mdp);
	        if(identifiantOk) {	
	        	framePrincipal.showPanAdmin(); //lancement passage � l'�cran admin
	        	dispose();
	        }
	        else {
	        	boxErreur.setVisible(true);
	        }
	        i++;
		}
		
		else {
			dispose(); //ferme la fenetre
		}
	}
}
