package spring.springCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.springCinema.models.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String userName);

    boolean existsByUsername(String Username);

    boolean existsByEmail(String Username);

}
