package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.configuration.security.AuthUser;
import cz.upce.bvwa2.db.entity.User;
import cz.upce.bvwa2.db.repository.UserRepository;
import cz.upce.bvwa2.model.auth.PasswordUpdateModel;
import cz.upce.bvwa2.model.auth.SignInModel;
import cz.upce.bvwa2.model.auth.SignUpModel;
import cz.upce.bvwa2.service.AuthService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/authentication")
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;
    private final UserRepository userRepository;

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

    @PostMapping("update-password")
    public void updatePassword(
        @RequestBody PasswordUpdateModel model,
        Authentication authentication
    ) {
        User user = userRepository.findByUuid((String) ((Jwt)authentication.getPrincipal()).getClaims().get("uuid"))
                                  .orElseThrow(EntityNotFoundException::new);
        authService.updatePassword(user, model);
    }

}
