
package ohtu.kivipaperisakset; 

public class Siirto {
    
    private String ekanSiirto;
    private String tokanSiirto;

    public Siirto(String ekanSiirto, String tokanSiirto) {
        this.ekanSiirto = ekanSiirto;
        this.tokanSiirto = tokanSiirto;
    }

    public String getEkanSiirto() {
        return this.ekanSiirto;
    }

    public String getTokanSiirto() {
        return this.tokanSiirto;
    }
    
    public boolean lopetetaanko() {
        return !(onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto));
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
