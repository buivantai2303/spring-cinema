package lts.ltsmovie.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Code")
    private String code;

    @Column(name = "RoleName")
    private String roleName;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roleId")
    @JsonManagedReference()
    private Set<User> users;
}
