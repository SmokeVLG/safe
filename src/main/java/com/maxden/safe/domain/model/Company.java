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
@Table(name = "company")
@Getter
public class Company {

    @Id
    @javax.persistence.Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_generator"
    )
    @SequenceGenerator(
            name = "company_generator",
            sequenceName = "company_id_seq",
            allocationSize = 1
    )
    Long id;
    @NotBlank(message = "The company name must be defined.")
    @Column(name = "company_name")
    String companyName;
    @NotBlank(message = "The book description name must be defined.")
    String description;
    @CreatedDate
    Instant created;
    @LastModifiedDate
    Instant updated;
    @Column(name = "is_activity")
    boolean isActivity;

    public Company() {
    }

    public Company(String companyName,
                   String description,
                   boolean isActivity) {
        this.id = null;
        this.companyName = companyName;
        this.description = description;
        this.isActivity = isActivity;
    }
}