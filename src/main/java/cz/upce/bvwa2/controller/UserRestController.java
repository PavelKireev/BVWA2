package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.db.entity.User;
import cz.upce.bvwa2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
