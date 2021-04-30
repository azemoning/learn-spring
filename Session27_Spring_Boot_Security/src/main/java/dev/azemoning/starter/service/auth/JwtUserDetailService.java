package dev.azemoning.starter.service.auth;

import dev.azemoning.starter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository  userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        dev.azemoning.starter.model.User findUser = userRepository.findByUsername(username);
        if (findUser.getUsername().equals(username)) {
            return new User(findUser.getUsername(), findUser.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
