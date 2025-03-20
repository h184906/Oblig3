package no.hvl.com.Oppgave4.unike;

import no.hvl.com.Oppgave4.MengdeADT;
import no.hvl.com.Oppgave4.TabellMengde;
import no.hvl.com.Oppgave4.TestHub;

public class MengdeTabellTest extends TestHub {
    
    @Override
    public MengdeADT<Integer> velger() {
        return new TabellMengde<>();
    }
}
