package dev.azemoning.starter.controller;

import dev.azemoning.starter.model.Role;
import dev.azemoning.starter.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("role")
    public ResponseEntity<Object> getAllRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("role/{roleId}")
    public ResponseEntity<Object> getRoleById(@PathVariable Long roleId) {
        return new ResponseEntity<>(roleService.getRoleById(roleId), HttpStatus.OK);
    }

    @PostMapping("role")
    public ResponseEntity<Object> addRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.addRole(role), HttpStatus.OK);
    }

    @PutMapping("role/{roleId}")
    public ResponseEntity<Object> updateRole(@PathVariable Long roleId, @RequestBody Role role) {
        return new ResponseEntity<>(roleService.updateRole(roleId, role), HttpStatus.OK);
    }

    @DeleteMapping("role/{roleId}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long roleId) {
        return new ResponseEntity<>(roleService.deleteRole(roleId), HttpStatus.OK);
    }
}
