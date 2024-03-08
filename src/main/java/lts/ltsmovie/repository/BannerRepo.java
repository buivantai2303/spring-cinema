package lts.ltsmovie.repository;

import lts.ltsmovie.models.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepo extends JpaRepository<Banner, Integer> {

}
