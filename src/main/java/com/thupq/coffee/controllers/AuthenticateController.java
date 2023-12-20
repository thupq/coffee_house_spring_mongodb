package com.thupq.coffee.controllers;

import com.thupq.coffee.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/i")
@RequiredArgsConstructor
public class AuthenticateController {

    private final UserService userService;

    @PostMapping("/signin")
    @Operation(summary = "UserController.signin")
    public String login(@RequestParam String userName, @RequestParam String password) {
        return userService.signin(userName, password);
    }
}
