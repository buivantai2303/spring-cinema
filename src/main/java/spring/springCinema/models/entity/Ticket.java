package spring.springCinema.models.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Code")
    private String code;

    // ManyToOne References:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ScheduleId", foreignKey = @ForeignKey(name = "fk_ticket_schedule"), insertable = false, updatable = false)
    @JsonBackReference
    private Schedule scheduleId;

    // ManyToOne References:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SeatId", foreignKey = @ForeignKey(name = "fk_ticket_seat"), insertable = false, updatable = false)
    @JsonBackReference
    private Seat seatId;

    @Column(name = "PriceTicket")
    private int priceTicket;

    @Column(name = "IsActive")
    private boolean isActive;
}
