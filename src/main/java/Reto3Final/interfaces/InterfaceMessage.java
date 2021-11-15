
package Reto3Final.interfaces;

import Reto3Final.entidades.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jacobo
 */
public interface InterfaceMessage extends CrudRepository<Message, Integer>{
    
}
