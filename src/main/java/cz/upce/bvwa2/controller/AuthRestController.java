package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.auth.LogoutModel;
import cz.upce.bvwa2.model.auth.SignInModel;
import cz.upce.bvwa2.model.auth.SignUpModel;
import cz.upce.bvwa2.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;

    @PostMapping("sign-in")
    public String signIn(
        @RequestBody SignInModel model,
        Authentication authentication
    ) {
        return authService.signIn(authentication, model);
    }

    @PostMapping("sign-up")
    public void signUp(
        @RequestBody SignUpModel model
    ) {
        authService.signUp(model);
    }

}
