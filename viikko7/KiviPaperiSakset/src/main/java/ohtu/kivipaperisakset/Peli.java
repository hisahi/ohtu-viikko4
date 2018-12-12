
package ohtu.kivipaperisakset; 

public abstract class Peli {
    protected IO io;
    
    public void pelaa() {
        io.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        Tuomari tuomari = new Tuomari();
        
        while (true) {
            Siirto s = valinnat();
            if (s.lopetetaanko()) {
                break;
            }
            
            tuomari.kirjaaSiirto(s);
            io.println(tuomari);
        }
        
        io.println();
        io.println("Kiitos!");
        io.println(tuomari);
    }
    
    public abstract Siirto valinnat();
}
