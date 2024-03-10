package spring.springCinema.decentralize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring.springCinema.models.entity.RankCustomer;
import spring.springCinema.models.entity.User;
import spring.springCinema.models.entity.UserStatus;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class CustomUserDetails implements UserDetails {

    private int id;
    private int point;
    private String username;
    private String email;
    private String name;
    private String phoneNumber;

    @JsonIgnore
    private String password;
    private RankCustomer rankCustomerId;
    private UserStatus userStatusId;
    private boolean isActive;


    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities () {
        return this.authorities;
    };


    public static CustomUserDetails mapUserToUserDetail(User user) {
        // Get permissions from User
        List<GrantedAuthority> listAuthorities = user.getRoleId()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
        // Returned object CustomUserDetails
        return new CustomUserDetails(
                user.getId(),
                user.getPoint(),
                user.getUsername(),
                user.getEmail(),
                user.getName(),
                user.getPhoneNumber(),
                user.getPassword(),
                user.getRankCustomerId(),
                user.getUserStatusId(),
                user.isActive(),
                listAuthorities
        );
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
