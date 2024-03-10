package spring.springCinema.models.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "MovieType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieType {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MovieTypeName")
    private String description;

    @Column(name = "IsAvtive")
    private boolean isActive;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieTypeId")
    @JsonManagedReference()
    private Set<Movie> movies;
}
