package geldautomat;

import java.util.ArrayList;
import java.util.Scanner;

public class Geldautomat {
    private int geldstand;
    private String datetime;
    private String bank;
    private ArrayList<Kunde> kundenliste;
    Scanner sc = new Scanner(System.in);

    public Geldautomat(int geldstand , String datetime, String bank) {
        this.geldstand = geldstand;
        this.datetime = datetime;
        this.bank = bank;
        this.kundenliste = ladeKundenliste();

    }

    public int getGeldstand() {return this.geldstand;}
    public String getDateTime() {return this.datetime;}
    public String getBank() {return this.bank;}
    public ArrayList<Kunde> getKundenliste() {return this.kundenliste;}


    private ArrayList<Kunde> ladeKundenliste() {
        ArrayList<Kunde> kundenliste = new ArrayList<>();
        Kunde[] liste = new Kunde[100];
        liste[0] = new Kunde(1,123,2000);
        liste[1] = new Kunde(2,321,26);
        liste[2] = new Kunde(3,789,55000);
        kundenliste.add(0,liste[0]);
        kundenliste.add(0,liste[1]);
        kundenliste.add(0,liste[2]);
        return kundenliste;

    }

    public int anmeldung(int byPin) {
        byPin = -1;
        for (Kunde kunde : kundenliste) {
            if (kunde.getPin() == byPin) {
                System.out.println("Ihre ID: " + kunde.getKid());
                System.out.println("Ihr Kontostand: " + kunde.getKontostand());
                byPin = kunde.getKid();
                break;
            }
        }
        if (byPin == -1) {
            System.out.println("Anmeldung fehlgeschlagen");
        }
        return byPin;

    }


    public int ausgabeKunde(int byPin) {
        int kid = -1;
        for (Kunde kunde : kundenliste) {
            if (kunde.getPin() == byPin) {
                System.out.println("Ihre ID: " + kunde.getKid());
                System.out.println("Ihr Kontostand: " + kunde.getKontostand());
                kid = kunde.getKontostand();
                break;
            }
        }
        if (kid == -1) {
            System.out.println("Anmeldung fehlgeschlagen");
        }
        return kid;

    }
    public int auszahlung(int kid) {
        int abheben = 30;
        kontostand = kontostand - abheben;
        return kontostand;
        // änderung



    }


}
