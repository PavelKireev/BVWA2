package cz.upce.bvwa2.service;

public interface UserService {
    void updatePassword(String userUuid, String newPassword);
}
