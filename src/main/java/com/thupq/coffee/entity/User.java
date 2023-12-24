package com.thupq.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User extends AuditEntity{
    @Id
    private UUID id;

    private String code;

    private String userName;

    private String password;

    private String fullName;

    private String contactPhone;

    private String email;

    private Date dateOfBirth;

    private String gender;

    private String description;

    private String status;
}