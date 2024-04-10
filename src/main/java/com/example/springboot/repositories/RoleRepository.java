package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{

}
