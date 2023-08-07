package com.maxden.safe.domain;

import com.maxden.safe.domain.exception.UserJobByCompanyNotFoundException;
import com.maxden.safe.domain.exception.UserJobByUserNotFoundException;
import com.maxden.safe.domain.model.Company;
import com.maxden.safe.domain.model.UserJobInfo;
import com.maxden.safe.domain.model.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserJobInfoService {

    private final UserJobInfoRepository userJobInfoRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public List<UserJobInfo> findByUserId(Long userId) {
        return userJobInfoRepository.findByUserId(userId).orElseThrow(() -> new UserJobByUserNotFoundException(userId));
    }

    public  List<UserJobInfo> findCompanyId(Long companyId) {
        return userJobInfoRepository.findByCompanyId(companyId).orElseThrow(() -> new UserJobByCompanyNotFoundException(companyId));
    }

    public UserJobInfo save(UserJobInfo userJobInfo) {

        Long userId = userJobInfo.getUser().getId();
        Long companyId = userJobInfo.getCompany().getId();
        Company newCompany = null;
        Users newUser = null;
        if (userId != null) {
            Optional<Users> users = userRepository.findById(userId);
            log.info("Find user with id:{}", users.orElseThrow(() -> new UserJobByUserNotFoundException(userId)));
            newUser = users.get();
        } else {
            newUser = userRepository.save(userJobInfo.getUser());
        } if (companyId != null) {
            Optional<Company> company = companyRepository.findById(companyId);
            log.info("Find company with id:{}", company.orElseThrow(() -> new UserJobByCompanyNotFoundException(companyId)));
            newCompany = company.get();
        } else {
            newCompany = companyRepository.save(userJobInfo.getCompany());
        }

        userJobInfo.setCompany(newCompany);
        userJobInfo.setUser(newUser);
        Date updated = new Date();
        Date created = new Date();
        Long newJobId = userJobInfoRepository.saveAll(newUser.getId(), newCompany.getId(), userJobInfo.getDescription(), userJobInfo.isActivity(), updated, created);

        log.info("crete job with userId: {}, companyId:{}, jobId:{}", newUser.getId(), newCompany.getId(), newJobId);

        userJobInfo.setUpdated(updated);
        userJobInfo.setCreated(created);
        userJobInfo.setId(newJobId);

        return userJobInfo;
    }
}
