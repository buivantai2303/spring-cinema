package lts.ltsmovie.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ConfirmEmail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmEmail {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // ManyToOne References:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", foreignKey = @ForeignKey(name = "fk_confirmEmail_user"), insertable = false, updatable = false)
    @JsonBackReference
    private User userId;

    @Column(name = "RequiredTime")
    private LocalDateTime requiredTime;

    @Column(name = "ExpiredTime")
    private LocalDateTime expiredTime;

    @Column(name = "ConfirmCode")
    private String confirmCode;

    @Column(name = "IsActive")
    private boolean isActive;
}
