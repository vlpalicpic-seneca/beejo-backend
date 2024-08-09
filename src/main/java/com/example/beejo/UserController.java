package com.example.beejo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://beejo.vercel.app/")
public class UserController {
    @Autowired
    private UserService userService;

    //1
    @PostMapping("/register")
    public ResponseEntity<UserResponse> addUser(@RequestBody User user){
        UserResponse register = userService.saveUser(user);
        if (Objects.equals(register.getMessage(), "user already exists")){
            UserResponse response = new UserResponse("User already exists.", null);
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } else if (Objects.equals(register.getMessage(), "missing value")) {
            UserResponse response = new UserResponse("Missing required value.", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else{
            UserResponse response = new UserResponse("User created successfully.", register.getUser());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    //2
    @PostMapping("/login")
    public ResponseEntity<User> authenticate(@RequestBody User login) {
        User authUser = userService.authenticateUser(login);
        if (authUser == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(authUser, HttpStatus.OK);
        }
    }

    //app
    @GetMapping("/user")
    public ResponseEntity<UserResponse> authenticate(@RequestParam String id) {
        Optional<User> user = userService.getUser(id);
        if (user.isEmpty()) {
            // Return 200 OK with a message indicating no user found
            UserResponse response = new UserResponse("No user found with the given ID.", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Return 200 OK with the user data
            UserResponse response = new UserResponse("User found.", user.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}