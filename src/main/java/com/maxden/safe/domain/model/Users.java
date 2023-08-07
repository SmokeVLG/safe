package com.maxden.safe.domain.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.Instant;

@Entity
@Getter
@Table(name = "users")
public class Users {

    @Id
    @javax.persistence.Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_generator"
    )
    @SequenceGenerator(
            name = "users_generator",
            sequenceName = "users_id_seq",
            allocationSize = 1
    )
    Long id;
    @NotBlank(message = "The family name must be defined.")
    @Column(name = "family_name")
    String familyName;
    @NotBlank(message = "The book middle name must be defined.")
    @Column(name = "middle_name")
    String middleName;
    @NotBlank(message = "The book first name must be defined.")
    @Column(name = "first_name")
    String firstName;
    @NotBlank(message = "The birthday must be defined.")
    Date birthday;
    @NotBlank(message = "The gender must be defined.")
    String gender;
    @NotBlank(message = "The age must be defined.")
    int age;
    @NotBlank(message = "The description must be defined.")
    String description;
    @CreatedDate
    Instant created;
    @LastModifiedDate
    Instant updated;
    @Column(name = "is_blocked")
    boolean isBlocked;

    public Users() {
    }

    public Users(String familyName,
                 String middleName,
                 String firstName,
                 Date birthday,
                 String gender,
                 int age,
                 String description,
                 boolean isBlocked) {
        this.id = null;
        this.familyName = familyName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.gender = gender;
        this.age = age;
        this.description = description;
        this.isBlocked = isBlocked;
    }
}