package com.maxden.safe.demo;

import com.maxden.safe.domain.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@Profile("testdata")
public class UserDataLoader {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final UserJobRepository userJobRepository;

    public UserDataLoader(
            UserRepository userRepository,
            CompanyRepository companyRepository,
            UserJobRepository userJobRepository
    ) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.userJobRepository = userJobRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadUserJobTestData() {
        createTempUsers();
        createTempCompanies();
        createTempUserJob();
    }

    private void createTempUserJob() {
        userJobRepository.deleteAll();
        var userJob1 = UserJobInfo.of(1, 1, "описание", true);
        var userJob2 = UserJobInfo.of(1, 1, "описание", true);
        userJobRepository.saveAll(List.of(userJob1, userJob2));
    }

    private void createTempCompanies() {
        companyRepository.deleteAll();
        var company1 = Company.of("Рога", "Продажа мяса", true);
        var company2 = Company.of("Копыта", "Продажа молока", true);
        companyRepository.saveAll(List.of(company1, company2));
    }

    private void createTempUsers() {
        userRepository.deleteAll();
        var user1 = Users.of(
                "Денисов",
                "Владимирович",
                "Максим",
                Date.valueOf(LocalDate.parse("1989-09-23")),
                "М",
                33,
                "программист",
                false
        );

        var user2 = Users.of(
                "Иванов",
                "Иванович",
                "Иван",
                Date.valueOf(LocalDate.parse("1993-08-20")),
                "М",
                30,
                "программист",
                false
        );

        userRepository.saveAll(List.of(user1, user2));
    }

}