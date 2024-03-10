package spring.springCinema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springCinema.services.interfaces.IUserStatusServices;
import spring.springCinema.models.entity.UserStatus;
import spring.springCinema.repository.UserStatusRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserStatusServices implements IUserStatusServices {
    private final UserStatusRepo userStatusRepo;

    @Autowired
    public UserStatusServices (UserStatusRepo userStatusRepo) {
        this.userStatusRepo = userStatusRepo;
    }

    @Override
    public List<UserStatus> getAllUserStatus() {
        return userStatusRepo.findAll();
    }

    @Override
    public UserStatus getUserStatusById(int Id) {
        Optional<UserStatus> userStatusOptional = userStatusRepo.findById(Id);
        return userStatusOptional.orElse(null);
    }

    public UserStatus newUserStatus(UserStatus userStatus) {
        userStatusRepo.save(userStatus);
        return userStatus;
    }


    @Override
    public UserStatus updateUserStatus(UserStatus userStatus) {
        Optional<UserStatus> userStatusOptional = userStatusRepo.findById(userStatus.getId());

        if (userStatusOptional.isEmpty()) {
            return null;
        }

        UserStatus newUserStatus = userStatusOptional.get();
        newUserStatus.setCode(userStatus.getCode());
        newUserStatus.setNameStatus(userStatus.getNameStatus());
        return newUserStatus;
    }


    @Override
    public UserStatus removeUserStatus(int Id) {
        Optional<UserStatus> userStatusOptional = userStatusRepo.findById(Id);

        if (userStatusOptional.isEmpty()) {
            return null;
        }

        userStatusRepo.delete(userStatusOptional.get());
        return userStatusOptional.get();
    }
}
