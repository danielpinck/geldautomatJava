package geldautomat;

import java.io.IOException;

public class Programm {
    public static void main(String[] args) throws IOException {
        Geldautomat geldautomat = new Geldautomat(1000000, "Uhrzeit", "Haspa");
        Kunde kunde = geldautomat.ausgabeKunde(geldautomat.login());
        geldautomat.abheben(kunde);
    }
}