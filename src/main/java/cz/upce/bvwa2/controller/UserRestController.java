package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

}
