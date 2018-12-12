package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends Peli {
    
    public KPSPelaajaVsPelaaja(IO io) {
        this.io = io;
    }

    @Override
    public Siirto valinnat() {
        String ekanSiirto = io.prompt("Ensimmäisen pelaajan siirto");
        String tokanSiirto = io.prompt("Toisen pelaajan siirto");
        return new Siirto(ekanSiirto, tokanSiirto);
    }
}