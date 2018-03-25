package testControl;

import control.ControlIndexation;
import control.ControlVerifierIdentification;
import model.Indexeur;
import model.TypeFichier;

import org.junit.Test;

public class ControlIndexationTest {
	
	ControlVerifierIdentification controlVerifierIdentification;
	
	@Before
    public void setup(){
		controlVerifierIdentification = new ControlVerifierIdentification(); 
		ControlIndexation controlIdexation = new ControlIndexation(controlVerifierIdentification);
    	Assume.assumeNotNull(controlVerifierIdentification,ControlIndexation);
    }
	
	@Test
	public void createControlVerifierIdentification() {
		ControlIndexation controlIdexation = new ControlIndexation(controlVerifierIdentification);
		Assert.assertNotNull("Création d'un controler d'indexation", controlIdexation);
	}
	
    @Test
    public void verifierIdentification() throws Exception {
		ControlIndexation controlIdexation = new ControlIndexation(controlVerifierIdentification);
        Assert.assertTrue("Devrais etre true:",controlIdexation.verifierIdentification());
    }

    @Test
    public void indexer() throws Exception {
		ControlIndexation controlIdexation = new ControlIndexation(controlVerifierIdentification);
        Assert.assertTrue("Indexation image",controlIdexation.indexer(TypeFichier.IMAGE));
        Assert.assertTrue("Indexation son ",controlIdexation.indexer(TypeFichier.SON));
        Assert.assertTrue("Indexation texte",controlIdexation.indexer(TypeFichier.TEXTE));
    }

}