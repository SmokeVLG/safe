package com.maxden.safe.domain.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Getter
@Table(name = "user_job_info")
public class UserJobInfo {
    @Id
    @javax.persistence.Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_job_info_generator"
    )
    @SequenceGenerator(
            name = "user_job_info_generator",
            sequenceName = "user_job_info_id_seq",
            allocationSize = 1
    )
    Long id;
    @Column(name = "id_company")
    Long idCompany;
    @Column(name = "user_id")
    Long userId;
    @NotBlank(message = "The book description name must be defined.")
    String description;
    @Column(name = "is_activity")
    boolean isActivity;
    @CreatedDate
    Instant created;
    @LastModifiedDate
    Instant updated;

    public UserJobInfo() {
    }

    public UserJobInfo(long idCompany,
                       long userId,
                       String description,
                       boolean isActivity) {
        this.id = null;
        this.idCompany = idCompany;
        this.userId = userId;
        this.description = description;
        this.isActivity = isActivity;

    }
}