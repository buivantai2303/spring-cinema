package spring.springCinema.services.interfaces;

import spring.springCinema.models.entity.UserStatus;

import java.util.List;

public interface IUserStatusServices {
    List<UserStatus> getAllUserStatus();

    UserStatus getUserStatusById(int Id);

    UserStatus newUserStatus(UserStatus banner);

    UserStatus updateUserStatus(UserStatus banner);

    UserStatus removeUserStatus(int Id);
}
