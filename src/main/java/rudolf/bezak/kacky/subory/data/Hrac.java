package rudolf.bezak.kacky.subory.data;

import lombok.Getter;
import rudolf.bezak.kacky.subory.karty.Karta;

@Getter
public class Hrac {
    private int id;
    private Karta[] ruka;

    private int zivot;

    public Hrac(int id) {
        this.zivot = 6;
        this.id = id;
        this.ruka = new Karta[3];
    }

    public void decrementZivot(){
        this.zivot -= 1;
    }
}
