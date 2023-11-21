package cz.upce.bvwa2.model.auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class SignInModel {

    private String email;
    private String password;

}
