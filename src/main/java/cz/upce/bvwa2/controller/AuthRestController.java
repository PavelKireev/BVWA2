package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.auth.LogoutModel;
import cz.upce.bvwa2.model.auth.SignInModel;
import cz.upce.bvwa2.model.auth.SignUpModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthRestController {

    @PostMapping("sign-in")
    public void signIn(
        @RequestBody SignInModel model
    ) {

    }

    @PostMapping("sign-up")
    public void signUp(
        @RequestBody SignUpModel model
    ) {

    }

    @PostMapping("logout")
    public void logout(
        @RequestBody LogoutModel logoutModel
    ) {

    }

}
