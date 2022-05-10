package rudolf.bezak.kacky.subory.karty;

import lombok.Getter;
import rudolf.bezak.kacky.subory.data.Doska;

@Getter
public class Turbokacka extends Karta{
    private int id = 3;
    private boolean ma2Kroky = true;


    public boolean zahrajKartu(Doska doska, int miesto){
        if (doska.getJazero()[miesto] == 0) {
            return false;
        }
        int tmp = doska.getJazero()[miesto];
        for (int i = miesto; i > 0; i--){
            doska.getJazero()[i] = doska.getJazero()[i-1];
        }
        doska.getJazero()[0] = tmp;
        return true;
    }


}
