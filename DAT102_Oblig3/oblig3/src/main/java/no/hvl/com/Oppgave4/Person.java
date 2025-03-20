package no.hvl.com.Oppgave4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {
    private String navn;
    private HashSet<String> hobbyer;

    public Person(String navn, String... hobbyer) {
        this.navn = navn;
        this.hobbyer = new HashSet<>();
        for (String hobby : hobbyer) {
            this.hobbyer.add(hobby);
        }
    }

    public String getNavn() {
        return navn;
    }

    public Set<String> getHobbyer() {
        return hobbyer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(navn, hobbyer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Person))
            return false;
        Person other = (Person) obj;
        return Objects.equals(navn, other.navn) && Objects.equals(hobbyer, other.hobbyer);
    }
}