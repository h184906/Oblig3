package no.hvl.com.Oppgave4.unike;

import no.hvl.com.Oppgave4.MengdeADT;
import no.hvl.com.Oppgave4.SetToMengde;
import no.hvl.com.Oppgave4.TestHub;

public class MengdeSetToTest extends TestHub {
    
    @Override
    public MengdeADT<Integer> velger() {
        return new SetToMengde<>();
    }
}
