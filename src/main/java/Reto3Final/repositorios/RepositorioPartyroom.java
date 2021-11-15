
package Reto3Final.repositorios;

import Reto3Final.entidades.Partyroom;
import Reto3Final.interfaces.InterfacePartyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jacobo
 */
@Repository
public class RepositorioPartyroom {
    @Autowired
    private InterfacePartyroom interfacePartyroom;
    
    public List<Partyroom> getALL(){
        return (List<Partyroom>) interfacePartyroom.findAll();
    }
    
    public Optional <Partyroom> getPartytoom(int id){
        return interfacePartyroom.findById(id);
    }
    
    public Partyroom save(Partyroom partyroom){
        return interfacePartyroom.save(partyroom);
    }
            
}
