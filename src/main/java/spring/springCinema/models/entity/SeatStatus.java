package spring.springCinema.models.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "SeatStatus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatStatus {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Code")
    private String code;

    @Column(name = "NameStatus")
    private String nameStatus;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seatStatusId")
    @JsonManagedReference()
    private Set<Seat> seats;
}
