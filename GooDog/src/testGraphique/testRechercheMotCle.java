package testGraphique;

import java.io.IOException;

import javax.swing.JFrame;

import control.ControlRecherche;
import vueGraphique.FrameRechercheAdmin;
import vueGraphique.FrameRechercheU;
import vueGraphique.FrameTestConfig;
import vueGraphique.PanRechercheMotCle;


public class testRechercheMotCle {

	public static void main(String[] args) throws IOException {
		ControlRecherche controlRecherche = new ControlRecherche();
		/* // JFrame test = new JFrame();
		// test.add(panTest);
		// test.isVisible();
		// panTest.isVisible();
		// panTest.enregistrerCoordonneesBancaires(1);
		JFrame fenetre = new JFrame();
		fenetre.setVisible(true);
		fenetre.setSize(800,400);

		 PanRechercheMotCle panTest = new PanRechercheMotCle(controlRecherche);
		 fenetre.setContentPane(panTest);
		 panTest.initialisation();
		 panTest.rechercheMotCle();
		 panTest.setVisible(true);
		 fenetre.repaint();*/
		
		new FrameTestConfig(controlRecherche);
	}

}

