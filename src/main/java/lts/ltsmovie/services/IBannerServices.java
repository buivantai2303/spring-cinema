package lts.ltsmovie.services;

import lts.ltsmovie.models.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBannerServices {
    List<Banner> getAllBanner();

    Banner getBannerById(int Id);

    Banner newBanner(Banner banner);

    Banner updateBanner(Banner banner);

    Banner removeBannerById(int Id);
}
