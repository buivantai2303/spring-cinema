package lts.ltsmovie.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Price")
    private double price;

    @Column(name = "StartAt")
    private LocalDateTime startAt;

    @Column(name = "EndAt")
    private LocalDateTime endAt;

    @Column(name = "Code")
    private String code;

    // Reference:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MovieId", foreignKey = @ForeignKey(name = "fk_schedule_movie"), insertable = false, updatable = false)
    @JsonBackReference
    private Movie movieId;

    @Column(name = "Name")
    private String name;

    // Reference:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoomId", foreignKey = @ForeignKey(name = "fk_schedule_room"), insertable = false, updatable = false)
    @JsonBackReference
    private Room roomId;

    @Column(name = "Trailer")
    private String trailer;

    @Column(name = "IsActive")
    private boolean isActive;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "scheduleId")
    @JsonManagedReference()
    private Set<Ticket> tickets;
}
