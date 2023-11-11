package cz.upce.bvwa2.db.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
