package dev.azemoning.starter.service;

import dev.azemoning.starter.exception.ResourceNotFoundException;
import dev.azemoning.starter.model.User;
import dev.azemoning.starter.repository.UserRepository;
import dev.azemoning.starter.util.BcryptPasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BcryptPasswordEncoderUtil passwordEncoderUtil;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoderUtil.passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User findUserById = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        findUserById.setPassword(passwordEncoderUtil.passwordEncoder().encode(user.getPassword()));
        return userRepository.save(findUserById);

    }

    @Override
    public User deleteUser(Long id) {
        User findUserById = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        userRepository.delete(findUserById);
        return findUserById;
    }
}
