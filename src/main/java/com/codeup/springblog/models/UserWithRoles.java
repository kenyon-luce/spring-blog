package com.codeup.springblog.models;

public class UserWithRoles extends User implements UserDetails { //this class extends from the User model to get user info

    public UserWithRoles(User user){
        super(user); //calls copy constructor in User
    }
}
