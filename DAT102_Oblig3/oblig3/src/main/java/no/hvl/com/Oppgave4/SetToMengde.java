package no.hvl.com.Oppgave4;

import java.util.HashSet;
import java.util.Set;

public class SetToMengde<T> implements MengdeADT<T> {

    private Set<T> mengde;

    public SetToMengde() {
        mengde = new HashSet<>();
    }
    @Override
    public boolean erTom() {
        return mengde.isEmpty();
    }

    @Override
    public boolean inneholder(Object element) {
        return mengde.contains(element);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {

        if (mengde.size() > annenMengde.antallElementer()) {
            return false;
        }

        for (T Mengde_element : mengde) {
            if (!annenMengde.inneholder(Mengde_element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        //dobbelsjekk ekstra med tester, børr fungere men ikke 100%
        return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);

    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {

        for (T element : mengde) {
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> nySetToMengde = new SetToMengde<>();

        for (T element : mengde) {
            if (annenMengde.inneholder(element)) {
                nySetToMengde.leggTil(element);
            }
        }
        return nySetToMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> nySetToMengde = new SetToMengde<>();

        nySetToMengde.leggTilAlleFra(annenMengde);
        
        for (T elemnt : mengde) {
            nySetToMengde.leggTil(elemnt);
        }

        return nySetToMengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> nySetToMengde = new SetToMengde<>();

        for (T element: mengde) {
            if (!annenMengde.inneholder(element)) {
                nySetToMengde.leggTil(element);
            }
        }

        return nySetToMengde;
    }

    @Override
    public void leggTil(T element) {
        mengde.add(element);
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        // mengde.addAll(annenMengde);
        for (T element : annenMengde.tilTabell()) {
            mengde.add(element);
        }
    }

    @Override
    public T fjern(T element) {

        if (mengde.remove(element)) {
            return element;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] tilTabell() {
        return (T[]) mengde.toArray();
    }

    @Override
    public int antallElementer() {
        return mengde.size();
    }
    
}
