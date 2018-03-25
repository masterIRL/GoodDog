package control;
import java.lang.Math;
public class ControlConfig {
			
	public boolean verifInterval(int m, int n) {
		return (n>m);
	}

	public boolean verifEchantillon(int n) {
		return ( (Math.log((double)n)/Math.log(2.0))-(int)(Math.log((double)n)/Math.log(2.0))==0.0 ); 
	}

	public boolean verifQuantification(int n) {
		return ( (n>1) && (n<6) );
	}

}