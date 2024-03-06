package com.example.myblog.repository;

import com.example.myblog.enity.Role;
import com.example.myblog.enity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName roleName);
}
