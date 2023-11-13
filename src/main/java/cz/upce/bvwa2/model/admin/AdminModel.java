package cz.upce.bvwa2.model.admin;

import cz.upce.bvwa2.db.entity.Admin;
import lombok.Data;

@Data
public class AdminModel {

    private String uuid;
    private String email;
    private String firstName;
    private String lastName;
    private String role;

    public AdminModel(Admin entity) {
        this.uuid = entity.getUser().getUuid();
        this.email = entity.getUser().getEmail();
        this.firstName = entity.getUser().getFirstName();
        this.lastName = entity.getUser().getLastName();
        this.role = entity.getUser().getRole();
    }

}
