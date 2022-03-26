package com.ctrends.employee.repository;

import java.util.Optional;

import com.ctrends.employee.models.ERole;
import com.ctrends.employee.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
