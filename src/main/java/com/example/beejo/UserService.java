package com.example.beejo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        try {
            String email = user.getEmail();
            User existing = userRepository.findByEmail(email);
            if (existing != null) {
                // User with the given email already exists
                return null;
            } else {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return userRepository.save(user);
            }
        } catch (Exception e) {
            // Handle exceptions (e.g., DuplicateKeyException)
            return null;
        }
    }

    public User authenticateUser(User login) {
        String email = login.getEmail();
        String password = login.getPassword();
        User acct = userRepository.findByEmail(email);
        if (acct != null && passwordEncoder.matches(password, acct.getPassword())) {
            return acct;
        } else {
            return null;
        }
    }
}