
package Reto3Final.controlador;

import Reto3Final.servicios.ServiciosPartyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import Reto3Final.entidades.Partyroom;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jacobo
 */
@RestController
@RequestMapping("api/Partyroom")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST})
public class WebPartyroom {
    
    @Autowired
    private ServiciosPartyroom servicios;
    @GetMapping("/all")
    public List<Partyroom> getPartyroom(){
        return servicios.getALL();
    }
    
    @GetMapping("/{id}")
    public Optional<Partyroom> getPartyroom(@PathVariable("id") int idPartyroom){
        return servicios.getPartyroom(idPartyroom);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody Partyroom partyroom){
        return servicios.save(partyroom);
    } 
    
}