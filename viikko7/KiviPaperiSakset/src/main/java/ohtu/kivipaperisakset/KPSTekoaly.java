package ohtu.kivipaperisakset;

public class KPSTekoaly extends Peli {
    
    private Tekoaly tekoaly;
    
    public KPSTekoaly(IO io) {
        this.io = io;
        this.tekoaly = new Tekoaly();
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