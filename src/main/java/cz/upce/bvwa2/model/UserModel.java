package cz.upce.bvwa2.model;

import lombok.Data;

@Data
public abstract class UserModel {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
}
