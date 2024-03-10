package spring.springCinema.models.entity;
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
@Table(name = "Movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MovieDuration")
    private int movieDuration;

    @Column(name = "EndTime")
    private LocalDateTime endTime;

    @Column(name = "PremiereDate")
    private LocalDateTime premiereDate;

    @Column(name = "Description")
    private String description;

    @Column(name = "Director")
    private String director;

    @Column(name = "Image")
    private String image;

    @Column(name = "HeroImage")
    private String heroImage;

    @Column(name = "Language")
    private String language;

    // ManyToOne References:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MovieTypeId", foreignKey = @ForeignKey(name = "fk_movie_movieType"), insertable = false, updatable = false)
    @JsonBackReference
    private MovieType movieTypeId;

    @Column(name = "Name")
    private String name;

    // ManyToOne References:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RateId", foreignKey = @ForeignKey(name = "fk_movie_rate"), insertable = false, updatable = false)
    @JsonBackReference
    private Rate rateId;

    @Column(name = "Trailer")
    private String trailer;

    @Column(name = "IsActive")
    private boolean isActive;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieId")
    @JsonManagedReference()
    private Set<Schedule> schedules;
}
