package dev.azemoning.starter.service;

import dev.azemoning.starter.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role addRole(Role role);
    Role updateRole(Long id, Role role);
    Role deleteRole(Long id);
}
