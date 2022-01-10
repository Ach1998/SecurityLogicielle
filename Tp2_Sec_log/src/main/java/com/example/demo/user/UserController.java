package com.example.demo.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v/users")
public class UserController {
    private static final List<User> Users = Arrays.asList(
            new User(1,"Imane"),
            new User(2,"Imane"),
            new User(3,"amin")


    );
    @GetMapping(path="{Id}")
    public User getUser(@PathVariable("Id")Integer Id){
        return  Users.stream()
                .filter(user -> Id.equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User"+Id+"does not exist"));
    }
}
