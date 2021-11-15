
package Reto3Final.repositorios;

/**
 *
 * @author Jacobo
 */

import Reto3Final.entidades.Category;
import Reto3Final.interfaces.InterfaceCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategory {
    @Autowired
    private InterfaceCategory crud;
    
    public List<Category> getALL(){
        return (List<Category>) crud.findAll();
    }
    
    public Optional <Category> getCategory(int id){
        return crud.findById(id);
    }
    
    public Category save(Category category){
        return crud.save(category);
    }
}
