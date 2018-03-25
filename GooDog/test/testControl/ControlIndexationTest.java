package testControl;

import control.ControlVerifierIdentification;
import model.Indexeur;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControlIndexationTest {
    @Test
    public void verifierIdentification() throws Exception {
        ControlVerifierIdentification verifierAdmin= new ControlVerifierIdentification();
        assertTrue("Devrais etre true",verifierAdmin.verifierIdentification());
    }

    @Test
    public void indexer() throws Exception {

        Indexeur indexeur = new Indexeur();
        assertTrue("devrais etre true lors de l'indexion du image",indexeur.indexerImage());
        assertTrue("devrais renvoyer true lors de l'indexion du son ",indexeur.indexerSon());
        assertTrue("devrais etre true lors de l'indexion du texte",indexeur.indexerTexte());

    }

}