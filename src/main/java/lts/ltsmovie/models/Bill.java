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
@Table(name = "Bill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TotalMoney")
    private double totalMoney;

    @Column(name = "TradingCode")
    private String tradingCode;

    @Column(name = "CreateTime")
    private LocalDateTime createTime;

    // ManyToOne References :
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_bill_customer"), insertable = false, updatable = false)
    @JsonBackReference
    private User customerId;

    @Column(name = "Name")
    private String name;

    @Column(name = "UpdateTime")
    private LocalDateTime updateTime;

    // ManyToOne References :
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PromotionId", foreignKey = @ForeignKey(name = "fk_bill_promotion"), insertable = false, updatable = false)
    @JsonBackReference
    private Promotion promotionId;

    // ManyToOne References :
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BillStatusId", foreignKey = @ForeignKey(name = "fk_bill_billStatus"), insertable = false, updatable = false)
    @JsonBackReference
    private BillStatus billStatusId;

    @Column(name = "IsActive")
    private boolean isActive;


}
