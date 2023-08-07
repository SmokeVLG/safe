package com.maxden.safe.domain;

import com.maxden.safe.domain.exception.UserJobByCompanyNotFoundException;
import com.maxden.safe.domain.exception.UserJobByUserNotFoundException;
import com.maxden.safe.domain.model.Company;
import com.maxden.safe.domain.model.UserJobInfo;
import com.maxden.safe.domain.model.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserJobInfoService {

    private final UserJobInfoRepository userJobInfoRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public UserJobInfo findByUserId(Long userId) {
        return userJobInfoRepository.findByUserId(userId)
                .orElseThrow(() -> new UserJobByUserNotFoundException(userId));
    }

    public UserJobInfo findCompanyId(Long companyId) {
        return userJobInfoRepository.findByCompanyId(companyId)
                .orElseThrow(() -> new UserJobByCompanyNotFoundException(companyId));
    }

    public UserJobInfo save(UserJobInfo userJobInfo) {

        Long userId = userJobInfo.getUserId();
        Long companyId = userJobInfo.getIdCompany();

        Optional<Users> users = userRepository.findById(userId);
        log.info("Find user with id:{}", users.orElseThrow(() -> new UserJobByUserNotFoundException(userId)));
        Optional<Company> company = companyRepository.findById(companyId);
        log.info("Find company with id:{}", company.orElseThrow(() -> new UserJobByCompanyNotFoundException(companyId)));

        return userJobInfoRepository.save(userJobInfo);
    }
}
