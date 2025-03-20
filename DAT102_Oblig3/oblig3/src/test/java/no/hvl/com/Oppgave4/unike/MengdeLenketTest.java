package no.hvl.com.Oppgave4.unike;

import no.hvl.com.Oppgave4.MengdeADT;
import no.hvl.com.Oppgave4.LenketMengde;
import no.hvl.com.Oppgave4.TestHub;


public class MengdeLenketTest extends TestHub{
    
    @Override
    public MengdeADT<Integer> velger() {
        return new LenketMengde<>();
    }
}
