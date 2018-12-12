package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Pelinvalinta(new IO(System.in, System.out)).valitsePeliSilmukka();
    }
}
