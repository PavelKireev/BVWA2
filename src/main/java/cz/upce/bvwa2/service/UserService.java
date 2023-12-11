package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.entity.User;

import java.util.List;

public interface UserService {
    void updatePassword(String userUuid, String newPassword);
    List<User> getAll();
    void updateProfilePhoto(String userUuid, byte[] profilePhoto);
    byte[] getProfilePhoto(String userUuid);
    User findByUuid(String userUuid);
}
