package com.upmusic.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.upmusic.entity.User;
import com.upmusic.repo.RoleRepo;
import com.upmusic.repo.UserRepo;

@Service
public class UserServiceImpl  implements UserService{
	@Autowired 
	UserRepo urepo;
	@Autowired
	RoleRepo roleRepo ;
	@Autowired BCryptPasswordEncoder bCryptPasswordEncoder ;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepo.findAll()));
	urepo.save(user);
		
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return urepo.findByUsername(username);
	}

}
