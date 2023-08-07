package com.maxden.safe.demo;

import com.maxden.safe.domain.CompanyRepository;
import com.maxden.safe.domain.UserJobInfoRepository;
import com.maxden.safe.domain.UserRepository;
import com.maxden.safe.domain.model.Company;
import com.maxden.safe.domain.model.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Profile("testdata")
@RequiredArgsConstructor
@Slf4j
public class UserDataLoader {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final UserJobInfoRepository userJobRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadUserJobTestData() {
        createTempData();
    }

    private void createTempData() {
        userJobRepository.truncateAll();
        userRepository.deleteAll();
        companyRepository.deleteAll();

        Users testUser1 = new Users(
                "Денисов",
                "Владимирович",
                "Максим",
                Date.valueOf(LocalDate.parse("1989-09-23")),
                "М",
                33,
                "программист",
                false);


        testUser1 = userRepository.save(testUser1);


        Users testUser2 = new Users("Денисов",
                "Владимирович",
                "Максим",
                Date.valueOf(LocalDate.parse("1989-09-23")),
                "М",
                33,
                "программист",
                false);


        testUser2 = userRepository.save(testUser2);


        Company testCompany1 =
                companyRepository.save(
                        new Company(
                                "Рога",
                                "Продажа мяса",
                                true
                        ));
        Company testCompany2 =
                companyRepository.save(
                        new Company(
                                "Копыта",
                                "Продажа молока",
                                true
                        ));


        var userJob1 = userJobRepository.saveAll(
                testCompany1.getId(),
                testUser1.getId(),
                "Первый пользователь с первой работой",
                true,
                new java.util.Date(),
                new java.util.Date()
        );
        log.info("Test user1 is created with id:{}", userJob1);

        var userJob2 = userJobRepository.saveAll(
                testCompany2.getId(),
                testUser2.getId(),
                "Второй пользователь со второй работой",
                true,
                new java.util.Date(),
                new java.util.Date()
        );

        log.info("Test user2 is created with id:{}", userJob2);
    }
}