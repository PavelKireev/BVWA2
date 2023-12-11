package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.db.entity.User;
import cz.upce.bvwa2.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @SneakyThrows
    @PostMapping("update-profile-photo")
    public void updateProfilePhoto(
        Authentication authentication,
        @RequestParam("profilePhoto") MultipartFile file
    ) {
        userService.updateProfilePhoto((String) ((Jwt)authentication.getPrincipal()).getClaims().get("uuid"),
                                       file.getBytes());
    }

    @GetMapping(value = "profile-photo",
                produces = MediaType.IMAGE_JPEG_VALUE
    )
    public byte[] getProfilePhoto(Authentication authentication) {
        return userService.getProfilePhoto((String) ((Jwt)authentication.getPrincipal()).getClaims().get("uuid"));
    }
}
