package lts.ltsmovie.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BillTicket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillTicket {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Quantity")
    private String quantity;

    // ManyToOne References :
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BillId", foreignKey = @ForeignKey(name = "fk_billTicket_bill"), insertable = false, updatable = false)
    @JsonBackReference
    private Bill billId;

    // ManyToOne References :
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TicketId", foreignKey = @ForeignKey(name = "fk_billTicket_ticket"), insertable = false, updatable = false)
    @JsonBackReference
    private Ticket ticketId;

}
