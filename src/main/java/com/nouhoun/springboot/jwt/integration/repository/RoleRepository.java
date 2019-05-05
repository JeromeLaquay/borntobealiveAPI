package com.nouhoun.springboot.jwt.integration.repository;

import com.nouhoun.springboot.jwt.integration.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nydiarra on 06/05/17.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
