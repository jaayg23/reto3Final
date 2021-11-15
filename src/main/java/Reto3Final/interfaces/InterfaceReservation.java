
package Reto3Final.interfaces;

import Reto3Final.entidades.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jacobo
 */
public interface InterfaceReservation extends CrudRepository<Reservation, Integer>{
    
}
