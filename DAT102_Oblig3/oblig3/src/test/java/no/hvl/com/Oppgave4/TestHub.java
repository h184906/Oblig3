package no.hvl.com.Oppgave4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class TestHub {

    private MengdeADT<Integer> mengde, annenMengde, test, feil, tom;


    public abstract MengdeADT<Integer> velger();

    @BeforeEach
    void setUp() {
        this.mengde = velger();
        this.annenMengde = velger();
        this.test = velger();
        this.feil = velger();
        this.tom = velger();

        mengde.leggTil(1);
        mengde.leggTil(7);
        mengde.leggTil(4);
        mengde.leggTil(13);
        annenMengde.leggTil(1);
        annenMengde.leggTil(2);
        annenMengde.leggTil(3);
        annenMengde.leggTil(6);
        annenMengde.leggTil(9);
        test.leggTil(1);
        test.leggTil(2);
        feil.leggTil(99999);
        feil.leggTil(9871243);



    }

    @Test
    void testAntallElementer() {
        assertEquals(mengde.antallElementer(), 4);
        assertEquals(annenMengde.antallElementer(), 5);
        assertEquals(test.antallElementer(), 2);
        assertEquals(feil.antallElementer(), 2);
    }

    @Test
    void testErDelmengdeAv() {
        assertFalse(mengde.erDelmengdeAv(annenMengde));
        assertTrue(test.erDelmengdeAv(annenMengde));
        assertFalse(mengde.erDelmengdeAv(test));
        assertFalse(feil.erDelmengdeAv(test));
    }

    @Test
    void testErDisjunkt() {
        assertTrue(mengde.erDisjunkt(feil));
        assertTrue(feil.erDisjunkt(test));
        assertFalse(test.erDisjunkt(annenMengde));
        assertFalse(mengde.erDisjunkt(annenMengde));
    }

    @Test
    void testErLik() {
        assertFalse(mengde.erLik(annenMengde));
        assertFalse(test.erLik(annenMengde));
        assertFalse(feil.erLik(annenMengde));
        assertTrue(annenMengde.erLik(annenMengde));
    }

    @Test
    void testErTom() {
        assertTrue(tom.erTom());
        assertFalse(test.erTom());
    }

    @Test
    void testFjern() {
        assertEquals(test.antallElementer(), 2);
        test.fjern(1);
        assertEquals(test.antallElementer(), 1);
        assertEquals(mengde.fjern(42), null);
    }

    @Test
    void testInneholder() {
        assertFalse(test.inneholder(14));
        assertFalse(mengde.inneholder(0));
        assertTrue(annenMengde.inneholder(1));
    }

    @Test
    void testMinus() {
        tom.leggTilAlleFra(test);
        tom.leggTil(3);
        
        MengdeADT<Integer> resultat = tom.minus(test); 

        assertTrue(resultat.inneholder(3));
        assertFalse(resultat.inneholder(2));
        assertEquals(resultat.antallElementer(), 1);

        resultat.leggTil(2);
        assertEquals(resultat.antallElementer(), 2);
    }

    @Test
    void testSnitt() {

        MengdeADT<Integer> snitt = test.snitt(annenMengde);

        assertTrue(snitt.inneholder(1));
        assertTrue(snitt.inneholder(2));
        assertFalse(snitt.inneholder(3));
        assertEquals(snitt.antallElementer(), 2);


    }

    @Test
    void testTilTabell() {
        Object[] faktisObj = test.tilTabell(); 
        Integer[] faktis = new Integer[faktisObj.length];
    
        for (int i = 0; i < faktisObj.length; i++) {
            faktis[i] = (Integer) faktisObj[i]; 
        }
    
        Integer[] forventet = {1, 2};
    
        assertEquals(forventet.length, faktis.length);
    
        for (int i = 0; i < forventet.length; i++) {
            Arrays.sort(forventet);
            Arrays.sort(faktis);
            assertEquals(forventet[i], faktis[i]);
        }
    }
    
    @Test
    void testUnion() {
        
        MengdeADT<Integer> union = mengde.union(annenMengde);

        assertTrue(union.inneholder(1));
        assertTrue(union.inneholder(7));
        assertTrue(union.inneholder(4));
        assertTrue(union.inneholder(13));
        assertTrue(union.inneholder(2));
        assertTrue(union.inneholder(3));
        assertTrue(union.inneholder(6));
        assertTrue(union.inneholder(9));
        assertFalse(union.inneholder(5));
        assertEquals(union.antallElementer(), 8); 
    }
}
