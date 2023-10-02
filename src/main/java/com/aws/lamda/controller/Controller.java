package com.aws.lamda.controller;

import com.aws.lamda.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUser() {
        return List
                .of(new User("Mahsa", "Saeedi", "mahsa.saeedy@google.com"),
                        new User("Elham", "Heydari", "eli.heydari@yahoo.com"));
    }
}