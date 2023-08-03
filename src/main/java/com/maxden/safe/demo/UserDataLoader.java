package com.maxden.safe.demo;

import com.maxden.safe.domain.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Profile("testdata")
public class UserDataLoader {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final UserJobInfoRepository userJobRepository;

    public UserDataLoader(
            UserRepository userRepository,
            CompanyRepository companyRepository,
            UserJobInfoRepository userJobRepository
    ) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.userJobRepository = userJobRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadUserJobTestData() {
        createTempData();
    }


    private void createTempData() {
        userJobRepository.deleteAll();
        userRepository.deleteAll();
        companyRepository.deleteAll();

        Users testUser1 = userRepository.save(Users.of(
                "Денисов",
                "Владимирович",
                "Максим",
                Date.valueOf(LocalDate.parse("1989-09-23")),
                "М",
                33,
                "программист",
                false
        ));

        Users testUser2 = userRepository.save(Users.of(
                "Иванов",
                "Иванович",
                "Иван",
                Date.valueOf(LocalDate.parse("1993-08-20")),
                "М",
                30,
                "программист",
                false
        ));

        Company testCompany1 =
                companyRepository.save(
                        Company.of(
                                "Рога",
                                "Продажа мяса",
                                true
                        ));
        Company testCompany2 =
                companyRepository.save(
                        Company.of(
                                "Копыта",
                                "Продажа молока",
                                true
                        ));


        var userJob1 = userJobRepository.save(UserJobInfo.of(
                testCompany1.id(),
                testUser1.id(),
                "Первый пользователь с первой работой",
                true
        ));
        var userJob2 = userJobRepository.save(UserJobInfo.of(
                testCompany2.id(),
                testUser2.id(),
                "Второй пользователь со второй работой",
                true
        ));
    }
}