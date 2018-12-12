
package ohtu.kivipaperisakset; 

public class Pelinvalinta {

    private IO io;
    
    public Pelinvalinta(IO io) {
        this.io = io;
    }
    
    public void valitsePeliSilmukka() {
        Pelitehdas pelitehdas = new Pelitehdas(io);
        while (true) {
            io.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.nextLine();
            Peli peli = pelitehdas.hae(vastaus);
            if (peli == null) {
                break;
            }
            peli.pelaa();
        }
    }
    
}
