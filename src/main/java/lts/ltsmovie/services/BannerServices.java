package lts.ltsmovie.services;

import lts.ltsmovie.models.Banner;
import lts.ltsmovie.repository.BannerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannerServices implements IBannerServices {

    private final BannerRepo bannerRepo;

    @Autowired
    public BannerServices (BannerRepo bannerRepo) {
        this.bannerRepo = bannerRepo;
    }

    @Override
    public List<Banner> getAllBanner() {
        return bannerRepo.findAll();
    }

    @Override
    public Banner getBannerById(int Id) {
        Optional<Banner> duAnOptional = bannerRepo.findById(Id);
        return duAnOptional.orElse(null);
    }

    public Banner newBanner(Banner banner) {
        bannerRepo.save(banner);
        return banner;
    }

    @Override
    public Banner updateBanner(Banner banner) {
        Optional<Banner> bannerOptional = bannerRepo.findById(banner.getId());

        if (bannerOptional.isEmpty()) {
            return null;
        }

        Banner newBanner = bannerOptional.get();
        newBanner.setTitle(banner.getTitle());
        newBanner.setImageUrl(banner.getImageUrl());
        return newBanner;
    }

    @Override
    public Banner removeBannerById(int Id) {
        Optional<Banner> bannerOptional = bannerRepo.findById(Id);

        if (bannerOptional.isEmpty()) {
            return null;
        }

        bannerRepo.delete(bannerOptional.get());
        return bannerOptional.get();
    }
}
