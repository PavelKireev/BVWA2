package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.entity.User;
import cz.upce.bvwa2.db.repository.UserRepository;
import cz.upce.bvwa2.model.user.UserCreateModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public void create(UserCreateModel model) {
        throw new UnsupportedOperationException();
    }

    public void updatePassword(String userUuid, String newPassword) {
        User user = repository.findByUuid(userUuid)
                              .orElseThrow(EntityNotFoundException::new);
        user.setPassword(newPassword);
        repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void updateProfilePhoto(String userUuid, byte[] profilePhoto) {
        User user = repository.findByUuid(userUuid)
                              .orElseThrow(EntityNotFoundException::new);
        user.setProfilePhoto(profilePhoto);
        repository.save(user);
    }

    @Override
    public @ResponseBody byte[] getProfilePhoto(String userUuid) {
        User user = repository.findByUuid(userUuid)
                              .orElseThrow(EntityNotFoundException::new);
        return user.getProfilePhoto();
    }

    @Override
    public User findByUuid(String userUuid) {
        return repository.findByUuid(userUuid)
                         .orElseThrow(EntityNotFoundException::new);
    }
}
