package dev.azemoning.starter.service;

import dev.azemoning.starter.exception.ResourceNotFoundException;
import dev.azemoning.starter.model.Role;
import dev.azemoning.starter.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Role findRole = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        findRole.setName(role.getName());
        return roleRepository.save(findRole);
    }

    @Override
    public Role deleteRole(Long id) {
        Role findRole = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        roleRepository.delete(findRole);
        return findRole;
    }
}
