package no.hvl.com.Oppgave2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoderMainTest {
    private Node<Integer> forste;

    @SuppressWarnings("unchecked")
    @BeforeEach
    void setup() {
        forste = null;
        Node<Integer>[] nodes = new Node[5];
        
        nodes[0] = new Node<>(3);
        nodes[1] = new Node<>(4);
        nodes[2] = new Node<>(3);
        nodes[3] = new Node<>(2);
        nodes[4] = new Node<>(1);
        
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].neste = forste;
            forste = nodes[i];
        }
    }
    
    @Test
    void testAntallAvIterativ() {
        assertEquals(2, NoderMain.antallAvIterativ(forste, 3));
        assertEquals(1, NoderMain.antallAvIterativ(forste, 4));
        assertEquals(1, NoderMain.antallAvIterativ(forste, 2));
        assertEquals(0, NoderMain.antallAvIterativ(forste, 5));
    }

    @Test
    void testAntallAvRekursiv() {
        assertEquals(2, NoderMain.antallAvRekursiv(forste, 3));
        assertEquals(1, NoderMain.antallAvRekursiv(forste, 4));
        assertEquals(1, NoderMain.antallAvRekursiv(forste, 2));
        assertEquals(0, NoderMain.antallAvRekursiv(forste, 5));
    }

    @Test
    void testLenkeInneholderRekursiv() {
        assertTrue(NoderMain.lenkeInneholderRekursiv(forste, 3));
        assertTrue(NoderMain.lenkeInneholderRekursiv(forste, 4));
        assertTrue(NoderMain.lenkeInneholderRekursiv(forste, 2));
        assertTrue(NoderMain.lenkeInneholderRekursiv(forste, 1));
        assertFalse(NoderMain.lenkeInneholderRekursiv(forste, 5));
    }

}