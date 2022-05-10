package rudolf.bezak.kacky.subory.karty;

import lombok.Getter;
import rudolf.bezak.kacky.subory.Doska;

import java.util.List;

@Getter
public class KacaciPochod extends Karta{
    private int id = 1;

    @Override
    public void zahrajKartu(Doska doska){
        List<Integer> balikKaciek =  doska.getBalikKaciek();
        int[] jazero = doska.getJazero();

        //1. karta v jazere sa ulozi, posune sa jazero, hodis z balika na jazero, ulozis ulozenu kartu na spodok baliku
        int tmp = jazero[0];
        for (int i = 0; i < 5; i++){
            jazero[i] = jazero[i+1];
        }
        jazero[5] = balikKaciek.get(0);

        balikKaciek.remove(0);
        balikKaciek.add(tmp);
    }

}
