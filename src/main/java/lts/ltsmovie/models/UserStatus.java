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
@Table(name = "UserStatus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserStatus {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Code")
    private String code;

    @Column(name = "NameStatus")
    private String nameStatus;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userStatusId")
    @JsonManagedReference()
    private Set<User> users;
}
