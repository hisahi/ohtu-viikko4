
package laskin; 

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {
    
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private Integer lastValue = null;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.lastValue = null;
    }

    @Override
    public void suorita() {
        this.lastValue = sovellus.tulos();
        sovellus.nollaa();
    }

    @Override
    public void peru() {
        if (this.lastValue != null) {
            sovellus.nollaa();
            sovellus.plus(this.lastValue);
            this.lastValue = null;
        }
    }

}
