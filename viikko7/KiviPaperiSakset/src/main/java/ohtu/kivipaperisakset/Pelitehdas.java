
package ohtu.kivipaperisakset; 

import java.util.HashMap;
import java.util.Map;

public class Pelitehdas {
    
    private IO io;
    private Map<String, Peli> pelit;
    
    public Pelitehdas(IO io) {
        this.io = io;
        this.pelit = new HashMap<>();
        this.pelit.put("a", new KPSPelaajaVsPelaaja(io));
        this.pelit.put("b", new KPSTekoaly(io));
        this.pelit.put("c", new KPSParempiTekoaly(io));
    }

    public Peli hae(String vastaus) {
        return pelit.getOrDefault(vastaus.trim(), null);
    }
    
}
