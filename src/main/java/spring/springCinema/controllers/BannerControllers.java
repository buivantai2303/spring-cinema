package spring.springCinema.controllers;

import com.google.gson.*;
import spring.springCinema.models.entity.Banner;
import spring.springCinema.services.BannerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "cinema/api/version/1.0")
public class BannerControllers {

    private final BannerServices bannerServices;

    public Gson GsonDateFormatter() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>)
                        (json, type, jsonDeserializationContext) -> LocalDateTime.parse(json.getAsJsonPrimitive()
                                .getAsString()))
                .create();
    }


    @Autowired
    private BannerControllers(BannerServices bannerServices) {
        this.bannerServices = bannerServices;
    }

    @GetMapping(value = "banner-list")
    public List<Banner> getAllBanner() {
        return bannerServices.getAllBanner();
    }

    @GetMapping(value = "banner-details")
    public Banner getBannerById(@RequestParam int Id) {
        return bannerServices.getBannerById(Id);
    }

    @PostMapping(value = "new-banner")
    public Banner newBanner(@RequestBody String banner) {

        Gson gson= new Gson();
        Banner newBanner = gson.fromJson(banner, Banner.class);

        bannerServices.newBanner(newBanner);
        return newBanner;
    }

    @PutMapping(value = "update-banner")
    public Banner modifyBanner(@RequestBody String banner) {
        Gson gson = new Gson();
        Banner updateBanner = gson.fromJson(banner, Banner.class);

        return bannerServices.updateBanner(updateBanner);
    }

    @DeleteMapping(value = "remove-banner")
    public Banner removeBanner(@RequestParam int Id) {
        return bannerServices.removeBannerById(Id);
    }
}
