/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Final.servicios;

import Reto3Final.entidades.Partyroom;
import Reto3Final.repositorios.RepositorioPartyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jacobo
 */
@Service
public class ServiciosPartyroom {
    
    
    @Autowired
    private RepositorioPartyroom metodosCrud;
    
    public List<Partyroom> getALL(){
        return metodosCrud.getALL();
    }
    
    public Optional<Partyroom> getPartyroom(int id){
        return metodosCrud.getPartytoom(id);
    }
    
    public Partyroom save(Partyroom partyroom){
        if(partyroom.getId()==null){
            return metodosCrud.save(partyroom);
        }else{
            Optional<Partyroom> evt=metodosCrud.getPartytoom(partyroom.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(partyroom);
            }else{
                return partyroom;
            }
        }
    }
}
