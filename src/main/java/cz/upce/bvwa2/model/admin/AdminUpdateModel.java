package cz.upce.bvwa2.model.admin;

import cz.upce.bvwa2.db.entity.Admin;
import cz.upce.bvwa2.db.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminUpdateModel {

    private String uuid;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String role;

    public Admin toEntity() {
        Admin admin = Admin.builder()
                           .user(User.builder()
                                     .password(password)
                                     .firstName(firstName)
                                     .lastName(lastName)
                                     .email(email)
                                     .phoneNumber(phoneNumber)
                                     .role(role)
                                     .build())
                           .build();
        admin.getUser().setUuid(uuid);
        return admin;
    }
}
