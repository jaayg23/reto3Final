
package Reto3Final.controlador;

import Reto3Final.entidades.Reservation;
import Reto3Final.servicios.ServiciosReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jacobo
 */

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class WebReservation {
    
    @Autowired
    private ServiciosReservation serviciosReservation;
    
    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return serviciosReservation.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable Integer id){
        return serviciosReservation.getReservation(id);
    }
    
    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation reservation){
        return serviciosReservation.save(reservation);
    }
}
