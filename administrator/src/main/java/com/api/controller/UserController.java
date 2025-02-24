package com.api.controller;

import com.api.DTO.UpdateStudentDTO;
import com.api.model.User;
import com.api.repository.UserRepository;
import com.api.service.SendEmail;
import com.api.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping(path="/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        try {
            return userService.getAllUsers();
        } catch (SQLException ex) {
            return (List<User>) ResponseEntity
                    .badRequest()
                    .body("Error loading user list");
        }
    }

    @PostMapping ("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        JSONObject response = new JSONObject();
        try {
            userService.saveUser(user);
            response.put("message", "User added successfully");
            response.put("isSuccess", true);
            return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
        } catch (SQLException ex) {
            return ResponseEntity
                    .badRequest()
                    .body("User not inserted");
        }
    }
    @PostMapping("/saveProfessorUser")
    public ResponseEntity<?> saveProfessorUser(@RequestBody User user) {
        JSONObject response = new JSONObject();
        try {
            if (userRepository.existsByEmail(user.getEmail())) {
                response.put("message", "El correo ya está registrado.");
                return ResponseEntity.badRequest().body(response.toString());
            }

            userService.saveProfessorUser(user);
            response.put("message", "Usuario registrado con éxito.");
            return ResponseEntity.ok(response.toString());

        } catch (Exception ex) {
            response.put("message", "Error al registrar el usuario.");
            return ResponseEntity.badRequest().body(response.toString());
        }
    }

    @PostMapping("/deleteUserById/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") String id) {
        JSONObject response = new JSONObject();
        try {
            userService.deleteUserById(id);
            response.put("message", "User deleted");
            response.put("isSuccess", true);
            return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
        } catch (SQLException ex) {
            return ResponseEntity
                    .badRequest()
                    .body("User not deleted");
        }
    }

    @GetMapping("/getUserDetailById/{id}")
    public ResponseEntity<User> get(@PathVariable String id) {
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getUserDetailByEmail/{email}")
    public ResponseEntity<User> getUserDetailByEmail(@PathVariable String email) {
        try {
            User user = userService.getUserByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/getPendingUsers")
    public ResponseEntity<?> getPendingUsers() {
        try {
            List<User> users = userService.getPendingUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/changeUserStatus/{id}")
    public ResponseEntity<?> changeUserStatus(@PathVariable(value = "id") String id, @RequestBody String status) {
        try{
            String email = userService.changeUserStatus(id, status);
            status = status.equalsIgnoreCase("accepted") ? "aprobada" : "rechazada";
            SendEmail.sendRegistrationEmail(email, status);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(SQLException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProfessors")
    public ResponseEntity<?> getProfessors() {
        try {
            List<User> users = userService.getProfessors();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try{
            userService.saveUser(user);
            return ResponseEntity.ok("User updated successfully");
        }catch(SQLException ex){
            return ResponseEntity.badRequest().body("Error updating user");
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody UpdateStudentDTO student) {
        try{
            userService.updateStudent(student);
            return ResponseEntity.ok("Student updated successfully");
        }catch(SQLException ex){
            return ResponseEntity.badRequest().body("Error updating student");
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
