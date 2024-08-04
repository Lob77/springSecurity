package com.project.springsecurity.common.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
@Slf4j
public class LoginContoller {

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }
}
