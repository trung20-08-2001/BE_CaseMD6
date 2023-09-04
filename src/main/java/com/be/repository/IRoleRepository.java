package com.be.repository;

import com.be.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
    Role findById(int id);
}
