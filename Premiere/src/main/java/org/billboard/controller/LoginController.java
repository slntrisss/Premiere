package org.billboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/admin")
    public String getLogin(){
        return "login/login";
    }
}
