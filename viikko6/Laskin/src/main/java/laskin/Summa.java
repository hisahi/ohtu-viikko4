
package laskin; 

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private int lastValue;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
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
        sovellus.plus(value);
        this.lastValue = value;
    }

    @Override
    public void peru() {
        sovellus.miinus(lastValue);
        this.lastValue = 0;
    }

}
