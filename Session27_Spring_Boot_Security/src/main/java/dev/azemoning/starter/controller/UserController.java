package dev.azemoning.starter.controller;

import dev.azemoning.starter.model.User;
import dev.azemoning.starter.repository.UserRepository;
import dev.azemoning.starter.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("user")
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @PutMapping("user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
