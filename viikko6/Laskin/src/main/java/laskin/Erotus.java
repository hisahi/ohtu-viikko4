
package laskin; 

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {
    
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private int lastValue;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.lastValue = 0;
    }

    @Override
    public void suorita() {
        int value = Integer.parseInt(syotekentta.getText());
        sovellus.miinus(value);
        this.lastValue = value;
    }

    @Override
    public void peru() {
        sovellus.plus(lastValue);
        this.lastValue = 0;
    }

}
