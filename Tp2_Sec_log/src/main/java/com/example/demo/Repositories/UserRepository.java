package com.example.demo.Repositories;


import com.example.demo.user.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public interface UserRepository  {

    User findClientByNom(String nom);
}
class RepositoryClient {

    private static final Map<String, User> Users = new HashMap<>();


    private static void initDATA() {

        User user1 = new User(1, "IM");
        User admin = new User(2, "ma");


        Users.put(user1.getName(),user1);
        Users.put(admin.getName(),admin);
    }
}

