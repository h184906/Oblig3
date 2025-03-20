package no.hvl.com.Oppgave4;

public class LenketMengde<T> implements MengdeADT<T> {

    private Node<T> start;
    private int antall;

    public LenketMengde() {
        start = null;
        antall = 0;
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {
        
        Node<T> aktuellNode = start; 
        
        while(aktuellNode != null) {
            if (aktuellNode.data.equals(element)) {
                return true;
            }
            aktuellNode = aktuellNode.neste;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        Node<T> aktuellNode = start;

        while (aktuellNode != null) {
            if (!annenMengde.inneholder(aktuellNode.data)) {
                return false;
            }
            aktuellNode = aktuellNode.neste;
        }

        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        Node<T> aktuelNode = start;

        if (annenMengde.antallElementer() != antall) {
            return false;
        }

        while (aktuelNode != null) {
            if (!annenMengde.inneholder(aktuelNode.data)) {
                return false;
            }
            aktuelNode = aktuelNode.neste;
        }
        
        return true; 
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        Node<T> aktuellNode = start; 

        while (aktuellNode != null) {
            if (annenMengde.inneholder(aktuellNode.data)) {
                return false;
            }
            aktuellNode = aktuellNode.neste;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> nymengde = new LenketMengde<>();
        Node<T> aktuellNode = start;

        while(aktuellNode != null) {
            if (annenMengde.inneholder(aktuellNode.data)) {
                nymengde.leggTil(aktuellNode.data);
            }
            aktuellNode = aktuellNode.neste;
        }

        return nymengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {

        Node<T> akutellNode = start;
        MengdeADT<T> nymengde = new LenketMengde<>();
        nymengde.leggTilAlleFra(annenMengde);

        while (akutellNode != null) {
            nymengde.leggTil(akutellNode.data);
            akutellNode = akutellNode.neste;
        }

        return nymengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {

        MengdeADT<T> nymengde = new LenketMengde<>();
        Node<T> aktuellNode = start; 

        while (aktuellNode != null) {
            if (!annenMengde.inneholder(aktuellNode.data)) {
                nymengde.leggTil(aktuellNode.data);
            }
            aktuellNode = aktuellNode.neste;
        }

        return nymengde;
    }

    @Override
    public void leggTil(T element) {

        if (inneholder(element)) {
            return; 
        }

        Node<T> nyNode = new Node<>(element);
        nyNode.neste = start;
        start = nyNode;

        antall++;
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

        T[] elementTabell = annenMengde.tilTabell();

        for (int i = 0; i < elementTabell.length; i++) {
            leggTil(elementTabell[i]);
        }
    }

    @Override
    public T fjern(T element) {

        if (!inneholder(element)) {
            return null;
        }
    
        Node<T> aktuellNode = start;
    
        if (aktuellNode.data.equals(element)) {
            start = aktuellNode.neste; 
            antall--;
            return aktuellNode.data;
        }
    
        while (aktuellNode.neste != null && !aktuellNode.neste.data.equals(element)) {
            aktuellNode = aktuellNode.neste;
        }
    
        if (aktuellNode.neste != null) {
            Node<T> temp = aktuellNode.neste;
            aktuellNode.neste = aktuellNode.neste.neste;
            antall--;
            return temp.data;
        }
    
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] tilTabell() {

        Node<T> aktuellNode = start; 
        T[] Ttabell = (T[]) new Object[antall];

        for (int i = 0; i < antall; i++) {
            Ttabell[i] = aktuellNode.data;
            aktuellNode = aktuellNode.neste;
        }
        return Ttabell;
    }

    @Override
    public int antallElementer() {
        return antall; 
    }

}
