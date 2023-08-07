package com.maxden.safe.domain.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

public record UserJobInfo(
        @Id
        Long id,
        Long id_company,
        Long user_id,
        @NotBlank(message = "The book description name must be defined.")
        String description,
        boolean is_activity,
        @CreatedDate
        Instant created,
        @LastModifiedDate
        Instant updated
) {
    public static UserJobInfo of(
            long idCompany,
            long userId,
            String description,
            boolean isActivity) {
        return new UserJobInfo(null, idCompany, userId, description, isActivity, null, null);
    }
}