package rudolf.bezak.kacky.subory.karty;

import lombok.Getter;
import rudolf.bezak.kacky.subory.Doska;

@Getter
public class Karta {
    private int id = 0;
    private boolean ma2Kroky = false;

    public boolean viemZahrat(){
        return true;
    }
    public int getId(){
        return this.id;
    }

    public boolean zahrajKartu(Doska doska){
        return false;
    }

    public boolean zahrajKartu(Doska doska, int miesto){
        return false;
    }

    //kacaci pochod = 1
    //kacaci tanec = 2
    //turbokacka = 3
}
