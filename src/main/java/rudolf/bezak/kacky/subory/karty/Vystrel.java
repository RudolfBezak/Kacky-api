package rudolf.bezak.kacky.subory.karty;

import lombok.Getter;
import rudolf.bezak.kacky.subory.data.Doska;

@Getter
public class Vystrel extends Karta{
    private int id = 6;
    private boolean ma2Kroky = true;

    public boolean viemZahrat(Doska doska){
        for (int i = 0; i < 6; i++){
            if (doska.getZameriavaci()[i]){
                return true;
            }
        }
        return false;

    }

    public boolean zahrajKartu(Doska doska, int miesto){
        if (doska.getZameriavaci()[miesto]){
            return doska.zastrelKacku(miesto);
        }
        return false;
    }
}
