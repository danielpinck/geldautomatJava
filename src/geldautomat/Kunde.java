package geldautomat;

public class Kunde {
    private int kid;
    private int pin;
    private int kontostand;

    public Kunde(int kid, int pin, int kontostand) {
        this.kid = kid;
        this.pin = pin;
        this.kontostand = kontostand;
    }

    public void setKontostand(int kontostand) {
        this.kontostand = kontostand;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public int getKid() { return this.kid;}
    public int getPin() { return this.pin;}
    public int getKontostand() { return this.kontostand;}
}
