package rudolf.bezak.kacky.subory.karty;

import lombok.Getter;
import rudolf.bezak.kacky.subory.Doska;

@Getter
public class Karta {
    private int id = 0;

    public boolean viemZahrat(){
        return true;
    }
    public int getId(){
        return this.id;
    }

    public void zahrajKartu(Doska doska){
    }

    //kacaci pochod = 1
    //kacaci tanec = 2
}
