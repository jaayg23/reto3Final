
package Reto3Final.entidades;

/**
 *
 * @author Jacobo
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;
    
    @OneToMany(cascade = (CascadeType.PERSIST), mappedBy = "client")
    @JsonIgnoreProperties({"client", "partyroom"})
    public List<Message>messages;
    
    @OneToMany(cascade = (CascadeType.PERSIST), mappedBy = "client")
    @JsonIgnoreProperties({"client", "partyroom"})
    public List<Reservation>reservations;
}
