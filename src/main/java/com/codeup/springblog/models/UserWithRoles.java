package com.codeup.springblog.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserWithRoles extends User implements UserDetails { //this class extends from the User model to get user info

    public UserWithRoles(User user){
        super(user); //calls copy constructor in User
    }

    @Override
    public Collection< ? extends GrantedAuthority > getAuthorities(){
        String roles = ""; //not using authorization part for this so we will leave this empty
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles); //  <-- ehh?
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
