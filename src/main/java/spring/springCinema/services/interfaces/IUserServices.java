package spring.springCinema.services.interfaces;

import spring.springCinema.models.entity.User;
import java.util.List;

public interface IUserServices {

    List<User> getAllUser();

    User getUserById(int Id);

    User newUser(User banner);

    User updateUser(User banner);

    User removeUser(int Id);

}
