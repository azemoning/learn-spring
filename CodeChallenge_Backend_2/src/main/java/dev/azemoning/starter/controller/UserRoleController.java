package dev.azemoning.starter.controller;

import dev.azemoning.starter.service.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserRoleController {

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @GetMapping("role/users")
    public ResponseEntity<Object> getAllUserRole() {
        return new ResponseEntity<>(userRoleService.getUserRoles(), HttpStatus.OK);
    }

    @GetMapping("role/users/{id}")
    public ResponseEntity<Object> getUserRoleById(@PathVariable Long id) {
        return new ResponseEntity<>(userRoleService.getUserRoleById(id), HttpStatus.OK);
    }

    @PostMapping("role/users/{userId}/{roleId}")
    public ResponseEntity<Object> addUserRole(@PathVariable Long userId, @PathVariable Long roleId) {
        return new ResponseEntity<>(userRoleService.addUserRole(userId, roleId), HttpStatus.CREATED);
    }

    @PutMapping("role/users/{id}/{userId}/{roleId}")
    public ResponseEntity<Object> updateUserRole(@PathVariable Long id,
                                                 @PathVariable Long userId,
                                                 @PathVariable Long roleId) {
        return new ResponseEntity<>(userRoleService.updateUserRole(id, userId, roleId), HttpStatus.OK);
    }

    @DeleteMapping("role/users/{id}")
    public ResponseEntity<Object> deleteUserRole(@PathVariable Long id) {
        return new ResponseEntity<>(userRoleService.deleteUserRole(id), HttpStatus.OK);
    }
}
