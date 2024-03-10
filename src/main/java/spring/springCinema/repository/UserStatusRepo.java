package spring.springCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.springCinema.models.entity.UserStatus;

@Repository
public interface UserStatusRepo extends JpaRepository<UserStatus, Integer>{

}
