package com.jco.projectmanagement.dao;

import com.jco.projectmanagement.enteties.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityUserRepo extends JpaRepository<SecurityUser, Integer> {

    Optional<SecurityUser> findByEmail(String email);
}
