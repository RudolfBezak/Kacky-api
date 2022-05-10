package rudolf.bezak.kacky.subory.karty;

import lombok.Getter;
import rudolf.bezak.kacky.subory.Doska;

@Getter
public class DivokyBill extends Karta{
    private int id = 7;
    private boolean ma2Kroky = true;

    public boolean zahrajKartu(Doska doska, int miesto){
        doska.zastrelKacku(miesto);
        return true;
    }
}
