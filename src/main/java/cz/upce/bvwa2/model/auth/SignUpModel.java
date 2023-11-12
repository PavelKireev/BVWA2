package cz.upce.bvwa2.model.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpModel {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
