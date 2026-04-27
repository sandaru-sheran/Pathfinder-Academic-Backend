package com.example.security.repository;

import com.example.security.model.User;
import com.example.security.model.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserReposotry extends JpaRepository<User, Long> {
    User findByEmail(String username);

    @Query("SELECT new com.example.security.model.dto.UserDTO(" +
            "u.id, u.firstName, u.lastName, u.email, u.registrationNumber, u.role, u.isEnabled) " +
            "FROM User u")
    List<UserDTO> findAllUserDtos();
}
