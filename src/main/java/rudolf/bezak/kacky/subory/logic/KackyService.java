package rudolf.bezak.kacky.subory.logic;

import org.springframework.stereotype.Service;
import rudolf.bezak.kacky.subory.data.Doska;
import rudolf.bezak.kacky.subory.data.Hrac;
import rudolf.bezak.kacky.subory.exceptions.IllegalOperationException;
import rudolf.bezak.kacky.subory.karty.*;
import rudolf.bezak.kacky.subory.logic.IKackyService;

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
        this.listKariet.add(new Turbokacka());
        this.listKariet.add(new Rosambo());
        this.listKariet.add(new Zamierit());
        this.listKariet.add(new Vystrel());
        this.listKariet.add(new DivokyBill());
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

    public void zahrajKartuById(int id, int miesto) throws IllegalOperationException {
        if (this.listKariet.size() <= id){
            throw new IllegalOperationException();
        }
        //pozri ci vies zahrat tu kartu: ma ju na ruke, da sa zahrat


        if (doska.isNaRadeVieHrat()){
            boolean maKartuNaRuke = false;
            for (int i = 0; i < 3; i++) {
                if (doska.getHraci()[doska.getNaRade()].getRuka()[i].getId() == id){
                    maKartuNaRuke  = true;
                    //vymen ju s kopou
                    doska.getBalikKariet().add(doska.getHraci()[doska.getNaRade()].getRuka()[i]);
                    doska.getHraci()[doska.getNaRade()].getRuka()[i] = doska.getBalikKariet().get(0);
                    doska.getBalikKariet().remove(0);
                    break;
                }
            }
            if (!maKartuNaRuke){
                throw new IllegalOperationException();
            }
        }

        if (!doska.isNaRadeVieHrat()){
            return;
        }



        if(!this.listKariet.get(id).isMa2Kroky()){
            if(!this.listKariet.get(id).zahrajKartu(this.doska)){
                throw new IllegalOperationException();
            }
            posunHraca();
            return;
        }
        if (miesto > 5){
            throw new IllegalOperationException();
        }
        if (!this.listKariet.get(id).zahrajKartu(this.doska, miesto)){
            throw new IllegalOperationException();
        }
        if (!posunHraca()){
            this.doska.setPokracujeHra(false);
        }
    }

    public boolean posunHraca(){
        //zisti kto je na rade
        int naRade = doska.getNaRade();
        naRade += 1;
        if (naRade >= doska.getHraci().length){
            naRade -= doska.getHraci().length;
        }

        //zisti ci neskoncila hra
        boolean hra1 = false;
        boolean hra2 = false;
        for (int i = 0; i < doska.getHraci().length; i++){
            if(hra1 && doska.getHraci()[i].getZivot() > 0){
                hra2 = true;
                break;
            }

            if (doska.getHraci()[i].getZivot() > 0){
                hra1 = true;
            }
        }

        if (!hra2){
            return false;
        }

        //ak hrac ume vrati ruku
        while (doska.getHraci()[naRade].getZivot()==0){
            if (!doska.getHraci()[naRade].isVratilRuku()){
                vratRuku(naRade);
            }
            naRade++;
        }
        if (naRade >= doska.getHraci().length){
            naRade -= doska.getHraci().length;
        }
        doska.setNaRade(naRade);
        //pozri ci vie zahrat
        this.doska.setNaRadeVieHrat(false);
        for (int i = 0; i < 3; i++){
            if(this.doska.getHraci()[this.doska.getNaRade()].getRuka()[i].viemZahrat(this.doska)){
                this.doska.setNaRadeVieHrat(true);
                break;
            }
        }
        return true;

    }
    private void vratRuku(int hracId){
        for (int i = 0; i < 3; i++){
            doska.getBalikKariet().add(doska.getHraci()[hracId].getRuka()[i]);
            doska.getHraci()[hracId].getRuka()[i] = null;
        }

    }
}
