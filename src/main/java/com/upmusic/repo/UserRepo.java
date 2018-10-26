package com.upmusic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upmusic.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
public User findByUsername(String username);
}
