package lts.ltsmovie.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Set;

@Entity
@Table(name = "Rate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rate {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Description")
    private String description;

    @Column(name = "Code")
    private String code;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rateId")
    @JsonManagedReference()
    private Set<Movie> movies;


}
