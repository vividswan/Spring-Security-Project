package com.security.vividswan.repository;

import com.security.vividswan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    // SELECT * FROM user WHERE username = 1?;
    public User findByUsername(String username);
}
