package spring.springCinema.models.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "GeneralSetting")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralSetting {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "BreakTime")
    private LocalDateTime breakTime;

    @Column(name = "BusinessHours")
    private int businessHours;

    @Column(name = "CloseTime")
    private LocalDateTime closeTime;

    @Column(name = "FixedTicketPrice")
    private double fixedTicketPrice;

    @Column(name = "PercentDay")
    private int percentDay;

    @Column(name = "PercentWeekend")
    private int percentWeekend;

    @Column(name = "TimeBeginToChange")
    private LocalDateTime timeBeginToChange;
}
