package vue;

import control.ControlSIdentifier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class EcranConnexionAdmin extends JFrame {

    private JButton buttonLogin;
    private JLabel errorLabel;


    public EcranConnexionAdmin(){
        this.setTitle("conexion admin");
        this.setSize(new Dimension(700,500
        ));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(920,700));
        initIHM();
    }

    private void initIHM() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(getButtonLogin());
        panel.add(getErrorLabel());
        this.getContentPane().add(panel);
        this.setVisible(true);
    }

    public JButton getButtonLogin() {
        if(buttonLogin == null){
            buttonLogin = new JButton("Bon Login");
            buttonLogin.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Random random = new Random();
                    if(!random.nextBoolean()){
                        errorLabel.setVisible(true);
                    }else{
                        ControlSIdentifier.getInstance().setEcranAcceuilAdmin();
                        EcranConnexionAdmin.this.dispose();
                    }
                }
            });
        }
        return buttonLogin;
    }

    public JLabel getErrorLabel() {
        if(errorLabel == null){
            errorLabel = new JLabel("Afficher la liste des erreurs..");
            errorLabel.setForeground(Color.red);
            errorLabel.setVisible(false);
        }
        return errorLabel;
    }
}
