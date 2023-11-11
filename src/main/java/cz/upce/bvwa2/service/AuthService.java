package cz.upce.bvwa2.service;

import cz.upce.bvwa2.model.auth.SignInModel;
import cz.upce.bvwa2.model.auth.SignUpModel;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;

public interface AuthService {
    String signIn(Authentication authentication, SignInModel model);

    @SneakyThrows
    void signUp(SignUpModel model);
}
