package com.api.repository;

import com.api.DTO.NewsDTO;
import com.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, String> {

    @Query("SELECT u.id, u.name, u.email, u.role FROM User u WHERE u.registrationStatus = 'pending'")
    List<Object[]> findPendingUsers();

    @Query("SELECT u.id, u.name FROM User u WHERE u.role = 'professor'")
    List<Object[]> getProfessors();

    @Query(value = "EXEC GetUserByEmail :email", nativeQuery = true)
    User getUserByEmail(String email);

}
