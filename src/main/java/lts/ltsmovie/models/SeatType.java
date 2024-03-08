package lts.ltsmovie.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "SeatType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatType {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NameType")
    private String nameType;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seatTypeId")
    @JsonManagedReference()
    private Set<Seat> seats;
}
