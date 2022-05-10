package rudolf.bezak.kacky.subory.karty;

import lombok.Getter;
import rudolf.bezak.kacky.subory.data.Doska;


import java.util.Collections;

@Getter
public class KacaciTanec extends Karta{
    private int id = 2;

    @Override
    public boolean zahrajKartu(Doska doska){
        //daj vsetko do decku, shuffle deck, vyloz vrchnych 6
        for (int i = 0; i < 6; i++){
            doska.getBalikKaciek().add(doska.getJazero()[i]);
        }
        Collections.shuffle(doska.getBalikKaciek());
        for (int i = 0; i < 6; i++){
            doska.getJazero()[i] = doska.getBalikKaciek().get(0);
            doska.getBalikKaciek().remove(0);
        }
        return true;
    }
}
