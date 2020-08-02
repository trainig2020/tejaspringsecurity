package com.SpringSecurityJpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurityJpa.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserName(String userName);

}
