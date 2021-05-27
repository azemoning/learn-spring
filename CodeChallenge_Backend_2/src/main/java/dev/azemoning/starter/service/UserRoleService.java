package dev.azemoning.starter.service;

import dev.azemoning.starter.model.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getUserRoles();
    UserRole getUserRoleById(Long id);
    UserRole addUserRole(Long userId, Long roleId);
    UserRole updateUserRole(Long id, Long userId, Long roleId);
    UserRole deleteUserRole(Long id);
}
