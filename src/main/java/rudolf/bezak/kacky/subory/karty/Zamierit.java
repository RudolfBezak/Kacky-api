package rudolf.bezak.kacky.subory.karty;

import lombok.Getter;
import rudolf.bezak.kacky.subory.Doska;

@Getter
public class Zamierit extends Karta{
    private int id = 5;
    private boolean ma2Kroky = true;

    public boolean zahrajKartu(Doska doska, int miesto){
        if (doska.getZameriavaci()[miesto]){
            return false;
        }
        doska.getZameriavaci()[miesto] = true;
        return true;
    }
}
