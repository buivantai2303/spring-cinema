package lts.ltsmovie.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "BillStatus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillStatus {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "billStatusId")
    @JsonManagedReference()
    private Set<Bill> bills;
}
