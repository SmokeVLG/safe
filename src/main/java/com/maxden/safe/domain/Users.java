package com.maxden.safe.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.Instant;

public record Users(

        @Id
        Long id,

        @NotBlank(message = "The family name must be defined.")
        String family_name,

        @NotBlank(message = "The book middle name must be defined.")
        String middle_name,

        @NotBlank(message = "The book first name must be defined.")
        String first_name,

        @NotBlank(message = "The birthday must be defined.")
        Date birthday,

        @NotBlank(message = "The gender must be defined.")
        String gender,

        @NotBlank(message = "The age must be defined.")
        int age,

        @NotBlank(message = "The description must be defined.")
        String description,

        @CreatedDate
        Instant created,

        @LastModifiedDate
        Instant updated,

        boolean is_blocked

) {

    public static Users of(
            String familyName,
            String middleName,
            String firstName,
            Date birthday,
            String gender,
            int age,
            String description,
            boolean isBlocked) {
        return new Users(null, familyName, middleName, firstName, birthday, gender, age, description, null, null, isBlocked);
    }
}