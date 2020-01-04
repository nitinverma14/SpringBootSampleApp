package com.jarvis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.entity.AppUser;


public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
