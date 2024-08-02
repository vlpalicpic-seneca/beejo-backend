package com.example.beejo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //1
    @PostMapping("/register")
    public ResponseEntity<Boolean> addUser(@RequestBody User user){
        User existing = userService.saveUser(user);
        if (existing == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            return new ResponseEntity<>(HttpStatus.CREATED);
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

}