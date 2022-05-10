package rudolf.bezak.kacky.subory;

import rudolf.bezak.kacky.subory.karty.Karta;

public class Hrac {
    int id;
    Karta[] ruka;

    public Hrac(int id) {
        this.id = id;
        this.ruka = new Karta[3];
    }
}
