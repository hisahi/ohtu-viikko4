
package ohtu.intjoukkosovellus;

import java.util.Arrays;
import java.util.stream.Collectors;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IllegalArgumentException("kapasiteetti tai kasvatuskoko ei saa olla negatiivinen");
        }
        ljono = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }
    
    public IntJoukko(IntJoukko copyFrom) {
        this.kasvatuskoko = copyFrom.kasvatuskoko;
        this.ljono = Arrays.copyOf(copyFrom.ljono, copyFrom.ljono.length);
        this.alkioidenLkm = copyFrom.alkioidenLkm;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm++] = luku;
            if (alkioidenLkm == ljono.length) {
                this.ljono = Arrays.copyOf(this.ljono, this.ljono.length + this.kasvatuskoko);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < this.alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                System.arraycopy(this.ljono, i + 1, this.ljono, i, alkioidenLkm - i - 1);
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        return "{" + String.join(", ", Arrays.stream(this.toIntArray()).mapToObj(Integer::toString).collect(Collectors.toList())) + "}";
    }

    public int[] toIntArray() {
        return Arrays.copyOf(this.ljono, this.alkioidenLkm);
    }
    
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko(a);
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; ++i) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; ++i) {
            if (a.kuuluu(bTaulu[i])) {
                x.lisaa(bTaulu[i]);
            }
        }
        return x;
    }
    
    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko(a);
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; ++i) {
            x.poista(bTaulu[i]);
        }
        return x;
    }
        
}