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
@Table(name = "Promotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Percent")
    private int percent;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Type")
    private int type;

    @Column(name = "StartTime")
    private LocalDateTime startTime;

    @Column(name = "EndTime")
    private LocalDateTime endTime;

    @Column(name = "Description")
    private int description;

    @Column(name = "Name")
    private int name;

    @Column(name = "IsActive")
    private boolean isActive;

    // ManyToOne References:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RankCustomerId", foreignKey = @ForeignKey(name = "fk_promotion_rankCustomer"), insertable = false, updatable = false)
    @JsonBackReference
    private RankCustomer rankCustomerId;

    // OneToMany References:
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotionId")
    @JsonManagedReference()
    private Set<Bill> bills;
}
