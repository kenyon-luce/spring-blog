package com.codeup.springblog;

public class UserWithRoles extends User implements UserDetails{

    public UserWithRoles(User user) {
        super(user); //calls on copy constructor in User class
    }
}
