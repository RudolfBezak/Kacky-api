package rudolf.bezak.kacky.subory;

import lombok.Getter;
import org.springframework.stereotype.Service;
import rudolf.bezak.kacky.subory.exceptions.IllegalOperationException;
import rudolf.bezak.kacky.subory.karty.KacaciPochod;
import rudolf.bezak.kacky.subory.karty.KacaciTanec;
import rudolf.bezak.kacky.subory.karty.Karta;

import java.util.ArrayList;
import java.util.List;

@Service
public class KackyService implements IKackyService {

    private Doska doska;
    private List<Karta> listKariet;

    public KackyService() {
        this.listKariet = new ArrayList<>();
        this.listKariet.add(new Karta());
        this.listKariet.add(new KacaciPochod());
        this.listKariet.add(new KacaciTanec());
    }

    @Override
    public void vytvorDosku(int pocetHracov) throws IllegalOperationException {
        if (pocetHracov > 6){
            throw new IllegalOperationException();
        }
        if (pocetHracov < 2){
            throw  new IllegalOperationException();
        }
        doska = new Doska(pocetHracov);

    }
    public Doska getDoska() throws IllegalOperationException{
        if (doska == null){
            throw  new IllegalOperationException();
        }
        return doska;
    }

    public void zahrajKartuById(int id) throws IllegalOperationException {
        if (this.listKariet.size() <= id){
            throw new IllegalOperationException();
        }
        this.listKariet.get(id).zahrajKartu(this.doska);
    }
}
