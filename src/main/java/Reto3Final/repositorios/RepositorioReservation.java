
package Reto3Final.repositorios;

import Reto3Final.entidades.Reservation;
import Reto3Final.interfaces.InterfaceReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jacobo
 */
@Repository
public class RepositorioReservation {
    
    @Autowired
    private InterfaceReservation interfaceReservation;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) interfaceReservation.findAll();
    }
    
    public Optional<Reservation> getReservation(Integer id){
        return interfaceReservation.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return interfaceReservation.save(reservation);
    }
}

