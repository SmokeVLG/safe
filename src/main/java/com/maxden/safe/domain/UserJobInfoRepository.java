package com.maxden.safe.domain;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserJobInfoRepository extends CrudRepository<UserJobInfo, Long> {

    @Query("select *  from user_job_info where user_id = :userId")
    Optional<UserJobInfo> findByUserId(Long userId);

    @Query("select *  from user_job_info where id_company = :companyId")
    Optional<UserJobInfo> findByCompanyId(Long companyId);
}