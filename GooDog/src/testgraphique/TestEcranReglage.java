package testgraphique;

import control.ControlModeGestion;
import vuegraphique.FrameReglage;

public class TestEcranReglage {

	public static void main(String[] args) {
		ControlModeGestion controlModeGestion = new ControlModeGestion();
		new FrameReglage(null,controlModeGestion); 
	}
}
