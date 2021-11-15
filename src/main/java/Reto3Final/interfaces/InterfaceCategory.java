/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3Final.interfaces;

import Reto3Final.entidades.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jacobo
 */
public interface InterfaceCategory extends CrudRepository<Category, Integer>{
    
}
