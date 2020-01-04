package com.jarvis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
}
