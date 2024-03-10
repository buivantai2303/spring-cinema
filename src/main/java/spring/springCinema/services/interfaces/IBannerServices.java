package spring.springCinema.services.interfaces;

import spring.springCinema.models.entity.Banner;

import java.util.List;

public interface IBannerServices {
    List<Banner> getAllBanner();

    Banner getBannerById(int Id);

    Banner newBanner(Banner banner);

    Banner updateBanner(Banner banner);

    Banner removeBannerById(int Id);
}
