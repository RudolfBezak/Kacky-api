package rudolf.bezak.kacky.subory;

import lombok.Getter;
import lombok.Setter;
import rudolf.bezak.kacky.subory.karty.Karta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Doska {
    private int[] jazero;
    private boolean[] zameriavaci;
    private Hrac[] hraci;
    private List<Karta> balikKariet;
    private List<Integer> balikKaciek;


    public Doska(int pocetHracov) {

        //vytvor hracov
        this.hraci = new Hrac[pocetHracov];
        for (int i = 0; i < pocetHracov; i++){
            this.hraci[i] = new Hrac(i+1);
        }

        //vytvor balikkaciek
        this.balikKaciek = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            this.balikKaciek.add(0);
        }

        for (int i = 0; i < pocetHracov; i++){
            for (int ii = 0; ii < 6; ii++){
                balikKaciek.add(i+1);
            }
        }

        //vytvor zameriavacou
        zameriavaci = new boolean[6];
        for (int i = 0; i < 6; i++){
            zameriavaci[i] = false;
        }

        //vytvor jazero
        Collections.shuffle(balikKaciek);
        jazero = new int[6];
        for (int i = 0; i < 6; i++){
            jazero[i] = balikKaciek.get(0);
            balikKaciek.remove(0);
        }


    }

    public boolean zastrelKacku(int miesto){
        if (this.jazero[miesto] == 0){
            this.zameriavaci[miesto] = false;
            return true;
        }
        int posunKaciek = 5 - miesto;
        for (int i = 0; i < posunKaciek; i++){
            this.jazero[i + miesto] = this.jazero[i + miesto + 1];

        }
        this.jazero[5] = this.balikKaciek.get(0);
        this.balikKaciek.remove(0);
        this.zameriavaci[miesto] = false;

        return true;
    }
}
