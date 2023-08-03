package com.maxden.safe.domain;

import org.springframework.stereotype.Service;

@Service
public class UserJobInfoService {

    private final UserJobInfoRepository userJobInfoRepository;

    public UserJobInfoService(UserJobInfoRepository userJobInfoRepository) {
        this.userJobInfoRepository = userJobInfoRepository;
    }

    public UserJobInfo viewUserJobDetails(Long id) {
        return userJobInfoRepository.findById(id)
                .orElseThrow(() -> new UserJobByUserNotFoundException(id));
    }

    public UserJobInfo findByUserId(Long userId) {
        return userJobInfoRepository.findByUserId(userId)
                .orElseThrow(() -> new UserJobByUserNotFoundException(userId));
    }

    public UserJobInfo findCompanyId(Long companyId) {
        return userJobInfoRepository.findByCompanyId(companyId)
                .orElseThrow(() -> new UserJobByCompanyNotFoundException(companyId));
    }
}
