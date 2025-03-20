package no.hvl.com.Oppgave2;

import java.util.Stack;

public class NoderMain {
    public static void main(String[] args) {
        // Tenker at vi skal opprette en lenke som pekes på av forste
        Node<Integer> forste = null;
        Node<Integer> ny = null;
        // Oppretter en ny node og setter denne inn først i lenken
        ny = new Node<>(4);
        ny.neste = forste;
        forste = ny;
        skrivUtLenke("forste--> ", forste); // forste--➤[4|-]
        // Oppretter en ny node og setter denne inn først i lenken
        ny = new Node<>(3);
        ny.neste = forste;
        forste = ny;
        skrivUtLenke("forste--> ", forste); // forste--➤[3|-]--➤[4|-]
        // Oppgave a) skrives direkte inn her ...
        ny = new Node<>(2);
        ny.neste = forste;
        forste = ny;

        ny = new Node<>(1);
        ny.neste = forste;
        forste = ny;

        skrivUtLenke("forste--> ", forste);
        // Kall til metodene i Oppgave b)-g) gjøres her ...
        System.out.println(lenkeInneholderRekursiv(forste, 3));

        skrivUtFremlengsRekursiv(forste);

        System.out.println();

        skrivUtBaklengsRekursiv(forste);

        System.out.println();

        skrivUtBaklengsMedStabel(forste);

        ny = new Node<>(3);
        ny.neste = forste; 
        forste = ny;

        System.out.println(antallAvIterativ(forste, 3));
        
        System.out.println(antallAvRekursiv(forste, 3));

    }

    static int antallAvRekursiv(Node<Integer> start, int e) {
        int i = 0; 

        if (start == null) {
            return 0; 
        }

        if (start.data == e) {
            i++; ;
        }

        return antallAvRekursiv(start.neste, e) + i; 
    }

    static int antallAvIterativ(Node<Integer> start, int e) { 
        int count = 0; 

        while (start != null) { 
            if (start.data == e) {
                count++;
            }
            start = start.neste;
        }


        return count;
    }

    static void skrivUtBaklengsMedStabel(Node<Integer> start) {

        Stack<Integer> stack = new Stack<>();

        while (start != null) {
            stack.push(start.data);
            start = start.neste;

        }
        while (!stack.empty()) {
            
            System.out.print(stack.pop() +  " ");
        }

    }

    static boolean lenkeInneholderRekursiv(Node<Integer> start, int e) {
        if (start.neste == null) {
            return false;
        }

        if (start.data == e) {
            return true;
        }

        return lenkeInneholderRekursiv(start.neste, e);
    }

    static void skrivUtFremlengsRekursiv(Node<Integer> start) {

        if (start != null) {

            System.out.print(start.data + " ");
            skrivUtFremlengsRekursiv(start.neste);  
        }

    }

    static void skrivUtBaklengsRekursiv(Node<Integer> start) {

        if (start != null) {
            
            skrivUtBaklengsRekursiv(start.neste); 
            System.out.print(start.data + " ");
        }
        
    }



    /* ---------------------------------------------------------------- */
    // Metodene i Oppgave b)-g) skrives inn her ...
    private static <T> void skrivUtLenke(String intro, Node<T> start) {
        System.out.print(intro);
        Node<T> p = start;
        while (p != null) {
            System.out.print("[" + p.data + "|-]");
            if (p.neste != null) {
                System.out.print("--➤");
            }
            p = p.neste;
        }
        System.out.println();
    }
}
    