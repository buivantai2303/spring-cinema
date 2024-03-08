package lts.ltsmovie.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Seat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Number")
    private int number;

    // Reference:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SeatStatusId", foreignKey = @ForeignKey(name = "fk_seat_seatStatus"), insertable = false, updatable = false)
    @JsonBackReference
    private SeatStatus seatStatusId;

    @Column(name = "Line")
    private String line;

    // Reference:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoomId", foreignKey = @ForeignKey(name = "fk_seat_room"), insertable = false, updatable = false)
    @JsonBackReference
    private Room roomId;

    @Column(name = "IsActive")
    private int isActive;

    // OneToMany References:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SeatTypeId", foreignKey = @ForeignKey(name = "fk_seat_seatType"), insertable = false, updatable = false)
    @JsonBackReference
    private SeatType seatTypeId;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seatId")
    @JsonManagedReference()
    private Set<Ticket> tickets;
}
