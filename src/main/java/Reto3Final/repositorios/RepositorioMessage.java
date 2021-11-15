
package Reto3Final.repositorios;

import Reto3Final.entidades.Message;
import Reto3Final.interfaces.InterfaceMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jacobo
 */

@Repository
public class RepositorioMessage {
    @Autowired
    private InterfaceMessage interfaceMessage;
    
    public List<Message> getAll(){
        return (List<Message>) interfaceMessage.findAll();
    }
    
    public Optional<Message> getMessage(Integer id){
        return interfaceMessage.findById(id);
    }
    
    public Message save(Message message){
        return interfaceMessage.save(message);
    }
}