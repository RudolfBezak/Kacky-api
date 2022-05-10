package rudolf.bezak.kacky.subory;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rudolf.bezak.kacky.subory.exceptions.IllegalOperationException;

@RestController
@RequestMapping("/kacky")
public class KackyController {

    @Autowired
    IKackyService service;

    //vytvorenie dosky, rozdanie kariet, vytvorenie balickov
    @PostMapping("/{num}")
    public ResponseEntity<DoskaResponse> vytvorDosku(@PathVariable("num") int num) throws IllegalOperationException{
        this.service.vytvorDosku(num);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //vrati stav dosky
    @GetMapping
    public DoskaResponse posliMiDosku() throws IllegalOperationException {
        return new DoskaResponse(service.getDoska());
    }

    @PutMapping("/{id}")
    public DoskaResponse zahrajkartuById(@PathVariable("id") int id) throws IllegalOperationException{
        this.service.zahrajKartuById(id);
        return new DoskaResponse(service.getDoska());
    }



}
