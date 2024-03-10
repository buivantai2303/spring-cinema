package spring.springCinema.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springCinema.models.entity.UserStatus;
import spring.springCinema.services.UserStatusServices;

import java.util.List;

@RestController
public class UserStatusControllers {

    private final UserStatusServices userStatusServices;

    @Autowired
    private UserStatusControllers(UserStatusServices userStatusServices) {
        this.userStatusServices = userStatusServices;
    }

    @GetMapping(value = "user-status-list")
    public List<UserStatus> getAllDuAn() {
        return userStatusServices.getAllUserStatus();
    }

    @GetMapping(value = "user-status-details")
    public UserStatus getBannerById(@RequestParam int Id) {
        return userStatusServices.getUserStatusById(Id);
    }

    @PostMapping(value = "new-user-status")
    public UserStatus newBanner(@RequestBody String banner) {

        Gson gson= new Gson();
        UserStatus newDuAn = gson.fromJson(banner, UserStatus.class);

        userStatusServices.newUserStatus(newDuAn);
        return newDuAn;
    }

    @PutMapping(value = "update-user-status")
    public UserStatus modifyUserStatus(@RequestBody String banner) {
        Gson gson = new Gson();
        UserStatus updateStatus = gson.fromJson(banner, UserStatus.class);

        return userStatusServices.updateUserStatus(updateStatus);
    }

    @DeleteMapping(value = "remove-user-status")
    public UserStatus removeUserStatus(@RequestParam int Id) {
        return userStatusServices.removeUserStatus(Id);
    }
}
