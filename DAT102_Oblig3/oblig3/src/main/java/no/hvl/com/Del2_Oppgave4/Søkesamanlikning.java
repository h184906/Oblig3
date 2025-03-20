package no.hvl.com.Del2_Oppgave4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Søkesamanlikning {
    
    public static void main(String[] args) {

        int tabSize = 100000;
        int antalletSøk = 10000;
        int fellesFaktor = 1000000;
        int økning = 45713;

        int tall = 376; 
        
        HashSet<Integer> hashSet = new HashSet<>();
        Integer[] tabell = new Integer[tabSize];
        
        //tilfelidge unike verdier i tabellen og set
        for (int i = 0; i < tabSize; i++) {
            hashSet.add(tall);
            tabell[i] = tall;
            tall = (tall + økning) % fellesFaktor;
        }
        
        Arrays.sort(tabell);
        
        Random random = new Random();

        //tilfeldig tall vi skal søke etter hver gang
        int[] sokeTall = new int[antalletSøk];

        for (int i = 0; i < antalletSøk; i++) {
            sokeTall[i] = random.nextInt(fellesFaktor);
        }
        
        long startTid = System.currentTimeMillis();
        int antallFunnetHashSet = 0;
        
        for (int i = 0; i < antalletSøk; i++) {
            if (hashSet.contains(sokeTall[i])) {
                antallFunnetHashSet++;
            }
        }
        
        long hashSetTid = System.currentTimeMillis() - startTid;
        
        startTid = System.currentTimeMillis();
        int antallFunnetBinaer = 0;
        
        for (int i = 0; i < antalletSøk; i++) {
            if (Arrays.binarySearch(tabell, sokeTall[i]) >= 0) {
                antallFunnetBinaer++;
            }
        }
        
        long binaerSokTid = System.currentTimeMillis() - startTid;
        
        System.out.println("HashSet: \nTid brukt: " + hashSetTid + " ms");
        System.out.println("Antall ganger funnet: " + antallFunnetHashSet);
        System.out.println("\nBinersøk i sorterte tabell: \nTid brukt: " + binaerSokTid + " ms");
        System.out.println("Anntal ganger funnet:" + antallFunnetBinaer);
        System.out.println("Forskjell i tid Binær vs Hashset " + (double)binaerSokTid / hashSetTid);
        
    }
    
}