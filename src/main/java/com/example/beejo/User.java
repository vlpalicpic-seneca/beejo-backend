package com.example.beejo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.index.Indexed;

@Document(collection="user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class User {
    @Id
    private String _id;
    private String firstName;
    private String lastName;
    @Indexed(unique=true)
    private String email;
    private String password;
}
