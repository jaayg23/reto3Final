/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3Final.interfaces;

import Reto3Final.entidades.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jacobo
 */
public interface InterfaceClient extends CrudRepository<Client, Integer>{
    
}
