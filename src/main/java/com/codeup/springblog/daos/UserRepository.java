package com.codeup.springblog.daos;

import com.codeup.springblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { //grabs user info by id
    User findByUsername(String username);
    User findByEmail(String email);
}
