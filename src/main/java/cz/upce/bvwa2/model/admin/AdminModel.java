package cz.upce.bvwa2.model.admin;

import cz.upce.bvwa2.db.entity.Admin;
import lombok.Data;

@Data
public class AdminModel {

    private String uuid;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;

    public static AdminModel fromEntity(Admin admin) {
        AdminModel adminModel = new AdminModel();
        adminModel.setUuid(admin.getUuid());
        adminModel.setEmail(admin.getUser().getEmail());
        adminModel.setFirstName(admin.getUser().getFirstName());
        adminModel.setLastName(admin.getUser().getLastName());
        adminModel.setPhoneNumber(admin.getUser().getPhoneNumber());
        adminModel.setRole(admin.getUser().getRole());
        return adminModel;
    }

}
