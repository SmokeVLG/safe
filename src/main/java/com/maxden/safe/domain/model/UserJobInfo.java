package com.maxden.safe.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.Date;

@Entity
@Getter
@Setter
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "company")
    @JoinColumn(name = "id_company")
    Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "users")
    @JoinColumn(name = "user_id")
    Users user;
    @NotBlank(message = "The book description name must be defined.")
    String description;
    @Column(name = "is_activity")
    boolean isActivity;
    @CreatedDate
    Date created;
    @LastModifiedDate
    Date updated;

    public UserJobInfo() {
    }

    public UserJobInfo(Company company,
                       Users user,
                       String description,
                       boolean isActivity) {
        this.company = company;
        this.user = user;
        this.description = description;
        this.isActivity = isActivity;

    }
}