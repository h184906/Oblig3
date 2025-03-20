package no.hvl.com.Oppgave4;

import java.util.HashSet;
import java.util.Set;

public class HobbyMatchMain {
    public static double match(Person a, Person b) {

        Set<String> felles = new HashSet<>(a.getHobbyer());
        felles.retainAll(b.getHobbyer());

        Set<String> kunHosA = new HashSet<>(a.getHobbyer());
        kunHosA.removeAll(b.getHobbyer());

        Set<String> kunHosB = new HashSet<>(b.getHobbyer());
        kunHosB.removeAll(a.getHobbyer());

        int antallFelles = felles.size();
        int antallKunHosDenEne = kunHosA.size() + kunHosB.size();
        int antallTotalt = antallFelles + antallKunHosDenEne;

        return antallTotalt == 0 ? 0 : (double) (antallFelles - antallKunHosDenEne) / antallTotalt;
    }

    public static void main(String[] args) {
        Person arne = new Person("Arne", "jakt", "sykling", "venner", "data");
        Person bente = new Person("Bente", "sykling", "venner", "lesing", "musikk");
        Person carl = new Person("Carl", "fotball", "gaming", "data", "jakt");

        System.out.println("Match Arne-Bente: " + match(arne, bente));
        System.out.println("Match Arne-Bente: " + match(bente, arne));
        System.out.println("Match Arne-Carl: " + match(arne, carl));
        System.out.println("Match Bente-Carl: " + match(bente, carl));
        System.out.println("Match Arne-Arne: " + match(arne, arne));
    }
}