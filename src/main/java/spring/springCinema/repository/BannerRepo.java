package spring.springCinema.repository;

import spring.springCinema.models.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepo extends JpaRepository<Banner, Integer> {

}
