
package Reto3Final.repositorios;

import Reto3Final.entidades.Client;
import Reto3Final.interfaces.InterfaceClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jacobo
 */
@Repository
public class RepositorioClient {
    
    @Autowired
    public InterfaceClient interfaceClient;
    
    public List<Client> getAll(){
        return (List<Client>) interfaceClient.findAll();
    }
    
    public Optional<Client> getClient(Integer id){
        return interfaceClient.findById(id);
    }
    
    public Client save(Client client){
        return interfaceClient.save(client);
    }
}