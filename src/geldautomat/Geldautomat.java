package geldautomat;

import java.io.IOException;
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

    public int login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gebe deine PIN ein: ");
        return sc.nextInt();
    }

    public int auswahl() throws IOException {
        System.out.println("1. Geld abheben");
        System.out.println("2. PIN ändern");
        System.out.println("3. beenden");
        return System.in.read();
    }


    public Kunde ausgabeKunde(int byPin) throws IOException {
        int kid = -1;
        Kunde benutzer = null;
        for (Kunde kunde : kundenliste) {
            if (kunde.getPin() == byPin) {
                System.out.println("Ihre ID: " + kunde.getKid());
                System.out.println("Ihr Kontostand: " + kunde.getKontostand());
                kid = kunde.getKid();
                benutzer = kunde;
                switch (auswahl()) {
                    case 1:
                        abheben(benutzer);
                        break;
                    case 2:
                    case 3:
                }
                break;
            }
        }
        if (kid == -1) {
            System.out.println("Anmeldung fehlgeschlagen");
        }
        return benutzer;

    }
    public void abheben(Kunde kunde) throws IOException {

        if (kunde != null) {
            System.out.println("Kontostand: " + kunde.getKontostand());
            System.out.println("Gebe den gewünschten Betrag ein: ");
            int abheben = sc.nextInt();
            int kontostand = kunde.getKontostand();
            kontostand -= abheben;
            kunde.setKontostand(kontostand);
            System.out.println("Sie haben " + abheben + "€ abgehoben. \nIhr neuer Kontostand ist " + kunde.getKontostand() + " €");
        }

    }

}
