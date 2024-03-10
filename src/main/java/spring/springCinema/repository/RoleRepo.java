package spring.springCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.springCinema.models.entity.Role;
import spring.springCinema.models.role.ERole;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(ERole roleName);
}
