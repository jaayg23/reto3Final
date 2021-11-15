/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Final.servicios;

import Reto3Final.entidades.Client;
import Reto3Final.repositorios.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jacobo
 */
@Service
public class ServiciosClient {
    
    @Autowired
    private RepositorioClient metodosCrud;
    
    public List<Client> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Client> getClient(Integer id){
        return metodosCrud.getClient(id);
    }
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else {
            Optional<Client> clientAux = metodosCrud.getClient(client.getIdClient());
            if(clientAux.isEmpty()){
                return metodosCrud.save(client);
            }else {
                return client;
            }
        }
    }
}
