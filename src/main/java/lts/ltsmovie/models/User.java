package lts.ltsmovie.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // Column:
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Point")
    private int point;

    @Column(name = "Username")
    private String username;

    @Column(name = "Email")
    private String email;

    @Column(name = "Name")
    private String name;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Password")
    private String password;

    // ManyToOne References :
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RankCustomerId", foreignKey = @ForeignKey(name = "fk_user_rankCustomer"), insertable = false, updatable = false)
    @JsonBackReference
    private RankCustomer rankCustomerId;

    // ManyToOne References :
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserStatusId", foreignKey = @ForeignKey(name = "fk_user_userStatus"), insertable = false, updatable = false)
    @JsonBackReference
    private UserStatus userStatusId;

    @Column(name = "IsActive")
    private boolean isActive;

    // ManyToOne References :
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleId", foreignKey = @ForeignKey(name = "fk_user_role"), insertable = false, updatable = false)
    @JsonBackReference
    private Role roleId;


    // OneToMany References :
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerId")
    @JsonManagedReference()
    private Set<Bill> bills;

    // OneToMany References :
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    @JsonManagedReference()
    private Set<ConfirmEmail> confirmEmails;

    // OneToMany References :
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    @JsonManagedReference()
    private Set<RefreshToken> refreshTokens;
}
