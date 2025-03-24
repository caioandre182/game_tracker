package com.gametracker.userauth.models;

import com.gametracker.userauth.enums.Role;
import com.gametracker.userauth.enums.Status;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String login;
    private String password;
    private Role role;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
    private Instant deletedAt;
    private boolean deleted;
    private Instant lastLogin;
    private Status status;
}
