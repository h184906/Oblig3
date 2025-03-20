package no.hvl.com.Oppgave4;

public class TabellMengde<T> implements MengdeADT<T>{

    private static final int maxLengde = 10;
    private T[] tabell;
    private int antall; 

    public TabellMengde() {
        this(maxLengde);
    }

    @SuppressWarnings("unchecked")
    public TabellMengde(int tabLengde) { 
        tabell = (T[]) new Object[tabLengde]; // Veldig forvirrendes, NB søk mer opp på dette
        antall = 0;
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    //Kunne lagt til en erTom fremst i hver av metodene nedover for å sikre oss at det ikke vil bli krasj i koden bare for å være sikker. kan hende at det må endres ettehvert for å gjøre koden "skikkelig"

    @Override
    public boolean inneholder(T element) {

        for (int i = 0; i < antall; i++) { 
            if (tabell[i].equals(element)) {
                return true; 
            }
        }
        return false;  
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {

        //Slippe å itere igjenom hele tabellen om den er større
        if (annenMengde.antallElementer() < antall) {
            return false; 
        }

        for (int i = 0; i < antall; i++) {
            if (!annenMengde.inneholder(tabell[i])) { 
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        
        if (annenMengde.antallElementer() != antall) {
            return false;
        }

        for (int i = 0; i < antall; i++) {
            if (!annenMengde.inneholder(tabell[i])) { 
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {

        //vurder å ha en sjekk for evt feil med tomme emgnder
        if (erTom() || annenMengde.erTom()) {
            throw new NullPointerException("En av mengdene er tom");
        }

        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(tabell[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {

        MengdeADT<T> nymengde = new TabellMengde<>(antall);
        
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(tabell[i])) {
                nymengde.leggTil(tabell[i]); 
            }
        } 
        return nymengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {

        //Om annenmengde og tabell begge er nesten full og bare har ulike verdier vil  den nye mengden måtte være større, så sitter den til antallet elementer i begge tilfelle. 

        MengdeADT<T> nymengde = new TabellMengde<>(annenMengde.antallElementer() + antall);

        nymengde.leggTilAlleFra(annenMengde);

        for (int i = 0; i < antall; i++) {
            nymengde.leggTil(tabell[i]);
        }
        

        return nymengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> nymengde = new TabellMengde<>(antall);
    
        for (int i = 0; i < antall; i++) { 
            if (!annenMengde.inneholder(tabell[i])) { 
                nymengde.leggTil(tabell[i]); 
            }
        }
    
        return nymengde;
    }

    @Override
    public void leggTil(T element) {

        if (!inneholder(element)) {
            if (antall == tabell.length) {
                utvid();
            }
            tabell[antall] = element;
            antall++; 
        } 
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

        T[] elementTabell = annenMengde.tilTabell();

        for (int i = 0; i < annenMengde.antallElementer(); i++) {
            leggTil(elementTabell[i]);
        }

    }

    @Override
    public T fjern(T element) {

        if (!inneholder(element)) {
            return null; 
        }

        for (int i = 0; i < antall; i++) {
            if (tabell[i] == element) {
                antall--;
                tabell[i] = tabell[antall];
                tabell[antall] = null;
            }
        }

        return element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] tilTabell() {

        T[] Ttabell = (T[]) new Object[antall];

        for (int i = 0; i < antall; i++) {
            Ttabell[i] = tabell[i];
        }


        return Ttabell;
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    @SuppressWarnings("unchecked")
    private void utvid() {
        T[] nyTabell = (T[]) new Object[tabell.length * 2];
        for (int i = 0; i < antall; i++) {
            nyTabell[i] = tabell[i];
        }
        tabell = nyTabell;
    }

}