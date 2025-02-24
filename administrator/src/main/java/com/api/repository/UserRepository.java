package com.api.repository;

import com.api.DTO.NewsDTO;
import com.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, String> {

    @Query("SELECT u.id, u.name, u.email, u.role FROM User u WHERE u.registrationStatus = 'pending'")
    List<Object[]> findPendingUsers();

    @Query("SELECT u.id, u.name FROM User u WHERE u.role = 'professor'")
    List<Object[]> getProfessors();


    @Procedure(name = "InsertProfessorUser")
    void insertProfessorUser(
            @Param("id") String id,
            @Param("name") String name,
            @Param("email") String email,
            @Param("password") String password,
            @Param("role") String role
    );
    boolean existsByEmail(String email);

    @Query(value = "EXEC GetUserByEmail :email", nativeQuery = true)
    User getUserByEmail(String email);


}
