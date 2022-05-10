package rudolf.bezak.kacky.subory.data;

import lombok.Getter;
import rudolf.bezak.kacky.subory.karty.Karta;

@Getter
public class Hrac {
    private int id;
    private Karta[] ruka;

    public Hrac(int id) {
        this.id = id;
        this.ruka = new Karta[3];
    }
}
