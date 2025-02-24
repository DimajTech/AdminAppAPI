package com.api.repository;

import com.api.DTO.NewsDTO;
import com.api.DTO.UpdateStudentDTO;
import com.api.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query("""
        UPDATE User u
        SET u.name = :name,
            u.picture = :picture,
            u.description = :description,
            u.linkedIn = :linkedIn,
            u.professionalBackground = :professionalBackground,
            u.password = :password
        WHERE u.id = :id
        """)
    @Transactional
    void updateStudent(@Param("name") String name,
                       @Param("picture") String picture,
                       @Param("description") String description,
                       @Param("linkedIn") String linkedIn,
                       @Param("professionalBackground") String professionalBackground,
                       @Param("password") String password,
                       @Param("id") String id);
}
