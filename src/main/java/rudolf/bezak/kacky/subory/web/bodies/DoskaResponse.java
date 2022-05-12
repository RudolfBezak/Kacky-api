package rudolf.bezak.kacky.subory.web.bodies;

import lombok.Getter;
import rudolf.bezak.kacky.subory.data.Doska;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DoskaResponse {
    private int[] jazero;
    private boolean[] zameriavaci;
    private int[][] ruky;

    private List<Integer> zivoty;
    private int naRade;

    private boolean vieZahrat;
    private List<Integer> balikKariet;
    private List<Integer> balikKaciek;

    private boolean pokracujeHra;




    public DoskaResponse(Doska doska) {
        this.pokracujeHra = doska.isPokracujeHra();
        this.jazero = doska.getJazero();
        this.zameriavaci = doska.getZameriavaci();
        this.ruky = new int[doska.getHraci().length][3];
        this.zivoty = new ArrayList<>();
        for (int i = 0; i < doska.getHraci().length; i++){
            zivoty.add(doska.getHraci()[i].getZivot());
            for (int y = 0; y < 3; y++){
                ruky[i][y] = doska.getHraci()[i].getRuka()[y].getId();
            }
        }
        this.vieZahrat = doska.isNaRadeVieHrat();
        naRade = doska.getNaRade();
        balikKariet = new ArrayList<>();
        for (int i = 0; i < doska.getBalikKariet().size(); i++){
            this.balikKariet.add(doska.getBalikKariet().get(i).getId());
        }
        this.balikKaciek = doska.getBalikKaciek();
    }
}
