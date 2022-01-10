package com.example.demo.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v/users")
public class UserManagementController {
    private static final List<User> Users = Arrays.asList(
            new User(1,"Imane"),
            new User(2,"Imane"),
            new User(3,"amin"));

    @GetMapping
    @PreAuthorize("hasAnyRole(('ROLE_ADMIN'))")
    public List <User> getAllUsers(){
        System.out.println("Allusers");

        return Users;
    }

    @PostMapping
    @PreAuthorize("hasAuthority(('user:write'))")
    public void saveNewUser(User user){
        System.out.println("added");
        System.out.println(user);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority(('user:write'))")
    public void deleteUser (Integer Id ){
        System.out.println("deleted");
        System.out.println(Id);
    }

    @PutMapping(path="{Id}")
    public void updateUer(Integer Id, User user){
        System.out.println("updated");
        System.out.println("%s %s"+ Id + user);
    }
}
