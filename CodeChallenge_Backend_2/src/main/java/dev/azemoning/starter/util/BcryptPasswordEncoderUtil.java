package dev.azemoning.starter.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BcryptPasswordEncoderUtil {
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
