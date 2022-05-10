package rudolf.bezak.kacky.subory;

import lombok.Getter;
import rudolf.bezak.kacky.subory.karty.Karta;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DoskaResponse {
    private int[] jazero;
    private boolean[] zameriavaci;
    //private Hrac[] hraci;
    private List<Integer> balikKariet;
    private List<Integer> balikKaciek;


    public DoskaResponse(Doska doska) {
        this.jazero = doska.getJazero();
        this.zameriavaci = doska.getZameriavaci();
        //Hrac[] hraci = doska.getHraci();
        /*balikKariet = new ArrayList<>();
        for (int i = 0; i < doska.getBalikKariet().size(); i++){
            this.balikKariet.add(doska.getBalikKariet().get(i).getId());
        }*/
        this.balikKaciek = doska.getBalikKaciek();
    }
}