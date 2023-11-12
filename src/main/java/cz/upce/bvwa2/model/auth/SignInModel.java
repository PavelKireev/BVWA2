package cz.upce.bvwa2.model.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInModel {

    private String email;
    private String password;

}
