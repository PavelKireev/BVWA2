package cz.upce.bvwa2.model.auth;

import lombok.Data;

@Data
public class PasswordUpdateModel {
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;
}
