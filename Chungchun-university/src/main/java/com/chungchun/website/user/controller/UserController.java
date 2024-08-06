package com.chungchun.website.user.controller;

import com.chungchun.website.user.model.UserDTO;
import com.chungchun.website.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String register() {return "user/signUp";}

    @PostMapping("/register")
    public String register(UserDTO userDTO) {

        log.info("signup : {}", userDTO);

        userService.register(userDTO);
        return "/auth/login";
    }
}
