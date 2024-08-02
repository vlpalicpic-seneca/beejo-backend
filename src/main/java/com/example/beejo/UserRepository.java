package com.example.beejo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String>{
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
