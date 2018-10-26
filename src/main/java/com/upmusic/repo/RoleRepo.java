package com.upmusic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upmusic.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
Role findByName(String name);
}
