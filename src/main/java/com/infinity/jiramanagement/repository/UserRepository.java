package com.infinity.jiramanagement.repository;

import com.infinity.jiramanagement.model.document.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}