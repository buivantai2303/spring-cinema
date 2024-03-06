package lts.ltsmovie.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "RefreshToken")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Token")
    private String token;

    @Column(name = "ExpiredTime")
    private LocalDateTime expiredTime;

    // ManyToOne References:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", foreignKey = @ForeignKey(name = "fk_refreshToken_user"), insertable = false, updatable = false)
    @JsonBackReference
    private User userId;
}
