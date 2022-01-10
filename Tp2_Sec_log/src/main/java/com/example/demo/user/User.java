package com.example.demo.user;

public class User {
    private final Integer Id;

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public User(Integer id, String name) {
        Id = id;
        this.name = name;
    }

    private final  String name ;
    @Override
    public String toString(){
        return "User{"+
                "userId :"+Id+
                ",username :"+name +
                "}";
    }
}
