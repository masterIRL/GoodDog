package test;


import control.ControlVerifierIdentification;
import model.FabriqueDescripteurs;
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
        FabriqueDescripteurs fabriqueDescripteurs = new FabriqueDescripteurs();
        assertTrue("devrais etre true lors de l'indexion du image",fabriqueDescripteurs.indexerImage());
        assertTrue("devrais renvoyer true lors de l'indexion du son ",fabriqueDescripteurs.indexerSon());
        assertTrue("devrais etre true lors de l'indexion du texte",fabriqueDescripteurs.indexerTexte());

    }

}