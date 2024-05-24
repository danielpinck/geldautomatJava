package geldautomat;

import java.util.ArrayList;

public class Programm {
    public static void main(String[] args) {
        Geldautomat geldautomat = new Geldautomat(1000000, "Uhrzeit", "Haspa");
        int kunde = geldautomat.ausgabeKunde(123);
        System.out.println(geldautomat.auszahlung(kunde));








    }
}