package lts.ltsmovie.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "RankCustomer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RankCustomer {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Point")
    private int point;

    @Column(name = "Description")
    private String description;

    @Column(name = "Name")
    @Max(value = 20, message = "Name maximum has 30 characters")
    @Min(value = 2, message = "Name minimum has 2 characters")
    private String name;

    @Column(name = "IsAvtice")
    private boolean isActive;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rankCustomerId")
    @JsonManagedReference()
    private Set<User> users;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rankCustomerId")
    @JsonManagedReference()
    private Set<Promotion> promotions;
}
