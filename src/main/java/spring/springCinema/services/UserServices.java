package spring.springCinema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springCinema.services.interfaces.IUserServices;
import spring.springCinema.models.entity.User;
import spring.springCinema.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices implements IUserServices {
    private final UserRepo userRepo;

    @Autowired
    public UserServices (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(int Id) {
        Optional<User> userOptional = userRepo.findById(Id);
        return userOptional.orElse(null);
    }

    public User newUser(User user) {
        userRepo.save(user);
        return user;
    }


    @Override
    public User updateUser(User user) {
        Optional<User> userOptional = userRepo.findById(user.getId());

        if (userOptional.isEmpty()) {
            return null;
        }

        User newUser = userOptional.get();
        newUser.setPoint(user.getPoint());
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setPassword(user.getPassword());
        newUser.setRankCustomerId(newUser.getRankCustomerId());
        newUser.setUserStatusId(newUser.getUserStatusId());
        newUser.setRoleId(user.getRoleId());
        newUser.setActive(user.isActive());
        return newUser;

    }


    @Override
    public User removeUser(int Id) {
        Optional<User> userOptional = userRepo.findById(Id);

        if (userOptional.isEmpty()) {
            return null;
        }

        userRepo.delete(userOptional.get());
        return userOptional.get();
    }
}
