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
@Table(name = "Room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Capacity")
    private int capacity;

    @Column(name = "Type")
    private int type;

    @Column(name = "Desciption")
    private String desciption;

    // ManyToOne References :
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CinemaId", foreignKey = @ForeignKey(name = "fk_room_cinema"), insertable = false, updatable = false)
    @JsonBackReference
    private Cinema cinemaId;

    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "IsActive")
    private boolean isActive;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomId")
    @JsonManagedReference()
    private Set<Seat> seats;
}
