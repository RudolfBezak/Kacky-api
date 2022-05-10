package rudolf.bezak.kacky.subory.logic;

import rudolf.bezak.kacky.subory.data.Doska;
import rudolf.bezak.kacky.subory.exceptions.IllegalOperationException;

public interface IKackyService {

    void vytvorDosku(int pocetHracov) throws IllegalOperationException;

    Doska getDoska() throws IllegalOperationException;

    void zahrajKartuById(int id, int miesto) throws IllegalOperationException;
}
