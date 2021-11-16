
package Reto3Final.entidades;

/**
 *
 * @author Jacobo
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer idReservation;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date devolutionDate;
    
    
    private String status = "created";
    
    @ManyToOne
    @JoinColumn(name = "description")
    @JsonIgnoreProperties("reservations")
    private Partyroom partyroom;
    
    
    @ManyToOne
    @JoinColumn(name = "name")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;
}
