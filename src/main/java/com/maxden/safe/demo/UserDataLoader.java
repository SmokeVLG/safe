package com.maxden.safe.demo;

import com.maxden.safe.domain.CompanyRepository;
import com.maxden.safe.domain.UserJobInfoRepository;
import com.maxden.safe.domain.UserRepository;
import com.maxden.safe.domain.model.Company;
import com.maxden.safe.domain.model.UserJobInfo;
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
        log.info("Test user1 is created with id:{}", userJob1.user_id());

        var userJob2 = userJobRepository.save(UserJobInfo.of(
                testCompany2.id(),
                testUser2.id(),
                "Второй пользователь со второй работой",
                true
        ));

        log.info("Test user2 is created with id:{}", userJob2.user_id());
    }
}