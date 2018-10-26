package com.upmusic.service;

import com.upmusic.entity.User;

public interface UserService {
void save(User user);
public User findByUsername(String username);
}
