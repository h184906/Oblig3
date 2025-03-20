package no.hvl.com.Oppgave1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoderMainTest {

    private Node<String> a, b, c, d, e;

    @BeforeEach
    void setup() {
        a = new Node<>("A");
        b = new Node<>("B");
        c = new Node<>("C");
        d = new Node<>("D");
        e = new Node<>("E");

        a.neste = b;
        b.neste = c;
        c.neste = d;
        d.neste = e;
    }

    @Test
    void testAntallNoderILenke() {
        assertEquals(5, NoderMain.antallNoderILenke(a));
        assertEquals(3, NoderMain.antallNoderILenke(c));
        assertEquals(1, NoderMain.antallNoderILenke(e));
        assertEquals(0, NoderMain.antallNoderILenke(null));
    }

    @Test
    void testLenkeInneholder() {
        assertTrue(NoderMain.lenkeInneholder(a, "C"));
        assertTrue(NoderMain.lenkeInneholder(a, "A"));
        assertTrue(NoderMain.lenkeInneholder(a, "E"));
        assertFalse(NoderMain.lenkeInneholder(a, "F"));
        assertFalse(NoderMain.lenkeInneholder(null, "A"));
    }
}