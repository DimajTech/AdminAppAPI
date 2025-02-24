package com.api.service;

import com.api.DTO.UpdateStudentDTO;
import com.api.model.User;
import com.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() throws SQLException {
        return userRepository.findAll();
    }

    public void saveUser(User user) throws SQLException {
        userRepository.save(user);
    }
    public void saveProfessorUser(User user) {
        userRepository.insertProfessorUser(user.getId(),user.getName(), user.getEmail(), user.getPassword(), user.getRole());
    }

    public User getUserById(String id) throws SQLException {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new RuntimeException("User not found for id :: " + id));
    }

    public User getUserByEmail(String email) throws SQLException {
        User optionalUser = userRepository.getUserByEmail(email);
        return optionalUser;
    }

    public void deleteUserById(String id) throws SQLException {
        userRepository.deleteById(id);
    }

    public Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.userRepository.findAll(pageable);
    }


    public List<User> getPendingUsers() throws SQLException {
        List<Object[]> results = userRepository.findPendingUsers();
        List<User> users = new ArrayList<>();
        for (Object[] row : results) {
            User user = new User();
            user.setId((String) row[0]);
            user.setName((String) row[1]);
            user.setEmail((String) row[2]);
            user.setRole((String) row[3]);
            users.add(user);
        }
        return users;
    }

    public String changeUserStatus(String id, String status) throws SQLException {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found for id :: " + id));
        user.setRegistrationStatus(status);
        userRepository.save(user);
        return user.getEmail();
    }

    public List<User> getProfessors() throws SQLException {
        List<Object[]> result = userRepository.getProfessors();
        List<User> professors = new ArrayList<>();
        for (Object[] user : result) {
            User professor = new User();
            professor.setId((String) user[0]);
            professor.setName((String) user[1]);
            professors.add(professor);
        }
        return professors;
    }

    public void updateStudent(UpdateStudentDTO student) throws SQLException {
        userRepository.updateStudent(student.getName(), student.getPicture(), student.getDescription(), student.getLinkedIn(), student.getProfessionalBackground(), student.getPassword(), student.getId());
    }
}
