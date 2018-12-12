package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends Peli {
    TekoalyParannettu tekoaly;
    
    public KPSParempiTekoaly(IO io) {
        this.io = io;
        this.tekoaly = new TekoalyParannettu(20);
    }

    @Override
    public Siirto valinnat() {
        String ekanSiirto = io.prompt("Ensimmäisen pelaajan siirto");
        String tokanSiirto;

        tokanSiirto = tekoaly.annaSiirto();
        io.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        
        return new Siirto(ekanSiirto, tokanSiirto);
    }
}
