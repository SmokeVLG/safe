package com.maxden.safe.domain.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

public record Company(
        @Id
        Long id,
        @NotBlank(message = "The company name must be defined.")
        String company_name,
        @NotBlank(message = "The book description name must be defined.")
        String description,
        @CreatedDate
        Instant created,
        @LastModifiedDate
        Instant updated,
        boolean is_activity
) {
    public static Company of(
            String companyName,
            String description,
            boolean isActivity) {
        return new Company(null, companyName, description, null, null, isActivity);
    }
}