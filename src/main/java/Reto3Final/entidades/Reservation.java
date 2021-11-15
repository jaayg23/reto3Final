
package Reto3Final.entidades;

/**
 *
 * @author Jacobo
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer idReservation;
    private String startDate;
    private String devolutionDate;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "description")
    @JsonIgnoreProperties("reservations")
    private Partyroom partyroom;
    
    @ManyToOne
    @JoinColumn(name = "messageText")
    @JsonIgnoreProperties({"partyroom", "client"})
    private Message messages;
    
    @ManyToOne
    @JoinColumn(name = "name")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;
}
