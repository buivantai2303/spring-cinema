package lts.ltsmovie.controllers;

import com.google.gson.*;
import lts.ltsmovie.models.Banner;
import lts.ltsmovie.services.BannerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "cinema/api/version/1.0")
public class BannerControllers {

    private final BannerServices bannerServices;

    @Autowired
    private BannerControllers(BannerServices bannerServices) {
        this.bannerServices = bannerServices;
    }

    @GetMapping(value = "list-banner")
    public List<Banner> getAllDuAn() {
        return bannerServices.getAllBanner();
    }

    @GetMapping(value = "banner-details")
    public Banner getBannerById(@RequestParam int Id) {
        return bannerServices.getBannerById(Id);
    }

    @PostMapping(value = "newBanner")
    public Banner newBanner(@RequestBody String banner) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws
                    JsonIOException {
                return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();

        Banner newDuAn = gson.fromJson(banner, Banner.class);

        bannerServices.newBanner(newDuAn);
        return newDuAn;
    }

    @GetMapping(value = "remove-banner")
    public Banner removeBanner(@RequestParam int Id) {
        return bannerServices.removeBannerById(Id);
    }
}
