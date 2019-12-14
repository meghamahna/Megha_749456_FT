package com.example.register;

public class User {

    String name;
    String email;
    String phone;



    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    static User[] users = new User[]{};
}
