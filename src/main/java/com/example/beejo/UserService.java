package com.example.beejo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse saveUser(User user) {
        try {
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String email = user.getEmail();
            String password = user.getPassword();
            User existing = userRepository.findByEmail(email);
            if (firstName != null && lastName != null && email != null && password != null
            && !firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                if (existing != null) {
                    return new UserResponse("user already exists", null);
                } else {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    return new UserResponse("success", userRepository.save(user));
                }
            }
            else {
                return new UserResponse("missing value", null);
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

    public Optional<User> getUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user;
        } else {
            return Optional.empty();
        }
    }
}