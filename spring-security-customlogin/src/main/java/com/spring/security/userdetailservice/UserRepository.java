package com.spring.security.userdetailservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.userdetailservice.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
