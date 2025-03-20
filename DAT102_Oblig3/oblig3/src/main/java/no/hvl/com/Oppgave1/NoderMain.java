package no.hvl.com.Oppgave1;

public class NoderMain {
    public static void main(String[] args) {

        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");

        a.neste = c;

        skrivUtLenke("a--➤", a); // a--➤[A|-]--➤[C|-]    
        // Oppgave a)-d) skrives direkte inn her ...
        
        a.neste = b;
        b.neste = c;
        skrivUtLenke("a--➤", a);

        a.neste = c;
        skrivUtLenke("a-->", a);

        Node<String> d = new Node<>("D");
        a.neste = d;
        d.neste = c;
        skrivUtLenke("a-->", a);

        Node<String> e = new Node<>("E");
        c.neste = e;
        skrivUtLenke("a-->", a);

        //Kall til metodene i Oppgave e)-f) gjøres her ...

        System.out.println(antallNoderILenke(a));
        System.out.println(lenkeInneholder(a, "C"));
        System.out.println(lenkeInneholder(a, "F"));
    }
        /* ---------------------------------------------------------------- */
    // Metodene i Oppgave e)-f) skrives inn her ... 

    static boolean lenkeInneholder(Node<String> start, String e) {
        while(start != null) {
            if (start.data.equals(e)) {
                return true;
            }

            start = start.neste;
        }
        return false;
    }

    static int antallNoderILenke(Node<String> start) {
        int count = 0;
        while(start != null) {
            count++;
            start = start.neste;
        }

        return count;
    }

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