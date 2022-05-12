package rudolf.bezak.kacky.subory.data;

import lombok.Getter;
import lombok.Setter;
import rudolf.bezak.kacky.subory.karty.*;

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

    private int naRade;

    private boolean naRadeVieHrat;

    private boolean pokracujeHra;




    public Doska(int pocetHracov) {

        int[] poctykariet = {6,1,1,2,10,12,2};

        //vytvor hracov
        this.naRade = 0;
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

        //vytvor balikkariet
        balikKariet = new ArrayList<>();
        for (int i = 0; i < poctykariet[0]; i++){
            balikKariet.add(new KacaciPochod());
        }
        for (int i = 0; i < poctykariet[1]; i++){
            balikKariet.add(new KacaciTanec());
        }
        for (int i = 0; i < poctykariet[2]; i++){
            balikKariet.add(new Turbokacka());
        }
        for (int i = 0; i < poctykariet[3]; i++){
            balikKariet.add(new Rosambo());
        }
        for (int i = 0; i < poctykariet[4]; i++){
            balikKariet.add(new Zamierit());
        }
        for (int i = 0; i < poctykariet[5]; i++){
            balikKariet.add(new Vystrel());
        }
        for (int i = 0; i < poctykariet[6]; i++){
            balikKariet.add(new DivokyBill());
        }
        Collections.shuffle(balikKariet);

        //potiahni karty hracom
        for (int i = 0; i < pocetHracov; i++){
            for (int y = 0; y < 3; y++){
                hraci[i].getRuka()[y] = balikKariet.get(0);
                balikKariet.remove(0);
            }
        }
        //pozri ci hrac 0 vie zahrat
        this.naRadeVieHrat = false;
        this.naRade = 0;
        for (int i = 0; i < 3; i++){
            if(this.getHraci()[this.getNaRade()].getRuka()[i].viemZahrat(this)){
                this.naRadeVieHrat = true;
                break;
            }
        }
        this.pokracujeHra = true;


    }

    public boolean zastrelKacku(int miesto){
        if (this.jazero[miesto] == 0){
            this.zameriavaci[miesto] = false;
            return true;
        }
        hraci[this.jazero[miesto]-1].decrementZivot();
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
