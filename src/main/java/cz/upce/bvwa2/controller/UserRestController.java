package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.user.UserCreateModel;
import cz.upce.bvwa2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("create")
    public ResponseEntity<Void> create(
        @RequestBody UserCreateModel model
    ) {
        return ResponseEntity.ok().build();
    }
}
