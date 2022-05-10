package rudolf.bezak.kacky.subory.karty;

import lombok.Getter;
import rudolf.bezak.kacky.subory.Doska;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Rosambo extends Karta{
    private int id = 4;
    @Override
    public boolean zahrajKartu(Doska doska){
        List<Integer> jazeroList = new ArrayList<>();
        int[] jazero = doska.getJazero();
        for (int i = 0; i < 6; i++){
            jazeroList.add(jazero[i]);
        }
        Collections.shuffle(jazeroList);
        for (int i = 0; i < 6; i++){
            jazero[i] = jazeroList.get(i);
        }
        return true;
    }
}
